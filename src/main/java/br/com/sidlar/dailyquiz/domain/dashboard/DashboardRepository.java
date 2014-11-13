package br.com.sidlar.dailyquiz.domain.dashboard;

import br.com.sidlar.dailyquiz.domain.questionario.Questionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by RODRIGOSIS on 13/11/14.
 */
@Repository
public class DashboardRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Questionario> buscaQuestionariosNovos(int idMembro) {
        TypedQuery<Questionario> query = em.createQuery(" select q" +
                                                        " from   Questionario q" +
                                                        " where  not exists (" +
                                                        "                   select  rq" +
                                                        "                   from    RespostaQuestionario rq" +
                                                        "                   where   rq.questionario = q" +
                                                        "                       and rq.membro.id = :idMembro" +
                                                        "                   )", Questionario.class)
                                                        .setParameter("idMembro", idMembro);
        return query.getResultList();
    }



}
