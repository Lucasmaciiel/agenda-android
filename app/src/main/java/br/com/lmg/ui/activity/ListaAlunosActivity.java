package br.com.lmg.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.lmg.R;
import br.com.lmg.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView aluno = new TextView(this);
        setContentView(R.layout.activity_lista_alunos);

        AlunoDAO dao = new AlunoDAO();

        setTitle("Lista de Alunos");

        ListView listaDeAlunos = (ListView) findViewById(R.id.activity_lista_alunos_listView);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                 android.R.layout.simple_list_item_1,
                 dao.todos()));

    }
}
