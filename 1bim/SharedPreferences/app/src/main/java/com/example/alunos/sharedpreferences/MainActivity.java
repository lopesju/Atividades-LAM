package com.example.alunos.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    EditText valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor = (EditText) findViewById(R.id.txtValor);
    }

    public void salvar(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String texto = valor.getText().toString();
        if(texto.matches("")) {
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("valor",texto);
        editor.commit();
        valor.setText("");
    }

    public void carregar(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String texto = arquivo.getString("valor","Nada...");
        valor.setText(texto);
        Log.i("oValor: ",texto);
    }
}