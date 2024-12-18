package com.exploreX.infrastructure.persistent.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exploreX.domain.active.upAndDownActive.repository.IUpAndDownActiveRepository;
import com.exploreX.infrastructure.persistent.dao.FestivalDAO;
import com.exploreX.infrastructure.persistent.dao.UpAndDownActiveDAO;
import com.exploreX.infrastructure.persistent.dao.YearInfoDAO;
import com.exploreX.infrastructure.persistent.po.Festival;
import com.exploreX.infrastructure.persistent.po.YearInfo;
import com.exploreX.types.common.KafkaActiveConstants;
import com.exploreX.types.utils.RedisService;
import com.exploreX.types.utils.ZookeeperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/14 下午1:22
 **/
@Slf4j
@Repository
public class UpAndDownActiveRepository implements IUpAndDownActiveRepository {

    @Resource
    FestivalDAO festivalDAO;
    @Resource
    YearInfoDAO yearInfoDAO;
    @Resource
    RedisService redisService;
    @Resource
    UpAndDownActiveDAO upAndDownActiveDAO;
    @Resource
    KafkaTemplate kafkaTemplate;
    @Autowired
    private ZookeeperService zookeeperService;


    @Override
    public List<String> getFestivalIdsByDays(Long daysSinceStartOfYear) {

        QueryWrapper<YearInfo> yearInfoQueryWrapper = new QueryWrapper<>();
        yearInfoQueryWrapper.eq("days_since_start_of_year",daysSinceStartOfYear);
        List<YearInfo> yearInfos = yearInfoDAO.selectList(yearInfoQueryWrapper);
        YearInfo yearInfo = yearInfos.get(0);
        return yearInfo.getFestivalIds();
    }


    @Override
    public void WarmUpFestivalByIds(List<String> festivalIds) {
        List<Festival> festivals = festivalDAO.selectBatchByFestivalIds(festivalIds);
        //节日列表缓存
        for (Festival festival : festivals) {
            redisService.set(festival.getFestivalId(),festival);
            //开启MQ异步预热活动数据缓存(所有SKU数据、策略、规则、令牌桶)
            String[] activeIds = festival.getActiveIds();
            for (String activeId : activeIds) {
                //TODO
                kafkaTemplate.send(KafkaActiveConstants.SKU,activeId);
                kafkaTemplate.send(KafkaActiveConstants.STRATEGY,activeId);
                kafkaTemplate.send(KafkaActiveConstants.topic,activeId);
                kafkaTemplate.send(KafkaActiveConstants.TOKEN,activeId);

                //开启zookeeper节点记录对应活动id的限流，有节点就说明有被限流，开启了限流之后，在aop处做限流aop
                try {
                    zookeeperService.createNode("active_limit"+activeId, activeId.getBytes());
                } catch (Exception e) {
                    log.error("开启活动限流出现了问题哦...",e);
                    throw new RuntimeException(e);
                }
            }
        }



    }

    @Override
    @Async
    public void asyncCopyTableData(String tableName) {
        upAndDownActiveDAO.createShadowTable("up_and_down_active");
    }
}
