package com.exploreX.domain.sharding.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/9 下午8:14
 **/

@Mapper
public interface upAndDownActiveMapper {

    @Select("CREATE TABLE ${tableName} (\n" +
            "  `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',\n" +
            "  `name` VARCHAR(255) NOT NULL COMMENT '用户名',\n" +
            "  `email` VARCHAR(255) NOT NULL UNIQUE COMMENT '邮箱',\n" +
            "  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';")
    public void createShadowTable(String tableName);

}
