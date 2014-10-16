package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.Autenticador;
import br.com.sidlar.dailyquiz.infraestrutura.validador.ValidadorEmailUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
public class CadastraMembroFactory {

    @Autowired
    public Autenticador autenticador;

    @Transactional(readOnly = false)
    public Membro fabricaMembro(FormularioCadastroMembro formulario) throws Exception {
        validaFormularioParaFabricacaoMembro(formulario);
        Membro membro = new Membro(formulario.getNome(),formulario.getEmail(),formulario.getSenha(),formulario.getDataNascimento());
        return membro;
    }

    private void validaFormularioParaFabricacaoMembro(FormularioCadastroMembro formulario) throws Exception {
        validaNomeMembro(formulario);
        validaEmailMembro(formulario);
        validaSenhaMembro(formulario);
    }

    private void validaNomeMembro(FormularioCadastroMembro formulario) throws Exception {

        if (formulario.getNome().equals("")) {
            throw new IllegalArgumentException("O campo nome é obrigatório!");
        }

        if (formulario.getNome().length() > 50) {
            throw new IllegalArgumentException("O nome do deve conter no máximo 50 caracteres!");
        }
    }

    private void validaEmailMembro(FormularioCadastroMembro formulario) throws Exception {
        if (!ValidadorEmailUtils.ehEmailValido(formulario.getEmail())) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validaSenhaMembro(FormularioCadastroMembro formulario) throws Exception {
        if (formulario.getSenha().length() < 6 || formulario.getSenha().length() > 10) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 e no máximo 10 caracteres");
        }
        formulario.setSenha(DigestUtils.md5Hex(formulario.getSenha()));
    }

}
