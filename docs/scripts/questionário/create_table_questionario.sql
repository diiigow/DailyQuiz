CREATE TABLE `questionario` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idMembro` int(10) unsigned NOT NULL,
  `inicioDisponibilidadel` datetime DEFAULT NULL,
  `fimDisponibilidade` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questionario_fk_idx` (`idMembro`),
  CONSTRAINT `questionario_membro` FOREIGN KEY (`idMembro`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
