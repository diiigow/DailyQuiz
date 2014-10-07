package br.com.sidlar.dailyquiz.presentation.membro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rodrigo
 */

@Controller
@RequestMapping("/Cadastro")
public class CadastraMembroController {

    @RequestMapping(method = RequestMethod.GET)
    public String CadastraMembro () {
        return "/Membro/cadastro";
    }

}
