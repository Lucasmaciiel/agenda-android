package br.com.lmg.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.lmg.R;
import br.com.lmg.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {
    private Context context;


        private final List<Aluno> alunos = new ArrayList<>();

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
        public int getCount() {
            return alunos.size();
        }

        @Override
        public Object getItem(int posicao) {
            return alunos.get(posicao);
        }

        @Override
        public long getItemId(int posicao) {
            return alunos.get(posicao).getId();
        }

        @Override
        public View getView(int posicao, View view, ViewGroup viewGroup) {
            View viewCriada = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_aluno, viewGroup, false);
            Aluno alunoDevolvido = alunos.get(posicao);
            TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
            nome.setText(alunoDevolvido.getNome());
            TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
            telefone.setText(alunoDevolvido.getTelefone());
            return viewCriada;
        }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
