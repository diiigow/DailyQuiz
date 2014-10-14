package br.com.sidlar.dailyquiz.infraestrutura.autenticacao;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;
import br.com.sidlar.dailyquiz.infraestrutura.validador.ValidadorEmailUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Serviço de autenticação do membro.
 * <p>Passos para fazer a autenticação.
 * <ul>
 *      <li>Verifica se existe o membro com o email informado
 *      <li>Verifica se a senha do membro esta correta
 *      <li>Armazena o membro e o instante do último login na sessão
 * </ul>
 * @author Rodrigo
 */
@Component
public class Autenticador {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private HttpSession session;

    public void autentica(String email, String senha) throws Exception {
        Membro membro = verificaSeExisteMembroComEmail(email);
        verificaSenhaMembro(senha, membro);
        armazenaContextoAutenticacaoNaSessao(membro , DateTime.now());
    }

    private Membro verificaSeExisteMembroComEmail(String email) throws Exception {

        if (!ValidadorEmailUtils.ehEmailValido(email) ) {
            throw new IllegalArgumentException("E-mail inválido!");
        }

        return membroRepository.buscaMembroPoremail(email);
    }

    private void verificaSenhaMembro(String senha, Membro membro) throws Exception {
        if (!membro.getSenha().equals(DigestUtils.md5Hex(senha))) {
            throw new IllegalArgumentException("Senha inválida!");
        }
    }

    private void armazenaContextoAutenticacaoNaSessao(Membro membro, DateTime instanteUltimoLogin) {
        ContextoAutenticacao contextoAutenticacao = new ContextoAutenticacao(membro, instanteUltimoLogin);
        session.setAttribute("contextoAutenticado", contextoAutenticacao);
    }

}