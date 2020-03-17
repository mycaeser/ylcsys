/*
Navicat MySQL Data Transfer

Source Server         : administrator1
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : organization_ylc_sys

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-09-18 13:51:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ylc_local_account`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_local_account`;
CREATE TABLE `ylc_local_account` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '账号主键',
  `user_id` int(20) NOT NULL COMMENT '所属用户编号',
  `account_string` varchar(100) DEFAULT NULL COMMENT '账号',
  `password_string` varchar(100) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_local_account
-- ----------------------------
INSERT INTO `ylc_local_account` VALUES ('1', '1', 'xifeng', '123456', '2019-04-17 19:46:45', '2019-04-17 20:02:03');

-- ----------------------------
-- Table structure for `ylc_party_activist`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_party_activist`;
CREATE TABLE `ylc_party_activist` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '积极分子表主键',
  `user_id` int(20) NOT NULL COMMENT '用户编号',
  `apply_date` date DEFAULT NULL COMMENT '申请时间',
  `is_checked` tinyint(1) DEFAULT NULL COMMENT '审核状态，1审核中，2审核失败，3审核通过',
  `is_checked_opinion` varchar(50) DEFAULT NULL COMMENT '审核意见',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_party_activist
-- ----------------------------
INSERT INTO `ylc_party_activist` VALUES ('1', '1', '2019-04-17', '1', '表现优秀', '2019-04-17 20:08:37', '2019-04-19 22:31:00');
INSERT INTO `ylc_party_activist` VALUES ('2', '3', '2019-04-19', '0', null, '2019-04-19 22:23:55', '2019-04-19 22:23:55');
INSERT INTO `ylc_party_activist` VALUES ('3', '4', '2019-04-20', '1', '表现优秀', '2019-04-20 14:38:13', '2019-04-20 14:38:25');

-- ----------------------------
-- Table structure for `ylc_party_branch`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_party_branch`;
CREATE TABLE `ylc_party_branch` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '党支部主键',
  `name` varchar(50) NOT NULL COMMENT '党支部名称',
  `content` varchar(200) DEFAULT NULL COMMENT '党支部简介',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_party_branch
-- ----------------------------
INSERT INTO `ylc_party_branch` VALUES ('1', '体育学院党支部一部1', '体育学院总党支部', '2019-04-17 12:31:15', '2019-04-17 19:22:26');
INSERT INTO `ylc_party_branch` VALUES ('2', '继续教育学院党支部一部', '继续教育学院总党支部', '2019-04-17 19:23:59', '2019-04-17 19:23:59');

-- ----------------------------
-- Table structure for `ylc_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_user_info`;
CREATE TABLE `ylc_user_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1男0女',
  `id_card` varchar(30) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(30) DEFAULT NULL COMMENT '电话号码',
  `union_name` varchar(50) DEFAULT NULL COMMENT '学院名称',
  `class_name` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `priority` tinyint(1) DEFAULT NULL COMMENT '权限',
  `youth_org_time` date DEFAULT NULL COMMENT '入团时间',
  `apply_party_time` date DEFAULT NULL COMMENT '申请入党时间',
  `admit_party_time` date DEFAULT NULL COMMENT '确认入党时间',
  `party_branch_id` tinyint(1) DEFAULT NULL COMMENT '党支部编号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_user_info
-- ----------------------------
INSERT INTO `ylc_user_info` VALUES ('1', '习封', '0', '431374199906199', '13603442230', '计算机学院', '计科3班', '1', '2019-04-17', '2019-04-17', '2019-04-17', '1', '2019-04-17 19:34:16', '2019-04-19 20:24:42');
INSERT INTO `ylc_user_info` VALUES ('3', '房青', '0', '201902334511', '16765530112', '计算机学院', '软件171', '1', null, null, null, null, '2019-04-19 19:51:01', '2019-04-19 19:52:03');
INSERT INTO `ylc_user_info` VALUES ('4', '赵萌', '0', '201536781120', '18863237456', '艺术学院', '设计181', '1', null, null, null, null, '2019-04-19 19:54:11', '2019-04-19 19:54:11');
INSERT INTO `ylc_user_info` VALUES ('5', '张毅', '1', '2014364451', '167554355455', '汽车学院', '交通管理161', '1', null, null, null, null, '2019-04-19 20:14:01', '2019-04-19 20:14:01');
INSERT INTO `ylc_user_info` VALUES ('7', '蔡枫', '1', '20183124476', '13864546454', '管理学院', '管理181', '1', null, null, null, null, '2019-04-20 20:51:30', '2019-04-20 20:51:30');
INSERT INTO `ylc_user_info` VALUES ('8', '蔡洪', '1', '20183124479', '13822548458', '体育学院', '体育141', '1', null, null, null, null, '2019-04-20 20:52:09', '2019-04-20 20:52:09');
INSERT INTO `ylc_user_info` VALUES ('9', '张青', '1', '20153124608', '18864506401', '继续教育学院', '管理141', '1', null, null, null, null, '2019-04-20 20:59:24', '2019-04-20 20:59:24');
INSERT INTO `ylc_user_info` VALUES ('10', '王江枫', '0', '20180126427', '13894546480', '财经学院', '财务161', '1', null, null, null, null, '2019-04-20 21:01:40', '2019-04-20 21:01:40');
INSERT INTO `ylc_user_info` VALUES ('11', '赵清志', '1', '20143124474', '13860506481', '财经学院', '财务171', '1', null, null, null, null, '2019-04-20 21:07:24', '2019-04-20 21:07:24');
INSERT INTO `ylc_user_info` VALUES ('12', '陶向', '1', '20143123473', '15906829209', '管理学院', '管理143', '1', null, null, null, null, '2019-04-20 21:40:19', '2019-04-20 21:40:19');
INSERT INTO `ylc_user_info` VALUES ('15', '张习昆', '1', '201331248', '12653549454', '管理学院', '管理173', '1', null, null, null, null, '2019-04-21 09:29:57', '2019-04-21 09:29:57');

-- ----------------------------
-- Table structure for `ylc_youth_org`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_youth_org`;
CREATE TABLE `ylc_youth_org` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '团组织表主键',
  `name` varchar(80) NOT NULL COMMENT '团组织名称',
  `user_id` int(20) NOT NULL COMMENT '用户编号',
  `content` varchar(200) DEFAULT NULL COMMENT '团组织简介',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_youth_org
-- ----------------------------
INSERT INTO `ylc_youth_org` VALUES ('1', '北海市第五中学共青团', '1', '北海市XX县', '2019-04-17 20:28:35', '2019-04-20 10:26:49');
INSERT INTO `ylc_youth_org` VALUES ('3', '鹤岗市第五中学共青团', '3', '黑龙江鹤岗龙水县', '2019-04-20 14:39:09', '2019-04-20 14:39:26');

-- ----------------------------
-- Table structure for `ylc_youth_org_dues`
-- ----------------------------
DROP TABLE IF EXISTS `ylc_youth_org_dues`;
CREATE TABLE `ylc_youth_org_dues` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '团费表主键',
  `user_id` int(20) NOT NULL COMMENT '用户编号',
  `dues_value` int(20) DEFAULT NULL COMMENT '团费价格',
  `dues_date` date DEFAULT NULL COMMENT '团费缴费时间',
  `is_deduction` tinyint(1) DEFAULT NULL COMMENT '是否减免',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ylc_youth_org_dues
-- ----------------------------
INSERT INTO `ylc_youth_org_dues` VALUES ('1', '1', '13', '2019-04-17', '1', '2019-04-17 20:54:24', '2019-04-19 21:10:29');
DROP TRIGGER IF EXISTS `delete_trigger`;
DELIMITER ;;
CREATE TRIGGER `delete_trigger` AFTER DELETE ON `ylc_user_info` FOR EACH ROW BEGIN
DELETE FROM ylc_local_account WHERE user_id=OLD.id;
DELETE FROM ylc_party_activist WHERE user_id=OLD.id;
DELETE FROM ylc_youth_org WHERE user_id=OLD.id;
DELETE FROM ylc_youth_org_dues WHERE user_id=OLD.id;
END
;;
DELIMITER ;
