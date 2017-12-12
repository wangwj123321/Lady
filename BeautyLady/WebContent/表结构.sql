/*
SQLyog Ultimate v12.2.6 (64 bit)
MySQL - 5.6.31 : Database - beautylay
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`beautylay` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `beautylay`;

/*Table structure for table `band` */

DROP TABLE IF EXISTS `band`;

CREATE TABLE `band` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bandNo` varchar(20) NOT NULL,
  `bandName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bandNo` (`bandNo`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryNo` varchar(20) NOT NULL,
  `categoryName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `categoryNo` (`categoryNo`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Table structure for table `color` */

DROP TABLE IF EXISTS `color`;

CREATE TABLE `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `colorNo` varchar(20) NOT NULL,
  `colorName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `colorNo` (`colorNo`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8;

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilegeName` varchar(20) NOT NULL,
  `resource` varchar(255) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `stuffix` varchar(100) DEFAULT NULL,
  `params` varchar(100) DEFAULT NULL,
  `type` int(4) DEFAULT '0',
  `status` int(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `privilegeName` (`privilegeName`),
  UNIQUE KEY `resource` (`resource`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(20) NOT NULL,
  `productName` varchar(20) NOT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `tagPrice` double(10,2) DEFAULT NULL,
  `costPrice` double(10,2) DEFAULT NULL,
  `categoryNo` varchar(20) DEFAULT NULL,
  `subclassesNo` varchar(20) DEFAULT NULL,
  `bandNo` varchar(20) DEFAULT NULL,
  `themeNo` varchar(20) DEFAULT NULL,
  `seriesNo` varchar(20) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `quarter` int(4) DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  `picpath` varchar(255) DEFAULT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNoKey` (`productNo`),
  KEY `fk_product_category` (`categoryNo`),
  KEY `fk_product_subclasses` (`subclassesNo`),
  KEY `fk_product_band` (`bandNo`),
  KEY `fk_product_series` (`seriesNo`),
  KEY `fk_product_theme` (`themeNo`),
  CONSTRAINT `fk_product_band` FOREIGN KEY (`bandNo`) REFERENCES `band` (`bandNo`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`categoryNo`) REFERENCES `category` (`categoryNo`),
  CONSTRAINT `fk_product_series` FOREIGN KEY (`seriesNo`) REFERENCES `series` (`seriesNo`),
  CONSTRAINT `fk_product_subclasses` FOREIGN KEY (`subclassesNo`) REFERENCES `subclasses` (`subClassesNo`),
  CONSTRAINT `fk_product_theme` FOREIGN KEY (`themeNo`) REFERENCES `theme` (`themeNo`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;

/*Table structure for table `product_color` */

DROP TABLE IF EXISTS `product_color`;

CREATE TABLE `product_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(20) NOT NULL,
  `colorNo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNo` (`productNo`,`colorNo`),
  KEY `product_color_pc_fk2` (`colorNo`),
  CONSTRAINT `product_color_ibfk_1` FOREIGN KEY (`productNo`) REFERENCES `product` (`productNo`),
  CONSTRAINT `product_color_pc_fk2` FOREIGN KEY (`colorNo`) REFERENCES `color` (`colorNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2235 DEFAULT CHARSET=utf8;

/*Table structure for table `product_size` */

DROP TABLE IF EXISTS `product_size`;

CREATE TABLE `product_size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(20) NOT NULL,
  `sizeNo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNo` (`productNo`,`sizeNo`),
  KEY `product_size_psfk_2` (`sizeNo`),
  CONSTRAINT `product_size_ibfk_1` FOREIGN KEY (`productNo`) REFERENCES `product` (`productNo`),
  CONSTRAINT `product_size_psfk_2` FOREIGN KEY (`sizeNo`) REFERENCES `size` (`sizeNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4366 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `role_privilege` */

DROP TABLE IF EXISTS `role_privilege`;

CREATE TABLE `role_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`privilege_id`),
  UNIQUE KEY `privilege_id` (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `series` */

DROP TABLE IF EXISTS `series`;

CREATE TABLE `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seriesNo` varchar(20) NOT NULL,
  `seriesName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `seriesNo` (`seriesNo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `size` */

DROP TABLE IF EXISTS `size`;

CREATE TABLE `size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sizeNo` varchar(20) NOT NULL,
  `sizeName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sizeNo` (`sizeNo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Table structure for table `storage` */

DROP TABLE IF EXISTS `storage`;

CREATE TABLE `storage` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `productNo` varchar(20) NOT NULL,
  `tagPrice` double(10,2) NOT NULL,
  `colorNo` varchar(20) NOT NULL,
  `sizeNo` varchar(20) NOT NULL,
  `number` int(4) NOT NULL,
  `totalMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Storage_foreign` (`productNo`,`colorNo`),
  KEY `Storage_size_foreign` (`productNo`,`sizeNo`),
  CONSTRAINT `Storage_foreign` FOREIGN KEY (`productNo`, `colorNo`) REFERENCES `product_color` (`productNo`, `colorNo`),
  CONSTRAINT `Storage_size_foreign` FOREIGN KEY (`productNo`, `sizeNo`) REFERENCES `product_size` (`productNo`, `sizeNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `storageorder` */

DROP TABLE IF EXISTS `storageorder`;

CREATE TABLE `storageorder` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(20) NOT NULL,
  `productNo` varchar(20) NOT NULL,
  `colorNo` varchar(20) NOT NULL,
  `sizeNo` varchar(20) NOT NULL,
  `number` int(4) NOT NULL,
  `totalMoney` double(10,2) NOT NULL,
  `storageDate` datetime NOT NULL,
  `userName` varchar(50) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0',
  `createDate` datetime NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `subclasses` */

DROP TABLE IF EXISTS `subclasses`;

CREATE TABLE `subclasses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subClassesNo` varchar(20) NOT NULL,
  `subClassesName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subClassesNo` (`subClassesNo`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;

/*Table structure for table `theme` */

DROP TABLE IF EXISTS `theme`;

CREATE TABLE `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `themeNo` varchar(20) NOT NULL,
  `themeName` varchar(20) NOT NULL,
  `status` int(4) DEFAULT '0',
  `createdBy` varchar(20) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`themeNo`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` int(11) DEFAULT '0',
  `createdBy` varchar(50) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyBy` varchar(50) DEFAULT NULL,
  `modifyDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userAccount` (`userAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
