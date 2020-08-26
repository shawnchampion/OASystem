-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act`
--

DROP TABLE IF EXISTS `act`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act` (
  `actid` int(11) NOT NULL AUTO_INCREMENT,
  `actname` varchar(45) DEFAULT NULL,
  `acttime` varchar(45) DEFAULT NULL,
  `endtime` varchar(45) DEFAULT NULL,
  `empname` varchar(45) DEFAULT NULL,
  `actbody` varchar(45) DEFAULT NULL,
  `finish` int(11) DEFAULT NULL,
  PRIMARY KEY (`actid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act`
--

LOCK TABLES `act` WRITE;
/*!40000 ALTER TABLE `act` DISABLE KEYS */;
INSERT INTO `act` VALUES (3,'1','2012-01-01','2012-01-02','1','2w222',1),(4,'gdgdd','1997-1-1','1997-1-1','adsf','sdfsdfsdf',1),(5,'111','1909-1-1','1909-1-1','1','1',1),(6,'1','1909-1-1','1909-1-1','1','111',1),(7,'1','1909-1-1','1909-1-1','1','1',1),(8,'1','1909-1-1','1909-1-1','1','111',1),(9,'2','1909-1-1','1909-1-1','2','sadasfd',NULL),(11,'1','1991-1-1','1991-1-1','1','1',1),(13,'1','1991-1-1','1991-1-1','1','1',NULL);
/*!40000 ALTER TABLE `act` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `amid` varchar(20) NOT NULL,
  `ampass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`amid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1001','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ccname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `f1_idx` (`ccname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'2018010101','杨华芳','中软','业务','123','123','123@mail.com',NULL),(4,'2018010101','彭鸿','1','1','1','1','1','新同学'),(5,'2018010101','孙','24','25','26','27','28',NULL),(7,'2018010101','撒放假了','','','','','','新同学');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardcategory`
--

DROP TABLE IF EXISTS `cardcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardcategory` (
  `ccid` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ccid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardcategory`
--

LOCK TABLES `cardcategory` WRITE;
/*!40000 ALTER TABLE `cardcategory` DISABLE KEYS */;
INSERT INTO `cardcategory` VALUES (3,'2018010201','同事'),(5,'2018010101','新同学'),(8,'2018010101','好亲戚'),(10,'2018010101','123'),(11,'2018010101','456');
/*!40000 ALTER TABLE `cardcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `deptid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `info` text,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('01','人事部',NULL,NULL),('02','企划部',NULL,NULL),('03','后勤部',NULL,NULL),('04','财务部',NULL,NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `empid` varchar(20) NOT NULL,
  `posid` varchar(20) DEFAULT NULL,
  `deptid` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `hobby` text,
  `introduction` text,
  PRIMARY KEY (`empid`),
  KEY `FK_Relationship_4` (`deptid`),
  KEY `FK_Relationship_9` (`posid`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`posid`) REFERENCES `position` (`posid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('2018010101','01','01','2018010101','张果fsad','男',30,'dfasfasfd','saf123453241','sadfasfdsadf',' ','sadfasddfsa','safasfsd   '),('2018010201','02','02','2018010201','李四','女',24,NULL,NULL,NULL,NULL,NULL,NULL),('2018020101','01','01','2018020101','腦子','女',35,NULL,NULL,NULL,NULL,NULL,NULL),('2018020201','02','01','2018020201','麵包','男',32,NULL,NULL,NULL,NULL,NULL,NULL),('2018030102','01','03','2018030102','爾康','男',50,NULL,NULL,NULL,NULL,NULL,NULL),('2018030103','02','04','2018030103','美麗','女',40,NULL,NULL,NULL,NULL,NULL,NULL),('2018030202','01','02','2018030202','來人','男',20,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `fileid` varchar(20) NOT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `filename` varchar(20) DEFAULT NULL,
  `filepath` varchar(20) DEFAULT NULL,
  `shared` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`fileid`),
  KEY `FK_Relationship_6` (`empid`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  `meeting_name` varchar(45) DEFAULT NULL,
  `meeting_time` varchar(45) DEFAULT NULL,
  `meeting_content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` VALUES (2,122,'122','111','1111'),(111,111,'111','1','1');
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroom`
--

DROP TABLE IF EXISTS `meetingroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroom` (
  `mrrid` varchar(20) NOT NULL,
  `mrname` varchar(20) DEFAULT NULL,
  `mrloc` varchar(20) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `airconditioner` tinyint(1) DEFAULT NULL,
  `projector` tinyint(1) DEFAULT NULL,
  `done` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`mrrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroom`
--

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `senderid` varchar(20) DEFAULT NULL,
  `receiverid` varchar(20) DEFAULT NULL,
  `sendername` varchar(45) DEFAULT NULL,
  `receivername` varchar(45) DEFAULT NULL,
  `header` varchar(20) DEFAULT NULL,
  `content` text,
  `sendtime` datetime DEFAULT NULL,
  `receivetime` datetime DEFAULT NULL,
  `sended` tinyint(1) DEFAULT NULL,
  `readed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`msgid`),
  KEY `FK_Reference_11` (`receiverid`),
  KEY `FK_Relationship_3` (`senderid`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`receiverid`) REFERENCES `employee` (`empid`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`senderid`) REFERENCES `employee` (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'2018010101','2018010201',NULL,NULL,'你好','你好啊',NULL,NULL,0,NULL),(2,'2018010101','2018010201',NULL,NULL,'第二','第二次',NULL,NULL,1,NULL),(3,'2018010201','2018010101',NULL,NULL,'收到','收到',NULL,'2018-01-16 16:55:39',1,1),(4,'2018010201','2018010101',NULL,NULL,'还没读','是啊',NULL,'2018-01-16 16:55:47',1,1),(5,'2018010101','2018010201','张果','111','111','朋友你好','2018-01-16 15:32:27',NULL,1,NULL),(6,'2018010101','2018010201','张果','222','111','不好意思','2018-01-16 15:33:09','2018-01-17 16:43:12',0,1),(9,'2018010101','2018010101','张果','哈哈','嘎','1','2018-01-16 17:00:11','2018-01-16 17:00:19',1,1),(11,'2018010101','2018010101','张果','孙张平','你好','你好','2018-01-16 19:31:07','2018-01-16 19:31:12',1,1),(12,'2018010101','2018010101','张果','孙','11','阿凡达','2018-01-17 16:35:43','2018-01-17 16:36:20',1,1),(13,'2018010101','2018010101','张果','打','阿道夫','发的啥给我','2018-01-17 18:33:37','2018-01-17 18:47:20',0,1),(14,'2018010101','2018010101','张果','噶士大夫金龙卡','萨芬撒旦','啊打发十分','2018-01-17 18:47:08','2018-01-17 18:47:32',1,1),(16,'2018010101','2018010101','张果fsad','1','1','1','2018-01-17 20:29:43','2018-01-17 20:30:19',1,1);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `posid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`posid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('01','职员'),('02','经理'),('03','主任');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roommanage`
--

DROP TABLE IF EXISTS `roommanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roommanage` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `room_name` varchar(45) DEFAULT NULL,
  `room_site` varchar(45) DEFAULT NULL,
  `room_count` int(11) DEFAULT NULL,
  `room_air` int(11) DEFAULT NULL,
  `room_view` int(11) DEFAULT NULL,
  `room_state` int(11) DEFAULT NULL,
  `meeting_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roommanage`
--

LOCK TABLES `roommanage` WRITE;
/*!40000 ALTER TABLE `roommanage` DISABLE KEYS */;
INSERT INTO `roommanage` VALUES (1,111,'111','11',50,1,1,0,NULL),(2,103,'21312','12312',21312,1,1,1,NULL);
/*!40000 ALTER TABLE `roommanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `tkid` varchar(20) NOT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `tkname` varchar(20) DEFAULT NULL,
  `bgtime` datetime DEFAULT NULL,
  `edtime` datetime DEFAULT NULL,
  `tkinfo` text,
  PRIMARY KEY (`tkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todo` (
  `tdid` varchar(20) NOT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `tdname` varchar(20) DEFAULT NULL,
  `tddate` date DEFAULT NULL,
  `tdtime` time DEFAULT NULL,
  `done` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`tdid`),
  KEY `FK_Relationship_5` (`empid`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-18  9:15:26
