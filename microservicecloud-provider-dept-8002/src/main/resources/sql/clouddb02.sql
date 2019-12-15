/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : clouddb02

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-11-16 23:10:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dept_name` varchar(60) DEFAULT NULL COMMENT '部门名称',
  `db_source` varchar(60) DEFAULT NULL COMMENT '数据库源',
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('2', '人事部', 'clouddb02');
INSERT INTO `dept` VALUES ('3', '财务部', 'clouddb02');
INSERT INTO `dept` VALUES ('4', '市场部', 'clouddb02');
INSERT INTO `dept` VALUES ('5', '运维部', 'clouddb02');
INSERT INTO `dept` VALUES ('6', '五六七', 'clouddb02');
