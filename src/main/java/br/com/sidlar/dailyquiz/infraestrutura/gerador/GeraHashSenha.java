package br.com.sidlar.dailyquiz.infraestrutura.gerador;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Rodrigo
 */
public class GeraHashSenha {
    public static String defineHashApartirSenha(String senha) {
        return DigestUtils.md5Hex(senha);
    }
}
