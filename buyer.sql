-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:00 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buyer`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `Buyer ID` int(11) NOT NULL,
  `Buyer Code` varchar(10) CHARACTER SET latin1 NOT NULL,
  `Buyer Name` varchar(30) CHARACTER SET latin1 NOT NULL,
  `Buyer Email` varchar(25) CHARACTER SET latin1 NOT NULL,
  `Buyer Contact Number` varchar(15) NOT NULL,
  `Buyer Address` varchar(40) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`Buyer ID`, `Buyer Code`, `Buyer Name`, `Buyer Email`, `Buyer Contact Number`, `Buyer Address`) VALUES
(5, 'C123', 'Chathura', 'chathura12@gmail.com', '713466734', 'court road,Kandy'),
(9, 'A123', 'Nihal', 'nihal123@gmail.com', '774528780', 'Galle Road,Colombo'),
(12, 'N101', 'Ama Fernando', 'ama98@gmail.com', '776207076', '1/56 B,Panagoda,Homagama'),
(14, 'K429', 'Chinthaka', 'chinthaka10@gmail.com', '763828420', 'Hospital Road,Matara'),
(18, 'E145', 'Manjula', 'manjula10@gmail.com', '0776725680', 'Ranwala,Kegalle');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`Buyer ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
  MODIFY `Buyer ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
