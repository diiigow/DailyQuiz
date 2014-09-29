package br.com.sidlar.dailyquiz.presentation.login;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Serviço de autenticação do membro.
 * <p>Passos para fazer a autenticação.
 * <ul>
 *      <li>Verifica se existe o membro com o username informado</li>
 *      <li>Verifica se a senha do membro esta correta</li>
 *      <li>Armazena o membro na sessão</li>
 *  </ul>
 * @author Rodrigo
 */
@Component
class Autenticador {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private HttpSession session;

    void autentica(String username, String senha) throws Exception {

        Membro membro = verificaSeExisteMembroComUsername(username);
        verificaSenhaMembro(senha, membro);
        armazenaMembroNaSessao(membro);
    }

    private void armazenaMembroNaSessao(Membro membro) {
        session.setAttribute("membroAutenticado", membro);
    }

    private void verificaSenhaMembro(String senha, Membro membro) throws Exception {
        if (!membro.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha inválida!");
        }
    }

    private Membro verificaSeExisteMembroComUsername(String username) throws Exception {
        return membroRepository.buscaMembroPorUsername(username);
    }
}