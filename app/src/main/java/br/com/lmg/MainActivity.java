package br.com.lmg;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

        import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView aluno = new TextView(this);
        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "José", "Lucas", "Maria", "Pedro"));

        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                 android.R.layout.simple_list_item_1,
                 alunos));

    }
}
