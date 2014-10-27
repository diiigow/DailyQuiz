package br.com.sidlar.dailyquiz.domain.membro;

import org.joda.time.DateTimeUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TesteEm_Membro_getQuantidadeDiasParaProximoAniversario  {

    @Test
    public void membroJaFezAniversarioNoAno() {

        //Setup fixture
        defineHojeEm("01/10/2014");
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(2014, 8, 10));

        // exercise SUT
        Days diasFaltanteParaProximoAniversario = membro.getQuantidadeDiasFaltanteParaProximoAniversario();

        // verify outcome
        assertThat(diasFaltanteParaProximoAniversario.getDays() , is(313));
    }

    @Test
    public void membroFazAniversarioEmAnoOuMesSeguinte() {
        //Setup fixture
        defineHojeEm("01/10/2014");
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(2015, 1, 3));

        // exercise SUT
        Days diasFaltanteParaProximoAniversario = membro.getQuantidadeDiasFaltanteParaProximoAniversario();

        // verify outcome
        assertThat(diasFaltanteParaProximoAniversario.getDays() , is(94));
    }

    @Test
    public void membroFazAniversarioHoje() {
        //Setup fixture
        defineHojeEm("01/10/2014");
        Membro membro = new Membro();
        membro.setDataNascimento(new LocalDate(2014, 10, 1));

        // exercise SUT
        Days diasFaltanteParaProximoAniversario = membro.getQuantidadeDiasFaltanteParaProximoAniversario();

        // verify outcome
        assertThat(diasFaltanteParaProximoAniversario.getDays() , is(0));
    }

    //Chupinhei do gersão
    private static LocalDate newLocaldate(String diaMesAno) {
        return LocalDate.parse(diaMesAno, DateTimeFormat.forPattern("dd/MM/yyyy"));
    }

    //Chupinhei do gersão
    private static void defineHojeEm(String diaMesAno) {
        DateTimeUtils.setCurrentMillisFixed(newLocaldate(diaMesAno).toDateTimeAtStartOfDay().getMillis());
    }

}