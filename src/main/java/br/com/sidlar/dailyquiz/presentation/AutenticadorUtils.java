package br.com.sidlar.dailyquiz.presentation;

import javax.servlet.http.HttpSession;

/**
 * @author Rodrigo
 */
public class AutenticadorUtils {

    public static boolean membroEstaAutenticado(HttpSession session) {
        return session.getAttribute("membroAutenticado") != null;
    }

}
