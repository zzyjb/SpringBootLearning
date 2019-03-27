/*
Navicat MySQL Data Transfer

Source Server         : 10.32.2.23
Source Server Version : 50560
Source Host           : 10.32.2.23:3306
Source Database       : dzpj_sj

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-03-22 16:09:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sj_user
-- ----------------------------
DROP TABLE IF EXISTS `sj_user`;
CREATE TABLE `sj_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sj_user
-- ----------------------------
INSERT INTO `sj_user` VALUES ('1', 'wy', '202cb962ac59075b964b07152d234b70', '2019-03-04 14:44:51');
