CREATE TABLE `respostaquestao` (
  `id` int(10) unsigned NOT NULL,
  `idQuestionario` int(10) unsigned NOT NULL,
  `idQuestao` int(10) unsigned NOT NULL,
  `idAlternativa` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questionario_fk_idx` (`idQuestionario`),
  KEY `questao_fk_idx` (`idQuestao`),
  KEY `alternativa_fk_idx` (`idAlternativa`),
  CONSTRAINT `respostaQuestaoQuestionario` FOREIGN KEY (`idQuestionario`) REFERENCES `questionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `respostaQuestaoQuestao` FOREIGN KEY (`idQuestao`) REFERENCES `questao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `respostaQuestaoAlternativa` FOREIGN KEY (`idAlternativa`) REFERENCES `alternativa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);