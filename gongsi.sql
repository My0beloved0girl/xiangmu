/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - gongsi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gongsi` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `gongsi`;

/*Table structure for table `bumenb` */

DROP TABLE IF EXISTS `bumenb`;

CREATE TABLE `bumenb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bmname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `bumenb` */

insert  into `bumenb`(`id`,`bmname`) values (1,'管理部门'),(2,'财务部门'),(3,'保安部门'),(4,'外交部门'),(5,'业务部门');

/*Table structure for table `jueseb` */

DROP TABLE IF EXISTS `jueseb`;

CREATE TABLE `jueseb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jsname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `jueseb` */

insert  into `jueseb`(`id`,`jsname`) values (1,'Boos'),(2,'管理员'),(3,'普通用户');

/*Table structure for table `ls_butten` */

DROP TABLE IF EXISTS `ls_butten`;

CREATE TABLE `ls_butten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btntype` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ls_butten` */

insert  into `ls_butten`(`id`,`btntype`) values (1,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>'),(2,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>'),(3,'<button type=\'button\' lay-event=\'upFunc\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>'),(4,'<button type=\'button\' lay-event=\'shangFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\'layui-icon\'>&#xe681;</i>上传</button>'),(5,'<button type=\'button\' lay-event=\'xiaFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\"layui-icon\">&#xe601;</i>下载</button>'),(6,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*Table structure for table `quanxian` */

DROP TABLE IF EXISTS `quanxian`;

CREATE TABLE `quanxian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qxname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mfatherid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `buttom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `quanxian` */

insert  into `quanxian`(`id`,`qxname`,`mfatherid`,`type`,`url`,`buttom`) values (1,'系统权限菜单',0,1,NULL,NULL),(2,'员工管理',1,2,'YHS?action=ygan','js/zxjs/ZxList.js'),(3,'删除员工',2,3,NULL,'<button type=\"button\" lay-event=\"delUser\" class=\"layui-btn layui-btn-danger\">删除员工</button>'),(4,'修改员工',2,3,NULL,'<button type=\"button\" lay-event=\"uapUser\" class=\"layui-btn layui-btn-normal\">修改员工</button>'),(5,'新增员工',2,3,NULL,'<button type=\"button\" lay-event=\"insUser\" class=\"layui-btn layui-btn-warm\">增加员工</button>'),(6,'权限管理',1,2,'YHS?action=qxan','js/zxjs/menlist.js'),(7,'删除权限',6,3,NULL,'<button type=\"button\" lay-event=\"delMenu\" class=\"layui-btn layui-btn-danger\">删除权限</button>'),(8,'修改权限',6,3,NULL,'<button type=\"button\" lay-event=\"uapMenu\" class=\"layui-btn layui-btn-normal\">修改权限</button>'),(9,'增加权限',6,3,NULL,'<button type=\"button\" lay-event=\"addMenu\" class=\"layui-btn layui-btn-warm\">增加权限</button>'),(10,'角色管理',1,2,'YHS?action=jsan','js/zxjs/JsList.js'),(11,'删除角色',10,3,NULL,'<button type=\"button\" lay-event=\"deljs\" class=\"layui-btn layui-btn-danger\">删除角色</button>'),(12,'修改角色',10,3,NULL,'<button type=\"button\" lay-event=\"upajs\" class=\"layui-btn layui-btn-normal\">修改角色</button>'),(13,'新增角色',10,3,NULL,'<button type=\"button\" lay-event=\"insjs\" class=\"layui-btn layui-btn-warm\">增加角色</button>'),(14,'分配权限',10,3,NULL,'<button type=\"button\" lay-event=\"hairMenu\" class=\"layui-btn layui-btn-primary\"><i class=\"layui-icon\">&#xe654;</i>分配权限</button>'),(15,'部门管理',1,2,'YHS?action=bman','js/zxjs/BmList.js'),(16,'删除部门',15,3,NULL,'<button type=\"button\" lay-event=\"deljs\" class=\"layui-btn layui-btn-danger\">删除部门</button>'),(17,'修改部门',15,3,NULL,'<button type=\"button\" lay-event=\"upajs\" class=\"layui-btn layui-btn-normal\">修改部门</button>'),(18,'新增部门',15,3,NULL,'<button type=\"button\" lay-event=\"insjs\" class=\"layui-btn layui-btn-warm\">增加部门</button>');

/*Table structure for table `qxjs` */

DROP TABLE IF EXISTS `qxjs`;

CREATE TABLE `qxjs` (
  `jueseid` int(11) NOT NULL,
  `quanxianid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qxjs` */

insert  into `qxjs`(`jueseid`,`quanxianid`) values (2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18);

/*Table structure for table `yuangongb` */

DROP TABLE IF EXISTS `yuangongb`;

CREATE TABLE `yuangongb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ygname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dlname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `passwd` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `bumen` int(11) NOT NULL,
  `zhicheng` int(11) NOT NULL,
  `juese` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `yuangongb` */

insert  into `yuangongb`(`id`,`ygname`,`dlname`,`passwd`,`bumen`,`zhicheng`,`juese`,`sex`) values (1,'管理员','root','1',1,2,2,1),(2,'李四','lisi','1',5,4,3,1),(3,'王五','wangwu','1',5,4,3,1),(6,'柳柳','liuliu','123456',4,2,3,2),(7,'蝙蝠侠','bfx','123456',2,2,2,1);

/*Table structure for table `zhichengb` */

DROP TABLE IF EXISTS `zhichengb`;

CREATE TABLE `zhichengb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zcname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zhichengb` */

insert  into `zhichengb`(`id`,`zcname`) values (1,'金主'),(2,'经理'),(3,'组长'),(4,'员工'),(5,'秘书');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
