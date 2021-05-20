/*
Navicat MySQL Data Transfer

Source Server         : ef
Source Server Version : 50729
Source Host           : 123.57.20.138:3306
Source Database       : db_comehome

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-04-11 16:27:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ch_user`
-- ----------------------------
DROP TABLE IF EXISTS `ch_user`;
CREATE TABLE `ch_user` (
  `u_id` int(255) NOT NULL AUTO_INCREMENT,
  `u_openid` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户的OpenID',
  `u_nickname` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `u_avator` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户头像',
  `u_sex` varchar(4) COLLATE utf8_bin DEFAULT '保密' COMMENT '用户性别',
  `u_province` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '省份code',
  `u_city` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '城市code',
  `u_tel` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '用户的手机号码',
  `u_state` int(1) DEFAULT '1' COMMENT '-1 封号| 0 暂不可使用| 1 可用',
  `u_isvol` int(1) DEFAULT '0' COMMENT '0 普通用户 | 1 志愿者',
  `u_idcard` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '申请志愿者需要填写的身份证号',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ch_user
-- ----------------------------
