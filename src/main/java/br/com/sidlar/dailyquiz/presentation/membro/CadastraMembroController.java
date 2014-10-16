package br.com.sidlar.dailyquiz.presentation.membro;

import br.com.sidlar.dailyquiz.domain.membro.*;
import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.Autenticador;
import br.com.sidlar.dailyquiz.infraestrutura.autenticacao.ContextoAutenticacao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Rodrigo
 */

@Controller
@RequestMapping("/Cadastro")
public class CadastraMembroController {

    @Autowired
    public MembroService membroService;

    @RequestMapping(method = RequestMethod.GET)
    public String CadastraMembro(ModelMap modelMap) {
        Membro formulario = new Membro();
        modelMap.addAttribute("formulario", formulario);
        return "/Membro/cadastro";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String CadastraMembro(@ModelAttribute("formulario") FormularioCadastroMembro formulario, ModelMap model, HttpSession session) {
        try {
            Membro membro = membroService.criaMembro(formulario);
            membroService.armazenaNovoMembroNaSession(session, membro, DateTime.now());
        }
        catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "/Membro/cadastro";
        }
        return "redirect:/";
    }
}
