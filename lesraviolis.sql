/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.34-MariaDB : Database - lesraviolis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lesraviolis` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lesraviolis`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `branchID` int(3) NOT NULL AUTO_INCREMENT,
  `managerID` int(3) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`branchID`,`managerID`,`address`) values 
(1,1,'Av. Corrientes 1075'),
(2,2,'Av. Callao 3558'),
(3,1,'Av. Costanera 123');

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `clientID` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `document` int(8) NOT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clients` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeeID` int(3) NOT NULL AUTO_INCREMENT,
  `branchID` int(3) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `document` int(8) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`employeeID`,`branchID`,`name`,`surname`,`document`,`username`,`password`) values 
(1,1,'Juano','Morello',37704518,'juano.morello','testeo123'),
(2,1,'pedro','gomez',37414741,'pedro.gomez','testeo123'),
(3,0,'Gonzalo','Gimenez',35852521,'Gonzalo.Gimenez','testeo123'),
(4,3,'Alan','Vaudagna',37456456,'Alan.Vaudagna','testeo123');

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `itemID` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `type` int(1) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `items` */

insert  into `items`(`itemID`,`name`,`price`,`type`) values 
(1,'Pizza',100,1),
(2,'Sushi',250,1),
(3,'Water',15,2),
(4,'Beer',25,2),
(5,'Ice Cream',75,3),
(6,'Fruit Salad',115,3),
(7,'Hamburguer',55,1),
(8,'Pepsi',15,2);

/*Table structure for table `ticket_item` */

DROP TABLE IF EXISTS `ticket_item`;

CREATE TABLE `ticket_item` (
  `ticketID` int(3) NOT NULL,
  `itemID` int(3) NOT NULL,
  `amount` int(3) NOT NULL,
  PRIMARY KEY (`ticketID`,`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ticket_item` */

insert  into `ticket_item`(`ticketID`,`itemID`,`amount`) values 
(1,2,1),
(1,3,1),
(1,6,1),
(2,1,1),
(2,4,1),
(2,6,1),
(3,1,1),
(4,2,1),
(4,4,1),
(4,6,1),
(5,2,1),
(5,4,1),
(5,6,1),
(6,1,1),
(6,4,1),
(6,6,1),
(7,1,1),
(7,4,1),
(7,6,1),
(8,2,1),
(8,4,1),
(8,5,1),
(9,1,1),
(9,2,1),
(9,3,1),
(9,4,1),
(9,6,1),
(10,2,1),
(10,3,1),
(11,2,1),
(11,4,1),
(11,5,1),
(12,1,1),
(12,4,1),
(12,5,2),
(12,6,1),
(12,7,1),
(13,1,1),
(13,2,1),
(13,3,1),
(13,4,1),
(13,5,2),
(13,6,1),
(13,7,1);

/*Table structure for table `tickets` */

DROP TABLE IF EXISTS `tickets`;

CREATE TABLE `tickets` (
  `ticketID` int(3) NOT NULL AUTO_INCREMENT,
  `clientID` int(3) NOT NULL,
  `branchID` int(3) NOT NULL,
  `ticketDate` datetime NOT NULL,
  `employeeID` int(3) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`ticketID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `tickets` */

insert  into `tickets`(`ticketID`,`clientID`,`branchID`,`ticketDate`,`employeeID`,`amount`) values 
(1,1,1,'2018-11-27 00:00:00',1,115),
(2,1,1,'2018-11-27 00:00:00',1,115),
(3,1,1,'2018-11-27 00:00:00',1,100),
(4,1,1,'2018-11-27 00:00:00',1,115),
(5,1,1,'2018-11-27 00:00:00',1,115),
(6,1,1,'2018-11-27 00:00:00',1,115),
(7,1,1,'2018-11-27 00:00:00',1,115),
(8,1,1,'2018-11-27 00:00:00',1,75),
(9,1,1,'2018-11-27 00:00:00',1,115),
(10,1,1,'2018-11-27 00:00:00',1,250),
(11,1,1,'2018-11-27 00:00:00',1,75),
(12,1,1,'2018-11-28 00:00:00',1,150),
(13,1,1,'2018-11-28 12:24:37',1,15);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
