DROP DATABASE IF EXISTS `useradmin`;
CREATE DATABASE `useradmin`;

USE `useradmin`;

DROP TABLE IF EXISTS `order`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `h` int NOT NULL,
  `l` int NOT NULL,
  `w` int NOT NULL,
  `shipped` boolean NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'a@a.dk','a','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','customer'),
(4, 'admin', 'admin', 'employee');
UNLOCK TABLES;

LOCK TABLES `order` WRITE;
INSERT INTO `order`(`user_id`, `h`, `l`, `w`) VALUES 
(1, 10, 10, 10);
INSERT INTO `order`(`user_id`, `h`, `l`, `w`) VALUES 
(2, 12, 12, 12);
INSERT INTO `order`(`user_id`, `h`, `l`, `w`) VALUES 
(3, 13, 13, 13);
UNLOCK TABLES;
