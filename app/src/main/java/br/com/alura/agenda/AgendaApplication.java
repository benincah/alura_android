package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "123", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1234", "fran@gmail.com"));
    }
}
