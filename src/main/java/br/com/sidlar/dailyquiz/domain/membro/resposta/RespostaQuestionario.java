package br.com.sidlar.dailyquiz.domain.membro.resposta;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.Questionario;
import org.joda.time.LocalDate;

/**
 * @author Rodrigo
 */
public class RespostaQuestionario {

    private int id;
    private Membro membro = new Membro();
    private Questionario questionario = new Questionario();
    private LocalDate dataCriacao;

}
