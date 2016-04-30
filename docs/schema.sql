-- MySQL Script generated by MySQL Workbench
-- Fri 29 Apr 2016 04:02:40 PM CEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema companies_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `companies_db` ;

-- -----------------------------------------------------
-- Schema companies_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `companies_db` DEFAULT CHARACTER SET latin1 ;
USE `companies_db` ;

-- -----------------------------------------------------
-- Table `companies_db`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`companies` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nipt` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `address` TEXT NULL DEFAULT NULL,
  `email` VARCHAR(30) NOT NULL,
  `password` VARCHAR(113) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nipt` (`nipt` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `nipt_idx` (`nipt` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`departments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `company_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `company_id` (`company_id` ASC),
  CONSTRAINT `departments_ibfk_1`
    FOREIGN KEY (`company_id`)
    REFERENCES `companies_db`.`companies` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`salaries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`salaries` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `value` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `salary_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `salary_id` (`salary_id` ASC),
  INDEX `name_idx` (`name` ASC),
  CONSTRAINT `roles_ibfk_1`
    FOREIGN KEY (`salary_id`)
    REFERENCES `companies_db`.`salaries` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`offices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`offices` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tables` INT(11) NULL DEFAULT '0',
  `pc_count` INT(11) NULL DEFAULT '0',
  `laptops` INT(11) NULL DEFAULT '0',
  `chairs` INT(11) NULL DEFAULT '0',
  `windows` INT(11) NULL DEFAULT '0',
  `books` INT(11) NULL DEFAULT '0',
  `pencils` INT(11) NULL DEFAULT '0',
  `pens` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`sectors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`sectors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `office_id` INT(11) NOT NULL,
  `department_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `office_id` (`office_id` ASC),
  INDEX `department_id` (`department_id` ASC),
  CONSTRAINT `sectors_ibfk_1`
    FOREIGN KEY (`office_id`)
    REFERENCES `companies_db`.`offices` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `sectors_ibfk_2`
    FOREIGN KEY (`department_id`)
    REFERENCES `companies_db`.`departments` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `companies_db`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `companies_db`.`employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(30) NOT NULL,
  `ssn` VARCHAR(20) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `dob` DATE NOT NULL,
  `role_id` INT(11) NULL DEFAULT '0',
  `sector_id` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `name_idx` (`full_name` ASC),
  INDEX `ssn_idx` (`ssn` ASC),
  INDEX `email_idx` (`email` ASC),
  INDEX `role_id` (`role_id` ASC),
  INDEX `sector_id` (`sector_id` ASC),
  CONSTRAINT `employees_ibfk_1`
    FOREIGN KEY (`role_id`)
    REFERENCES `companies_db`.`roles` (`id`),
  CONSTRAINT `employees_ibfk_2`
    FOREIGN KEY (`sector_id`)
    REFERENCES `companies_db`.`sectors` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;