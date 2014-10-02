package br.com.sidlar.dailyquiz.domain;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Rodrigo
 */

@Repository
public class MembroRepository {

    @PersistenceContext
    private EntityManager em;

    public Membro buscaMembroPoremail(String email) throws Exception {
        TypedQuery<Membro> query = em.createQuery(  "select m " +
                                                    "from   Membro m " +
                                                    "where  m.email = :username", Membro.class)
                                                    .setParameter("username", email);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("Nenhum membro foi encontrado com o email " + email);
        }
    }
}
