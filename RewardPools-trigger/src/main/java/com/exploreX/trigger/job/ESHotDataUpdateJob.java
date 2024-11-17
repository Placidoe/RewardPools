package com.exploreX.trigger.job;

import com.xxl.job.core.handler.annotation.XxlJob;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 上午2:24
 **/
public class ESHotDataUpdateJob {

    @XxlJob("ESHotDataUpdateJob")
    public void ESHotDataUpdate() {
        System.out.println("ESHotDataUpdateJob");
    }
}
