package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RODRIGO
 * @since 01/09/2014
 */

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private MembroRepository membroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "/Login/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loga(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpServletRequest request) {

        Membro membro = membroRepository.buscaMembro(email, senha);
        request.getSession().setAttribute("membro", membro);
        return "/Home/index";

    }

}
