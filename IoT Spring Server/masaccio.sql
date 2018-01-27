-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 26, 2018 at 04:53 PM
-- Server version: 5.6.35
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `masaccio`
--

-- --------------------------------------------------------

--
-- Table structure for table `APP_USER`
--

CREATE TABLE `APP_USER` (
  `id` bigint(20) NOT NULL,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `APP_USER`
--

INSERT INTO `APP_USER` (`id`, `sso_id`, `password`, `first_name`, `last_name`, `email`, `state`) VALUES
(1, 'admin', 'admin', 'Luca', 'Grillo', 'danny2@xyz.com', 'Active'),
(2, 'user', 'user', 'Danny', 'Theys', 'danny@xyz.com', 'Active'),
(3, 'employee', 'employee', 'Sam', 'Smith', 'samy@xyz.com', 'Active'),
(4, 'responder', 'responder', 'Nicole', 'warner', 'nicloe@xyz.com', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `APP_USER_USER_PROFILE`
--

CREATE TABLE `APP_USER_USER_PROFILE` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `APP_USER_USER_PROFILE`
--

INSERT INTO `APP_USER_USER_PROFILE` (`user_id`, `user_profile_id`) VALUES
(1, 1),
(2, 1),
(1, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `CARD`
--

CREATE TABLE `CARD` (
  `id` int(11) NOT NULL,
  `uid` varchar(8) NOT NULL,
  `user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `CARD`
--

INSERT INTO `CARD` (`id`, `uid`, `user`) VALUES
(1, 'abcdef12', 1),
(2, '12345678', 2),
(3, 'a1b2c3d4', 3),
(4, 'abcd1234', 4);

-- --------------------------------------------------------

--
-- Table structure for table `ITEM`
--

CREATE TABLE `ITEM` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ITEM`
--

INSERT INTO `ITEM` (`id`, `name`) VALUES
(1, 'door1'),
(2, 'door2'),
(3, 'door3'),
(4, 'showcase1'),
(5, 'showcase2'),
(6, 'showcase3'),
(7, 'gate1'),
(8, 'gate2'),
(9, 'gate3');

-- --------------------------------------------------------

--
-- Table structure for table `USER_PROFILE`
--

CREATE TABLE `USER_PROFILE` (
  `id` bigint(20) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USER_PROFILE`
--

INSERT INTO `USER_PROFILE` (`id`, `type`) VALUES
(2, 'ADMIN'),
(3, 'EMPLOYEE'),
(4, 'RESPONDER'),
(1, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `USER_PROFILE_ITEM`
--

CREATE TABLE `USER_PROFILE_ITEM` (
  `user_profile` bigint(20) NOT NULL,
  `item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USER_PROFILE_ITEM`
--

INSERT INTO `USER_PROFILE_ITEM` (`user_profile`, `item`) VALUES
(1, 7),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(4, 1),
(4, 2),
(4, 3),
(4, 7),
(4, 8),
(4, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `APP_USER`
--
ALTER TABLE `APP_USER`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sso_id` (`sso_id`);

--
-- Indexes for table `APP_USER_USER_PROFILE`
--
ALTER TABLE `APP_USER_USER_PROFILE`
  ADD PRIMARY KEY (`user_id`,`user_profile_id`),
  ADD KEY `FK_USER_PROFILE` (`user_profile_id`);

--
-- Indexes for table `CARD`
--
ALTER TABLE `CARD`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user`),
  ADD KEY `user_2` (`user`);

--
-- Indexes for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `USER_PROFILE`
--
ALTER TABLE `USER_PROFILE`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `USER_PROFILE_ITEM`
--
ALTER TABLE `USER_PROFILE_ITEM`
  ADD KEY `user` (`user_profile`),
  ADD KEY `item` (`item`),
  ADD KEY `user_2` (`user_profile`,`item`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `APP_USER`
--
ALTER TABLE `APP_USER`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `CARD`
--
ALTER TABLE `CARD`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ITEM`
--
ALTER TABLE `ITEM`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `USER_PROFILE`
--
ALTER TABLE `USER_PROFILE`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `APP_USER_USER_PROFILE`
--
ALTER TABLE `APP_USER_USER_PROFILE`
  ADD CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `APP_USER` (`id`),
  ADD CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `USER_PROFILE` (`id`);

--
-- Constraints for table `CARD`
--
ALTER TABLE `CARD`
  ADD CONSTRAINT `card_ibfk_1` FOREIGN KEY (`user`) REFERENCES `APP_USER` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `USER_PROFILE_ITEM`
--
ALTER TABLE `USER_PROFILE_ITEM`
  ADD CONSTRAINT `user_profile_item_ibfk_1` FOREIGN KEY (`item`) REFERENCES `ITEM` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_profile_item_ibfk_2` FOREIGN KEY (`user_profile`) REFERENCES `APP_USER_USER_PROFILE` (`user_profile_id`) ON DELETE CASCADE ON UPDATE CASCADE;
