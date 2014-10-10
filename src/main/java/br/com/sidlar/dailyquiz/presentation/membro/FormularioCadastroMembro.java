package br.com.sidlar.dailyquiz.presentation.membro;

import java.time.LocalDate;

/**
 * @author Rodrigo
 */
public class FormularioCadastroMembro {

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    public FormularioCadastroMembro() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
