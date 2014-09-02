package br.com.sidlar.dailyquiz.presentation;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RODRIGO
 * @since  01/09/2014
 */

@Controller
@RequestMapping("/Login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "/Login/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loga(@RequestParam("username") String userName, @RequestParam("senha") String senha, HttpServletRequest request) {

        MembroRepository membroRepository = new MembroRepository();
        Membro membro = membroRepository.buscaMembro(userName, senha);

        request.getSession().setAttribute("membro", membro);
        return "/Home/index";
    }

}
