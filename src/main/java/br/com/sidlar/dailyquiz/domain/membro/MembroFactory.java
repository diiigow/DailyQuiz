package br.com.sidlar.dailyquiz.domain.membro;

import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.Autenticador;
import br.com.sidlar.dailyquiz.infraestrutura.gerador.GeraHashSenha;
import br.com.sidlar.dailyquiz.infraestrutura.validador.ValidadorEmailUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.LocalDate;
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
public class MembroFactory {

    @Autowired
    public Autenticador autenticador;

    @Autowired
    public MembroRepository repository;

    @Transactional(readOnly = false)
    public Membro fabricaMembro(FormularioCadastroMembro formulario) throws Exception {
        validaFormularioParaFabricacaoMembro(formulario);
        return new Membro(formulario.getNome(), formulario.getEmail(), formulario.getSenha(), formulario.getDataNascimento());
    }

    private void validaFormularioParaFabricacaoMembro(FormularioCadastroMembro formulario) throws Exception {
        validaNomeMembro(formulario.getNome());
        validaEmailMembro(formulario.getEmail());
        validaSenhaMembro(formulario.getSenha());
        validaDataNascimento(formulario.getDataNascimento());
    }

    private void validaNomeMembro(String nome) throws Exception {
        if (nome.equals("")) {
            throw new IllegalArgumentException("O campo nome é obrigatório!");
        }
        if (nome.length() > 50) {
            throw new IllegalArgumentException("O nome do deve conter no máximo 50 caracteres!");
        }
    }

    private void validaEmailMembro(String email) throws Exception {
        if (!ValidadorEmailUtils.ehEmailValido(email)) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        repository.verificaSeEmailJaEstaCadastrado(email);
    }

    private void validaSenhaMembro(String senha) throws Exception {
        if (senha.length() < 6 || senha.length() > 10) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 e no máximo 10 caracteres");
        }

        GeraHashSenha.defineHashApartirSenha(senha);
    }

    private void validaDataNascimento(LocalDate dataNascimento) throws Exception {

        if (dataNascimento == null) {
            throw new IllegalArgumentException("Favor informar a data de nascimento!");
        }

        if (dataNascimento.compareTo(LocalDate.now()) >= 0) {
            throw new IllegalArgumentException("A data de nascimento tem que ser menor que a data de hoje!");
        }
    }

}
