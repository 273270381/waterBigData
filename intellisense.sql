/*
 Navicat Premium Data Transfer

 Source Server         : mysql172.16.14.9
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 172.16.14.9:3306
 Source Schema         : intellisense

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 29/05/2021 15:30:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test@qq.com', '测试账号', NULL, '2018-09-29 13:55:30', '2018-09-29 13:55:39', 1);
INSERT INTO `admin` VALUES (3, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'admin@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', 1);
INSERT INTO `admin` VALUES (4, 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'string', 'macro@qq.com', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', 1);
INSERT INTO `admin` VALUES (6, 'productAdmin', '$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm', NULL, 'product@qq.com', '商品管理员', '只有商品权限', '2020-02-07 16:15:08', NULL, 1);
INSERT INTO `admin` VALUES (7, 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', NULL, 'order@qq.com', '订单管理员', '只有订单管理权限', '2020-02-07 16:15:50', NULL, 1);
INSERT INTO `admin` VALUES (8, 'test1', '$2a$10$qZJHlaD3osJV15doE9dm6edWV0JMgUsFwHJSQxvKnLh48pDpfK9p2', 'shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test1@qq.com', '测试账号', '', '2020-12-23 09:32:22', NULL, 1);

-- ----------------------------
-- Table structure for admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission_relation`;
CREATE TABLE `admin_permission_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `permission_id` bigint(20) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_relation`;
CREATE TABLE `admin_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_relation
-- ----------------------------
INSERT INTO `admin_role_relation` VALUES (26, 3, 5);
INSERT INTO `admin_role_relation` VALUES (27, 6, 1);
INSERT INTO `admin_role_relation` VALUES (28, 7, 2);
INSERT INTO `admin_role_relation` VALUES (29, 1, 5);
INSERT INTO `admin_role_relation` VALUES (30, 4, 5);

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` bigint(32) NOT NULL,
  `area_id` int(32) NULL DEFAULT NULL COMMENT '区域id',
  `area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区名称',
  `area_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区编码',
  `lever_id` int(20) NULL DEFAULT NULL COMMENT '地区等级',
  `super_area_id` int(32) NULL DEFAULT NULL COMMENT '上级地区id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组级列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, 100, '江苏省', '321300000000', 6, 0, '0');
INSERT INTO `area` VALUES (2, 101, '宿迁市', '321301000000', 7, 100, '0,100');
INSERT INTO `area` VALUES (3, 102, '宿城区', '321302000000', 20, 101, '0,100,101');
INSERT INTO `area` VALUES (4, 103, '宿豫区', '321303000000', 20, 101, '0,100,101');
INSERT INTO `area` VALUES (5, 104, '苏州市', '321303000000', 7, 100, '0,100');
INSERT INTO `area` VALUES (6, 105, '苏州工业园区', '321303000000', 20, 104, '0,100,104');
INSERT INTO `area` VALUES (7, 106, '高新区', '321303000000', 20, 104, '0,100,104');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(10) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `department_id` int(10) NULL DEFAULT NULL COMMENT '部门id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门地址',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门电话',
  `lever_id` int(20) NULL DEFAULT NULL COMMENT '部门级别',
  `area_id` int(11) NULL DEFAULT NULL COMMENT '上级部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '宿城区城市管理局', 110, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (2, '宿城区农业农村局', 111, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (3, '宿城区卫生健康局', 112, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (4, '宿城区规划局', 113, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (5, '宿城区国土局', 114, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (6, '宿城区公安分局', 115, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (7, '宿城区农业局', 116, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (8, '宿城区水利局', 117, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (9, '宿城区财政局', 118, '激光产业园', '110', 8, 102);
INSERT INTO `department` VALUES (10, '宿城区发展和改革局', 119, '激光产业园', '110', 8, 102);

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `num` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典标志',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父id',
  `tips` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (0, '水位过线', '4', 1, NULL);
INSERT INTO `dict` VALUES (1, '报警类型', '0', 0, NULL);
INSERT INTO `dict` VALUES (2, '设备报警', '1', 1, NULL);
INSERT INTO `dict` VALUES (3, '断线报警', '2', 1, NULL);
INSERT INTO `dict` VALUES (4, '数据报警', '3', 1, NULL);
INSERT INTO `dict` VALUES (5, '地区等级', '0', 0, NULL);
INSERT INTO `dict` VALUES (6, '省级', '1', 5, NULL);
INSERT INTO `dict` VALUES (7, '市级', '2', 5, NULL);
INSERT INTO `dict` VALUES (8, '县级', '3', 5, NULL);
INSERT INTO `dict` VALUES (9, '镇级', '4', 5, NULL);
INSERT INTO `dict` VALUES (10, '村级', '5', 5, NULL);
INSERT INTO `dict` VALUES (11, '站点类型', '0', 0, NULL);
INSERT INTO `dict` VALUES (12, '河流断面', '1', 11, NULL);
INSERT INTO `dict` VALUES (13, '监测设备', '0', 0, NULL);
INSERT INTO `dict` VALUES (14, '总磷分析仪', '1', 13, NULL);
INSERT INTO `dict` VALUES (15, '关联乡村', '0', 0, NULL);
INSERT INTO `dict` VALUES (16, '洋北镇', '1', 15, NULL);
INSERT INTO `dict` VALUES (17, '耿车镇', '2', 15, NULL);
INSERT INTO `dict` VALUES (18, '埠子镇', '3', 15, NULL);
INSERT INTO `dict` VALUES (19, '龙河镇', '4', 15, NULL);
INSERT INTO `dict` VALUES (20, '区级', '6', 5, NULL);
INSERT INTO `dict` VALUES (21, '水质状态', '0', 0, NULL);
INSERT INTO `dict` VALUES (22, '优', '1', 21, NULL);
INSERT INTO `dict` VALUES (23, '良好', '2', 21, NULL);
INSERT INTO `dict` VALUES (24, '轻度污染', '3', 21, NULL);
INSERT INTO `dict` VALUES (25, '中度污染', '4', 21, NULL);
INSERT INTO `dict` VALUES (26, '重度污染', '5', 21, NULL);
INSERT INTO `dict` VALUES (27, '巡河状态', '0', 0, NULL);
INSERT INTO `dict` VALUES (28, '已结束', '1', 27, NULL);
INSERT INTO `dict` VALUES (29, '未结束', '2', 27, NULL);

-- ----------------------------
-- Table structure for drainage_area
-- ----------------------------
DROP TABLE IF EXISTS `drainage_area`;
CREATE TABLE `drainage_area`  (
  `id` bigint(25) NOT NULL COMMENT '流域id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流域名称',
  `valley_id` int(20) NULL DEFAULT NULL COMMENT '流域id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流域代码',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '水体类型',
  `super_valley_id` int(20) NULL DEFAULT NULL COMMENT '上级流域',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '祖级列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drainage_area
-- ----------------------------
INSERT INTO `drainage_area` VALUES (1, '淮河流域', 10, '323000000000', NULL, 0, '0');
INSERT INTO `drainage_area` VALUES (2, '黄河流域', 11, '324000000000', NULL, 0, '0');
INSERT INTO `drainage_area` VALUES (3, '京杭大运河', 12, '325000000000', '淮河水系', 10, '0,10');
INSERT INTO `drainage_area` VALUES (4, '淮沭新河', 13, '325000000000', '淮河水系', 10, '0,10');
INSERT INTO `drainage_area` VALUES (5, '徐洪河', 14, '325000000000', '淮河水系', 10, '0,10');
INSERT INTO `drainage_area` VALUES (6, '东鱼河', 15, '325000000000', '沂沭泗水系', 10, '0,10');
INSERT INTO `drainage_area` VALUES (7, '洙赵新河', 16, '325000000000', '沂沭泗水系', 10, '0,10');
INSERT INTO `drainage_area` VALUES (8, '梁济运河', 17, '325000000000', '沂沭泗水系', 11, '0,11');

-- ----------------------------
-- Table structure for hydrology_station
-- ----------------------------
DROP TABLE IF EXISTS `hydrology_station`;
CREATE TABLE `hydrology_station`  (
  `id` int(20) NOT NULL COMMENT '主键id',
  `station_id` int(20) NULL DEFAULT NULL COMMENT '水文站点id',
  `station_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '水文站点名称',
  `area_id` int(20) NULL DEFAULT NULL COMMENT '区域id',
  `valley_id` int(20) NULL DEFAULT NULL COMMENT '所属小流域id',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `longitude` decimal(60, 8) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(60, 8) NULL DEFAULT NULL COMMENT '纬度',
  `high` decimal(60, 2) NULL DEFAULT NULL COMMENT '高程',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `country_id` int(20) NULL DEFAULT NULL COMMENT '关联乡村',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT NULL COMMENT '前端隐藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (21, 0, '2020-02-07 16:29:13', '权限', 0, 0, 'ums', 'ums', 0);
INSERT INTO `menu` VALUES (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0);
INSERT INTO `menu` VALUES (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0);
INSERT INTO `menu` VALUES (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0);
INSERT INTO `menu` VALUES (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0);
INSERT INTO `menu` VALUES (26, 0, '2020-02-07 16:31:13', '实时数据', 0, 0, 'sms', 'real-time', 0);
INSERT INTO `menu` VALUES (27, 26, '2020-02-07 16:31:13', '水文地图', 1, 0, 'map', 'map', 0);
INSERT INTO `menu` VALUES (28, 26, '2020-12-22 10:06:45', '水文报表', 1, 0, 'report', 'real-time', 0);
INSERT INTO `menu` VALUES (29, 0, '2020-12-23 15:39:04', '报警信息', 0, 0, 'alarm', 'alarm-list', 0);
INSERT INTO `menu` VALUES (30, 29, '2020-12-23 16:28:15', '水质报警管理', 1, 0, 'manage', 'water-alarm', 0);
INSERT INTO `menu` VALUES (32, 0, '2020-12-24 14:22:19', '报表管理', 0, 0, 'bms', 'sms', 0);
INSERT INTO `menu` VALUES (33, 32, '2020-12-24 14:35:31', '水位日报表', 1, 0, 'waterday', 'sms', 0);
INSERT INTO `menu` VALUES (34, 32, '2020-12-25 14:42:17', '水位月报表', 1, 0, 'watermonth', 'sms', 0);
INSERT INTO `menu` VALUES (35, 29, '2020-12-25 10:11:06', '水质报警统计', 1, 0, 'count', 'water-alarm', 0);
INSERT INTO `menu` VALUES (36, 32, '2020-12-25 10:48:55', '水位报表', 1, 0, 'waterlevel', 'sms', NULL);
INSERT INTO `menu` VALUES (37, 32, NULL, '雨量报表', 1, 0, 'rainlevel', 'sms', NULL);
INSERT INTO `menu` VALUES (38, 0, '2020-12-28 09:23:21', '基础信息', 0, 0, 'basicinfo', 'base', 0);
INSERT INTO `menu` VALUES (39, 38, '2020-12-28 09:28:02', '站点管理', 1, 0, 'station', 'site', 0);
INSERT INTO `menu` VALUES (40, 39, '2020-12-28 09:30:13', '水文站点', 2, 0, 'hydrology', 'alarm', 0);
INSERT INTO `menu` VALUES (41, 39, '2020-12-28 09:31:34', '水质站点', 2, 0, 'waterquality', 'alarm', 0);
INSERT INTO `menu` VALUES (42, 0, '2020-12-28 09:34:06', '历史数据', 0, 0, 'oms', 'order', 0);
INSERT INTO `menu` VALUES (43, 42, '2020-12-28 09:35:57', '水位时段图', 1, 0, 'waterlevelchart', 'product-list', 0);
INSERT INTO `menu` VALUES (44, 42, '2020-12-28 09:37:57', '雨量时段图', 1, 0, 'rainlevelchart', 'product-list', 0);
INSERT INTO `menu` VALUES (45, 38, '2020-12-28 11:22:39', '行政区划', 1, 0, 'area', 'area', 0);
INSERT INTO `menu` VALUES (47, 38, '2020-12-28 11:23:26', '流域管理', 1, 0, 'drainagearea', 'velley', 0);
INSERT INTO `menu` VALUES (48, 38, '2020-12-28 11:24:29', '水质类别', 1, 0, 'watercategory', 'water-quality', 0);
INSERT INTO `menu` VALUES (49, 38, '2020-12-28 11:25:59', '水功能区', 1, 0, 'waterfeatures', 'water-quality', 0);
INSERT INTO `menu` VALUES (50, 38, '2020-12-28 11:27:21', '河湖名录', 1, 0, 'rivers', 'river', 0);
INSERT INTO `menu` VALUES (51, 38, '2020-12-28 11:28:27', '河长名录', 1, 0, 'revermanagers', 'river-name-list', 0);
INSERT INTO `menu` VALUES (57, 29, '2021-01-04 08:59:24', '水文实时报警', 1, 0, 'waterrealalarm', 'water-alarm', 0);
INSERT INTO `menu` VALUES (58, 29, '2021-01-04 09:03:05', '水文历史报警', 1, 0, 'waterhistoryalarm', 'water-alarm', 0);
INSERT INTO `menu` VALUES (59, 26, '2021-01-05 13:59:05', '水质报表', 1, 0, 'waterqualityreport', 'real-time', 0);
INSERT INTO `menu` VALUES (60, 26, '2021-01-11 09:00:25', '水质地图', 1, 0, 'waterqualitymap', 'map', 0);
INSERT INTO `menu` VALUES (61, 32, NULL, '水质单站报表', 1, 0, 'waterqualitysglreport', 'sms-coupon', 0);
INSERT INTO `menu` VALUES (62, 0, '2021-01-18 14:54:32', '视频列表', 0, 0, 'video', 'alarm', 0);
INSERT INTO `menu` VALUES (63, 42, '2021-01-19 08:55:17', '数据查询', 1, 0, 'waterqualityquery', 'product-list', 0);
INSERT INTO `menu` VALUES (64, 42, '2021-01-20 08:48:12', '水质评价', 1, 0, 'waterqualityevaluation', 'product-list', 0);
INSERT INTO `menu` VALUES (65, 42, '2021-01-29 09:08:24', '巡河记录', 1, 0, 'riverpatroldata', 'product-list', 0);
INSERT INTO `menu` VALUES (66, 32, NULL, '水质综合报表', 1, 0, 'waterqualitycomreport', NULL, NULL);
INSERT INTO `menu` VALUES (67, 32, NULL, '水质综合报表', 1, 0, 'waterqualitycomreport', 'sms-coupon', 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` int(1) NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 0, '商品', NULL, NULL, 0, NULL, 1, '2018-09-29 16:15:14', 0);
INSERT INTO `permission` VALUES (2, 1, '商品列表', 'pms:product:read', NULL, 1, '/pms/product/index', 1, '2018-09-29 16:17:01', 0);
INSERT INTO `permission` VALUES (3, 1, '添加商品', 'pms:product:create', NULL, 1, '/pms/product/add', 1, '2018-09-29 16:18:51', 0);
INSERT INTO `permission` VALUES (4, 1, '商品分类', 'pms:productCategory:read', NULL, 1, '/pms/productCate/index', 1, '2018-09-29 16:23:07', 0);
INSERT INTO `permission` VALUES (5, 1, '商品类型', 'pms:productAttribute:read', NULL, 1, '/pms/productAttr/index', 1, '2018-09-29 16:24:43', 0);
INSERT INTO `permission` VALUES (6, 1, '品牌管理', 'pms:brand:read', NULL, 1, '/pms/brand/index', 1, '2018-09-29 16:25:45', 0);
INSERT INTO `permission` VALUES (7, 2, '编辑商品', 'pms:product:update', NULL, 2, '/pms/product/updateProduct', 1, '2018-09-29 16:34:23', 0);
INSERT INTO `permission` VALUES (8, 2, '删除商品', 'pms:product:delete', NULL, 2, '/pms/product/delete', 1, '2018-09-29 16:38:33', 0);
INSERT INTO `permission` VALUES (9, 4, '添加商品分类', 'pms:productCategory:create', NULL, 2, '/pms/productCate/create', 1, '2018-09-29 16:43:23', 0);
INSERT INTO `permission` VALUES (10, 4, '修改商品分类', 'pms:productCategory:update', NULL, 2, '/pms/productCate/update', 1, '2018-09-29 16:43:55', 0);
INSERT INTO `permission` VALUES (11, 4, '删除商品分类', 'pms:productCategory:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:44:38', 0);
INSERT INTO `permission` VALUES (12, 5, '添加商品类型', 'pms:productAttribute:create', NULL, 2, '/pms/productAttr/create', 1, '2018-09-29 16:45:25', 0);
INSERT INTO `permission` VALUES (13, 5, '修改商品类型', 'pms:productAttribute:update', NULL, 2, '/pms/productAttr/update', 1, '2018-09-29 16:48:08', 0);
INSERT INTO `permission` VALUES (14, 5, '删除商品类型', 'pms:productAttribute:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:48:44', 0);
INSERT INTO `permission` VALUES (15, 6, '添加品牌', 'pms:brand:create', NULL, 2, '/pms/brand/add', 1, '2018-09-29 16:49:34', 0);
INSERT INTO `permission` VALUES (16, 6, '修改品牌', 'pms:brand:update', NULL, 2, '/pms/brand/update', 1, '2018-09-29 16:50:55', 0);
INSERT INTO `permission` VALUES (17, 6, '删除品牌', 'pms:brand:delete', NULL, 2, '/pms/brand/delete', 1, '2018-09-29 16:50:59', 0);
INSERT INTO `permission` VALUES (18, 0, '首页', NULL, NULL, 0, NULL, 1, '2018-09-29 16:51:57', 0);

-- ----------------------------
-- Table structure for rain_level_day
-- ----------------------------
DROP TABLE IF EXISTS `rain_level_day`;
CREATE TABLE `rain_level_day`  (
  `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `station_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `zero_hour` double UNSIGNED NOT NULL DEFAULT 0,
  `first_hour` double UNSIGNED NULL DEFAULT 0,
  `second_hour` double UNSIGNED NULL DEFAULT 0,
  `third_hour` double UNSIGNED NULL DEFAULT 0,
  `fourth_hour` double UNSIGNED NULL DEFAULT 0,
  `fifth_hour` double UNSIGNED NULL DEFAULT 0,
  `sixth_hour` double UNSIGNED NULL DEFAULT 0,
  `seventh_hour` double UNSIGNED NULL DEFAULT 0,
  `eighth_hour` double UNSIGNED NULL DEFAULT 0,
  `ninth_hour` double UNSIGNED NULL DEFAULT 0,
  `tenth_hour` double UNSIGNED NULL DEFAULT 0,
  `eleventh_hour` double UNSIGNED NULL DEFAULT 0,
  `twelfth_hour` double UNSIGNED NULL DEFAULT 0,
  `thirteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `fourteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `fifteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `sixteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `seventeenth_hour` double UNSIGNED NULL DEFAULT 0,
  `eighteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `nineteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_first_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_two_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_three_hour` double UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rain_level_day
-- ----------------------------
INSERT INTO `rain_level_day` VALUES (8, '100001', '2020-12-20', 12.34, 12.35, 12.36, 12.36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (9, '100001', '2020-12-21', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (10, '100001', '2020-12-22', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (11, '100001', '2020-08-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (12, '100001', '2020-09-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (13, '100001', '2020-09-03', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (14, '100001', '2020-09-02', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (15, '100001', '2020-12-23', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (16, '100001', '2020-12-24', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (17, '100001', '2020-12-25', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (18, '100001', '2020-12-26', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (19, '100001', '2020-12-27', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (20, '100001', '2020-12-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (21, '100002', '2020-12-05', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (22, '100003', '2020-12-06', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (23, '100003', '2020-12-07', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (24, '100003', '2020-12-08', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (25, '100004', '2020-12-09', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (26, '100001', '2021-01-05', 234, 23, 23, 234, 23, 65465675, 567, 567, 345, 345, 34534534, 567, 789, 678, 890, 890, 567, 345, 56, 45567, 78, 789, 789, 789);
INSERT INTO `rain_level_day` VALUES (27, '100005', '2021-01-05', 342, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (28, '100001', '2021-01-07', 234, 234, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_day` VALUES (29, '100002', '2021-01-07', 2324, 234, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for rain_level_month
-- ----------------------------
DROP TABLE IF EXISTS `rain_level_month`;
CREATE TABLE `rain_level_month`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `stationId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `one` double UNSIGNED NULL DEFAULT 0,
  `two` double UNSIGNED NULL DEFAULT 0,
  `three` double UNSIGNED NULL DEFAULT 0,
  `four` double UNSIGNED NULL DEFAULT 0,
  `five` double UNSIGNED NULL DEFAULT 0,
  `six` double UNSIGNED NULL DEFAULT NULL,
  `seven` double UNSIGNED NULL DEFAULT 0,
  `eight` double UNSIGNED NULL DEFAULT 0,
  `nine` double UNSIGNED NULL DEFAULT 0,
  `ten` double UNSIGNED NULL DEFAULT 0,
  `eleven` double UNSIGNED NULL DEFAULT 0,
  `twelve` double UNSIGNED NULL DEFAULT 0,
  `thirteen` double UNSIGNED NULL DEFAULT 0,
  `fourteen` double UNSIGNED NULL DEFAULT 0,
  `fifteen` double UNSIGNED NULL DEFAULT 0,
  `sixteen` double UNSIGNED NULL DEFAULT 0,
  `seventeen` double UNSIGNED NULL DEFAULT 0,
  `eighteen` double UNSIGNED NULL DEFAULT 0,
  `nineteen` double UNSIGNED NULL DEFAULT 0,
  `twenty` double UNSIGNED NULL DEFAULT 0,
  `twenty_one` double UNSIGNED NULL DEFAULT 0,
  `twenty_two` double UNSIGNED NULL DEFAULT 0,
  `twenty_three` double UNSIGNED NULL DEFAULT 0,
  `twenty_four` double UNSIGNED NULL DEFAULT 0,
  `twenty_five` double UNSIGNED NULL DEFAULT 0,
  `twenty_six` double UNSIGNED NULL DEFAULT 0,
  `twenty_seven` double UNSIGNED NULL DEFAULT 0,
  `twenty_eight` double UNSIGNED NULL DEFAULT 0,
  `twenty_nine` double UNSIGNED NULL DEFAULT 0,
  `thirty` double UNSIGNED NULL DEFAULT 0,
  `thirty_one` double UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rain_level_month
-- ----------------------------
INSERT INTO `rain_level_month` VALUES (1, '100001', '2020-01', 90, 45, 345, 345, 34, 345, 2.83, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 3, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_month` VALUES (2, '100001', '2020-02', 0, 0, 0, 0, 0, NULL, 2.83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_month` VALUES (5, '100001', '2021-03', 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_month` VALUES (11, '100001', '2021-01', 0, 0, 0, 0, 0, NULL, 2.83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `rain_level_month` VALUES (12, '100002', '2021-01', 0, 0, 0, 0, 0, NULL, 13509.75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for rain_level_year
-- ----------------------------
DROP TABLE IF EXISTS `rain_level_year`;
CREATE TABLE `rain_level_year`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `stationId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `one` double NULL DEFAULT NULL,
  `two` double NULL DEFAULT NULL,
  `three` double NULL DEFAULT NULL,
  `four` double NULL DEFAULT NULL,
  `five` double NULL DEFAULT NULL,
  `six` double NULL DEFAULT NULL,
  `seven` double NULL DEFAULT NULL,
  `eight` double NULL DEFAULT NULL,
  `nine` double NULL DEFAULT NULL,
  `ten` double NULL DEFAULT NULL,
  `eleven` double NULL DEFAULT NULL,
  `twelve` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rain_level_year
-- ----------------------------
INSERT INTO `rain_level_year` VALUES (1, '100001', '2021', 34, 345, 345, NULL, 345, NULL, 345, NULL, 345, NULL, 345, 345345);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '资源分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '2020-02-04 17:04:55', '商品品牌管理', '/intellisense-user/brand/**', NULL, 1);
INSERT INTO `resource` VALUES (2, '2020-02-04 17:05:35', '商品属性分类管理', '/intellisense-user/productAttribute/**', NULL, 1);
INSERT INTO `resource` VALUES (3, '2020-02-04 17:06:13', '商品属性管理', '/intellisense-user/productAttribute/**', NULL, 1);
INSERT INTO `resource` VALUES (4, '2020-02-04 17:07:15', '商品分类管理', '/intellisense-user/productCategory/**', NULL, 1);
INSERT INTO `resource` VALUES (5, '2020-02-04 17:09:16', '商品管理', '/intellisense-user/product/**', NULL, 1);
INSERT INTO `resource` VALUES (6, '2020-02-04 17:09:53', '商品库存管理', '/intellisense-user/sku/**', NULL, 1);
INSERT INTO `resource` VALUES (8, '2020-02-05 14:43:37', '订单管理', '/intellisense-user/order/**', '', 2);
INSERT INTO `resource` VALUES (9, '2020-02-05 14:44:22', ' 订单退货申请管理', '/intellisense-user/returnApply/**', '', 2);
INSERT INTO `resource` VALUES (10, '2020-02-05 14:45:08', '退货原因管理', '/intellisense-user/returnReason/**', '', 2);
INSERT INTO `resource` VALUES (11, '2020-02-05 14:45:43', '订单设置管理', '/intellisense-user/orderSetting/**', '', 2);
INSERT INTO `resource` VALUES (12, '2020-02-05 14:46:23', '收货地址管理', '/intellisense-user/companyAddress/**', '', 2);
INSERT INTO `resource` VALUES (13, '2020-02-07 16:37:22', '优惠券管理', '/intellisense-user/coupon/**', '', 3);
INSERT INTO `resource` VALUES (14, '2020-02-07 16:37:59', '优惠券领取记录管理', '/intellisense-user/couponHistory/**', '', 3);
INSERT INTO `resource` VALUES (15, '2020-02-07 16:38:28', '限时购活动管理', '/intellisense-user/flash/**', '', 3);
INSERT INTO `resource` VALUES (16, '2020-02-07 16:38:59', '限时购商品关系管理', '/intellisense-user/flashProductRelation/**', '', 3);
INSERT INTO `resource` VALUES (17, '2020-02-07 16:39:22', '限时购场次管理', '/intellisense-user/flashSession/**', '', 3);
INSERT INTO `resource` VALUES (18, '2020-02-07 16:40:07', '首页轮播广告管理', '/intellisense-user/home/advertise/**', '', 3);
INSERT INTO `resource` VALUES (19, '2020-02-07 16:40:34', '首页品牌管理', '/intellisense-user/home/brand/**', '', 3);
INSERT INTO `resource` VALUES (20, '2020-02-07 16:41:06', '首页新品管理', '/intellisense-user/home/newProduct/**', '', 3);
INSERT INTO `resource` VALUES (21, '2020-02-07 16:42:16', '首页人气推荐管理', '/intellisense-user/home/recommendProduct/**', '', 3);
INSERT INTO `resource` VALUES (22, '2020-02-07 16:42:48', '首页专题推荐管理', '/intellisense-user/home/recommendSubject/**', '', 3);
INSERT INTO `resource` VALUES (23, '2020-02-07 16:44:56', ' 商品优选管理', '/intellisense-user/prefrenceArea/**', '', 5);
INSERT INTO `resource` VALUES (24, '2020-02-07 16:45:39', '商品专题管理', '/intellisense-user/subject/**', '', 5);
INSERT INTO `resource` VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/intellisense-user/admin/**', '', 4);
INSERT INTO `resource` VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/intellisense-user/role/**', '', 4);
INSERT INTO `resource` VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/intellisense-user/menu/**', '', 4);
INSERT INTO `resource` VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/intellisense-user/resourceCategory/**', '', 4);
INSERT INTO `resource` VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/intellisense-user/resource/**', '', 4);
INSERT INTO `resource` VALUES (31, '2020-08-24 13:43:54', '登录后获取用户信息', '/intellisense-user/admin/info', '后台用户登录需要配置', 4);
INSERT INTO `resource` VALUES (32, '2020-08-24 13:44:37', '后台用户登出', '/intellisense-user/admin/logout', '后台用户登出需要配置', 4);
INSERT INTO `resource` VALUES (33, '2020-12-22 10:45:53', '水文报表管理', '/intellisense-floodcontrol/waterReport/**', NULL, 3);
INSERT INTO `resource` VALUES (34, '2020-12-22 16:13:56', '报警信息管理', '/waterquality-monitor/waterAlarmController/**', NULL, 3);
INSERT INTO `resource` VALUES (35, '2020-12-24 16:33:12', '水位报表', '/intellisense-floodcontrol/waterLevel/**', NULL, 3);
INSERT INTO `resource` VALUES (36, '2020-12-26 09:45:37', '水质站点查询', '/waterquality-monitor/waterStationController/**', NULL, 3);
INSERT INTO `resource` VALUES (37, '2020-12-28 11:31:16', '水文历史图', '/intellisense-floodcontrol/history/**', NULL, 3);
INSERT INTO `resource` VALUES (38, '2020-12-30 09:29:40', '基础信息', '/waterquality-monitor/basicInfoController/**', NULL, 3);
INSERT INTO `resource` VALUES (39, '2021-01-04 11:33:27', '水文报警', '/intellisense-floodcontrol/alarm/**', NULL, 3);
INSERT INTO `resource` VALUES (40, '2021-01-06 13:15:36', '水质管理', '/waterquality-monitor/waterQuality/**', NULL, 3);
INSERT INTO `resource` VALUES (41, NULL, '雨量报表', '/intellisense-floodcontrol/rainLevel/**', NULL, 3);
INSERT INTO `resource` VALUES (42, NULL, '水质单站', '/intellisense-floodcontrol/waterQualityReport/**', NULL, 3);
INSERT INTO `resource` VALUES (43, '2021-01-29 09:11:51', '巡河', '/intellisense-riverpatorl/riverPatrolController/**', NULL, 3);

-- ----------------------------
-- Table structure for resource_category
-- ----------------------------
DROP TABLE IF EXISTS `resource_category`;
CREATE TABLE `resource_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_category
-- ----------------------------
INSERT INTO `resource_category` VALUES (1, '2020-02-05 10:21:44', '商品模块', 0);
INSERT INTO `resource_category` VALUES (2, '2020-02-05 10:22:34', '订单模块', 0);
INSERT INTO `resource_category` VALUES (3, '2020-02-05 10:22:48', '营销模块', 0);
INSERT INTO `resource_category` VALUES (4, '2020-02-05 10:23:04', '权限模块', 0);
INSERT INTO `resource_category` VALUES (5, '2020-02-07 16:34:27', '内容模块', 0);
INSERT INTO `resource_category` VALUES (6, '2020-02-07 16:35:49', '其他模块', 0);

-- ----------------------------
-- Table structure for river_area
-- ----------------------------
DROP TABLE IF EXISTS `river_area`;
CREATE TABLE `river_area`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡河地区名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级地区id',
  `ancestors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组级列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of river_area
-- ----------------------------
INSERT INTO `river_area` VALUES (1, '宿城区', 0, '0');
INSERT INTO `river_area` VALUES (2, '支口街道', 1, '0,1');
INSERT INTO `river_area` VALUES (3, '王官集镇', 1, '0,1');
INSERT INTO `river_area` VALUES (4, '蔡集镇', 1, '0,1');
INSERT INTO `river_area` VALUES (5, '幸福街道', 1, '0,1');
INSERT INTO `river_area` VALUES (6, '张一居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (7, '张二居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (8, '张三居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (9, '张四居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (10, '张无居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (11, '张六居委会', 3, '0,1,3');
INSERT INTO `river_area` VALUES (12, '王一居委会', 5, '0,1,5');
INSERT INTO `river_area` VALUES (13, '王二居委会', 5, '0,1,5');
INSERT INTO `river_area` VALUES (14, '王三居委会', 5, '0,1,5');
INSERT INTO `river_area` VALUES (15, '王四居委会', 5, '0,1,5');
INSERT INTO `river_area` VALUES (16, '王五居委会', 5, '0,1,5');
INSERT INTO `river_area` VALUES (17, '王六居委会', 5, '0,1,5');

-- ----------------------------
-- Table structure for river_managers
-- ----------------------------
DROP TABLE IF EXISTS `river_managers`;
CREATE TABLE `river_managers`  (
  `id` int(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '河长姓名',
  `lever_id` int(20) NULL DEFAULT NULL COMMENT '河长级别',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '河长类型',
  `area_id` int(20) NULL DEFAULT NULL COMMENT '区域id',
  `post` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行政职务',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '河长账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of river_managers
-- ----------------------------
INSERT INTO `river_managers` VALUES (1, '张三', 8, '总河长', 102, '区委副书记、总河长', 'zhangsan@qq.com');
INSERT INTO `river_managers` VALUES (2, '李二', 8, '总河长', 102, '区政府副区长、总河长', 'lier@qq.com');
INSERT INTO `river_managers` VALUES (3, '王一', 8, '总河长', 102, '区委常委、总河长', 'wangyi@qq.com');

-- ----------------------------
-- Table structure for river_patrol_data
-- ----------------------------
DROP TABLE IF EXISTS `river_patrol_data`;
CREATE TABLE `river_patrol_data`  (
  `id` int(10) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡河人员',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `mileage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡河里程',
  `problem` int(8) NULL DEFAULT NULL COMMENT '巡河问题',
  `river_track_id` int(10) NULL DEFAULT NULL COMMENT '巡河轨迹id',
  `river_id` int(10) NULL DEFAULT NULL COMMENT '河湖id',
  `status` int(10) NULL DEFAULT NULL COMMENT '巡河状态id',
  `river_area_id` int(10) NULL DEFAULT NULL COMMENT '所属区域',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of river_patrol_data
-- ----------------------------
INSERT INTO `river_patrol_data` VALUES (1, '张一', '2021-01-26 10:01:32', '2021-01-28 10:01:36', '0.55', 0, 23, 1, 28, 6);
INSERT INTO `river_patrol_data` VALUES (3, '张二', '2021-01-27 15:01:32', '2021-01-28 08:01:36', '0.4', 0, 23, 3, 29, 8);
INSERT INTO `river_patrol_data` VALUES (4, '张三', '2021-01-27 15:01:32', '2021-01-28 08:01:36', '0.4', 0, 23, 2, 29, 9);
INSERT INTO `river_patrol_data` VALUES (5, '张四', '2021-01-27 15:01:32', '2021-01-28 08:01:36', '0.4', 0, 23, 2, 28, 12);
INSERT INTO `river_patrol_data` VALUES (6, '张五', '2021-01-27 15:01:32', '2021-01-28 08:01:36', '0.4', 0, 23, 2, 28, 13);
INSERT INTO `river_patrol_data` VALUES (7, '张六', '2021-01-27 15:01:32', '2021-01-28 08:01:36', '0.4', 0, 23, 2, 29, 14);
INSERT INTO `river_patrol_data` VALUES (8, '张七', '2021-01-27 15:01:32', '2021-01-31 08:01:36', '0.4', 0, 23, 2, 29, 15);

-- ----------------------------
-- Table structure for river_track
-- ----------------------------
DROP TABLE IF EXISTS `river_track`;
CREATE TABLE `river_track`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '轨迹id',
  `trackPoints` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '轨迹',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of river_track
-- ----------------------------
INSERT INTO `river_track` VALUES (16, 'H4sIAAAAAAAAAIuuVspJLMksKU1JVbIyNtazNDYyMjA0sjAxMTLRgUu5mgEl9YyRJQ0MXc2BCvLz\n0qGaDQ0t9IwMTEzNTCxMLcxNkORAug31DC2QZF0tanUGzOZYAFUKRZn1AAAA');
INSERT INTO `river_track` VALUES (17, 'H4sIAAAAAAAAAO3NOwrCQABF0b2kDkPmk2S0zyrEQlBEEG1iJe7dCCLZg6e+73F2z+Z6mC/z43hq\ntjmHTU6pi6mWkkr7S9OwxJDXsYvTuAzut/P3HGMNqSv9UGpfx7Jqn3cMsa7qVF8tmUwmk8lkMplM\nJpPJZDKZTCaTyWQymUwmk8lkMplMJpPJZDKZTCaTyWQymUwmk8lkMplMJpPJZDKZTCaTyWQymUwm\nk8lkMplMJpPJZDKZTCaTyWQymUwmk8lk8h/L+zcluJxhR2oAAA==');
INSERT INTO `river_track` VALUES (18, 'H4sIAAAAAAAAAO3Ru4oCQRCF4XcxlqFOV3VdzOcpxEDYZVkQN3Ej8d1toUcnqI5NjL9p/uHU/ro5\nHS+/l/+v782OeQouhVBcpMj2SbM2nHiNhNnaB3/nn/4Y8KmQVBWvbrKyx2tM8JXOftt+ym8tQwzV\nVaBJ+YV5V5SAEpx3Fx10nbmowtJuR42oabpyGMGtpumnUlssqzOhmYsiqb8wTzu4/V3VPL3oaG1x\ni0DN1+6Yr22wwhr52B1HVYrwoMGNOw5u3I4B0CC7aOse7rTwnW1FBAAA');
INSERT INTO `river_track` VALUES (19, 'H4sIAAAAAAAAAO3Ru4oCQRCF4XcxlqFOV3VdzOcpxEDYZVkQN3Ej8d1toUcnqI5NjL9p/uHU/ro5\nHS+/l/+v782OeQouhVBcpMj2SbM2nHiNhNnaB3/nn/4Y8KmQVBWvbrKyx2tM8JXOftt+ym8tQwzV\nVaBJ+YV5V5SAEpx3Fx10nbmowtJuR42oabpyGMGtpumnUlssqzOhmYsiqb8wTzu4/V3VPL3oaG1x\ni0DN1+6Yr22wwhr52B1HVYrwoMGNOw5u3I4B0CC7aOse7rTwnW1FBAAA');
INSERT INTO `river_track` VALUES (20, 'H4sIAAAAAAAAAHXSTUrEQBCG4bvMegj131Xu5xTiQlBEEN2MK/Hu1oxJO+CXrAJvmoeu1P3X4e3x\n/Hr+fHo+3KkupSrqwimsx5lO0XHR23ganT/eX9ajzLkIBakJm8tNu5zlpc/81VN+H/+7rK4pKo7c\nGaHrVaZebNCdlYghLTUoPCqAPBuGUzks0zG8VaxmilAyFWJnxO4oJ6sY2N0qdi21UvoFuTPuuE5M\n5jv33Sp2nURM+zPkzohdqxK9riRg17hz26CS0fOEt13jqL0fzM7ZM0ksbxXTWiM4HA96RuxS6NDr\nagD2N2b1g2UqJu4FGkieEcqWFFxD8axnbffhB9fi1xw9BAAA');
INSERT INTO `river_track` VALUES (21, 'H4sIAAAAAAAAAHXUz0oDQQzH8XfpuSz5M8kk3vsU4kFQRBC91JP47sZ2Nxb8bU+F704/zEy691+H\nt8fz6/nz6flwp7qkqqgJh7AeO5284qK38TQrf7y/rEuZYxFy0iE8TG7a71peas1fPcX38b/Lahqi\nYsjtCF3LHGrJA7pdiRjSkpPcPB3I3TAcyj4iDMNbxWqECAVTIrYjdmcajfSJ3a1id4RmSH1Bbscd\n14hp2M5+t4pdI5Gh9RhyO2J3ZIpeRhKwa9zZrVPKrPOEu13jzL0LZuOoMwksbxXTmtPZDR90R+yS\n69TLaAD2GiPrg2VKJq4BmkjuCOUR5JxT8Vl3xa4Mca6bhDvuiN363Yg0PNJdscvBg+svjtitYdVk\n8nT8wtrizl5p2hRmeMYdd9SauhobfL1dr++rhx9//SXhpAUAAA==');
INSERT INTO `river_track` VALUES (22, 'H4sIAAAAAAAAAHWUy0rEQBBF/8X1MNSj6+V+vkJcCIoIoptxJf675Zi0A97OKnDSOblVlbr7vHl9\nOL+cPx6fbm5Vj6UqasIprIeJTt7wqNfwFI3f3563o8x5FHLSITxMrtjPWT72mT96yq/Dfy+raYqK\nIe+E0GtVQ614QO+kRAzVUkFuXg7Mk2FxKvvINCzeKbZmilAyFdJOiL1RRqM8sHen2DtSK6VvkHfC\nhdeIadgi706x10hkaD+GvBNi76gSvYwk0G5wkdapJLqeMO0Go1YNZuPsmiQ27xSrtcLZDRd6Quwl\n19DLaADtL8zqC5upmLgHKJB5QmgeSc4Vims9KfbKEOfuJEw8Ifb2ezPL8EhPir2cPLh/caTdGbaa\nBIfjhbXDRVYKC2GGNZ5wYe2p67HB7Z10ua+6FkrS6wXm3aD02lvY3Xoj1ir0Rleptb/PEy6tCVfe\nyEGLBm+wrffflxMvRZUGAAA=');
INSERT INTO `river_track` VALUES (23, 'H4sIAAAAAAAAAH2VS4oVQRBF99Lj5hGfjJ/zt4rGgaCIIDppR+LejW6z0gZvWKOCU1mnbmRk1NPP\nh68fnr88//j46eGd6q1URU04hfXxoLs3vOlbeI/G37993kuZ8ybkpEt4mbxhL2v51mv+0nv+evzX\ny2qaomLIeyD0WtVSK17QeygRQ7VUkJuXA/NhWJzKvjINiy+KrZkilEyFtAdib5TRKg/svSj2rtRK\n6RvkPXDwGjEtG/JeFHuNRJb2Y8h7IPauKtHXlgTaDYe0TiXR9YRpN4yaNpiNs2uS2HxRrNYKZzdc\n6AOxl1xDX1sDaP/ArL6wmYqJu4ECmQ+E5pXkXKG41odiryxx7p2EiQ/E3n5vZhlu6UOxl5MX9xFH\n2othq0lwOB5YFxyyUlgIM6zxgYO1u67bBm/voeO86looSY8XmHdD6bE32N16ItYUetMptfb3ecKh\ndeDkjVw0bPCG/7GKMe6rDXk6xP1ujdDAv4dDx3K/DKbli+D/4UCiodwetqKbf2jsTQe1UheFa0H1\nhjoGd+Eo4ulMbdrq978B0zHW2wkIAAA=');

-- ----------------------------
-- Table structure for rivers
-- ----------------------------
DROP TABLE IF EXISTS `rivers`;
CREATE TABLE `rivers`  (
  `id` int(20) NOT NULL COMMENT '主键id',
  `riverName` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '河流名称',
  `name_id` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '河长姓名',
  `lever_id` int(10) NULL DEFAULT NULL COMMENT '河流等级',
  `length` double(10, 2) NULL DEFAULT NULL COMMENT '河流长度',
  `valleyAcreage` double(10, 2) NULL DEFAULT NULL COMMENT '流域面积',
  `waterAcreage` double(10, 2) NULL DEFAULT NULL COMMENT '水域面积',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rivers
-- ----------------------------
INSERT INTO `rivers` VALUES (1, '卓玛河', '3', 20, 17.66, 20.50, 20.50);
INSERT INTO `rivers` VALUES (2, '清水河', '3', 20, 15.66, 20.50, 20.50);
INSERT INTO `rivers` VALUES (3, '团结河', '2', 20, 20.66, 20.50, 20.50);
INSERT INTO `rivers` VALUES (4, '东方红河', '1', 20, 20.66, 20.50, 20.50);
INSERT INTO `rivers` VALUES (5, '利民河', '1', 20, 20.66, 20.50, 20.50);
INSERT INTO `rivers` VALUES (6, '七支沟', '1', 20, 20.66, 20.50, 19.50);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) NULL DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '商品管理员', '只能查看及操作商品', 0, '2020-02-03 16:50:37', 1, 0);
INSERT INTO `role` VALUES (2, '订单管理员', '只能查看及操作订单', 0, '2018-09-30 15:53:45', 1, 0);
INSERT INTO `role` VALUES (5, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 0);

-- ----------------------------
-- Table structure for role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_relation
-- ----------------------------
INSERT INTO `role_menu_relation` VALUES (33, 1, 1);
INSERT INTO `role_menu_relation` VALUES (34, 1, 2);
INSERT INTO `role_menu_relation` VALUES (35, 1, 3);
INSERT INTO `role_menu_relation` VALUES (36, 1, 4);
INSERT INTO `role_menu_relation` VALUES (37, 1, 5);
INSERT INTO `role_menu_relation` VALUES (38, 1, 6);
INSERT INTO `role_menu_relation` VALUES (53, 2, 7);
INSERT INTO `role_menu_relation` VALUES (54, 2, 8);
INSERT INTO `role_menu_relation` VALUES (55, 2, 9);
INSERT INTO `role_menu_relation` VALUES (56, 2, 10);
INSERT INTO `role_menu_relation` VALUES (57, 2, 11);
INSERT INTO `role_menu_relation` VALUES (72, 5, 1);
INSERT INTO `role_menu_relation` VALUES (73, 5, 2);
INSERT INTO `role_menu_relation` VALUES (74, 5, 3);
INSERT INTO `role_menu_relation` VALUES (75, 5, 4);
INSERT INTO `role_menu_relation` VALUES (76, 5, 5);
INSERT INTO `role_menu_relation` VALUES (77, 5, 6);
INSERT INTO `role_menu_relation` VALUES (78, 5, 7);
INSERT INTO `role_menu_relation` VALUES (79, 5, 8);
INSERT INTO `role_menu_relation` VALUES (80, 5, 9);
INSERT INTO `role_menu_relation` VALUES (81, 5, 10);
INSERT INTO `role_menu_relation` VALUES (82, 5, 11);
INSERT INTO `role_menu_relation` VALUES (83, 5, 12);
INSERT INTO `role_menu_relation` VALUES (84, 5, 13);
INSERT INTO `role_menu_relation` VALUES (85, 5, 14);
INSERT INTO `role_menu_relation` VALUES (86, 5, 16);
INSERT INTO `role_menu_relation` VALUES (87, 5, 17);
INSERT INTO `role_menu_relation` VALUES (88, 5, 18);
INSERT INTO `role_menu_relation` VALUES (89, 5, 19);
INSERT INTO `role_menu_relation` VALUES (90, 5, 20);
INSERT INTO `role_menu_relation` VALUES (91, 5, 21);
INSERT INTO `role_menu_relation` VALUES (92, 5, 22);
INSERT INTO `role_menu_relation` VALUES (93, 5, 23);
INSERT INTO `role_menu_relation` VALUES (94, 5, 24);
INSERT INTO `role_menu_relation` VALUES (95, 5, 25);
INSERT INTO `role_menu_relation` VALUES (96, 5, 26);
INSERT INTO `role_menu_relation` VALUES (97, 5, 27);
INSERT INTO `role_menu_relation` VALUES (98, 5, 28);
INSERT INTO `role_menu_relation` VALUES (99, 5, 29);
INSERT INTO `role_menu_relation` VALUES (100, 5, 30);
INSERT INTO `role_menu_relation` VALUES (101, 5, 31);
INSERT INTO `role_menu_relation` VALUES (102, 5, 32);
INSERT INTO `role_menu_relation` VALUES (103, 5, 33);
INSERT INTO `role_menu_relation` VALUES (104, 5, 34);
INSERT INTO `role_menu_relation` VALUES (105, 5, 35);
INSERT INTO `role_menu_relation` VALUES (106, 5, 36);
INSERT INTO `role_menu_relation` VALUES (107, 5, 37);
INSERT INTO `role_menu_relation` VALUES (108, 5, 38);
INSERT INTO `role_menu_relation` VALUES (109, 5, 39);
INSERT INTO `role_menu_relation` VALUES (110, 5, 40);
INSERT INTO `role_menu_relation` VALUES (111, 5, 41);
INSERT INTO `role_menu_relation` VALUES (112, 5, 42);
INSERT INTO `role_menu_relation` VALUES (113, 5, 43);
INSERT INTO `role_menu_relation` VALUES (114, 5, 44);
INSERT INTO `role_menu_relation` VALUES (115, 5, 45);
INSERT INTO `role_menu_relation` VALUES (116, 5, 46);
INSERT INTO `role_menu_relation` VALUES (117, 5, 47);
INSERT INTO `role_menu_relation` VALUES (118, 5, 48);
INSERT INTO `role_menu_relation` VALUES (119, 5, 50);
INSERT INTO `role_menu_relation` VALUES (120, 5, 51);
INSERT INTO `role_menu_relation` VALUES (121, 5, 49);
INSERT INTO `role_menu_relation` VALUES (122, 5, 57);
INSERT INTO `role_menu_relation` VALUES (123, 5, 58);
INSERT INTO `role_menu_relation` VALUES (124, 5, 59);
INSERT INTO `role_menu_relation` VALUES (125, 5, 60);
INSERT INTO `role_menu_relation` VALUES (126, 5, 61);
INSERT INTO `role_menu_relation` VALUES (127, 5, 62);
INSERT INTO `role_menu_relation` VALUES (128, 5, 63);
INSERT INTO `role_menu_relation` VALUES (129, 5, 64);
INSERT INTO `role_menu_relation` VALUES (130, 5, 65);
INSERT INTO `role_menu_relation` VALUES (131, 5, 67);

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `permission_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色和权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission_relation
-- ----------------------------
INSERT INTO `role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `role_permission_relation` VALUES (2, 1, 2);
INSERT INTO `role_permission_relation` VALUES (3, 1, 3);
INSERT INTO `role_permission_relation` VALUES (4, 1, 7);
INSERT INTO `role_permission_relation` VALUES (5, 1, 8);
INSERT INTO `role_permission_relation` VALUES (6, 2, 4);
INSERT INTO `role_permission_relation` VALUES (7, 2, 9);
INSERT INTO `role_permission_relation` VALUES (8, 2, 10);
INSERT INTO `role_permission_relation` VALUES (9, 2, 11);
INSERT INTO `role_permission_relation` VALUES (10, 3, 5);
INSERT INTO `role_permission_relation` VALUES (11, 3, 12);
INSERT INTO `role_permission_relation` VALUES (12, 3, 13);
INSERT INTO `role_permission_relation` VALUES (13, 3, 14);
INSERT INTO `role_permission_relation` VALUES (14, 4, 6);
INSERT INTO `role_permission_relation` VALUES (15, 4, 15);
INSERT INTO `role_permission_relation` VALUES (16, 4, 16);
INSERT INTO `role_permission_relation` VALUES (17, 4, 17);

-- ----------------------------
-- Table structure for role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_relation`;
CREATE TABLE `role_resource_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 236 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台角色资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource_relation
-- ----------------------------
INSERT INTO `role_resource_relation` VALUES (178, 5, 1);
INSERT INTO `role_resource_relation` VALUES (179, 5, 2);
INSERT INTO `role_resource_relation` VALUES (180, 5, 3);
INSERT INTO `role_resource_relation` VALUES (181, 5, 4);
INSERT INTO `role_resource_relation` VALUES (182, 5, 5);
INSERT INTO `role_resource_relation` VALUES (183, 5, 6);
INSERT INTO `role_resource_relation` VALUES (184, 5, 8);
INSERT INTO `role_resource_relation` VALUES (185, 5, 9);
INSERT INTO `role_resource_relation` VALUES (186, 5, 10);
INSERT INTO `role_resource_relation` VALUES (187, 5, 11);
INSERT INTO `role_resource_relation` VALUES (188, 5, 12);
INSERT INTO `role_resource_relation` VALUES (189, 5, 13);
INSERT INTO `role_resource_relation` VALUES (190, 5, 14);
INSERT INTO `role_resource_relation` VALUES (191, 5, 15);
INSERT INTO `role_resource_relation` VALUES (192, 5, 16);
INSERT INTO `role_resource_relation` VALUES (193, 5, 17);
INSERT INTO `role_resource_relation` VALUES (194, 5, 18);
INSERT INTO `role_resource_relation` VALUES (195, 5, 19);
INSERT INTO `role_resource_relation` VALUES (196, 5, 20);
INSERT INTO `role_resource_relation` VALUES (197, 5, 21);
INSERT INTO `role_resource_relation` VALUES (198, 5, 22);
INSERT INTO `role_resource_relation` VALUES (199, 5, 23);
INSERT INTO `role_resource_relation` VALUES (200, 5, 24);
INSERT INTO `role_resource_relation` VALUES (201, 5, 25);
INSERT INTO `role_resource_relation` VALUES (202, 5, 26);
INSERT INTO `role_resource_relation` VALUES (203, 5, 27);
INSERT INTO `role_resource_relation` VALUES (204, 5, 28);
INSERT INTO `role_resource_relation` VALUES (205, 5, 29);
INSERT INTO `role_resource_relation` VALUES (206, 5, 31);
INSERT INTO `role_resource_relation` VALUES (207, 5, 32);
INSERT INTO `role_resource_relation` VALUES (208, 2, 8);
INSERT INTO `role_resource_relation` VALUES (209, 2, 9);
INSERT INTO `role_resource_relation` VALUES (210, 2, 10);
INSERT INTO `role_resource_relation` VALUES (211, 2, 11);
INSERT INTO `role_resource_relation` VALUES (212, 2, 12);
INSERT INTO `role_resource_relation` VALUES (213, 2, 31);
INSERT INTO `role_resource_relation` VALUES (214, 2, 32);
INSERT INTO `role_resource_relation` VALUES (215, 1, 1);
INSERT INTO `role_resource_relation` VALUES (216, 1, 2);
INSERT INTO `role_resource_relation` VALUES (217, 1, 3);
INSERT INTO `role_resource_relation` VALUES (218, 1, 4);
INSERT INTO `role_resource_relation` VALUES (219, 1, 5);
INSERT INTO `role_resource_relation` VALUES (220, 1, 6);
INSERT INTO `role_resource_relation` VALUES (221, 1, 23);
INSERT INTO `role_resource_relation` VALUES (222, 1, 24);
INSERT INTO `role_resource_relation` VALUES (223, 1, 31);
INSERT INTO `role_resource_relation` VALUES (224, 1, 32);
INSERT INTO `role_resource_relation` VALUES (225, 5, 33);
INSERT INTO `role_resource_relation` VALUES (226, 5, 34);
INSERT INTO `role_resource_relation` VALUES (227, 5, 35);
INSERT INTO `role_resource_relation` VALUES (228, 5, 36);
INSERT INTO `role_resource_relation` VALUES (229, 5, 37);
INSERT INTO `role_resource_relation` VALUES (230, 5, 38);
INSERT INTO `role_resource_relation` VALUES (231, 5, 39);
INSERT INTO `role_resource_relation` VALUES (232, 5, 40);
INSERT INTO `role_resource_relation` VALUES (233, 5, 41);
INSERT INTO `role_resource_relation` VALUES (234, 5, 42);
INSERT INTO `role_resource_relation` VALUES (235, 5, 43);

-- ----------------------------
-- Table structure for staion_device
-- ----------------------------
DROP TABLE IF EXISTS `staion_device`;
CREATE TABLE `staion_device`  (
  `id` int(11) NOT NULL,
  `station_id` int(11) NULL DEFAULT NULL,
  `device_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staion_device
-- ----------------------------
INSERT INTO `staion_device` VALUES (0, 100001, 60);

-- ----------------------------
-- Table structure for water_alarm_data
-- ----------------------------
DROP TABLE IF EXISTS `water_alarm_data`;
CREATE TABLE `water_alarm_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `station_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点id',
  `alarm_time` datetime(0) NULL DEFAULT NULL COMMENT '报警时间',
  `alarm_type` int(11) NULL DEFAULT NULL COMMENT '报警类型',
  `alarm_value` double NULL DEFAULT NULL COMMENT '报警值',
  `alarm_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_alarm_data
-- ----------------------------
INSERT INTO `water_alarm_data` VALUES (1, '100001', '2021-01-30 11:08:14', 4, 25, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (2, '100001', '2021-01-30 11:09:58', 4, 30, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (3, '100001', '2021-01-29 11:10:20', 4, 30, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (4, '100001', '2021-01-29 11:10:41', 4, 25, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (6, '100001', '2021-01-29 11:11:29', 4, 22, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (7, '100001', '2021-01-29 11:11:46', 4, 24, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (8, '100001', '2021-01-29 11:12:40', 4, 35, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (9, '100001', '2021-01-29 11:08:40', 4, 33, '水位超过警戒线');
INSERT INTO `water_alarm_data` VALUES (11, '100001', '2021-01-29 11:09:20', 4, 22, '水位超过警戒线');

-- ----------------------------
-- Table structure for water_history_data
-- ----------------------------
DROP TABLE IF EXISTS `water_history_data`;
CREATE TABLE `water_history_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `station_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点id',
  `capture_time` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  `element` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采集参数',
  `value` double NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_history_data
-- ----------------------------
INSERT INTO `water_history_data` VALUES (1, '100001', '2020-12-14 15:15:45', 'WL', 15);
INSERT INTO `water_history_data` VALUES (3, '100001', '2020-12-15 11:18:33', 'WL', 14);
INSERT INTO `water_history_data` VALUES (4, '100001', '2020-12-16 11:18:58', 'WL', 16);
INSERT INTO `water_history_data` VALUES (5, '100001', '2020-12-17 11:19:36', 'WL', 5);
INSERT INTO `water_history_data` VALUES (6, '100001', '2020-12-18 11:19:41', 'WL', 8);
INSERT INTO `water_history_data` VALUES (7, '100001', '2020-12-19 11:19:45', 'WL', 3);
INSERT INTO `water_history_data` VALUES (8, '100002', '2020-12-20 13:56:10', 'YL', 20);
INSERT INTO `water_history_data` VALUES (9, '100003', '2020-12-21 13:56:52', 'WL', 15);
INSERT INTO `water_history_data` VALUES (10, '100001', '2020-12-09 08:55:11', 'YL', 12);
INSERT INTO `water_history_data` VALUES (11, '100001', '2020-12-10 08:56:16', 'YL', 13);
INSERT INTO `water_history_data` VALUES (12, '100001', '2020-12-11 08:57:52', 'YL', 16);
INSERT INTO `water_history_data` VALUES (13, '100001', '2020-12-12 08:58:37', 'YL', 25);
INSERT INTO `water_history_data` VALUES (14, '100001', '2020-12-13 08:59:03', 'YL', 30);
INSERT INTO `water_history_data` VALUES (15, '100001', '2020-12-14 09:06:14', 'YL', 26);
INSERT INTO `water_history_data` VALUES (16, '100001', '2020-12-15 09:06:55', 'YL', 21);
INSERT INTO `water_history_data` VALUES (17, '100001', '2020-12-16 09:07:15', 'YL', 16);
INSERT INTO `water_history_data` VALUES (18, '100001', '2020-12-17 09:07:35', 'YL', 15);
INSERT INTO `water_history_data` VALUES (19, '100001', '2020-12-18 09:08:19', 'YL', 26);
INSERT INTO `water_history_data` VALUES (20, '100001', '2020-12-19 09:09:03', 'YL', 24);

-- ----------------------------
-- Table structure for water_level_day
-- ----------------------------
DROP TABLE IF EXISTS `water_level_day`;
CREATE TABLE `water_level_day`  (
  `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `station_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `zero_hour` double UNSIGNED NOT NULL DEFAULT 0,
  `first_hour` double UNSIGNED NULL DEFAULT 0,
  `second_hour` double UNSIGNED NULL DEFAULT 0,
  `third_hour` double UNSIGNED NULL DEFAULT 0,
  `fourth_hour` double UNSIGNED NULL DEFAULT 0,
  `fifth_hour` double UNSIGNED NULL DEFAULT 0,
  `sixth_hour` double UNSIGNED NULL DEFAULT 0,
  `seventh_hour` double UNSIGNED NULL DEFAULT 0,
  `eighth_hour` double UNSIGNED NULL DEFAULT 0,
  `ninth_hour` double UNSIGNED NULL DEFAULT 0,
  `tenth_hour` double UNSIGNED NULL DEFAULT 0,
  `eleventh_hour` double UNSIGNED NULL DEFAULT 0,
  `twelfth_hour` double UNSIGNED NULL DEFAULT 0,
  `thirteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `fourteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `fifteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `sixteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `seventeenth_hour` double UNSIGNED NULL DEFAULT 0,
  `eighteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `nineteenth_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_first_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_two_hour` double UNSIGNED NULL DEFAULT 0,
  `twentieth_three_hour` double UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_level_day
-- ----------------------------
INSERT INTO `water_level_day` VALUES (8, '100001', '2020-12-20', 12.34, 12.35, 12.36, 12.36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (9, '100001', '2020-12-21', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (10, '100001', '2020-12-22', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (11, '100001', '2020-08-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (12, '100001', '2020-09-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (13, '100001', '2020-09-03', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (14, '100001', '2020-09-02', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (15, '100001', '2020-12-23', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (16, '100001', '2020-12-24', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (17, '100001', '2020-12-25', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (18, '100001', '2020-12-26', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (19, '100001', '2020-12-27', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (20, '100001', '2020-12-01', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (21, '100002', '2020-12-05', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (22, '100003', '2020-12-06', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (23, '100003', '2020-12-07', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (24, '100003', '2020-12-08', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (25, '100004', '2020-12-09', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (30, '100001', '2021-01-07', 34, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (31, '100001', '2021-01-08', 345, 345, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_day` VALUES (32, '100002', '2021-01-07', 324234, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for water_level_month
-- ----------------------------
DROP TABLE IF EXISTS `water_level_month`;
CREATE TABLE `water_level_month`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `stationId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `one` double UNSIGNED NULL DEFAULT 0,
  `two` double UNSIGNED NULL DEFAULT 0,
  `three` double UNSIGNED NULL DEFAULT 0,
  `four` double UNSIGNED NULL DEFAULT 0,
  `five` double UNSIGNED NULL DEFAULT 0,
  `six` double UNSIGNED NULL DEFAULT NULL,
  `seven` double UNSIGNED NULL DEFAULT 0,
  `eight` double UNSIGNED NULL DEFAULT 0,
  `nine` double UNSIGNED NULL DEFAULT 0,
  `ten` double UNSIGNED NULL DEFAULT 0,
  `eleven` double UNSIGNED NULL DEFAULT 0,
  `twelve` double UNSIGNED NULL DEFAULT 0,
  `thirteen` double UNSIGNED NULL DEFAULT 0,
  `fourteen` double UNSIGNED NULL DEFAULT 0,
  `fifteen` double UNSIGNED NULL DEFAULT 0,
  `sixteen` double UNSIGNED NULL DEFAULT 0,
  `seventeen` double UNSIGNED NULL DEFAULT 0,
  `eighteen` double UNSIGNED NULL DEFAULT 0,
  `nineteen` double UNSIGNED NULL DEFAULT 0,
  `twenty` double UNSIGNED NULL DEFAULT 0,
  `twenty_one` double UNSIGNED NULL DEFAULT 0,
  `twenty_two` double UNSIGNED NULL DEFAULT 0,
  `twenty_three` double UNSIGNED NULL DEFAULT 0,
  `twenty_four` double UNSIGNED NULL DEFAULT 0,
  `twenty_five` double UNSIGNED NULL DEFAULT 0,
  `twenty_six` double UNSIGNED NULL DEFAULT 0,
  `twenty_seven` double UNSIGNED NULL DEFAULT 0,
  `twenty_eight` double UNSIGNED NULL DEFAULT 0,
  `twenty_nine` double UNSIGNED NULL DEFAULT 0,
  `thirty` double UNSIGNED NULL DEFAULT 0,
  `thirty_one` double UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_level_month
-- ----------------------------
INSERT INTO `water_level_month` VALUES (1, '100001', '2020-01', 90, 45, 345, 345, 34, 345, 2.83, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 3, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_month` VALUES (2, '100001', '2020-02', 0, 0, 0, 0, 0, NULL, 2.83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_month` VALUES (5, '100001', '2021-03', 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_month` VALUES (11, '100001', '2021-01', 0, 0, 0, 0, 0, NULL, 2.83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `water_level_month` VALUES (12, '100002', '2021-01', 0, 0, 0, 0, 0, NULL, 13509.75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for water_level_year
-- ----------------------------
DROP TABLE IF EXISTS `water_level_year`;
CREATE TABLE `water_level_year`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `stationId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `one` double NULL DEFAULT NULL,
  `two` double NULL DEFAULT NULL,
  `three` double NULL DEFAULT NULL,
  `four` double NULL DEFAULT NULL,
  `five` double NULL DEFAULT NULL,
  `six` double NULL DEFAULT NULL,
  `seven` double NULL DEFAULT NULL,
  `eight` double NULL DEFAULT NULL,
  `nine` double NULL DEFAULT NULL,
  `ten` double NULL DEFAULT NULL,
  `eleven` double NULL DEFAULT NULL,
  `twelve` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_level_year
-- ----------------------------
INSERT INTO `water_level_year` VALUES (1, '100001', '2021', 34, 345, 345, NULL, 345, NULL, 345, NULL, 345, NULL, 345, 345345);

-- ----------------------------
-- Table structure for water_quality_alarm_data
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_alarm_data`;
CREATE TABLE `water_quality_alarm_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `station_id` bigint(20) NULL DEFAULT NULL COMMENT '站点id',
  `device_id` int(20) NULL DEFAULT NULL COMMENT '监测项目/设备',
  `alarmtime` datetime(0) NULL DEFAULT NULL COMMENT '报警时间',
  `alarmtype` bigint(20) NULL DEFAULT NULL COMMENT '报警类型',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报警描述',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通知状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_alarm_data
-- ----------------------------
INSERT INTO `water_quality_alarm_data` VALUES (1, 1, 14, '2020-12-18 17:10:48', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (2, 1, 14, '2020-12-17 09:06:05', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (3, 1, 14, '2020-12-18 09:06:33', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (4, 1, 14, '2020-12-19 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (5, 1, 14, '2020-12-20 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (6, 1, 14, '2020-12-21 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (7, 2, 14, '2020-12-18 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (8, 2, 14, '2020-12-17 09:06:33', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (9, 2, 14, '2020-12-20 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (10, 2, 14, '2020-12-21 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (11, 3, 14, '2020-12-19 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (12, 3, 14, '2020-12-19 09:06:33', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (13, 3, 14, '2020-12-20 09:06:33', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (14, 3, 14, '2020-12-20 09:06:33', 4, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (15, 4, 14, '2020-12-20 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (16, 4, 14, '2020-12-20 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (17, 4, 14, '2020-12-20 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (18, 2, 14, '2020-12-17 09:06:33', 2, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (19, 1, 14, '2020-12-17 09:06:33', 3, '利民河斯塘小区站自动站，在2019年11月06日14时', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (20, 1, 14, '2020-12-15 09:06:33', 3, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (21, 2, 14, '2020-12-15 09:06:33', 3, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (22, 3, 14, '2020-12-15 09:06:33', 3, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (23, 5, 14, '2020-12-15 09:06:33', 3, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (24, 5, 14, '2020-12-15 09:06:33', 4, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (25, 6, 14, '2020-12-15 09:06:33', 4, '123', '通知');
INSERT INTO `water_quality_alarm_data` VALUES (26, 6, 14, '2020-12-15 09:06:33', 2, '123', '通知');

-- ----------------------------
-- Table structure for water_quality_category
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_category`;
CREATE TABLE `water_quality_category`  (
  `id` int(20) NOT NULL COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `lever` int(10) NULL DEFAULT NULL COMMENT '级别',
  `status_id` int(10) NULL DEFAULT NULL COMMENT '水质状态',
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表征颜色',
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_category
-- ----------------------------
INSERT INTO `water_quality_category` VALUES (1, 'Ⅰ', 1, 22, '#807CC5', '主要使用源头水，国家自然保护区');
INSERT INTO `water_quality_category` VALUES (2, 'Ⅱ', 2, 22, '#4D4C51', '主要使用集中式生活饮用水地表水源地一级保护区、珍惜水生生物栖息地、鱼虾类产卵场等');
INSERT INTO `water_quality_category` VALUES (3, 'Ⅲ', 3, 23, '#008000', '主要使用集中式生活饮用水地表水源地二级保护区、鱼虾类越冬场、洄游通道、水产养殖区等渔业水域及游泳区');
INSERT INTO `water_quality_category` VALUES (4, 'Ⅳ', 4, 24, '#FEFF01', '主要使用于一般工业用水及人体非直接接触的娱乐用水区');
INSERT INTO `water_quality_category` VALUES (5, 'Ⅴ', 5, 25, '#FDA600', '主要使用与农业用水及一般景观要求水域');
INSERT INTO `water_quality_category` VALUES (6, '劣Ⅴ', 6, 26, '#FB0102', NULL);

-- ----------------------------
-- Table structure for water_quality_data_day
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_data_day`;
CREATE TABLE `water_quality_data_day`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `site_id` int(255) NULL DEFAULT NULL COMMENT '站点id',
  `date_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采样时间',
  `w01019_Rtd` float NULL DEFAULT NULL COMMENT '高锰酸盐指数',
  `w01019_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高锰酸盐指数实时数据标记',
  `w21011_Rtd` float NULL DEFAULT NULL COMMENT '总磷',
  `w21011_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总磷实时数据标记',
  `w21003_Rtd` float NULL DEFAULT NULL COMMENT '氨氮',
  `w21003_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01010_Rtd` float NULL DEFAULT NULL COMMENT '水温',
  `w01010_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01001_Rtd` float NULL DEFAULT NULL COMMENT 'ph值',
  `w01001_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ph值实时数据标记',
  `w01009_Rtd` float(255, 0) NULL DEFAULT NULL COMMENT '溶解氧',
  `w01009_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_data_day
-- ----------------------------
INSERT INTO `water_quality_data_day` VALUES (1, 1, '2021-01-16 00:41:45', 15, NULL, 45, NULL, 56, NULL, 14, NULL, 12, '2', 12, NULL);
INSERT INTO `water_quality_data_day` VALUES (2, 1, '2021-01-16 00:42', 23, NULL, 53, NULL, 12, NULL, 32, NULL, 34, NULL, 12, NULL);
INSERT INTO `water_quality_data_day` VALUES (3, 1, '2021-01-16 00:42', 22, NULL, 33, NULL, 44, NULL, 55, NULL, 22, NULL, 6, NULL);
INSERT INTO `water_quality_data_day` VALUES (4, 1, '2021-01-06 00:42', 55, NULL, 77, NULL, 77, NULL, 33, NULL, 55, NULL, 99, NULL);

-- ----------------------------
-- Table structure for water_quality_data_week
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_data_week`;
CREATE TABLE `water_quality_data_week`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `site_id` int(255) NULL DEFAULT NULL COMMENT '站点id',
  `date_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采样时间',
  `w01019_Rtd` float UNSIGNED NULL DEFAULT 0 COMMENT '高锰酸盐指数',
  `w01019_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高锰酸盐指数实时数据标记',
  `w21011_Rtd` float UNSIGNED NULL DEFAULT 0 COMMENT '总磷',
  `w21011_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总磷实时数据标记',
  `w21003_Rtd` float UNSIGNED NULL DEFAULT 0 COMMENT '氨氮',
  `w21003_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01010_Rtd` float UNSIGNED NULL DEFAULT 0 COMMENT '水温',
  `w01010_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01001_Rtd` float UNSIGNED NULL DEFAULT NULL COMMENT 'ph值',
  `w01001_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ph值实时数据标记',
  `w01009_Rtd` float(255, 0) UNSIGNED NULL DEFAULT NULL COMMENT '溶解氧',
  `w01009_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_data_week
-- ----------------------------
INSERT INTO `water_quality_data_week` VALUES (1, 10, '2021-01-16', 15, NULL, 45, NULL, 56, NULL, 14, NULL, 12, '2', 12, NULL);
INSERT INTO `water_quality_data_week` VALUES (2, 10, '2021-01-17', 23, NULL, 53, NULL, 12, NULL, 32, NULL, 34, NULL, 12, NULL);
INSERT INTO `water_quality_data_week` VALUES (3, 10, '2021-01-18', 22, NULL, 33, NULL, 44, NULL, 55, NULL, 22, NULL, 6, NULL);
INSERT INTO `water_quality_data_week` VALUES (4, 10, '2021-01-19', 55, NULL, 77, NULL, 77, NULL, 33, NULL, 55, NULL, 99, NULL);
INSERT INTO `water_quality_data_week` VALUES (5, 1, '2019-10-28', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (6, 1, '2019-10-29', 5555, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (7, 1, '2019-10-30', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (8, 1, '2019-10-31', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (9, 1, '2019-11-01', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (10, 1, '2019-11-02', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (11, 1, '2019-11-03', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (12, 1, '2019-10-27', 55, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL);
INSERT INTO `water_quality_data_week` VALUES (13, 1, '2021-01-16', 435, NULL, 345, '', 345, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `water_quality_data_week` VALUES (14, 1, '2021-01-17', 435, NULL, 435, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for water_quality_data_year
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_data_year`;
CREATE TABLE `water_quality_data_year`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `site_id` int(255) NULL DEFAULT NULL COMMENT '站点id',
  `date_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采样时间',
  `w01019_Rtd` float NULL DEFAULT NULL COMMENT '高锰酸盐指数',
  `w01019_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高锰酸盐指数实时数据标记',
  `w21011_Rtd` float NULL DEFAULT NULL COMMENT '总磷',
  `w21011_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总磷实时数据标记',
  `w21003_Rtd` float NULL DEFAULT NULL COMMENT '氨氮',
  `w21003_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01010_Rtd` float NULL DEFAULT NULL COMMENT '水温',
  `w01010_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01001_Rtd` float NULL DEFAULT NULL COMMENT 'ph值',
  `w01001_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ph值实时数据标记',
  `w01009_Rtd` float(255, 0) NULL DEFAULT NULL COMMENT '溶解氧',
  `w01009_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_data_year
-- ----------------------------
INSERT INTO `water_quality_data_year` VALUES (5, 1, '2021-01', 345, NULL, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `water_quality_data_year` VALUES (6, 1, '2021-02', 435, NULL, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `water_quality_data_year` VALUES (7, 1, '2021-03', 345, NULL, 35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `water_quality_data_year` VALUES (8, 1, '2021-04', 345, NULL, 67, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `water_quality_data_year` VALUES (9, 1, '2021-05', 45, NULL, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for water_quality_history_data
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_history_data`;
CREATE TABLE `water_quality_history_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `site_id` int(11) NULL DEFAULT NULL COMMENT '站点id',
  `date_time` datetime(0) NULL DEFAULT NULL COMMENT '采样时间',
  `w01001_Rtd` float NULL DEFAULT NULL COMMENT 'ph值',
  `w01001_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ph值实时数据标记',
  `w01019_Rtd` float NULL DEFAULT NULL COMMENT '高锰酸盐指数',
  `w01019_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高锰酸盐指数实时数据标记',
  `w21011_Rtd` float NULL DEFAULT NULL COMMENT '总磷',
  `w21011_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总磷实时数据标记',
  `w21003_Rtd` float NULL DEFAULT NULL COMMENT '氨氮',
  `w21003_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01010_Rtd` float NULL DEFAULT NULL COMMENT '水温',
  `w01010_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01009_Rtd` float(255, 0) NULL DEFAULT NULL COMMENT '溶解氧',
  `w01009_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_history_data
-- ----------------------------
INSERT INTO `water_quality_history_data` VALUES (1, 1, '2021-01-18 00:41:45', 23, NULL, 3, NULL, 12, NULL, 2, NULL, 4, NULL, 3, NULL);

-- ----------------------------
-- Table structure for water_quality_real_data
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_real_data`;
CREATE TABLE `water_quality_real_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `site_id` int(11) NULL DEFAULT NULL COMMENT '站点id',
  `date_time` datetime(0) NULL DEFAULT NULL COMMENT '采样时间',
  `w01001_Rtd` float NULL DEFAULT NULL COMMENT 'ph值',
  `w01001_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ph值实时数据标记',
  `w01019_Rtd` float NULL DEFAULT NULL COMMENT '高锰酸盐指数',
  `w01019_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高锰酸盐指数实时数据标记',
  `w21011_Rtd` float NULL DEFAULT NULL COMMENT '总磷',
  `w21011_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总磷实时数据标记',
  `w21003_Rtd` float NULL DEFAULT NULL COMMENT '氨氮',
  `w21003_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01010_Rtd` float NULL DEFAULT NULL COMMENT '水温',
  `w01010_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `w01009_Rtd` float(255, 0) NULL DEFAULT NULL COMMENT '溶解氧',
  `w01009_Flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_real_data
-- ----------------------------
INSERT INTO `water_quality_real_data` VALUES (1, 1, '2021-01-06 11:41:45', 12, '2', 15, NULL, 45, NULL, 56, NULL, 14, NULL, 12, NULL);
INSERT INTO `water_quality_real_data` VALUES (2, 2, '2021-01-06 11:42:23', 34, NULL, 23, NULL, 53, NULL, 12, NULL, 32, NULL, 12, NULL);
INSERT INTO `water_quality_real_data` VALUES (3, 3, '2021-01-06 14:47:08', 22, NULL, 22, NULL, 33, NULL, 44, NULL, 55, NULL, 6, NULL);
INSERT INTO `water_quality_real_data` VALUES (4, 4, '2021-01-06 14:56:53', 55, NULL, 55, NULL, 77, NULL, 77, NULL, 33, NULL, 99, NULL);

-- ----------------------------
-- Table structure for water_quality_site
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_site`;
CREATE TABLE `water_quality_site`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点名称',
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `code_region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区',
  `code_waterarea` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '水域',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `contactman` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `pictures` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `station_type_id` int(32) NULL DEFAULT NULL COMMENT '站点类型',
  `lever_id` int(32) NULL DEFAULT NULL COMMENT '地区等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_quality_site
-- ----------------------------
INSERT INTO `water_quality_site` VALUES (1, '龙河', '118.205318', '33.931567', '102', '1', '激光产业园', '110', NULL, NULL, NULL, NULL, NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (10, '民便河青海湖路站', '118.205318', '33.931567', '102', '2', '激光产业园', '110', '', NULL, '2021-01-06 11:01:15', '2021-01-06 11:01:25', NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (11, '民便河朱老庄站', '118.315318', '33.921567', '102', '11', '激光产业园', '110', '', NULL, '2021-01-06 11:01:15', '2021-01-06 11:01:25', NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (12, '古黄河船行罐区站', '118.478318', '33.945567', '102', '12', '激光产业园', '110', '', NULL, '2021-01-06 11:01:15', '2021-01-06 11:01:25', NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (13, '十支沟古城路站', '118.528318', '33.955567', '103', '13', '激光产业园', '110', '', NULL, '2021-01-06 11:01:15', '2021-01-06 11:01:25', NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (14, '五河中扬毛集站', '118.638318', '33.965567', '106', '14', '激光产业园', '110', '', NULL, '2021-01-06 11:01:15', '2021-01-06 11:01:25', NULL, '123456', 12, 8);
INSERT INTO `water_quality_site` VALUES (15, '埠子镇', '118.638318', '33.975567', '102', '1', NULL, NULL, NULL, NULL, '2021-01-29 14:02:01', NULL, NULL, '123', 12, 8);
INSERT INTO `water_quality_site` VALUES (16, '耿车镇', '118.638318', '33.985567', '102', '1', NULL, NULL, NULL, NULL, '2021-01-29 14:02:30', NULL, NULL, '123', 12, 8);

-- ----------------------------
-- Table structure for water_quality_station
-- ----------------------------
DROP TABLE IF EXISTS `water_quality_station`;
CREATE TABLE `water_quality_station`  (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '水质站点名称',
  `station_id` int(32) NULL DEFAULT NULL COMMENT '水质站点id',
  `area_id` int(32) NULL DEFAULT NULL COMMENT '区域id',
  `valley_id` int(32) NULL DEFAULT NULL COMMENT '流域id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `station_type_id` int(32) NULL DEFAULT NULL COMMENT '站点类型id',
  `longitude` decimal(53, 8) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(53, 8) NULL DEFAULT NULL COMMENT '纬度',
  `lever_id` int(32) NULL DEFAULT NULL COMMENT '地区等级id',
  `connected` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否联网',
  `monitor_time` datetime(0) NULL DEFAULT NULL COMMENT '监测时间',
  `kmno4` float(16, 2) NULL DEFAULT NULL COMMENT '高锰酸钾(mg/L)',
  `p4` float(16, 3) NULL DEFAULT NULL COMMENT '总磷(mg/L)',
  `nh4` float(16, 3) NULL DEFAULT NULL COMMENT '氨氮(mg/L)',
  `water_temperature` float(16, 2) NULL DEFAULT NULL COMMENT '水温(℃)',
  `ph` float(16, 2) NULL DEFAULT NULL COMMENT 'PH',
  `dissolved_oxygen` float(16, 2) NULL DEFAULT NULL COMMENT '溶解氧(mg/L)',
  `redox_potential` float(16, 0) NULL DEFAULT NULL COMMENT '氧化还原电位(mV)',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '点位状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for water_real_time_data
-- ----------------------------
DROP TABLE IF EXISTS `water_real_time_data`;
CREATE TABLE `water_real_time_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `station_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点id',
  `capture_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采集时间',
  `element` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采集参数',
  `value` double NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_real_time_data
-- ----------------------------
INSERT INTO `water_real_time_data` VALUES (1, '100001', '2020-12-14 15:15:45', 'WL', 15);
INSERT INTO `water_real_time_data` VALUES (2, '100002', '2020-12-25 09:06:15', 'YL', 16);
INSERT INTO `water_real_time_data` VALUES (3, '100003', '2021-01-30 13:45:56', 'YL', 20);
INSERT INTO `water_real_time_data` VALUES (4, '100004', '2021-01-30 13:46:16', 'YL', 30);
INSERT INTO `water_real_time_data` VALUES (5, '100005', '2021-01-30 13:46:40', 'YL', 35);
INSERT INTO `water_real_time_data` VALUES (6, '100006', '2021-01-30 13:46:57', 'YL', 40);
INSERT INTO `water_real_time_data` VALUES (7, '100001', '2021-01-30 13:47:15', 'YL', 56);
INSERT INTO `water_real_time_data` VALUES (15, '10001', '2019-1-3 10:19:01', 'WL', 30);
INSERT INTO `water_real_time_data` VALUES (16, '100001', '2019-1-3 10:19:01', 'WL', 30);
INSERT INTO `water_real_time_data` VALUES (19, '100001', '0', 'WL', 300);
INSERT INTO `water_real_time_data` VALUES (20, '100001', '2019-1-3 10:19:01', 'WL', 891.545);
INSERT INTO `water_real_time_data` VALUES (21, '100001', '2019-1-3 10:19:01', 'WL', 891.545);

-- ----------------------------
-- Table structure for water_station
-- ----------------------------
DROP TABLE IF EXISTS `water_station`;
CREATE TABLE `water_station`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `station_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点id',
  `station_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '站点地址',
  `valley_id` int(10) NULL DEFAULT NULL COMMENT '所属流域',
  `code_region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `station_type` int(255) NULL DEFAULT NULL COMMENT '站点类型',
  `latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `high` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '高程',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `country_id` int(20) NULL DEFAULT NULL COMMENT '关联乡村',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of water_station
-- ----------------------------
INSERT INTO `water_station` VALUES (1, '100001', '团结排涝站', '勇进路与科苑路交叉口西150米', 10, '101', 1, '33.931567', '118.205318', '123456', '0.0', '2021-01-06 14:09:43', 17);
INSERT INTO `water_station` VALUES (2, '100002', '卓玛排涝站', '江苏省宿迁市宿城区南湖路1号', 10, '101', 1, '33.931467', '118.281838', '123456', '0.0', '2021-01-06 14:09:46', 17);
INSERT INTO `water_station` VALUES (3, '100003', '耿车水务站', '江苏省宿迁市宿城区南湖路1号', 10, '101', 2, '33.95195', '118.381838', '123456', '0.0', '2021-01-06 14:09:46', 17);
INSERT INTO `water_station` VALUES (4, '100004', '东沙河', '江苏省宿迁市宿城区南湖路1号', 10, '102', 2, '33.93895', '118.481838', '123456', '0.0', '2021-01-06 14:09:46', 17);
INSERT INTO `water_station` VALUES (5, '100005', '大西闸', '江苏省宿迁市宿城区南湖路1号333333333323fdsf', 11, '102', 3, '33.94895', '118.581838', '123456', '0.0', '2021-01-06 14:09:46', 17);
INSERT INTO `water_station` VALUES (6, '100006', '大西闸2', '江苏省宿迁市宿城区南湖路1号333333333323fdsf', 11, '102', 3, '33.94895', '118.581838', '123456', '0.0', '2021-01-06 14:09:46', 17);

SET FOREIGN_KEY_CHECKS = 1;
