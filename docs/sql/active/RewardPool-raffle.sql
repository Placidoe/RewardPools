CREATE TABLE `active`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `active_id` varchar(50) NOT NULL COMMENT '活动id',
  `active_name` varchar(255) NOT NULL COMMENT '活动名称',
  `strategy_id` varchar(50) NOT NULL COMMENT '策略id',
  `descripe` varchar(50) NULL COMMENT '活动描述',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX `index1`(`active_id`, `strategy_id`) COMMENT 'index1',
  INDEX `index2`(`active_name`) COMMENT 'index2'
);

CREATE TABLE `active_sku`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `sku_id` varchar(50) NOT NULL COMMENT 'skuid',
  `sku_name` varchar(255) NOT NULL COMMENT 'sku名字',
  `descripe` varchar(255) NULL COMMENT 'sku描述',
  `price` varchar(255) NOT NULL COMMENT 'sku价格',
  `priceinfo_id` varchar(50) NOT NULL COMMENT 'skuinfoid',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX `index1`(`sku_id`, `priceinfo_id`) COMMENT 'index1',
  INDEX `price_index2`(`price`) COMMENT 'price_index',
  INDEX `index3`(`sku_name`) COMMENT 'index3'
);

CREATE TABLE `rule`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rule_id` varchar(50) NOT NULL COMMENT '规则id',
  `rule_name` varchar(255) NOT NULL COMMENT '规则名称',
  `rule_value` varchar(255) NULL COMMENT '规则值',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX `index2`(`rule_name`) COMMENT 'index2',
  INDEX `index1`(`rule_id`) COMMENT 'index1'
);

CREATE TABLE `strategy`  (
  `id` bigint UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `strategy_id` varchar(50) NOT NULL COMMENT '策略id\r\n',
  `rule_ids` varchar(50) NOT NULL COMMENT '规则id',
  `active_id` varchar(50) NOT NULL COMMENT '活动id',
  `descripe` varchar(50) NOT NULL COMMENT '策略描述',
  `create_time` datetime NULL COMMENT '创建时间',
  `update_time` datetime NULL COMMENT '更新时间\r\n',
  PRIMARY KEY (`id`),
  INDEX `index1`(`strategy_id`, `active_id`)
);

