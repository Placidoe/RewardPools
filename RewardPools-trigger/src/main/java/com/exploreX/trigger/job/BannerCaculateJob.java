package com.exploreX.trigger.job;

import com.xxl.job.core.handler.annotation.XxlJob;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 上午2:22
 **/
public class BannerCaculateJob {

    /*零点结算日数据*/
    @XxlJob("BannerCaculateJob_Day")
    public void BannerCaculateJob_Day() throws Exception {
        //TODO 调用BannerCaculateService
        System.out.println("BannerCaculateJob");
    }

    @XxlJob("BannerCaculateJob_Month")
    public void BannerCaculateJob_Month() throws Exception {
        //TODO 调用BannerCaculateService
        System.out.println("BannerCaculateJob");
    }

    @XxlJob("BannerCaculateJob_Year")
    public void BannerCaculateJob_Year() throws Exception {
        //TODO 调用BannerCaculateService
        System.out.println("BannerCaculateJob");
    }
}
