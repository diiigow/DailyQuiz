CREATE TABLE `respostaquestionario` (
  `id` int(10) unsigned NOT NULL,
  `data` datetime NOT NULL,
  `idMembro` int(10) unsigned NOT NULL,
  `idQuestionario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `membro_fk_idx` (`idMembro`),
  KEY `questionario_fk_idx` (`idQuestionario`),
  CONSTRAINT `respostaquestionario_membro` FOREIGN KEY (`idMembro`) REFERENCES `membro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `respostaquestionario_questionario` FOREIGN KEY (`idQuestionario`) REFERENCES `questionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);