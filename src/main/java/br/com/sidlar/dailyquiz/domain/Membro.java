package br.com.sidlar.dailyquiz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * @author Rodrigo
 * @since 29/08/2014
 */
@Entity
public class Membro {
    @Id
    int id;
    String nome;
    String email;
    String senha;
    LocalDate dataNascimento;

    public Membro(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Membro() {
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userName) {
        this.email = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Years getIdade() {
        return Years.yearsBetween(dataNascimento, LocalDate.now());
    }
}
