package br.com.sidlar.dailyquiz.domain.membro;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
                                                    "where  m.email = :email", Membro.class)
                                                    .setParameter("email", email);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("Nenhum membro foi encontrado com o email " + email);
        }
    }

    @Transactional(readOnly = false)
    public void insereMembro(Membro membro) {
        em.persist(membro);
    }
}
