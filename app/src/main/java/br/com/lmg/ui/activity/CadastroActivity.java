package br.com.lmg.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.lmg.R;
import br.com.lmg.dao.AlunoDAO;
import br.com.lmg.ui.model.Aluno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_email);


        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salvar(alunoCriado);

                startActivity(new Intent(CadastroActivity.this,
                        ListaAlunosActivity.class));

//                Toast.makeText(CadastroActivity.this,
//                          alunoCriado.getNome() + "-" +
//                                alunoCriado.getTelefone() + "-" +
//                                alunoCriado.getEmail(),
//                        Toast.LENGTH_LONG).show();


            }
        });

    }
}
