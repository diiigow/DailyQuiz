package br.com.sidlar.dailyquiz.domain.membro.resposta;

import br.com.sidlar.dailyquiz.domain.questionario.Alternativa;
import br.com.sidlar.dailyquiz.domain.questionario.Questao;

import javax.persistence.*;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "respostaquestao")
public class RespostaQuestao {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "idQuestao")
    private Questao questao;

    @ManyToOne
    @JoinColumn(name = "idAlternativa")
    private Alternativa alternativaSelecionada;
}
