package com.exploreX.trigger.job;

import com.exploreX.domain.active.upAndDownActive.repository.IUpAndDownActiveRepository;
import com.exploreX.trigger.apis.active.DCCValueActiveStatusController;
import com.exploreX.types.common.ActiveConstant;
import com.exploreX.types.utils.RedisService;
import com.exploreX.types.utils.ZookeeperService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ActiveUpXxlJob {
    private static Logger logger = LoggerFactory.getLogger(ActiveUpXxlJob.class);

    @Resource
    private ZookeeperService zookeeperService;

    @Autowired
    private RedisService redisService;

    @Resource
    DCCValueActiveStatusController dccValueActiveStatusController;

    @Resource
    IUpAndDownActiveRepository iUpAndDownActiveRepository;



    //定时任务，每天00:00执行一次，将活动id存到缓存中去[预热]
    @XxlJob("ActiveUpJobHandler")
    public ReturnT<String> demoJobHandler(HashMap<String,String> param) throws Exception {
        logger.info("ActiveUpJobHandler start, param:{}", param.toString());

        String key = param.get("key");
        String value = param.get("value");

        Long daysSinceStartOfYear = getDayOfThisYear();

        //1.从库中查询相差天数为daysSinceStartOfYear的记录festival_ids列表
        List<String> festivalIds = iUpAndDownActiveRepository.getFestivalIdsByDays(daysSinceStartOfYear);


        //todo 2.根据活动ids开始预热数据
        iUpAndDownActiveRepository.WarmUpFestivalByIds(festivalIds);

        //todo 3.开启异步线程去对数据库进行拷贝，创建影子表
        iUpAndDownActiveRepository.asyncCopyTableData("tableName");
        //todo 4.使用nacos-api进行数据源的动态切换

        //todo 5.开启延迟队列，红包雨倒计时


        //2.从zookeeper中拿到活动_时间戳和活动id的
        String Key = ActiveConstant.ACTIVE_UP_KEY + daysSinceStartOfYear;

        if(zookeeperService.exists("/explorex/active/"+Key)) {
            byte[] bytes = zookeeperService.readNodeData("/explorex/active/" + Key);
            value = new String(bytes);
        }

        //3.将活动id存到缓存中去
        String RedisKey = ActiveConstant.CURRENT_ACTIVE_KEY;
        if(value!=null&&value.isEmpty()) {
            redisService.set(RedisKey,value,ActiveConstant.ACTIVE_UP_TIME, TimeUnit.DAYS);
        }else{
            redisService.set(RedisKey,value,ActiveConstant.DEFAULT_ACTIVE_ID, TimeUnit.DAYS);
        }

        //4.动态扩容调整库表状态
        dccValueActiveStatusController.doUpActive(key,value);

        return ReturnT.SUCCESS;
    }

    private static Long getDayOfThisYear() {
        //1.计算当前时间戳距离今年开始的日期天数
        // 获取当前日期
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());

        // 获取今年的1月1日
        LocalDate startOfYear = LocalDate.of(currentDate.getYear(), 1, 1);

        // 计算当前日期与今年1月1日之间的天数差
        long daysSinceStartOfYear = ChronoUnit.DAYS.between(startOfYear, currentDate);
        return daysSinceStartOfYear;
    }
}