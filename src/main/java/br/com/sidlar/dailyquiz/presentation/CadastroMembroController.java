package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;

/**
 * @author Rodrigo
 * @since  21/09/2014 19:47
 */

@Controller
@RequestMapping("/cadastro")
public class CadastroMembroController {

    @Autowired
    private MembroRepository membroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String Cadastro() {
        return "/Membro/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String CadastraMembro(@RequestParam("nome") String nome,@RequestParam("email") String email, @RequestParam("senha") String senha, @RequestParam("dataNascimento") LocalDate dataNascimento) {

        Membro membro= new Membro(nome,email,senha,dataNascimento);
        membroRepository.cadastraMembro(membro);

        return "redirect:/Home/index";
    }


}
