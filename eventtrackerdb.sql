-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eventtrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eventtrackerdb` ;

-- -----------------------------------------------------
-- Schema eventtrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventtrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `eventtrackerdb` ;

-- -----------------------------------------------------
-- Table `eventtrackerdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`user` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(90) NOT NULL,
  `last_name` VARCHAR(90) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`coffee_distributer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`coffee_distributer` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`coffee_distributer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `sellers` VARCHAR(100) NULL,
  `websiteURL` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`roast`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`roast` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`roast` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `coffee_type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`coffee_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`coffee_detail` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`coffee_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `coffee_distributer_id` INT NULL,
  `roast_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_coffee_type_coffee_distributer1_idx` (`coffee_distributer_id` ASC),
  INDEX `fk_coffee_type_roast1_idx` (`roast_id` ASC),
  CONSTRAINT `fk_coffee_type_coffee_distributer1`
    FOREIGN KEY (`coffee_distributer_id`)
    REFERENCES `eventtrackerdb`.`coffee_distributer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coffee_type_roast1`
    FOREIGN KEY (`roast_id`)
    REFERENCES `eventtrackerdb`.`roast` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`coffee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`coffee` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`coffee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NOT NULL DEFAULT 0,
  `detail_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_coffee_coffee_type1_idx` (`detail_id` ASC),
  CONSTRAINT `fk_coffee_coffee_type1`
    FOREIGN KEY (`detail_id`)
    REFERENCES `eventtrackerdb`.`coffee_detail` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`tea_variety`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`tea_variety` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`tea_variety` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `variety` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`tea_distributer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`tea_distributer` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`tea_distributer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `sellers` TEXT NULL,
  `websiteURL` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`tea_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`tea_detail` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`tea_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `variety_id` INT NULL DEFAULT NULL,
  `distributer_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tea_detail_tea_variety1_idx` (`variety_id` ASC),
  INDEX `fk_tea_detail_tea_distributer1_idx` (`distributer_id` ASC),
  CONSTRAINT `fk_tea_detail_tea_variety1`
    FOREIGN KEY (`variety_id`)
    REFERENCES `eventtrackerdb`.`tea_variety` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tea_detail_tea_distributer1`
    FOREIGN KEY (`distributer_id`)
    REFERENCES `eventtrackerdb`.`tea_distributer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`tea`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`tea` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`tea` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE UNSIGNED NOT NULL,
  `detail_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tea_tea_detail1_idx` (`detail_id` ASC),
  CONSTRAINT `fk_tea_tea_detail1`
    FOREIGN KEY (`detail_id`)
    REFERENCES `eventtrackerdb`.`tea_detail` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`cognitive_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`cognitive_status` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`cognitive_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cognitive_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eventtrackerdb`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eventtrackerdb`.`event` ;

CREATE TABLE IF NOT EXISTS `eventtrackerdb`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_time` VARCHAR(20) NOT NULL,
  `event_date` VARCHAR(20) NOT NULL,
  `user_id` INT NOT NULL,
  `coffee_id` INT NULL DEFAULT NULL,
  `tea_id` INT NULL DEFAULT NULL,
  `cognitive_status_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_user1_idx` (`user_id` ASC),
  INDEX `fk_event_coffee1_idx` (`coffee_id` ASC),
  INDEX `fk_event_tea1_idx` (`tea_id` ASC),
  INDEX `fk_event_cognitive_status1_idx` (`cognitive_status_id` ASC),
  CONSTRAINT `fk_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `eventtrackerdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_coffee1`
    FOREIGN KEY (`coffee_id`)
    REFERENCES `eventtrackerdb`.`coffee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_tea1`
    FOREIGN KEY (`tea_id`)
    REFERENCES `eventtrackerdb`.`tea` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_cognitive_status1`
    FOREIGN KEY (`cognitive_status_id`)
    REFERENCES `eventtrackerdb`.`cognitive_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS eventuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'eventuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `eventtrackerdb`.* TO 'eventuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`user` (`id`, `first_name`, `last_name`, `username`, `password`) VALUES (1, 'Mike', 'Murrell', 'mike', 'mike');
INSERT INTO `eventtrackerdb`.`user` (`id`, `first_name`, `last_name`, `username`, `password`) VALUES (2, 'Humphrey', 'Bogart', 'paris', 'casa');
INSERT INTO `eventtrackerdb`.`user` (`id`, `first_name`, `last_name`, `username`, `password`) VALUES (3, 'Al', 'Pacino', 'Corleone', 'sayhello');
INSERT INTO `eventtrackerdb`.`user` (`id`, `first_name`, `last_name`, `username`, `password`) VALUES (4, 'Denzel', 'Washington', 'gangster', 'pelicanbay');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`coffee_distributer`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`coffee_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (1, 'Starbucks', 'Starbucks', 'https://www.starbucks.com/');
INSERT INTO `eventtrackerdb`.`coffee_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (2, 'Novo', 'Novo', 'https://novocoffee.com/');
INSERT INTO `eventtrackerdb`.`coffee_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (3, 'Rex', 'Rex, Amazon', 'http://www.rexcoffeenyc.com/');
INSERT INTO `eventtrackerdb`.`coffee_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (4, 'Caribou', 'Caribou,k Amazon', 'https://www.cariboucoffee.com/');
INSERT INTO `eventtrackerdb`.`coffee_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (5, 'Peet\'s', 'Peet\'s, Amazon', 'https://www.peets.com/');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`roast`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`roast` (`id`, `coffee_type`) VALUES (1, 'Light');
INSERT INTO `eventtrackerdb`.`roast` (`id`, `coffee_type`) VALUES (2, 'Medium');
INSERT INTO `eventtrackerdb`.`roast` (`id`, `coffee_type`) VALUES (3, 'Medium Dark');
INSERT INTO `eventtrackerdb`.`roast` (`id`, `coffee_type`) VALUES (4, 'Dark');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`coffee_detail`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`coffee_detail` (`id`, `name`, `coffee_distributer_id`, `roast_id`) VALUES (1, 'Brazil Campos Altos', 5, 2);
INSERT INTO `eventtrackerdb`.`coffee_detail` (`id`, `name`, `coffee_distributer_id`, `roast_id`) VALUES (2, 'Mahogany', 4, 4);
INSERT INTO `eventtrackerdb`.`coffee_detail` (`id`, `name`, `coffee_distributer_id`, `roast_id`) VALUES (3, 'French Roast', 3, 4);
INSERT INTO `eventtrackerdb`.`coffee_detail` (`id`, `name`, `coffee_distributer_id`, `roast_id`) VALUES (4, 'Alquimia Honey', 2, 1);
INSERT INTO `eventtrackerdb`.`coffee_detail` (`id`, `name`, `coffee_distributer_id`, `roast_id`) VALUES (5, 'Pikes Place', 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`coffee`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (1, 10, 3);
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (2, 12, 5);
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (3, 8, 2);
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (4, 10, 3);
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (5, 24, 1);
INSERT INTO `eventtrackerdb`.`coffee` (`id`, `amount`, `detail_id`) VALUES (6, 16, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`tea_variety`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (1, 'Green');
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (2, 'Black');
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (3, 'Oolong');
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (4, 'Herbal');
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (5, 'White');
INSERT INTO `eventtrackerdb`.`tea_variety` (`id`, `variety`) VALUES (6, 'Pu\'erh');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`tea_distributer`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (1, 'Teavana', 'Amazon, Starbucks', 'https://www.teavana.com/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (2, 'The Tea Spot', 'Amazon', 'https://theteaspot.com/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (3, 'Prince of Peace', 'Amazon', 'https://shop.popus.com/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (4, 'Newman\'s Own', 'Amazon, Kroger', 'https://www.newmansown.com/beverages/type/tea/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (5, 'Harney and Sons', 'Amazon', 'https://www.harney.com/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (6, 'Tealyra', 'Amazon', 'https://www.tealyra.com/');
INSERT INTO `eventtrackerdb`.`tea_distributer` (`id`, `name`, `sellers`, `websiteURL`) VALUES (DEFAULT, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`tea_detail`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (1, 'Gyokuro Imperial Loose-Leaf Green Tea', 1, 1);
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (2, 'The Tea Spot, Lights Out Organic', 2, 2);
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (3, ' Prince Of Peace, Organic', 3, 3);
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (4, '\nNewman\'s Own Organic', 3, 4);
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (5, 'Harney and Sons, Dragon Pearl Jasmine ', 5, 5);
INSERT INTO `eventtrackerdb`.`tea_detail` (`id`, `name`, `variety_id`, `distributer_id`) VALUES (6, 'Tealyra, Jun Shan Yin Zhen', 4, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`cognitive_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`cognitive_status` (`id`, `cognitive_status`) VALUES (1, 'Lathargic');
INSERT INTO `eventtrackerdb`.`cognitive_status` (`id`, `cognitive_status`) VALUES (2, 'I\'m Awake');
INSERT INTO `eventtrackerdb`.`cognitive_status` (`id`, `cognitive_status`) VALUES (3, 'Let\'s Get Shit Done');
INSERT INTO `eventtrackerdb`.`cognitive_status` (`id`, `cognitive_status`) VALUES (4, 'Lazer Focus');
INSERT INTO `eventtrackerdb`.`cognitive_status` (`id`, `cognitive_status`) VALUES (5, 'I Can Hear Colors');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eventtrackerdb`.`event`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventtrackerdb`;
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (1, '08:41:56', '2019-01-26', 2, NULL, NULL, 1);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (2, '12:01:45', '2019-01-26', 3, 2, NULL, 3);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (3, '15:29:21', '2019-01-26', 1, 3, NULL, 3);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (4, '05:00:35', '2019-01-26', 1, 4, NULL, 2);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (5, '06:32:00', '2019-01-26', 2, 5 , NULL, 5);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (6, '17:12:44', '2019-01-26', 4, 6, NULL, 4);
INSERT INTO `eventtrackerdb`.`event` (`id`, `event_time`, `event_date`, `user_id`, `coffee_id`, `tea_id`, `cognitive_status_id`) VALUES (7, '08:09:22', '2019-01-26', 2, NULL, NULL, 1);

COMMIT;

