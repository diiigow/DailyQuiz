package br.com.sidlar.dailyquiz.domain;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Rodrigo
 * @since  29/08/2014
 */
@Repository
public class MembroRepository {

    @PersistenceContext
    private EntityManager em;

    public Membro buscaMembro(String userName, String senha) {
        try {

            TypedQuery<Membro> query = em.createQuery("select m from Membro as m where m.userName = :userName and m.senha = :senha", Membro.class);
            query.setParameter("userName", userName);
            query.setParameter("senha", senha);

            Membro membro = query.getSingleResult();

            return membro;

        } catch (NoResultException e) {
            return null;
        }
    }

    }