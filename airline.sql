-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `add_flights`
--

DROP TABLE IF EXISTS `add_flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `add_flights` (
  `flight_no` int NOT NULL,
  `flight_model` varchar(225) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `source` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `destination` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `departure_time` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `arrival_time` varchar(225) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `flight_date` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `mcheck` varchar(225) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `ercheck` varchar(225) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `wcheck` varchar(225) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`flight_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_flights`
--

LOCK TABLES `add_flights` WRITE;
/*!40000 ALTER TABLE `add_flights` DISABLE KEYS */;
INSERT INTO `add_flights` VALUES (123,'airbus','blr','goa','9:00pm','10:00pm','2020-03-30','Maintainance Check','Electronics and Radar Check','',123),(778,'ZX-65','Kolkata','Goa','12:00 PM','6:00 PM','2020-03-23','Maintainance Check','Electronics and Radar Check','',45),(787,'AW-3','Goa','Delhi','2:00 PM','3:00 AM','2020-03-10','Maintainance Check','','',67),(991,'SR-67','Bangalore','Goa','11:00 AM','1:00 PM','2020-03-25','Maintainance checked','Electronics and radar checked','Weather Check',65),(992,'CR-45','Bangalore','Goa','10:45 AM','2:00 PM','2020-03-30','Maintainance checked','Electronics and radar checked','Weather checked',45),(993,'CW-33','Bangalore','Delhi','4:00 PM','7:00 AM','2020-03-24','Maintainance checked','Electronics and Radar Check','Weather Check',56),(994,'AQ-65','Kolkata','Goa','12:00 PM','6:00 PM','2020-04-23','Maintainance Check','','Weather Check',79),(995,'AD-98','Bangalore','Delhi','4:00 PM','7:00 AM','2020-03-24','Maintainance checked','Electronics and radar checked','weather checked',33),(998,'AP-76','Goa','Jaipur','4:00 PM','4:00 PM','2020-03-30','Maintainance checked','Electronics and radar checked','weather checked',33),(999,'AD-90','Bangalore ','Kolkata','10:00 AM','1:00 PM','2020-03-30','Maintainance Check','','',23),(4443,'DE-78','Punjab','Delhi','12:00 PM','2:00 PM','2020-03-10','Maintainance Check','Electronics and Radar Check','Weather Check',67),(9999,'QW-12','Bangalore','Jaipur','12:00 AM','1:00 pm','2020-03-21','Maintainance Check','','',12),(32167,'AP-78','Jaipur','Bangalore','10:00 AM','4:00 PM','2020-03-09','Maintainance Check','','',44),(45654,'AP-75','Chennai','Goa','10:00 AM','4:00 PM','2020-03-03','Maintainance checked','Electronics and radar checked','weather checked',44),(999888,'SA-56','Bangalore','Jharkhand','12:00 AM','2:00 PM','2020-03-30','Maintainance Check','','',12);
/*!40000 ALTER TABLE `add_flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `last_name` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `email_id` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `password` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `phone_no` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','d','d@gmail.com','123','1234567890'),(2,'utsav','d','ud@gmail.com','321','0987654321');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `booking` (
  `passport_no` int NOT NULL,
  `fname` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `lname` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `flight_no` int DEFAULT NULL,
  `source` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `destination` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `date` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `category` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `classid` int DEFAULT NULL,
  PRIMARY KEY (`passport_no`),
  KEY `flight_no` (`flight_no`) /*!80000 INVISIBLE */,
  KEY `customer_id_fk` (`customer_id`),
  KEY `class_fk` (`classid`),
  CONSTRAINT `classid_fk` FOREIGN KEY (`classid`) REFERENCES `price` (`classid`),
  CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `flight_no_fk` FOREIGN KEY (`flight_no`) REFERENCES `add_flights` (`flight_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (21122,'Jayanth','C',991,'Bangalore','Goa','8873211432','2020-04-17',13,'Adult ',1),(55443,'Utsav','Das',991,'Bangalore','Goa','9956433254','2020-04-23',15,'Child',1),(123123,'Utsav','das',998,'Delhi','Gujrat','3423244444','2020-03-17',10,'Child',2),(213222,'Sam','T',991,'Bangalore','Kolkata','4895734888','2020-09-23',10,'Adult',2),(321321,'Ram','S',991,'Delhi','Bangalore','9934655621','2020-03-25',10,'Adult ',2),(328974,'Daarun','J K',998,'Bangalore','Goa','8665011019','2020-03-31',10,'Adult ',1),(435434,'Tarun','kumar',995,'Bangalore','Goa','9987999999','2020-03-11',10,'Adult ',3),(634785,'Ram','S',995,'Goa','Gujrat','0987654361','2020-04-01',10,'Adult ',1),(654222,'Tarun','kumar',995,'Delhi','Punjab','9987611018','2020-04-10',10,'Child',2),(687333,'Jyothi','kumari',995,'Bangalore','Jharkhand','9986777777','2020-03-31',10,'Adult ',3),(845325,'Jayanth','C',995,'Bangalore','Delhi','9986000000','2020-03-25',10,'Adult ',1),(987895,'Jayanth ','C',995,'Gujarat ','Maharashtra ','2314243245','2020-02-19',10,'Child',1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `state` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `landmark` varchar(255) NOT NULL,
  `pincode` int NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'mark','berg','berg11@gmail.com','12345','9111111111','karnataka','mangalore','state bank',574154),(2,'winston','dsouza','winstonds12@gmail.com','123456','9764316497','karnataka','mangalore','urva store',574154),(3,'Sheldon','Sam','sam12@gmail.com','2345','9888888856','karnataka','mangalore','urva store',574154),(4,'kishore','kumar','kumar45@gmail.com','12345','9865326598','karnataka','Bangalore','hsr layout',50004),(5,'bob','sin','bob14@gmail.com','45698','9081649731','karnataka','bangalore','bda complex hbr layout',560102),(6,'meril','dsouza','meril11@gmail.com','123456','9632895563','karnataka','bangalore','vijayanagar vijaya bank layout',560040),(7,'max','dsouza','max12@gmail.com','123456','9741628856','karnataka','mangalore','urva store',574154),(8,'maxton','mosses','mos12@gmail.com','123','9741628856','karnataka','bangalore','city centre mall mg road',574154),(9,'Feona','Melisa','melisa@gmail.com','123','9101928856','karnataka','mangalore','near state bank circle',574154),(10,'admin','admin','admin@gmail.com','pass','1234567890','Karnataka','Bangalore','NMIT College',560054),(11,'jefhjkw','ehfwqjk','mdnfakjb@gmail.com','password','1234567890','karnataka','bangalaore','jsfanv',560054),(12,'uhkh','jbjb','red@gmail.com','thethe','8887778877','fhjv','jhbmhv','vjhmhbh',560054),(13,'Jayanth','C','jayanth@gmail.com','ssap','9934211213','Goa','Goa','Goa',112232),(14,'Daarun','JK','daarun@gmail.com','1234','1145377654','karnataka','bangalore','jp nagar',560044),(15,'Utsav','Das','utsav@gmail.com','123','9945633231','Goa','Goa','NMIT',332213);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_details`
--

DROP TABLE IF EXISTS `payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `payment_details` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `card_number` varchar(16) NOT NULL,
  `card_holder_name` varchar(255) NOT NULL,
  `cvv` int NOT NULL,
  `exp_month` int NOT NULL,
  `exp_year` int NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`payment_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `payment_details_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_details`
--

LOCK TABLES `payment_details` WRITE;
/*!40000 ALTER TABLE `payment_details` DISABLE KEYS */;
INSERT INTO `payment_details` VALUES (8,2,'1234123412341234','winston',123,10,25,'2018-11-04 04:21:29'),(9,2,'1234123412341234','winston',123,12,34,'2018-11-06 09:21:19'),(10,2,'1234123412341234','winston',123,3,19,'2018-11-06 12:57:36'),(11,2,'1234123412341234','winston',122,12,22,'2018-11-07 04:20:01'),(12,2,'1234123412341234','winston',123,12,22,'2018-11-12 09:54:04'),(13,2,'1234123412341234','wins',123,12,22,'2018-11-12 10:57:53'),(14,10,'123412341234','ut',456,8,21,'2020-03-18 03:32:27'),(15,10,'4567456745674567','utsav',123,9,22,'2020-03-18 03:43:09'),(16,10,'1234123412341234','grgr',345,98,55,'2020-03-18 03:45:54'),(17,10,'3456345634563456','guyg',678,8,22,'2020-03-18 06:16:36'),(18,10,'1234123412341234','jjjj',789,9,22,'2020-03-23 03:54:49'),(19,10,'1234123412341234','red',98,9,22,'2020-03-23 03:58:45'),(20,10,'1234123412341234','der',987,12,22,'2020-03-23 04:01:01'),(21,10,'656754353','yuu',564,12,23,'2020-03-28 17:39:51'),(22,10,'1234123412341234','utsav',123,3,21,'2020-03-29 06:39:28'),(23,10,'6786767867878','hgighgh',888,9,88,'2020-03-29 11:03:47'),(24,10,'36536346','gjh',987,9,21,'2020-03-29 11:52:16'),(25,10,'980989','qwerty',123,9,22,'2020-03-29 11:59:35'),(26,10,'133243134331344','gbrtr',123,12,21,'2020-03-29 12:18:15'),(27,13,'123412341234','Jayanth',887,2,21,'2020-04-16 09:27:57');
/*!40000 ALTER TABLE `payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = latin14 */;
CREATE TABLE `price` (
  `classid` int NOT NULL,
  `class` varchar(45) DEFAULT NULL,
  `adultprice` int DEFAULT NULL,
  `childprice` int DEFAULT NULL,
  PRIMARY KEY (`classid`),
  KEY `class_fk` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin14 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'First Class',91000,80000),(2,'Business Class',30000,45000),(3,'Economy Class',20000,15000);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 14:54:34
