package br.com.sidlar.dailyquiz.domain.dashboard;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.questionario.Questionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RODRIGOSIS on 13/11/14.
 */
@Component
public class DashboardService {

    @Autowired
    public DashboardRepository repository;

    public Dashboard montaDashboard(Membro membro) {
        List<Questionario> questionarios = repository.buscaQuestionariosNovos(membro.getId());
        return null;
    }

}
