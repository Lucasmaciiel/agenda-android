package br.com.lmg;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView aluno = new TextView(this);
        setContentView(R.layout.activity_main);
        setTitle("Anotações");

        List<String> alunos = new ArrayList<String>(Arrays.asList("Alex", "Fran", "José", "Lucas", "Maria", "Pedro"));

        ListView listaDeAlunos = (ListView) findViewById(R.id.activity_main_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<String>(
                this,
                 android.R.layout.simple_list_item_1,
                 alunos));

    }
}
