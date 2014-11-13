package br.com.sidlar.dailyquiz.domain.membro.resposta;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.questionario.Questionario;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "respostaquestionario")
public class RespostaQuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "idMembro")
    private Membro membro;

    @OneToOne
    @JoinColumn(name = "idQuestionario")
    private Questionario questionario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostaQuestao> respostaQuestoes;

}