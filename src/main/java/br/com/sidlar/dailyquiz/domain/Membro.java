package br.com.sidlar.dailyquiz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Rodrigo
 * @since  29/08/2014
 */
@Entity
public class Membro {
    @Id
    int id;
    String nome;
    String userName;
    String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
