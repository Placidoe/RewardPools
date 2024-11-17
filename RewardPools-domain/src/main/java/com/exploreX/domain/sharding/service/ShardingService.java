package com.exploreX.domain.sharding.service;

import com.exploreX.types.model.pojo.Response;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/9 下午6:42
 **/
public interface ShardingService {

    /*动态数据源切换*/
    public Response switchDataSource(String dataSourceKey);

    /*创建影子表*/
    public Response createShadowTable(String tableName);

    /*删除影子表*/
    public Response deleteShadowTable(String tableName);

}
