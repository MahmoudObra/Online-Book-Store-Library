-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2016 at 06:02 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ISBN` int(15) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Author` varchar(40) NOT NULL,
  `Publication_Year` int(11) NOT NULL,
  `Category` varchar(20) NOT NULL,
  `No_Of_Copies` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_books`
--

CREATE TABLE `borrowed_books` (
  `User_ID` int(15) NOT NULL,
  `Book_ISBN` int(15) NOT NULL,
  `Borrow_Date` date NOT NULL,
  `Return_Due_Date` date NOT NULL,
  `Notification_flag` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `favourite_books`
--

CREATE TABLE `favourite_books` (
  `User_ID` int(15) NOT NULL,
  `Book_ISBN` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `ID` int(15) NOT NULL,
  `Content` varchar(100) NOT NULL,
  `User_ID` int(15) NOT NULL,
  `Seen_Flag` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(15) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Type` varchar(40) NOT NULL,
  `Date_Of_Birth` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Mobile` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Name`, `Password`, `Email`, `Type`, `Date_Of_Birth`, `Gender`, `Mobile`) VALUES
(1, 'Wagdy Mohamed', '123456789', 'wagdy', 'Admin', '0199-01-01', 'Male', '12012'),
(4, 'El-Admin', '123456', 'admin@library.com', 'Admin', '0199-01-01', 'Male', '01148712729');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD KEY `Book_ISBN` (`Book_ISBN`),
  ADD KEY `Book_ISBN_2` (`Book_ISBN`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `favourite_books`
--
ALTER TABLE `favourite_books`
  ADD KEY `User_ID` (`User_ID`),
  ADD KEY `Book_ISBN` (`Book_ISBN`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowed_books`
--
ALTER TABLE `borrowed_books`
  ADD CONSTRAINT `borrowed_books_ibfk_1` FOREIGN KEY (`Book_ISBN`) REFERENCES `book` (`ISBN`),
  ADD CONSTRAINT `borrowed_books_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `favourite_books`
--
ALTER TABLE `favourite_books`
  ADD CONSTRAINT `favourite_books_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `favourite_books_ibfk_2` FOREIGN KEY (`Book_ISBN`) REFERENCES `book` (`ISBN`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
