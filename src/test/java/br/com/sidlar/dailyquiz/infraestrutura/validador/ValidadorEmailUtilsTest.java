package br.com.sidlar.dailyquiz.infraestrutura.validador;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class ValidadorEmailUtilsTest {

    @Test
    public void testeVerificacaoEmailValido() {
        assertThat(ValidadorEmailUtils.ehEmailValido("rodrigosis@sidlar.com.br"), is(true));
        assertThat(ValidadorEmailUtils.ehEmailValido("digowsolutions@gmail.com"), is(true));
        assertThat(ValidadorEmailUtils.ehEmailValido("digow_lek@yahoo.com.br"), is(true));
        assertThat(ValidadorEmailUtils.ehEmailValido("tio..bill@microsoft.com"), is(false));
        assertThat(ValidadorEmailUtils.ehEmailValido("tio.bill@microsoft..com"), is(false));
        assertThat(ValidadorEmailUtils.ehEmailValido("tio_bill@localserver"), is(true));
    }

}