package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

/**
 * @author RODRIGO
 * @since  01/09/2014
 */

@Controller
@RequestMapping("/Login")
public class LoginController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "/Login/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loga(@RequestParam("username") String userName, @RequestParam("senha") String senha, HttpServletRequest request) {

        TypedQuery<Membro> query = em.createQuery("select m from Membro as m where m.userName = :userName and m.senha = :senha", Membro.class);
        query.setParameter("userName", userName);
        query.setParameter("senha", senha);

        Membro membro = query.getSingleResult();
        request.getSession().setAttribute("membro", membro);
        return "/Home/index";
    }

}
