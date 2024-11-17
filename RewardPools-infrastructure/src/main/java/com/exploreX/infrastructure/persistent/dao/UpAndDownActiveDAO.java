package com.exploreX.infrastructure.persistent.dao;

import com.exploreX.domain.sharding.mapper.upAndDownActiveMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/9 下午8:14
 **/

@Mapper
public class UpAndDownActiveDAO implements upAndDownActiveMapper {

    @Override
    public void createShadowTable(String tableName) {

    }
}
