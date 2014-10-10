package br.com.sidlar.dailyquiz.infraestrutura.autenticacao;

import javax.servlet.http.HttpSession;

/**
 * @author Rodrigo
 */
public class AutenticadorUtils {

    public static boolean membroEstaAutenticado(HttpSession session) {
        return session.getAttribute("contextoAutenticado") != null;
    }

}
