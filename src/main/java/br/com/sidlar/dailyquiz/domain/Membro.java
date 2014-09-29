package br.com.sidlar.dailyquiz.domain;

import javax.persistence.*;


@Table(name = "membro")
@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String username;
    private String senha;


    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }
}
