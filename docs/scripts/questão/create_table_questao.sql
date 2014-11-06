CREATE TABLE `dailyquiz`.`questao` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `idAlternativaCorreta` INT NOT NULL,
  PRIMARY KEY (`id`));