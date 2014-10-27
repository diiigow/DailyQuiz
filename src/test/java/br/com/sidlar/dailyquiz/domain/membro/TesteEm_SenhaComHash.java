package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.infraestrutura.gerador.GeraHashSenha;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TesteEm_SenhaComHash {

    @Test
    public void validaHash() {
        assertThat(GeraHashSenha.defineHashApartirSenha("123456") , is("e10adc3949ba59abbe56e057f20f883e"));
        assertThat(GeraHashSenha.defineHashApartirSenha("654321") , is("c33367701511b4f6020ec61ded352059"));
    }

}