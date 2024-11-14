CREATE TABLE `year_info` (
  `id` bigint NOT NULL COMMENT '主键id',
  `day_start_of_year_id` varchar(50) NOT NULL COMMENT 'day_start_of_year_id',
  `day_start_of_year` bigint NOT NULL COMMENT '一年中的第几天',
  `festival_ids` varchar(255) NOT NULL COMMENT '包含的节日id',
  `create_time` datetime NULL COMMENT '创建日期',
  `update_time` datetime NULL COMMENT '更新日期',
  PRIMARY KEY (`id`),
  INDEX `INDEX1` (`day_start_of_year_id`),
  INDEX `INDEX2` (`day_start_of_year`)
);

CREATE TABLE `festival` (
  `id` bigint NOT NULL COMMENT '主键id',
  `festival_id` varchar(50) NOT NULL COMMENT '节日id',
  `festival_descrip` varchar(255) NOT NULL COMMENT '节日描述',
  `day_start_of_year_id` varchar(50) NOT NULL COMMENT '节日日期id',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX `INDEX1` (`festival_id`)
);