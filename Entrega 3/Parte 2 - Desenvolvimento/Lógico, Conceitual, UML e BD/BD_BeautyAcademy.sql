CREATE DATABASE  IF NOT EXISTS `beautyacademy3` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `beautyacademy3`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: beautyacademy3
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `matricula` int NOT NULL AUTO_INCREMENT,
  `celular` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `id_cargo` bigint NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `UK_3wpes15e0anbfaa4do0pey97k` (`email`),
  KEY `FKkg98tqrexllrwi4kvm49i7e8h` (`id_cargo`),
  CONSTRAINT `FKkg98tqrexllrwi4kvm49i7e8h` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (5,21965777053,'admin@admin.com','Admin','$2a$10$.fPje6vY24hm4VTJStjLO.vJdFRiK2rk1tgiUkYr91wZAhYxgsVEG',2),(8,21965777053,'daniel.lira.s23@gmail.com','Daniel Lira da Silva ','$2a$10$8Iyu5/Fw3rBHVrpSELpZ7O0BpN7DwlqwHPM9s60gu.gKkCQxSy2yy',1),(10,12345678999,'caioPiabas@gmail.com','Caio Boladão','$2a$10$IGDcb7DEM1BO.DL4DpIA6u61QTQvvi6a6krH9ScCI4vxGWqMwBeZm',2);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_91fcfd99kg1af67rjv08heu1q` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (2,'ADMIN'),(1,'USER');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `UK_bdhliwglt8i7q1v80fb95vea9` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (6,'add5g4g'),(5,'aggthyd'),(2,'teste');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula_curso`
--

DROP TABLE IF EXISTS `matricula_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula_curso` (
  `id_matricula_curso` int NOT NULL AUTO_INCREMENT,
  `matricula_aluno` int DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_matricula_curso`),
  KEY `FK8sv8bcnhsali67nfphya6itaq` (`matricula_aluno`),
  KEY `FK3afp2epou4akwv3offsnns0pj` (`id_curso`),
  CONSTRAINT `FK3afp2epou4akwv3offsnns0pj` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `FK8sv8bcnhsali67nfphya6itaq` FOREIGN KEY (`matricula_aluno`) REFERENCES `aluno` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula_curso`
--

LOCK TABLES `matricula_curso` WRITE;
/*!40000 ALTER TABLE `matricula_curso` DISABLE KEYS */;
INSERT INTO `matricula_curso` VALUES (13,5,6);
/*!40000 ALTER TABLE `matricula_curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-27 14:06:13
