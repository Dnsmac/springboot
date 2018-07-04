/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.39 : Database - smartkit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smartkit` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `smartkit`;

/*Table structure for table `category_type` */

DROP TABLE IF EXISTS `category_type`;

CREATE TABLE `category_type` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称',
  `category_img` varchar(100) DEFAULT NULL COMMENT '图片',
  `category_url` varchar(100) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `dealer` */

DROP TABLE IF EXISTS `dealer`;

CREATE TABLE `dealer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(20) DEFAULT NULL COMMENT '店名',
  `dealer_name` varchar(20) DEFAULT NULL COMMENT '品牌名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `promotion` varchar(50) DEFAULT NULL COMMENT '促销',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5356 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `navigate_link` */

DROP TABLE IF EXISTS `navigate_link`;

CREATE TABLE `navigate_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '链接名',
  `link` varchar(100) NOT NULL DEFAULT '' COMMENT '链接',
  `description` varchar(500) NOT NULL DEFAULT '' COMMENT '介绍/描述',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '分类',
  `updateTime` decimal(16,0) NOT NULL DEFAULT '0' COMMENT '操作时间',
  `logo` varchar(100) DEFAULT '../../static/admin/images/api-icon.png' COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `project_title` */

DROP TABLE IF EXISTS `project_title`;

CREATE TABLE `project_title` (
  `project_id` int(10) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(200) NOT NULL COMMENT '名称',
  `category_id` int(10) NOT NULL COMMENT '系列id',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `series_type` */

DROP TABLE IF EXISTS `series_type`;

CREATE TABLE `series_type` (
  `series_id` int(10) NOT NULL AUTO_INCREMENT,
  `project_id` int(10) unsigned NOT NULL COMMENT '项目',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `series_img` varchar(100) DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`series_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_content_history` */

DROP TABLE IF EXISTS `t_content_history`;

CREATE TABLE `t_content_history` (
  `history_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(10) unsigned NOT NULL DEFAULT '0',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `created` varchar(20) NOT NULL DEFAULT '',
  `modified` varchar(20) DEFAULT '',
  `content` mediumtext COMMENT '内容文字',
  `author_id` int(10) NOT NULL DEFAULT '0' COMMENT '作者',
  `seriesId` int(16) NOT NULL DEFAULT '0' COMMENT '类型id',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '链接',
  `versions` varchar(200) NOT NULL DEFAULT '' COMMENT '版本',
  PRIMARY KEY (`history_id`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;

/*Table structure for table `t_contents` */

DROP TABLE IF EXISTS `t_contents`;

CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `created` varchar(20) NOT NULL DEFAULT '',
  `modified` varchar(20) DEFAULT '',
  `content` mediumtext NOT NULL COMMENT '内容文字',
  `author_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '作者',
  `seriesId` int(16) NOT NULL DEFAULT '0' COMMENT '类型id',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '链接',
  `versions` varchar(200) NOT NULL DEFAULT '' COMMENT '版本',
  `year_month_id` int(11) DEFAULT '0' COMMENT '年月表主键',
  `content_type` varchar(100) DEFAULT NULL COMMENT '类型',
  `project_id` int(11) DEFAULT '0' COMMENT '模块id',
  PRIMARY KEY (`cid`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `pass_word` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `group_name` varchar(16) DEFAULT 'visitor',
  `name` varchar(100) DEFAULT NULL COMMENT '姓',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`user_name`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Table structure for table `year_month_type` */

DROP TABLE IF EXISTS `year_month_type`;

CREATE TABLE `year_month_type` (
  `year_moth_id` int(11) NOT NULL AUTO_INCREMENT,
  `year_month_char` varchar(12) NOT NULL DEFAULT '' COMMENT '年月',
  PRIMARY KEY (`year_moth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
