package br.com.sidlar.dailyquiz.domain.questionario;

import javax.persistence.*;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "alternativa")
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

}
