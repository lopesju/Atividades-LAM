package com.example.alunos.listadinmica;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;

        import com.example.alunos.listadinmica.model.Pessoa;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista.add(new Pessoa("Letícia Lopes", "987451584",R.mipmap.ic_launcher_round));
        lista.add(new Pessoa("Amanda Machado", "987451525",R.mipmap.ic_launcher_round));
        lista.add(new Pessoa("Júlia Lopes", "956215842",R.mipmap.ic_launcher_round));
    }

    public void mostrarLista(View v) {
        Intent it = new Intent(this, ListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos",lista);
        it.putExtras(bundle);
        startActivity(it);
    }
    public void salvar(View v){
        EditText editnome = (EditText) findViewById(R.id.editNome);
        EditText edittelefone = (EditText) findViewById(R.id.editTelefone);
        String nome = editnome.getText().toString();
        String telefone = edittelefone.getText().toString();
        lista.add(new Pessoa(nome,telefone,R.mipmap.ic_launcher_round));
        editnome.setText("");
        edittelefone.setText("");
    }
}