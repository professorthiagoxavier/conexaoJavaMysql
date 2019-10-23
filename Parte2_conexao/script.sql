CREATE TABLE `tb_carros` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(32) NULL,
  `modelo` VARCHAR(45) NULL,
  `anoFabricacao` INT NULL,
  `cor` VARCHAR(16) NULL,
  `km` DECIMAL(8,2) NULL,
  `valor` DECIMAL(10,2) NULL,
  PRIMARY KEY (`idCarro`));