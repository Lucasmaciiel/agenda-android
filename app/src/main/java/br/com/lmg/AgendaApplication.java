package br.com.lmg;

import android.app.Application;

import br.com.lmg.dao.AlunoDAO;
import br.com.lmg.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Lucas", "18997062461", "lucasmaciel@gmail.com"));
        dao.salva( new Aluno("Michele", "18996747889", "michele@gmail.com"));
    }
}
