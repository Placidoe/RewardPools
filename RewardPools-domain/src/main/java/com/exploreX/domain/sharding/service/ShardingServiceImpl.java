package com.exploreX.domain.sharding.service;

import com.exploreX.domain.sharding.mapper.upAndDownActiveMapper;
import com.exploreX.types.model.pojo.Response;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/9 下午6:42
 **/
public class ShardingServiceImpl  implements  ShardingService {


    @Resource
    upAndDownActiveMapper upAndDownActiveMapper;


    /*通过nacos去动态配置实现*/
    @Override
    public Response switchDataSource(String dataSourceKey) {
        return null;
    }

    @Override
    public Response createShadowTable(String tableName) {
        //1.编写sql，将指定数据库进行一次拷贝
        upAndDownActiveMapper.createShadowTable(tableName);
        //2.当
        return null;
    }

    @Override
    public Response deleteShadowTable(String tableName) {
        return null;
    }
}
