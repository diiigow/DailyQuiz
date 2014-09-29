package br.com.sidlar.dailyquiz.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(HttpSession session) {

        if (session.getAttribute("membroAutenticado") == null) {
            return "/Login/login";
        }
        return "/Home/index";
    }
}
