-- 创建表
CREATE TABLE `springboot_flyway` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `type` varchar(2) DEFAULT NULL COMMENT '生活用品类别：1. 家电类 2. 厨具',
	`name` varchar(50) DEFAULT NULL COMMENT '生活用品名称',
	`description` varchar(200) DEFAULT NULL COMMENT '生活用品描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='springboot整合flyway测试表';