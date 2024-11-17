package com.exploreX.domain.active.upAndDownActive.service;

import com.exploreX.domain.sharding.service.ShardingService;
import com.exploreX.types.common.TableConstants;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/5 上午12:54
 **/
public class UpAndDownActiveServiceImpl implements UpAndDownActiveService{

    @Resource
    ShardingService shardingService;
    @Override
    public void upActive(String activeId,String value) {
        //TODO 触发一次活动创建影子表，配合cat进行分库分表
        shardingService.createShadowTable(TableConstants.ACTIVE_TABLE+activeId);
        //TODO 动态数据源切换
        shardingService.switchDataSource(value);      //TODO 修改Zookeeper活动名称
    }

    @Override
    public void downActive(String activeId) {

    }
}
