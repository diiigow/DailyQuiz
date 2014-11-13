package br.com.sidlar.dailyquiz.domain.questionario;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "questionario")
public class Questionario {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "idMembro")
    private Membro membroCriador;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate inicioDisponibilidade;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate fimDisponibilidade;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes;
}

