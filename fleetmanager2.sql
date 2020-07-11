-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 07:53 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fleetmanager2`
--

-- --------------------------------------------------------

--
-- Table structure for table `budget_cat`
--

CREATE TABLE `budget_cat` (
  `catId` int(11) NOT NULL,
  `catName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `budget_cat`
--

INSERT INTO `budget_cat` (`catId`, `catName`) VALUES
(1, 'A'),
(2, 'B');

-- --------------------------------------------------------

--
-- Table structure for table `contract_tbl`
--

CREATE TABLE `contract_tbl` (
  `id` int(11) NOT NULL,
  `vehicaleName` varchar(255) NOT NULL,
  `licensePlate` varchar(50) NOT NULL,
  `distance` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `driverId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contract_tbl`
--

INSERT INTO `contract_tbl` (`id`, `vehicaleName`, `licensePlate`, `distance`, `duration`, `startDate`, `endDate`, `driverId`, `userId`) VALUES
(3, 'Maruti suzuki 800', 'nmhn', 500, 89, '2020-05-26', '2020-05-29', 8, 1),
(4, 'Mercidise banze edited', 'GJ 01 xyz 2365', 500, 89, '2020-05-26', '2020-05-13', 22, 1),
(5, 'Audi A7', 'GJ 01 xyz 2365', 501, 89, '2020-05-26', '2020-05-13', 17, 1),
(6, 'Audi A7', 'GJ 01 xyz 2365', 600, 89, '2020-05-26', '2020-05-13', 8, 1),
(7, 'Baleno ', 'GJ 01 xyz 2365', 500, 89, '2020-05-26', '2020-05-13', 17, 1),
(8, 'Mercidise banze 007', 'GJ 01 xyz 2365', 500, 89, '2020-05-26', '2020-05-13', 21, 2),
(9, 'Brezza', 'GJ 01 xyz 2365', 500, 89, '2020-05-26', '2020-05-13', 21, 2);

-- --------------------------------------------------------

--
-- Table structure for table `driver_tbl`
--

CREATE TABLE `driver_tbl` (
  `id` int(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `middleName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `staffNumber` varchar(255) DEFAULT NULL,
  `address` text NOT NULL,
  `city` varchar(255) NOT NULL,
  `postcode` varchar(255) NOT NULL,
  `licenseNo` varchar(255) DEFAULT NULL,
  `licenseValidFrom` date DEFAULT NULL,
  `licenseValidTo` date DEFAULT NULL,
  `endDate` date NOT NULL,
  `isActive` tinyint(1) NOT NULL,
  `webAccess` tinyint(1) NOT NULL,
  `catId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver_tbl`
--

INSERT INTO `driver_tbl` (`id`, `title`, `firstName`, `middleName`, `lastName`, `dob`, `email`, `telephone`, `mobile`, `jobTitle`, `staffNumber`, `address`, `city`, `postcode`, `licenseNo`, `licenseValidFrom`, `licenseValidTo`, `endDate`, `isActive`, `webAccess`, `catId`) VALUES
(3, 'Mr', 'Meena', 'Girishbhai', 'Patel', '2020-04-08', 'meena@gmail.com', '8140850797', '8140850797', 'Student', '123', 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', '123', '2020-04-02', '2020-04-02', '2020-04-03', 0, 1, 1),
(4, 'Mr', 'Meena', 'Girishbhai', 'Patel', '2020-04-08', 'meena1@gmail.com', '8140850797', '8140850797', 'Student', '123', 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', '123', '2020-04-02', '2020-04-02', '2020-04-03', 0, 1, 1),
(5, 'Mr', 'Meena', 'Girishbhai', 'Patel', '2020-04-08', 'meena2@gmail.com', '8140850797', '8140850797', 'Student', '123', 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', '123', '2020-04-02', '2020-04-02', '2020-04-03', 0, 0, 0),
(6, 'Mr', 'Girish', 'M', 'Patel', '2020-04-02', 'meenapatellkl280674@gmail.com', '8140850797', NULL, NULL, NULL, 'C/7 Tirupati Shahibaug Township,Radhanpur road Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-04-01', 0, 0, 0),
(7, 'Mr', 'Girish', 'M', 'Patel', '2020-04-02', 'meenapathgjyellkl280674@gmail.com', '8140850797', NULL, NULL, NULL, 'C/7 Tirupati Shahibaug Township,Radhanpur road Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-04-01', 0, 0, 0),
(8, 'Miss', 'Mitul', 'M', 'Patel', '2020-04-01', 'mitulp23623@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-04-08', 1, 0, 2),
(9, 'Mrs', 'Meena', 'M', 'Patel', '2020-04-08', 'meenfffapatel280674@gmail.com', NULL, NULL, NULL, NULL, 'c-7\ntirupati shahibaug township radhanpur road mehsana-2\nmehsana', 'MEHSANA', '384002', NULL, NULL, '2020-04-02', '2020-04-03', 0, 0, 0),
(10, 'Mrs', 'Mituldfd', 'M', 'Patel', '2020-04-15', 'mitulp23690@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-04-02', 0, 0, 0),
(11, 'Mr', 'Mitulde', 'M', 'Patel', '2020-04-23', 'mitulp236eded@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-04-22', 0, 0, 1),
(12, 'Mr', 'Mitul', 'M', 'Patel', '2020-04-15', 'mitulp236565@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, '2020-04-15', '2020-04-02', 0, 0, 0),
(13, 'Mr', 'Mitul', 'M', 'Patel', '2020-04-14', 'mitulp2890936@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-04-15', 0, 0, 2),
(14, 'Mr', 'Ok', 'm', 'Patel', '2020-04-06', 'mitulp23651@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-04-15', 1, 1, 1),
(15, 'Miss', 'Oka', 'Girishbhaia', 'Okokoko', '2020-04-28', 'meenapatel2806efre74@gmail.com', NULL, NULL, NULL, NULL, 'swwdde', 'deded', 'deed', NULL, NULL, NULL, '2020-03-31', 1, 1, 2),
(16, 'Mrs', 'K', 'M', 'Patel', '2020-04-09', 'mitulp236knkn@gmail.com', '8140850797', '8140850797', NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-04-08', 0, 1, 1),
(17, 'Mr', 'Mitul', 'M', 'Patel', '2020-05-26', 'mitulp236@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-05-20', 1, 0, 0),
(18, 'Miss', 'Kk', 'M', 'Patel', '2020-05-26', 'mitulp236@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-05-20', 0, 0, 0),
(19, 'Mr', 'Girish', 'M', 'Patel', '2020-05-27', 'gmafatlal07@gmail.com', '8140850797', NULL, NULL, NULL, 'C/7 Tirupati Shahibaug Township,Radhanpur road Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-05-13', 0, 1, 2),
(20, 'Mr', 'Xyz', 'M', 'Patel', '2020-05-13', 'mitulffdp236@gmail.com', '8140850797', NULL, NULL, NULL, 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', NULL, NULL, NULL, '2020-05-12', 1, 1, 2),
(21, 'Miss', 'Urvi', 'V', 'Patel', '2020-05-20', 'urvipatel11796@gmail.com', NULL, NULL, NULL, NULL, 'C-7 TIRUPATI SHAHIBAUG TOWNSHIP RADHANPUR ROAD MEHSANA-2 MEHSANA', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-05-19', 0, 1, 2),
(22, 'Miss', 'Xyz', 'M', 'Patel', '2020-05-27', 'xyz@gmail.com', '8140850797', NULL, NULL, NULL, 'C/7 Tirupati Shahibaug Township,Radhanpur road Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-05-21', 1, 0, 0),
(23, 'Miss', 'Amanda', NULL, 'Jefer', '2020-05-12', 'add@gmail.com', '8140850797', '8140850797', NULL, NULL, 'C/7 Tirupati Shahibaug Township,Radhanpur road Mehsana\nShahibaug township,radhanpur road', 'MAHESANA', '384002', NULL, NULL, NULL, '2020-05-11', 1, 1, 1),
(24, 'Mr', 'Mitul', 'M', 'Patel', '2020-06-12', 'mitulp236dwd@gmail.com', '', '', '', '', 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', '', NULL, NULL, '2020-06-10', 1, 0, 2),
(25, 'Mrs', 'Mitul', 'M', 'Patel', '2020-06-10', 'mitulfvfdvdfvp236@gmail.com', '', '', '', '', 'Mehsana\nShahibaug township,radhanpur road', 'Mehsana', '384002', '', NULL, NULL, '2020-06-09', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `general_settings_tbl`
--

CREATE TABLE `general_settings_tbl` (
  `id` int(255) NOT NULL,
  `keyString` varchar(255) NOT NULL,
  `valueString` varchar(255) NOT NULL,
  `createdDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login_history_tbl`
--

CREATE TABLE `login_history_tbl` (
  `id` int(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `loginTime` datetime NOT NULL,
  `logoutTime` datetime NOT NULL,
  `remoteAddress` varchar(255) NOT NULL,
  `userAgent` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `id` int(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`id`, `name`, `email`, `password`) VALUES
(1, 'Mitul', 'mitulp236@gmail.com', '123'),
(2, 'Testy', 'testyemailid@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `budget_cat`
--
ALTER TABLE `budget_cat`
  ADD PRIMARY KEY (`catId`);

--
-- Indexes for table `contract_tbl`
--
ALTER TABLE `contract_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Driver_FK` (`driverId`);

--
-- Indexes for table `driver_tbl`
--
ALTER TABLE `driver_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `general_settings_tbl`
--
ALTER TABLE `general_settings_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_history_tbl`
--
ALTER TABLE `login_history_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `budget_cat`
--
ALTER TABLE `budget_cat`
  MODIFY `catId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `contract_tbl`
--
ALTER TABLE `contract_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `driver_tbl`
--
ALTER TABLE `driver_tbl`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `general_settings_tbl`
--
ALTER TABLE `general_settings_tbl`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login_history_tbl`
--
ALTER TABLE `login_history_tbl`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contract_tbl`
--
ALTER TABLE `contract_tbl`
  ADD CONSTRAINT `Driver_FK` FOREIGN KEY (`driverId`) REFERENCES `driver_tbl` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
