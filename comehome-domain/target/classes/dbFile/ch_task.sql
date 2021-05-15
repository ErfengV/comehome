/*
Navicat MySQL Data Transfer

Source Server         : ef
Source Server Version : 50729
Source Host           : 123.57.20.138:3306
Source Database       : db_comehome

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-04-11 16:42:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ch_task`
-- ----------------------------
DROP TABLE IF EXISTS `ch_task`;
CREATE TABLE `ch_task` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '走失人员的姓名',
  `t_sex` varchar(2) COLLATE utf8_bin NOT NULL COMMENT '走失人员的性别',
  `t_age` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `t_photopath` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '走失人员的照片',
  `t_addr` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '走失地点',
  `t_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `u_id` int(100) NOT NULL COMMENT '任务发起者',
  PRIMARY KEY (`t_id`),
  KEY `fk_tuid` (`u_id`),
  CONSTRAINT `fk_tuid` FOREIGN KEY (`u_id`) REFERENCES `ch_user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ch_task
-- ----------------------------
