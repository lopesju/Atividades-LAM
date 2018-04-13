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

        TextView txtResultado1 = (TextView) findViewById (R.id.txtResultado);
        txtResultado1.setText(String.format(pacote.getString("placar1","nao tem nada")));
        TextView txtResultado2 = (TextView) findViewById (R.id.txtResultado2);
        txtResultado2.setText(String.format(pacote.getString("placar2","nao tem nada")));
        TextView txtResultado3 = (TextView) findViewById (R.id.txtResultado3);
        txtResultado3.setText(String.format(pacote.getString("placar3","nao tem nada")));
        TextView txtResultado4 = (TextView) findViewById (R.id.txtResultado4);
        txtResultado4.setText(String.format(pacote.getString("placar4","nao tem nada")));
        TextView txtResultado5 = (TextView) findViewById (R.id.txtResultado5);
        txtResultado5.setText(String.format(pacote.getString("placar5","nao tem nada")));

    }
}