package br.com.sidlar.dailyquiz.domain.membro;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Rodrigo
 */
public class FormularioCadastroMembro {

    private String nome;
    private String email;
    private String senha;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
