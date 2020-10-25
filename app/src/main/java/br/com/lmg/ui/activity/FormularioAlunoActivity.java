package br.com.lmg.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import br.com.lmg.R;
import br.com.lmg.dataBase.AgendaDataBase;
import br.com.lmg.dataBase.dao.AlunoDao;
import br.com.lmg.model.Aluno;

import static br.com.lmg.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private Button botaoLimpar;
    public AlunoDao dao;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        AgendaDataBase dataBase = AgendaDataBase.getInstance(this);
        dao = dataBase.getRoomAlunoDao();

        inicializacaoDosCampos();
        carregaAluno();
        configuraBotaoLimpar();

    }

    public void configuraBotaoLimpar(){
        botaoLimpar.setOnClickListener(view -> {
            campoNome.setText("");
            campoEmail.setText("");
            campoTelefone.setText("");
            campoNome.requestFocus();

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_formulario_aluno_menu) {
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
             aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }


    private void finalizaFormulario() {
        if (campoNome.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Campo (Nome) é obrigatório", Toast.LENGTH_LONG).show();
        } else {
            preencheAluno();
            if (aluno.temIdValido()) {
                dao.edita(aluno);
            } else {
                dao.salva(aluno);
            }
            finish();
        }
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_nome);
        campoTelefone = findViewById(R.id.activity_formulario_telefone);
        campoEmail = findViewById(R.id.activity_formulario_email);
        botaoLimpar = findViewById(R.id.botao_limpar);
    }



    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}
