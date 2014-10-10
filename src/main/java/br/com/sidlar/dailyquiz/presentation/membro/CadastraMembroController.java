package br.com.sidlar.dailyquiz.presentation.membro;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rodrigo
 */

@Controller
@RequestMapping("/Cadastro")
public class CadastraMembroController {

    @RequestMapping(method = RequestMethod.GET)
    public String CadastraMembro (ModelMap modelMap) {
        Membro membro = new Membro();
        modelMap.addAttribute("membro", membro);
        return "/Membro/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String CadastraMembro(@ModelAttribute("membro") Membro membro) {
        return "";
    }

}
