-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 17, 2023 at 10:51 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pp2_membership`
--

-- --------------------------------------------------------

--
-- Table structure for table `jenis_member`
--

CREATE TABLE `jenis_member` (
  `id` varchar(255) NOT NULL,
  `nama` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jenis_member`
--

INSERT INTO `jenis_member` (`id`, `nama`) VALUES
('b4b53ca3-4d18-4475-944f-f4b63303f7d8', 'Platinum'),
('e08927d6-b718-4c8c-a591-1797c6db160e', 'Silver'),
('fdbdddfb-3a74-46a0-a865-ea219efc0241', 'Gold');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` varchar(255) NOT NULL,
  `jenis_member_id` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `jenis_member_id`, `nama`) VALUES
('26a786e5-08f5-4b0a-90b2-e51f4008c536', 'b4b53ca3-4d18-4475-944f-f4b63303f7d8', 'Putri'),
('3d194c37-be50-4a3f-9c84-cc737c25aee3', 'fdbdddfb-3a74-46a0-a865-ea219efc0241', 'Qudsiyah'),
('f266fb53-f673-4bae-b233-f6a143fbb0e8', 'e08927d6-b718-4c8c-a591-1797c6db160e', 'Azizah');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jenis_member`
--
ALTER TABLE `jenis_member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
