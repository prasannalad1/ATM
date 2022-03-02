-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2022 at 11:35 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atmapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `amount` bigint(20) NOT NULL,
  `transactionType` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `useratm`
--

CREATE TABLE `useratm` (
  `userId` bigint(20) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `password` bigint(20) NOT NULL,
  `balance` bigint(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useratm`
--

INSERT INTO `useratm` (`userId`, `userName`, `address`, `password`, `balance`, `email`, `phone`) VALUES
(101, 'Prasanna', 'Satara', 1122, 40000, 'pl@gmail.com', 9878987865),
(122, 'Rutuja', 'Sangli', 1122, 450000, 'rk12@gmail.com', 8767899892),
(149, 'Shreya', 'Aundh', 1111, 70000, 'sn@gmail.com', 8787678987);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionId`);

--
-- Indexes for table `useratm`
--
ALTER TABLE `useratm`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
