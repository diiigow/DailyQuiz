package br.com.sidlar.dailyquiz.presentation.membro;

import br.com.sidlar.dailyquiz.domain.membro.FormularioCadastroMembro;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.CadastraMembroFactory;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public CadastraMembroFactory factory;

    @Autowired
    public MembroRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String CadastraMembro (ModelMap modelMap) {
        Membro formulario = new Membro();
        modelMap.addAttribute("formulario", formulario);
        return "/Membro/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String CadastraMembro(@ModelAttribute("formulario") FormularioCadastroMembro formulario, ModelMap model) {
        try {
            Membro membro = factory.fabricaMembro(formulario);
            repository.insereMembro(membro);
        }
        catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "/Membro/cadastro";
        }
        return "redirect:/";
    }

}
