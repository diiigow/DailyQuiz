package br.com.sidlar.dailyquiz.domain.membro;

import org.hibernate.annotations.Type;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.persistence.*;


@Table(name = "membro")
@Entity
public class Membro extends FormularioCadastroMembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dataNascimento;

    public Membro() {
    }

    public Membro(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Years getIdade() {
        return Years.yearsBetween(dataNascimento, LocalDate.now());
    }

    public boolean isAniversario() {
        return getDataNascimento().dayOfMonth().equals(LocalDate.now().dayOfMonth());
    }

    public Days getQuantidadeDiasFaltanteParaProximoAniversario() {
        LocalDate hoje = LocalDate.now();
        LocalDate proximoAniversario = new LocalDate(hoje.getYear(), getDataNascimento().getMonthOfYear(), getDataNascimento().getDayOfMonth());
        return Days.daysBetween(hoje, proximoAniversario);
    }

}

