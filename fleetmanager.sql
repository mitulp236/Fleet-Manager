-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 29, 2020 at 08:36 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fleetmanager`
--

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
  `isActive` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver_tbl`
--

INSERT INTO `driver_tbl` (`id`, `title`, `firstName`, `middleName`, `lastName`, `dob`, `email`, `telephone`, `mobile`, `jobTitle`, `staffNumber`, `address`, `city`, `postcode`, `licenseNo`, `licenseValidFrom`, `licenseValidTo`, `endDate`, `isActive`) VALUES
(1, 'Mr', 'Mitul', 'Girishbhai', 'Patel', '2020-02-19', 'mitulp236@gmail.com', '1234567844', '8140850797', 'Senior Driver', '7894561235', 'xyz', 'Ahmedabad', '384002', '7945654562daa', '2020-02-03', '2020-02-19', '2020-02-19', 1),
(2, 'Miss', 'Bhumi', 'xyz', 'Dave', '2020-02-04', 'bhumidave@gmail.com', '7894561232', '789454612', 'Trainee Driver', '7984561234', 'wedfwedfewfwrefrewfwrfrwfwfwfrswfwr', 'Anand', '384002', 'aded564dfee', '2020-02-03', '2020-02-21', '2020-02-13', 1);

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
(1, 'Mitul', 'mitulp236@gmail.com', '123');

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for table `driver_tbl`
--
ALTER TABLE `driver_tbl`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
