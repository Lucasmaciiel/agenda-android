package br.com.lmg.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.lmg.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CadastroActivity.this,
                        "Salvo com sucesso",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
