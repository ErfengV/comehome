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
  `u_openid` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '�û���OpenID',
  `u_nickname` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '�û��ǳ�',
  `u_avator` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '�û�ͷ��',
  `u_sex` varchar(4) COLLATE utf8_bin DEFAULT '����' COMMENT '�û��Ա�',
  `u_province` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'ʡ��code',
  `u_city` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '����code',
  `u_tel` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '�û����ֻ�����',
  `u_state` int(1) DEFAULT '1' COMMENT '-1 ���| 0 �ݲ���ʹ��| 1 ����',
  `u_isvol` int(1) DEFAULT '0' COMMENT '0 ��ͨ�û� | 1 ־Ը��',
  `u_idcard` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '����־Ը����Ҫ��д�����֤��',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ch_user
-- ----------------------------
