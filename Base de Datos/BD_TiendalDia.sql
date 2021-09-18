CREATE DATABASE  IF NOT EXISTS `tiendaaldia` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tiendaaldia`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendaaldia
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(45) NOT NULL,
  `decripcionCategoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `idCategoria_UNIQUE` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Aseo','Incluídos aseo personal y para el hogar'),(2,'Abarrotes','Comidas, bebidas y conservas');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(45) NOT NULL,
  `referenciaProducto` varchar(45) NOT NULL,
  `cantidadProducto` double NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  `idProveedor` int NOT NULL,
  `idCategoria` int NOT NULL,
  `ivaActual` double NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idProducto_UNIQUE` (`idProducto`),
  KEY `proveedorId_idx` (`idProveedor`),
  KEY `categoriaId_idx` (`idCategoria`),
  CONSTRAINT `ProductoCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `ProductoProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Jabón de manos','1001',100,1000,2000,1,1,16),(2,'Papel higiénico','1002',250,800,1500,2,1,16),(3,'Cepillo dientes','1003',50,1900,3000,1,1,16),(4,'Panela','1004',300,900,2000,3,2,16);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(45) DEFAULT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `idProveedor_UNIQUE` (`idProveedor`),
  KEY `usuarioId_idx` (`idUsuario`),
  CONSTRAINT `ProveedorUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'JGB',2),(2,'Rosal',3),(3,'Fonce',4);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tendero`
--

DROP TABLE IF EXISTS `tendero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tendero` (
  `idTendero` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `idUsuario` int NOT NULL,
  `nombreTienda` varchar(45) NOT NULL,
  PRIMARY KEY (`idTendero`),
  UNIQUE KEY `idTendero_UNIQUE` (`idTendero`),
  KEY `usuarioID_idx` (`idUsuario`),
  CONSTRAINT `TenderoUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tendero`
--

LOCK TABLES `tendero` WRITE;
/*!40000 ALTER TABLE `tendero` DISABLE KEYS */;
INSERT INTO `tendero` VALUES (1,'DonTiendas','1234',1,'Tienda Colombia');
/*!40000 ALTER TABLE `tendero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacciones` (
  `idTransacciones` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `totalTransaccion` double NOT NULL,
  `cantidadTransaccion` double NOT NULL,
  `valorUnitarioCompra` double NOT NULL,
  `valorUnitarioVenta` double NOT NULL,
  `fechaTransaccion` date NOT NULL,
  `ivaTransaccion` double NOT NULL,
  `tipoTransacciones` varchar(45) NOT NULL,
  PRIMARY KEY (`idTransacciones`),
  UNIQUE KEY `idVentas_UNIQUE` (`idTransacciones`),
  KEY `TransaccionProducto_idx` (`idProducto`),
  CONSTRAINT `TransaccionProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacciones`
--

LOCK TABLES `transacciones` WRITE;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
INSERT INTO `transacciones` VALUES (1,1,20000,10,2000,2000,'2021-09-14',0.19,'Venta'),(2,2,22500,15,1500,1500,'2021-09-14',0.19,'Venta'),(3,3,24000,8,3000,3000,'2021-09-14',0.19,'Venta'),(4,1,40000,20,2000,2000,'2021-09-14',0.19,'Compra'),(5,4,5000,5,1000,1000,'2021-09-14',0.19,'Compra');
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `nombresUsuarios` varchar(45) NOT NULL,
  `apellidosUsuarios` varchar(45) NOT NULL,
  `tipoIdentificacion` varchar(45) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `direccionUsuarios` varchar(45) NOT NULL,
  `telefonoUsuarios` varchar(45) NOT NULL,
  `correoUsuarios` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE KEY `idusuarios_UNIQUE` (`idUsuarios`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Alfredo','Rojas','CC','159357','Bucaramanga','7268532','a@gmail.com'),(2,'Pedro','Masias','CC','153957','Bogotá','6543251','b@gmail.com'),(3,'Emperatriz','Pardo','CC','183927','Cali','3456523','c@gmail.com'),(4,'Carmen','Gómez','CC','193179','Tabio','5586278','d@gmail.com');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-17 20:49:11
