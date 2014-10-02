package br.com.sidlar.dailyquiz.domain;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.persistence.*;


@Table(name = "membro")
@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public Years getIdade() {
        return Years.yearsBetween(dataNascimento, LocalDate.now());
    }

}

