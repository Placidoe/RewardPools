package com.exploreX.infrastructure.persistent.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exploreX.domain.active.upAndDownActive.repository.IUpAndDownActiveRepository;
import com.exploreX.infrastructure.persistent.dao.FestivalDAO;
import com.exploreX.infrastructure.persistent.dao.UpAndDownActiveDAO;
import com.exploreX.infrastructure.persistent.dao.YearInfoDAO;
import com.exploreX.infrastructure.persistent.po.Festival;
import com.exploreX.infrastructure.persistent.po.YearInfo;
import com.exploreX.types.utils.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
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
                kafkaTemplate.send("active_warm_up_topic",activeId);

                //开启zookeeper节点记录对应活动id的限流

            }
        }



    }

    @Override
    public void asyncCopyTableData(String tableName) {
        upAndDownActiveDAO.createShadowTable("up_and_down_active");
    }
}
