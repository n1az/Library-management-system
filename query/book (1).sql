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
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` varchar(50) NOT NULL,
  `bookTitle` varchar(80) NOT NULL,
  `authorName` varchar(80) NOT NULL,
  `publicationYear` varchar(50) NOT NULL,
  `availableQuantity` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookTitle`, `authorName`, `publicationYear`, `availableQuantity`) VALUES
('00', 'rasha', 'MD. Jafar Iqbal', '2013', 3),
('22', 'Origin', 'Dan Brown', '2017', 5),
('33', '3:00 Am', 'Nick Pirog', '2018', 2),
('44', 'Alchemist', 'Paolo Coelho ', '1988', 7),
('55', 'Godfather ', 'Maria Puzo', '1969', 4),
('66', 'Debi', 'Humayun Ahmed ', '1985', 7),
('77', 'Confessor', 'Daniel Silva ', '2015', 6),
('99', 'Quantam Mechanics', 'Jonathan Dimock', '2011', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
