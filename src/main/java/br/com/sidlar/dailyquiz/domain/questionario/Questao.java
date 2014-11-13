package br.com.sidlar.dailyquiz.domain.questionario;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue
    private int id;

    private String enunciado;

    @OneToOne
    private Alternativa alternativaCorreta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternativa> alternativas;

}