-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2023 at 07:08 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `labman`
--
CREATE DATABASE IF NOT EXISTS `labman` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `labman`;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `ITEM_ID` int(8) NOT NULL,
  `USER_ID` int(8) DEFAULT NULL,
  `LAB_ID` int(8) DEFAULT NULL,
  `ITEM_NAME` text DEFAULT NULL,
  `ITEM_STATUS` int(11) DEFAULT NULL,
  `ITEM_SO` text NOT NULL,
  `ITEM_RAM` text NOT NULL,
  `ITEM_CPU` text NOT NULL,
  `ITEM_GPU` text NOT NULL,
  `ITEM_JUMLAH` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `LAB_ID` int(8) NOT NULL,
  `USER_ID` int(8) DEFAULT NULL,
  `LAB_NAME` text DEFAULT NULL,
  `LAB_LOCATION` text DEFAULT NULL,
  `LAB_STATUS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
CREATE TABLE `pengguna` (
  `USER_ID` int(8) NOT NULL,
  `ADM_USER_ID` int(8) DEFAULT NULL,
  `USER_USERNAME` char(8) DEFAULT 'username',
  `USER_PASSWORD` char(12) DEFAULT 'password',
  `USER_EMAIL` text DEFAULT NULL,
  `USER_ROLE` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

DROP TABLE IF EXISTS `pesanan`;
CREATE TABLE `pesanan` (
  `ORDER_ID` int(8) NOT NULL,
  `LAB_ID` int(8) DEFAULT NULL,
  `USER_ID` int(8) DEFAULT NULL,
  `ADM_USER_ID` int(8) DEFAULT NULL,
  `ORDER_DATE` datetime DEFAULT NULL,
  `ORDER_STATUS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ITEM_ID`),
  ADD KEY `FK_MEMILIKI` (`LAB_ID`),
  ADD KEY `FK_MEREKAM` (`USER_ID`);

--
-- Indexes for table `lab`
--
ALTER TABLE `lab`
  ADD PRIMARY KEY (`LAB_ID`),
  ADD KEY `FK_MENGATUR` (`USER_ID`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`USER_ID`),
  ADD KEY `FK_EDIT` (`ADM_USER_ID`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`ORDER_ID`),
  ADD KEY `FK_MANAGE` (`USER_ID`),
  ADD KEY `FK_MEMBUAT` (`ADM_USER_ID`),
  ADD KEY `FK_MEMESAN` (`LAB_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ITEM_ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lab`
--
ALTER TABLE `lab`
  MODIFY `LAB_ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `USER_ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `ORDER_ID` int(8) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FK_MEMILIKI` FOREIGN KEY (`LAB_ID`) REFERENCES `lab` (`LAB_ID`),
  ADD CONSTRAINT `FK_MEREKAM` FOREIGN KEY (`USER_ID`) REFERENCES `pengguna` (`USER_ID`);

--
-- Constraints for table `lab`
--
ALTER TABLE `lab`
  ADD CONSTRAINT `FK_MENGATUR` FOREIGN KEY (`USER_ID`) REFERENCES `pengguna` (`USER_ID`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `FK_EDIT` FOREIGN KEY (`ADM_USER_ID`) REFERENCES `pengguna` (`USER_ID`);

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `FK_MANAGE` FOREIGN KEY (`USER_ID`) REFERENCES `pengguna` (`USER_ID`),
  ADD CONSTRAINT `FK_MEMBUAT` FOREIGN KEY (`ADM_USER_ID`) REFERENCES `pengguna` (`USER_ID`),
  ADD CONSTRAINT `FK_MEMESAN` FOREIGN KEY (`LAB_ID`) REFERENCES `lab` (`LAB_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
