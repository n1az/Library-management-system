-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2018 at 08:44 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `borrowinfo`
--

CREATE TABLE `borrowinfo` (
  `borrowId` varchar(50) NOT NULL,
  `bookId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `borrowDate` varchar(50) NOT NULL,
  `returnDate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrowinfo`
--

INSERT INTO `borrowinfo` (`borrowId`, `bookId`, `userId`, `borrowDate`, `returnDate`) VALUES
('1', '22', 'c001', '22-04-2017', '30-4-2017'),
('2', '44', 'c002', '23-05-2016', '29-05-2016'),
('3', '55', 'c003', '01-06-2015', '01-07-2015'),
('c004-99', '99', 'c004', '2018-09-06', '2018-10-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrowinfo`
--
ALTER TABLE `borrowinfo`
  ADD PRIMARY KEY (`borrowId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
