package com.example.alunos.listadinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.example.alunos.listadinamica.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   private ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista.add(new Pessoa("Júlia ", "84848484", R.mipmap.ic_launcher_round));
        lista.add(new Pessoa("Carol", "95959595", R.mipmap.ic_launcher_round));
        lista.add(new Pessoa("Isabela", "12345657", R.mipmap.ic_launcher_round));
    }

    public void mostrarLista(View v){
        Intent it = new Intent(this, mostrarListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }
}
