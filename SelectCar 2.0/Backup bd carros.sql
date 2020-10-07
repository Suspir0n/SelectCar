CREATE DATABASE  IF NOT EXISTS `carros` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `carros`;
-- MariaDB dump 10.17  Distrib 10.4.10-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: carros
-- ------------------------------------------------------
-- Server version	10.4.10-MariaDB

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
-- Table structure for table `aluguel`
--

DROP TABLE IF EXISTS `aluguel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguel` (
  `ID_Aluguel` int(11) NOT NULL AUTO_INCREMENT,
  `Veiculo` varchar(40) NOT NULL,
  `Data_Aluguel` date DEFAULT NULL,
  `Data_Entrega` date DEFAULT NULL,
  `Cliente` varchar(14) NOT NULL,
  `Entregue` char(1) NOT NULL,
  `Observacao` varchar(30) DEFAULT NULL,
  `Valor_Pago` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_Aluguel`),
  KEY `placa` (`Veiculo`),
  KEY `cpf` (`Cliente`),
  CONSTRAINT `cpf` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`Cpf`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `placa` FOREIGN KEY (`Veiculo`) REFERENCES `veiculo` (`Placa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluguel`
--

LOCK TABLES `aluguel` WRITE;
/*!40000 ALTER TABLE `aluguel` DISABLE KEYS */;
INSERT INTO `aluguel` VALUES (1,'BLZ-6985','2020-04-01','2020-04-12','15926347826','N','Teste',1500);
/*!40000 ALTER TABLE `aluguel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Nome_Cliente` varchar(25) DEFAULT NULL,
  `Endereco` text DEFAULT NULL,
  `UF` char(3) DEFAULT NULL,
  `Telefone` int(11) DEFAULT NULL,
  `Cpf` varchar(14) NOT NULL,
  `Email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('Matheus Silva','Estrada de sucesso','BA',89745621,'15926347826','matheusnovato@gmail.com'),('Caique jesus','Rua Nova','BA',99885566,'32145698778','caiqueBD@gmail.com'),('Gabriel Guerreiro','Ta tega','BA',78954631,'36985214735','gabriel@gmail.com'),('Raudinei Andrade','Engenho velho','BA',85967423,'85296374135','raudineidesigner@gmai.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Usuario` varchar(25) DEFAULT NULL,
  `Cargo` varchar(20) DEFAULT NULL,
  `Login` varchar(20) DEFAULT NULL,
  `Senha` varchar(30) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','Programador','admin','admin','admin@support.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `Numero` varchar(40) NOT NULL,
  `Placa` varchar(40) NOT NULL,
  `Fabricante` varchar(40) DEFAULT NULL,
  `Modelo` varchar(20) DEFAULT NULL,
  `Ano_Modelo` int(11) DEFAULT NULL,
  `Qtd_Portas` int(11) DEFAULT NULL,
  `Acessorios` text DEFAULT NULL,
  PRIMARY KEY (`Placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES ('asda5123a14185','BLZ-6985','DevTech','suave',2020,4,'Condutor Adicional'),('asdd545a2ds','COD-6547','DevTech','programe',2020,4,'Wi-Fi'),('asfdd218s5dacac','MAE-0101','DevTech','paixao',2020,4,'Assento para Criança'),('gscafse251sfd','OPA-9874','DevTech','énois',2020,4,'Assento para Criança'),('as2d1564asdca','PPT-6587','DevTech','Boto Fé',2020,2,'Locatário Jovem');
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'carros'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-19 14:44:22
