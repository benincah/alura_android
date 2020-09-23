package br.com.alura.agenda.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

/**
 * essa classe foi criada apenas para retirar responsabildiades da ListaAlunosActivity
 * */
public class ListaAlunosView {

    private final AlunoDAO dao = new AlunoDAO();
    private final ListaAlunosAdapter adapter;


    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(context);
    }

    private Context context;

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Confirma exclusão do Aluno?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AdapterView.AdapterContextMenuInfo menuInfo =
                                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        remove(alunoEscolhido);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
