package br.com.sidlar.dailyquiz.presentation.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private Autenticador autenticador;

    @RequestMapping(method = GET)
    public String loing() {
        return "/Login/login";
    }

    @RequestMapping(method = POST)
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, ModelMap model) {
        try {
            autenticador.autentica(email, senha);
        }
        catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "/Login/login";
        }
        return "redirect:/";
    }

}