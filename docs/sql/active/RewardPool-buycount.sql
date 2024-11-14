CREATE TABLE `daily_buy_count`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `daily_id` varchar(50) NOT NULL,
  `count` bigint NOT NULL,
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `month_buy_count`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `month_id` varchar(50) NOT NULL,
  `count` bigint NOT NULL,
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `year_buy_count`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `year_id` varchar(50) NOT NULL,
  `count` bigint NOT NULL,
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id`)
);

