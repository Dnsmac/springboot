
ALTER  TABLE yw_exception_day
ADD COLUMN dealTime decimal(16,0) DEFAULT 0 NOT NULL COMMENT '处理时间',
ADD COLUMN processor VARCHAR(20) DEFAULT '' NOT NULL COMMENT '操作人';

<!--导航
CREATE TABLE `navigate_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '链接名',
  `link` varchar(100) NOT NULL DEFAULT '' COMMENT '链接',
  `description` varchar(500) NOT NULL DEFAULT '' COMMENT '介绍/描述',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '分类',
  `updateTime` decimal(16,0) NOT NULL DEFAULT '0' COMMENT '操作时间',
  `logo` varchar(100) DEFAULT '../../static/admin/images/api-icon.png' COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4

