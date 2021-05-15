/*
Navicat MySQL Data Transfer

Source Server         : ef
Source Server Version : 50729
Source Host           : 123.57.20.138:3306
Source Database       : db_comehome

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-04-11 16:52:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ch_equipment`
-- ----------------------------
DROP TABLE IF EXISTS `ch_equipment`;
CREATE TABLE `ch_equipment` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_bluetooth` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `e_tel` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `e_android` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `e_other` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '其他唯一标识',
  `u_id` int(255) NOT NULL,
  PRIMARY KEY (`e_id`),
  KEY `fk_euid` (`u_id`),
  CONSTRAINT `fk_euid` FOREIGN KEY (`u_id`) REFERENCES `ch_user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ch_equipment
-- ----------------------------
