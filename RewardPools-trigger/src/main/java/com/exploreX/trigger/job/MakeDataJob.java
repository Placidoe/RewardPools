package com.exploreX.trigger.job;

import com.exploreX.domain.hotpool.HotPoolBoostrap;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午5:02
 **/
@Service
public class MakeDataJob {

    @Resource
    HotPoolBoostrap hotPoolBoostrap;

    @XxlJob("MakeData")
    public void makeData() {
        //mock数据
        hotPoolBoostrap.AddData(new Object());
    }
}
