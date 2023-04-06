-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema alphamanagersd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema alphamanagersd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `alphamanagersd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `alphamanagersd` ;

-- -----------------------------------------------------
-- Table `alphamanagersd`.`insumos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`insumos` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`insumos` (
  `idIns` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_ins` VARCHAR(25) NOT NULL,
  `cantidad_ins` INT NOT NULL,
  `unidadMed_ins` VARCHAR(25) NOT NULL,
  `categoria_ins` VARCHAR(25) NOT NULL,
  `nombreProv_ins` VARCHAR(25) NOT NULL,
  `costo_ins` FLOAT(4,2) NOT NULL,
  `FchCaducidad` DATE NOT NULL,
  PRIMARY KEY (`idIns`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish_ci;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`productos` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`productos` (
  `idProduc` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_produc` VARCHAR(25) NOT NULL,
  `preparacion_produc` MEDIUMTEXT NOT NULL,
  `tipo_produc` VARCHAR(25) NOT NULL,
  `costo_produc` FLOAT(4,2) NOT NULL,
  `precio_produc` FLOAT(4,2) NOT NULL,
  `existencia` TINYINT(2) NOT NULL,
  `FchExpira` DATE NOT NULL,
  PRIMARY KEY (`idProduc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish_ci;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`roles` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`roles` (
  `idRol` INT(2) NOT NULL,
  `nombre_rol` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish_ci;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`usuarios` (
  `PK_NombreU` VARCHAR(30) NOT NULL,
  `contraseña_user` VARCHAR(30) NOT NULL,
  `CURP` VARCHAR(18) NOT NULL,
  `RFC` VARCHAR(13) NOT NULL,
  `telefono` VARCHAR(12) NULL,
  `roles_idRol` INT(2) NOT NULL,
  PRIMARY KEY (`PK_NombreU`),
  UNIQUE INDEX `PK_NombreU_UNIQUE` (`PK_NombreU` ASC) VISIBLE,
  INDEX `fk_usuarios_roles1_idx` (`roles_idRol` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`roles_idRol`)
    REFERENCES `alphamanagersd`.`roles` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish_ci;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`ventas` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`ventas` (
  `Nu_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_venta` DATE NOT NULL,
  `precioTot_venta` FLOAT(4,2) NOT NULL,
  `ganancia_venta` FLOAT(4,2) NOT NULL,
  `costoTot_venta` FLOAT(4,2) NOT NULL,
  `estado_venta` VARCHAR(25) NOT NULL,
  `usuarios_nombre_user` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Nu_venta`, `usuarios_nombre_user`),
  INDEX `fk_ventas_usuarios1_idx` (`usuarios_nombre_user` ASC) VISIBLE,
  CONSTRAINT `fk_ventas_usuarios1`
    FOREIGN KEY (`usuarios_nombre_user`)
    REFERENCES `alphamanagersd`.`usuarios` (`PK_NombreU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish_ci;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`Receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`Receta` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`Receta` (
  `Cantidad` INT NOT NULL,
  `insumos_IdIns` INT NOT NULL,
  `productos_idProduc` INT(11) NOT NULL,
  PRIMARY KEY (`productos_idProduc`, `insumos_IdIns`),
  INDEX `fk_Receta_productos1_idx` (`productos_idProduc` ASC) VISIBLE,
  INDEX `fk_insumos_idins_idx` (`insumos_IdIns` ASC) VISIBLE,
  CONSTRAINT `fk_Receta_productos1`
    FOREIGN KEY (`productos_idProduc`)
    REFERENCES `alphamanagersd`.`productos` (`idProduc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_insumos_idins`
    FOREIGN KEY (`insumos_IdIns`)
    REFERENCES `alphamanagersd`.`insumos` (`idIns`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alphamanagersd`.`DetalleVenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alphamanagersd`.`DetalleVenta` ;

CREATE TABLE IF NOT EXISTS `alphamanagersd`.`DetalleVenta` (
  `Cantidad` INT NOT NULL,
  `fk_pk_Nu_venta` INT NOT NULL,
  `fk_pk_IdProd` INT NOT NULL,
  INDEX `fk_pk_Nu_venta_idx` (`fk_pk_Nu_venta` ASC) VISIBLE,
  INDEX `fk_pk_IdProd_idx` (`fk_pk_IdProd` ASC) VISIBLE,
  PRIMARY KEY (`fk_pk_IdProd`, `fk_pk_Nu_venta`),
  CONSTRAINT `fk_pk_Nu_venta`
    FOREIGN KEY (`fk_pk_Nu_venta`)
    REFERENCES `alphamanagersd`.`ventas` (`Nu_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pk_IdProd`
    FOREIGN KEY (`fk_pk_IdProd`)
    REFERENCES `alphamanagersd`.`productos` (`idProduc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
