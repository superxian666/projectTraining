/*
Navicat MySQL Data Transfer

Source Server         : projectTraining
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : project_training

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2021-11-15 10:00:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `case`
-- ----------------------------
DROP TABLE IF EXISTS `case`;
CREATE TABLE `case` (
  `id` int(20) NOT NULL,
  `cid` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `url` varchar(10000) NOT NULL,
  `method` varchar(1000) NOT NULL,
  `type` varchar(1000) DEFAULT NULL COMMENT '请求体数据类型',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case
-- ----------------------------
INSERT INTO `case` VALUES ('1', '1', '登录', 'http://www.baidu.com', 'get', '');
INSERT INTO `case` VALUES ('2', '1', '注册', 'http://www.baidu.com', 'post', 'json');

-- ----------------------------
-- Table structure for `collections`
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collections
-- ----------------------------
INSERT INTO `collections` VALUES ('1', 'test01', '17');
INSERT INTO `collections` VALUES ('2', 'test02', '17');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('17', 'xiaozhu', '123456789');
INSERT INTO `user` VALUES ('31', 'xiaoxiao', '123456789');

