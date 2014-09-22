package br.com.sidlar.dailyquiz.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rodrigo
 * @since  21/09/2014 19:47
 */

@RequestMapping("/cadastro")
public class CadastroMembroController {

    @RequestMapping(method = RequestMethod.GET)
    public String Cadastro() {
        return "/Membro/cadastro";
    }

}
