- 用户信息表 users
  - 主要保存了用户登录的用户名、密码
  - 每一个用户有一个唯一的uid，通过这个uid与其他数据表中用户执行测试的相关的信息进行关联
  - 主要参数有username（用户名）、password（用户密码）、user_id（唯一关联信息）

  
  
- 项目表 collections

  - 测试一个项目通常需要对多个接口进行测试，通过项目表保存该项目进行测试时测试的所有接口
  - user_id
  - collections_name 项目名称
  - collections_id 项目id
  - collections_interfaces_id 保存该项目所包含接口用例的id
  - success 接口统计汇总-成功数
  - fail 接口统计汇总-失败数
  - remark 备注
  - create_time 创建时间
  - update_time 更新时间



- 接口用例表 interfaces

  - 主要保存了接口的主要信息
  - user_id
  - collections_name 所属项目名称
  - collections_id 所属项目id
  - interfaces_id 保存接口的唯一id
  - interfaces_name 保存接口用例名称
  - interface_address 保存接口地址
  - param_template 保存通过params传参时的参数内容
  - header_template_id 通过该变量与header-template表建立联系
  - body_template 保存请求体参数内容
  - request_type 保存请求类型POST/GET
  - post_type 保存请求体数据类型FORM/JSON
  - res_template 保存响应内容
  - remark 备注
  - create_time 创建时间
  - update_time 更新时间、
- header_template表
  - 通过该表记录请求头的各种信息
  - header_template_id
  - cookie 
  - token
  - host
  - user-agent
  - accept
  - accept-encoding
  - connection



- 建表语言

~~~mysql
/*
Navicat MySQL Data Transfer

Source Server         : homework
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : project_training

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2021-10-11 11:07:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `collections`
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections` (
  `user_id` int(10) NOT NULL,
  `collections_name` varchar(100) NOT NULL,
  `collections_id` varchar(20) NOT NULL,
  `collections_interfaces_id` varchar(20) NOT NULL,
  `success` int(10) DEFAULT NULL,
  `fail` int(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` bigint(100) NOT NULL,
  `update_time` bigint(100) NOT NULL,
  PRIMARY KEY (`user_id`,`collections_id`),
  KEY `collections_id` (`collections_id`),
  KEY `collections_name` (`collections_name`),
  KEY `collections_interfaces_id` (`collections_interfaces_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collections
-- ----------------------------
INSERT INTO `collections` VALUES ('1', 'coll_name1', 'coll_id1', 'coll_inid1', '3', '2', '备注1', '2021', '2021');
INSERT INTO `collections` VALUES ('2', 'coll_name2', 'coll_id2', 'coll_inid2', '5', '1', '备注2', '2021', '2021');
INSERT INTO `collections` VALUES ('3', 'coll_name3', 'coll_id3', 'coll_inid3', '7', '4', '备注3', '2021', '2021');
INSERT INTO `collections` VALUES ('4', 'coll_name4', 'coll_id4', 'coll_inid4', '3', '2', '备注4', '2021', '2021');
INSERT INTO `collections` VALUES ('5', 'coll_name5', 'coll_id5', 'coll_inid5', '2', '1', '备注5', '2021', '2021');
INSERT INTO `collections` VALUES ('6', 'coll_name6', 'coll_id6', 'coll_inid6', '0', '6', '备注6', '2021', '2021');

-- ----------------------------
-- Table structure for `header_template`
-- ----------------------------
DROP TABLE IF EXISTS `header_template`;
CREATE TABLE `header_template` (
  `cookie` varchar(1000) NOT NULL,
  `token` varchar(1000) NOT NULL,
  `host` varchar(100) NOT NULL,
  `user-agent` varchar(100) DEFAULT NULL,
  `accept` varchar(100) NOT NULL,
  `accept-encoding` varchar(100) DEFAULT NULL,
  `connection` varchar(100) DEFAULT NULL,
  `header_template_id` varchar(20) NOT NULL,
  PRIMARY KEY (`header_template_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of header_template
-- ----------------------------

-- ----------------------------
-- Table structure for `interfaces`
-- ----------------------------
DROP TABLE IF EXISTS `interfaces`;
CREATE TABLE `interfaces` (
  `user_id` int(10) NOT NULL,
  `collections_name` varchar(100) NOT NULL,
  `collections_id` varchar(20) NOT NULL,
  `interfaces_id` varchar(20) NOT NULL,
  `interfaces_name` varchar(100) DEFAULT NULL,
  `interface_address` varchar(100) NOT NULL,
  `param_template` text,
  `header_template_id` varchar(20) NOT NULL,
  `body_template` text NOT NULL,
  `request_type` varchar(20) NOT NULL,
  `post_type` varchar(20) NOT NULL,
  `res_template` text NOT NULL,
  `remark` text,
  `create_time` bigint(100) NOT NULL,
  `update_time` bigint(100) NOT NULL,
  PRIMARY KEY (`user_id`,`collections_id`,`interfaces_id`),
  KEY `collections_id` (`collections_id`),
  KEY `collections_name` (`collections_name`),
  KEY `interfaces_id` (`interfaces_id`),
  KEY `header_template_id` (`header_template_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interfaces
-- ----------------------------
INSERT INTO `interfaces` VALUES ('1', 'coll_name1', 'coll_id_1', 'infa_id_1', 'infa_name_1', 'url1', 'param_template1', 'header_template1', 'body_template1', 'post', 'json', 'res_template', '备注1', '2021', '2021');
INSERT INTO `interfaces` VALUES ('1', 'coll_name1', 'coll_id_1', 'infa_id_2', 'infa_name_2', 'url2', 'param_template2', 'header_template2', 'body_template2', 'post', 'json', 'res_template', '备注1', '2021', '2021');
INSERT INTO `interfaces` VALUES ('2', 'coll_name2', 'coll_id_2', 'infa_id_3', 'infa_name_3', 'url3', 'param_template3', 'header_template4', 'body_template3', 'post', 'json', 'res_template', '备注1', '2021', '2021');
INSERT INTO `interfaces` VALUES ('3', 'coll_name3', 'coll_id_3', 'infa_id_4', 'infa_name_4', 'url4', 'param_template4', 'header_template3', 'body_template4', 'post', 'json', 'res_template', '备注1', '2021', '2021');
INSERT INTO `interfaces` VALUES ('3', 'coll_name3', 'coll_id_3', 'infa_id_5', 'infa_name_5', 'url5', 'param_template5', 'header_template5', 'body_template5', 'post', 'json', 'res_template', '备注1', '2021', '2021');
INSERT INTO `interfaces` VALUES ('3', 'coll_name3', 'coll_id_3', 'infa_id_6', 'infa_name_6', 'url6', 'param_template6', 'header_template6', 'body_template6', 'post', 'json', 'res_template', '备注1', '2021', '2021');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jerry', '123456');
INSERT INTO `user` VALUES ('2', 'lisi', '234567');
INSERT INTO `user` VALUES ('3', 'zhangsan', '345678');
INSERT INTO `user` VALUES ('4', 'jesy', '456789');

~~~







