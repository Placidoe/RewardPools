package com.exploreX.domain.hotpool.service;

import com.exploreX.types.utils.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午4:58
 **/
@Service
public class MyMethodService {
    @Resource
    RedisService redisService;

    public void myMethod(){
        
    }

    public void run() {
        String name = "";
        //下游业务操作

        //记录成交量进入redis中
        redisService.zScore("hot_pool_SKU",name);
    }
}
