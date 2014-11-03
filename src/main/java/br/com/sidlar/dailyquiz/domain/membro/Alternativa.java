package br.com.sidlar.dailyquiz.domain.membro;

import javax.persistence.*;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "alternativa")
public class Alternativa {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;

    public Alternativa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
