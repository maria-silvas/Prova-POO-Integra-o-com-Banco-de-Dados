-- MySQL Script generated by MySQL Workbench
-- qui 24 nov 2022 16:39:01
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`campanhia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`campanhia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`aviao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`aviao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `prefixo` VARCHAR(3) NOT NULL,
  `capacidade` INT NOT NULL,
  `campanhia_id` INT NOT NULL,
  PRIMARY KEY (`id`, `campanhia_id`),
  INDEX `fk_aviao_campanhia1_idx` (`campanhia_id` ASC) VISIBLE,
  CONSTRAINT `fk_aviao_campanhia1`
    FOREIGN KEY (`campanhia_id`)
    REFERENCES `mydb`.`campanhia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`hangar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hangar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `local` VARCHAR(255) NOT NULL,
  `aviao_id` INT NOT NULL,
  PRIMARY KEY (`id`, `aviao_id`),
  INDEX `fk_hangar_aviao_idx` (`aviao_id` ASC) VISIBLE,
  CONSTRAINT `fk_hangar_aviao`
    FOREIGN KEY (`aviao_id`)
    REFERENCES `mydb`.`aviao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`helicoptero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`helicoptero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `cor` VARCHAR(255) NOT NULL,
  `capacidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NOT NULL,
  `cor` VARCHAR(255) NOT NULL,
  `velocidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`voo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`voo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(255) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  `origem` VARCHAR(3) NOT NULL,
  `destino` VARCHAR(3) NOT NULL,
  `piloto` VARCHAR(255) NOT NULL,
  `copiloto` VARCHAR(255) NOT NULL,
  `observacao` VARCHAR(255) NOT NULL,
  `pista_id` INT NOT NULL,
  `jato_id` INT NOT NULL,
  `helicoptero_id` INT NOT NULL,
  `aviao_id` INT NOT NULL,
  PRIMARY KEY (`id`, `pista_id`, `jato_id`, `helicoptero_id`, `aviao_id`),
  INDEX `fk_voo_pista1_idx` (`pista_id` ASC) VISIBLE,
  INDEX `fk_voo_jato1_idx` (`jato_id` ASC) VISIBLE,
  INDEX `fk_voo_helicoptero1_idx` (`helicoptero_id` ASC) VISIBLE,
  INDEX `fk_voo_aviao1_idx` (`aviao_id` ASC) VISIBLE,
  CONSTRAINT `fk_voo_pista1`
    FOREIGN KEY (`pista_id`)
    REFERENCES `mydb`.`pista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_jato1`
    FOREIGN KEY (`jato_id`)
    REFERENCES `mydb`.`jato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_helicoptero1`
    FOREIGN KEY (`helicoptero_id`)
    REFERENCES `mydb`.`helicoptero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_voo_aviao1`
    FOREIGN KEY (`aviao_id`)
    REFERENCES `mydb`.`aviao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;