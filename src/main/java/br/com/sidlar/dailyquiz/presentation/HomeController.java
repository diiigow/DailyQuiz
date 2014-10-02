package br.com.sidlar.dailyquiz.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class HomeController {

    /**
     * Verifica se o membro esta autenticado.
     * <p>Caso esteja autenticado o usuario vai para a página home, se não volta para a tela de login
     */
    @RequestMapping(method = RequestMethod.GET)
    public String goHome(HttpSession session) {
        if (!AutenticadorUtils.membroEstaAutenticado(session)) {
            return "redirect:/Login";
        }
        return "/Home/index";
    }

}
