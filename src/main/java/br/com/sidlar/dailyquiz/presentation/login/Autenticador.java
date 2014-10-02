package br.com.sidlar.dailyquiz.presentation.login;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Serviço de autenticação do membro.
 * <p>Passos para fazer a autenticação.
 * <ul>
 *      <li>Verifica se existe o membro com o username informado
 *      <li>Verifica se a senha do membro esta correta
 *      <li>Armazena o membro na sessão
 * </ul>
 * @author Rodrigo
 */
@Component
class Autenticador {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private HttpSession session;

    void autentica(String email, String senha) throws Exception {
        Membro membro = verificaSeExisteMembroComEmail(email);
        verificaSenhaMembro(senha, membro);
        armazenaMembroNaSessao(membro);
    }

    private void armazenaMembroNaSessao(Membro membro) {
        session.setAttribute("membroAutenticado", membro);
    }

    private void verificaSenhaMembro(String senha, Membro membro) throws Exception {
        if (!membro.getSenha().equals(DigestUtils.md5Hex(senha))) {
            throw new IllegalArgumentException("Senha inválida!");
        }
    }

    private Membro verificaSeExisteMembroComEmail(String email) throws Exception {
        return membroRepository.buscaMembroPoremail(email);
    }
}