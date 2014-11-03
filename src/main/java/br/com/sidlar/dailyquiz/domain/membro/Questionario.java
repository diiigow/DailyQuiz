package br.com.sidlar.dailyquiz.domain.membro;

import javax.persistence.*;

/**
 * @author Rodrigo
 */
@Entity
@Table(name =  "questionario")
public class Questionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Questionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}