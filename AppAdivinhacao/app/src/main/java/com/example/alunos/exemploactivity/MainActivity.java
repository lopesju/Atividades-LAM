package com.example.alunos.exemploactivity;

import android.support.v7.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int nSort;
    int t;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();
        t = 3;
        nSort = r.nextInt(10) + 1;
    }
    public void verificaTexto(View v){
        EditText userInput = findViewById(R.id.numero);
        String num = userInput.getText().toString();
            int nDigitado = Integer.parseInt(num);
            TextView resposta = findViewById(R.id.titulo);
            TextView resultado = findViewById(R.id.resultado);


        if(nSort==nDigitado && t>0){
            resposta.setText(getResources().getString(R.string.str_rsp1).toString());
            userInput.setText("");
            String nSorteado = Integer.toString(nSort);
            resultado.setText(getResources().getString(R.string.str_rsp3,nSorteado).toString());

        }else if(nSort!=nDigitado && t>0) {
            resposta.setText(getResources().getString(R.string.str_rsp2).toString());
            userInput.setText("");
            t--;
        }else{
        System.out.printf("O número era: %d \n", nSort);
        }

    }
}

