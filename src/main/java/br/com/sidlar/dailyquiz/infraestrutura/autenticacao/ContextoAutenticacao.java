package br.com.sidlar.dailyquiz.infraestrutura.autenticacao;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.joda.time.DateTime;

/**
 * @author Rodrigo
 */
public class ContextoAutenticacao {
    private Membro membro;
    private DateTime instanteUltimoLogin;
}
