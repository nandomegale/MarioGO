-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: mario
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `amigo`
--

DROP TABLE IF EXISTS `amigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amigo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  `habilidade` varchar(100) NOT NULL,
  `historia` varchar(100) NOT NULL,
  `AmigoHasUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AmigoHasUsuario` (`AmigoHasUsuario`),
  CONSTRAINT `amigo_ibfk_1` FOREIGN KEY (`AmigoHasUsuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amigo`
--

LOCK TABLES `amigo` WRITE;
/*!40000 ALTER TABLE `amigo` DISABLE KEYS */;
INSERT INTO `amigo` VALUES (2,'a','a','a',1),(3,'baaaaaaaaaaaaaa','aaaaaaaaaaaaaaaaaaaa','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',NULL),(4,'kkkkkkkkkkk','kkkkkkkkkkk','kkkkkkkkkkkkkkkk',1);
/*!40000 ALTER TABLE `amigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estalogado`
--

DROP TABLE IF EXISTS `estalogado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estalogado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estalogado`
--

LOCK TABLES `estalogado` WRITE;
/*!40000 ALTER TABLE `estalogado` DISABLE KEYS */;
INSERT INTO `estalogado` VALUES (7,'a'),(8,'user'),(9,'user'),(10,'user'),(11,'user'),(12,'user'),(13,'user'),(14,'user'),(15,'user'),(16,'user'),(17,'user'),(18,'user'),(19,'user');
/*!40000 ALTER TABLE `estalogado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inimigo`
--

DROP TABLE IF EXISTS `inimigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inimigo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  `habilidade` varchar(100) NOT NULL,
  `historia` varchar(100) NOT NULL,
  `InimigoHasUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `InimigoHasUsuario` (`InimigoHasUsuario`),
  CONSTRAINT `inimigo_ibfk_1` FOREIGN KEY (`InimigoHasUsuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inimigo`
--

LOCK TABLES `inimigo` WRITE;
/*!40000 ALTER TABLE `inimigo` DISABLE KEYS */;
INSERT INTO `inimigo` VALUES (1,'Browser','pegar_o_mario','ele-sequestra-a-princesa',1),(2,'ahhhhhhhhhhh','hhhhhhhhhhhh','hhhhhhhhhhhhhhhhhhhhhhhh',1);
/*!40000 ALTER TABLE `inimigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginuser`
--

DROP TABLE IF EXISTS `loginuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginuser`
--

LOCK TABLES `loginuser` WRITE;
/*!40000 ALTER TABLE `loginuser` DISABLE KEYS */;
INSERT INTO `loginuser` VALUES (1,'user','user'),(4,'teste','teste');
/*!40000 ALTER TABLE `loginuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poder`
--

DROP TABLE IF EXISTS `poder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  `efeito` varchar(100) NOT NULL,
  `PoderHasUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PoderHasUsuario` (`PoderHasUsuario`),
  CONSTRAINT `poder_ibfk_1` FOREIGN KEY (`PoderHasUsuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poder`
--

LOCK TABLES `poder` WRITE;
/*!40000 ALTER TABLE `poder` DISABLE KEYS */;
INSERT INTO `poder` VALUES (1,'flor','com_ela_o_personagem_solta_bola_de_fogo',1);
/*!40000 ALTER TABLE `poder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regiao`
--

DROP TABLE IF EXISTS `regiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regiao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `RegiaoHasUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regiao`
--

LOCK TABLES `regiao` WRITE;
/*!40000 ALTER TABLE `regiao` DISABLE KEYS */;
INSERT INTO `regiao` VALUES (1,'Fase1','O-jogador-da-os-primeiros-passos-no-jogo',1),(2,'qqqqqqqq','qqqqqqqqqqqqqq',1);
/*!40000 ALTER TABLE `regiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `idade` int(11) NOT NULL,
  `UsuarioHasLoginUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `UsuarioHasLoginUser` (`UsuarioHasLoginUser`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`UsuarioHasLoginUser`) REFERENCES `loginuser` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Andre',21,1),(4,'teste',67,4);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioregiao`
--

DROP TABLE IF EXISTS `usuarioregiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioregiao` (
  `usuario` int(11) NOT NULL,
  `regiao` int(11) NOT NULL,
  PRIMARY KEY (`usuario`,`regiao`),
  KEY `regiao` (`regiao`),
  CONSTRAINT `usuarioregiao_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `usuarioregiao_ibfk_2` FOREIGN KEY (`regiao`) REFERENCES `regiao` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioregiao`
--

LOCK TABLES `usuarioregiao` WRITE;
/*!40000 ALTER TABLE `usuarioregiao` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioregiao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-27 23:22:11
