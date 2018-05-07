package com.example.alunos.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatActivity;
import andorid.support.v7.widget.LinearLayoutManager;
import andorid.support.v7.widget.RecyclerView;


import com.example.alunos.recyclerview.R;

import adapter.LivroAdapter;
import model.Livro;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Livro> listaLivros;
    RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rview = findViewById(R.id.recyclerView);
        listaLivros = new ArrayList<>();

        listaLivros.add(new Livro("O senhor dos Anéis", "J.R.R. Tolien",
                "Fantasia épica onde elfos, anões, hobbits e homens enfrentam os poderes do mal."));
        listaLivros.add(new Livro("Uma breve história do Tempo", "Stephen W. Halking",
                "Uma introdução a alguns conceitos mais profundos da física"));
        listaLivros.add(new Livro("A espada da galáxia", "Marcelo Cassaro",
                "A premiada ficção cientíifca onde alienígenas rivais resolvem suas disputas na Terra."));

        rview.setAdater(new LivroAdapter(listaLivros, this));
        Recycler.View.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        rview.setLayoutManager(layout);

    }
}}
}
