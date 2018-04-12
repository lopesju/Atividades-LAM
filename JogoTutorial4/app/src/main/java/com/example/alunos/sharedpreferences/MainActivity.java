package com.example.alunos.sharedpreferences;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    EditText valor;
    int t, nSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();
        t = 0;
        nSort = r.nextInt(10) + 1;
        valor = (EditText) findViewById(R.id.numero);
    }

    public void jogar(View v) {
        EditText userInput = findViewById(R.id.numero);
        String num = userInput.getText().toString();
        int nDigitado = Integer.parseInt(num);
        TextView resposta = findViewById(R.id.resposta);

        if (nDigitado > nSort) {
            t++;
            resposta.setText("O número é menor");
            userInput.setText("");
        } else if (nDigitado < nSort) {
            t++;
            resposta.setText("O número é maior");
            userInput.setText("");
        } else {
            t++;
            String tent = Integer.toString(t);
            resposta.setText(String.format("Você acertou! Parabéns!! Você gastou %1$s tentativas", tent));
            userInput.setText("");
            SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
            String tentativas = Integer.toString(t);
            String texto = tentativas;
            if (texto.matches("")) {
                Toast toast = Toast.makeText(MainActivity.this,
                        "Digite algo...", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            SharedPreferences.Editor editor = arquivo.edit();
            editor.putString("tentativas", texto);
            editor.commit();
            //Log.d("msg:", "entrou aqui");
        }

    }

    public void carregaPlacar(View v){
        String tentativas = Integer.toString(t);
        //String texto = tentativas;
        Intent i = new Intent(MainActivity.this, Placar.class);
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String texto = arquivo.getString("tentativas","Nada...");
        Log.i("tentativas: ",texto);

        Bundle bundle = new Bundle();
        bundle.putString("tentativas", texto);
        i.putExtras(bundle);
        startActivity(i);
    }


    public void reiniciar(View v) {
        setContentView(R.layout.activity_main);
        Random r = new Random();
        t = 0;
        nSort = r.nextInt(10) + 1;
        valor = (EditText) findViewById(R.id.numero);

    }

    //public void carregar(View v) {
        //SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        //String texto = arquivo.getString("valor","Nada...");
        //valor.setText(texto);
        //Log.i("oValor: ",texto);
    //}
}