package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.Autenticador;
import br.com.sidlar.dailyquiz.infraestrutura.validador.ValidadorEmailUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * O membro é formado por Nome, email, senha e data de Nascimento
 * <p>Nome: obrigatório, máximo de 50 caracteres
 * <p>E-mail: deve ser um e-mail válido
 * <p>Senha: mínimo de 6 e máximo de 10 caracteres
 * <p>Data de Nascimento: dia/mês/ano válido
 *
 * @author Rodrigo
 */
@Component
public class ContextoCadastramentoMembro {

    @Autowired
    public MembroRepository membroRepository;

    @Autowired
    public Autenticador autenticador;

    public void validaCadastro(Membro membro) throws Exception{
        validaNomeMembro(membro);
        validaEmailMembro(membro);
        validaSenhaMembro(membro);
        membroRepository.insereMembro(membro);
        autenticador.autentica(membro.getEmail(), membro.getSenha());
    }

    private void validaNomeMembro(Membro membro) throws Exception {

        if (membro.getNome().equals("")) {
            throw new IllegalArgumentException("O campo nome é obrigatório!");
        }

        if (membro.getNome().length() > 50) {
            throw new IllegalArgumentException("O nome do deve conter no máximo 50 caracteres!");
        }
    }

    private void validaEmailMembro(Membro membro) throws Exception {
        if (!ValidadorEmailUtils.ehEmailValido(membro.getEmail())) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validaSenhaMembro(Membro membro) throws Exception {
        if (membro.getSenha().length() < 6 || membro.getSenha().length() > 10) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 e no máximo 10 caracteres");
        }
        membro.setSenha(DigestUtils.md5Hex(membro.getSenha()));
    }

}
