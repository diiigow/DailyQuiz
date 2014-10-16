package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.ContextoAutenticacao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author Rodrigo
 */
@Component
public class MembroService {

    @Autowired
    public MembroFactory factory;

    @Autowired
    public MembroRepository repository;

    public Membro criaMembro(FormularioCadastroMembro formulario) throws Exception {
        Membro membro = factory.fabricaMembro(formulario);
        repository.insereMembro(membro);
        return membro;
    }

    public void armazenaNovoMembroNaSession(HttpSession session, Membro membro, DateTime instanteUltimoLogin) {
        ContextoAutenticacao contextoAutenticacao = new ContextoAutenticacao(membro, instanteUltimoLogin);
        session.setAttribute("contextoAutenticado", contextoAutenticacao);
    }
}
