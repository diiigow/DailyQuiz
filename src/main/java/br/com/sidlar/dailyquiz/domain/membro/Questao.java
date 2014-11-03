package br.com.sidlar.dailyquiz.domain.membro;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int AlternativaCorreta;
    private List<Alternativa> alternativas;

    public Questao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlternativaCorreta() {
        return AlternativaCorreta;
    }

    public void setAlternativaCorreta(int numeroAlternativaCorreta) {
        this.AlternativaCorreta = numeroAlternativaCorreta;
    }

    public void adicionaAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }
}