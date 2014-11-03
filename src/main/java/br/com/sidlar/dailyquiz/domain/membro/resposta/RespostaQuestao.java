package br.com.sidlar.dailyquiz.domain.membro.resposta;

import br.com.sidlar.dailyquiz.domain.membro.Alternativa;
import br.com.sidlar.dailyquiz.domain.membro.Questao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 */
@Entity
@Table( name = "respostaquestao")
public class RespostaQuestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Questao questao;
    private List<Alternativa> alternativas = new ArrayList<>();
}
