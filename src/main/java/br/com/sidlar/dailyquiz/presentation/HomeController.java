package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)

    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpServletRequest req) {
        req.getSession().setAttribute("membro", new Membro());
        return "/Home/index";
    }

    public String goHome(HttpServletRequest request) {
        return "redirect:/Login";
    }

}