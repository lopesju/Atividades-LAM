package com.example.alunos.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Placar extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String tentativas = pacote.getString("tentativas");
        TextView txtResultado = (TextView) findViewById (R.id.txtResultado);
        txtResultado.setText(String.format("Número Tentativas: %s!", tentativas));
    }
}