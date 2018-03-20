/*
SQLyog Community v12.2.1 (64 bit)
MySQL - 5.6.24 : Database - koperasi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`koperasi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `koperasi`;

/*Table structure for table `akun` */

DROP TABLE IF EXISTS `akun`;

CREATE TABLE `akun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `akun` */

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kodeBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  `hargaSatuan` double DEFAULT NULL,
  `stokBarang` int(11) DEFAULT NULL,
  PRIMARY KEY (`kodeBarang`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`id`,`kodeBarang`,`namaBarang`,`hargaSatuan`,`stokBarang`) values 
(17,'ciki1','citato',5000,20),
(24,'ciki10','kacang',500,10),
(19,'ciki2','Katom',1500,400),
(20,'ciki3','HiuHiu',500,500),
(21,'ciki4','Ciatos',1000,30),
(22,'ciki5','Pancus',1000,20);

/*Table structure for table `laporanpembelian` */

DROP TABLE IF EXISTS `laporanpembelian`;

CREATE TABLE `laporanpembelian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date DEFAULT NULL,
  `kodeBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `totalHarga` double DEFAULT NULL,
  PRIMARY KEY (`kodeBarang`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `laporanpembelian` */

/*Table structure for table `laporanpenjualan` */

DROP TABLE IF EXISTS `laporanpenjualan`;

CREATE TABLE `laporanpenjualan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date DEFAULT NULL,
  `kodeBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `totalHarga` double DEFAULT NULL,
  PRIMARY KEY (`kodeBarang`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `laporanpenjualan` */

/*Table structure for table `menejer` */

DROP TABLE IF EXISTS `menejer`;

CREATE TABLE `menejer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `jenisKelamin` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `menejer` */

insert  into `menejer`(`id`,`nama`,`jenisKelamin`,`username`,`password`) values 
(1,'Roche Simanjuntak','Perempuan','rochesimanjuntak','roche123');

/*Table structure for table `pegawai` */

DROP TABLE IF EXISTS `pegawai`;

CREATE TABLE `pegawai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `jenisKelamin` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `pegawai` */

insert  into `pegawai`(`id`,`nama`,`jenisKelamin`,`username`,`password`) values 
(1,'Budi Hasibuan','Pria','budihasibuan','budi123'),
(2,'Ramos Pasaribu','Pria','ramospasaribu','ramos123');

/*Table structure for table `pembelian` */

DROP TABLE IF EXISTS `pembelian`;

CREATE TABLE `pembelian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kodeBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  `hargaBarang` double DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `totalHarga` double DEFAULT NULL,
  `tanggalPembelian` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`kodeBarang`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `pembelian` */

insert  into `pembelian`(`id`,`kodeBarang`,`namaBarang`,`hargaBarang`,`jumlah`,`totalHarga`,`tanggalPembelian`) values 
(9,'ciki10','kacang',500,10,5000,'12/06/2016'),
(6,'ciki3','HiuHiu',500,500,250000,'11/06/2016'),
(7,'ciki4','Ciatos',1000,30,30000,'12/06/2016'),
(8,'ciki5','Pancus',1000,20,20000,'19/06/2016');

/*Table structure for table `penjualan` */

DROP TABLE IF EXISTS `penjualan`;

CREATE TABLE `penjualan` (
  `kodeBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  `hargaBarang` double DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `totalHarga` double DEFAULT NULL,
  `tanggalPenjualan` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`kodeBarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `penjualan` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
