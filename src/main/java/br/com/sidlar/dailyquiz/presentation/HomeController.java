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
     * Caso esteja autenticado o usuario vai para a página home, se não volta para a tela de login
     * @author Rodrigo
     */
    @RequestMapping(method = RequestMethod.GET)
    public String goHome(HttpSession session) {

        if (!membroEstaAutenticado(session)) {
            return "redirect:/Login";
        }
        return "/Home/index";
    }

    private boolean membroEstaAutenticado(HttpSession session) {
        if (session.getAttribute("membroAutenticado") == null) {
            return false;
        }
        return true;
    }
}
