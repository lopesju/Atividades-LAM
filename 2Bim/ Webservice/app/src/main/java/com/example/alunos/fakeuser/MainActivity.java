package com.example.alunos.fakeuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView endereço;
    private TextView cidade;
    private TextView estado;
    private TextView username;
    private TextView senha;
    private TextView nascimento;
    private TextView telefone;
    private ImageView foto;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetJson download = new GetJson();

        load = (ProgressBar) findViewById(R.id.simpleProgressBar);

        nome = (TextView) findViewById(R.id.textView5);
        sobrenome = (TextView) findViewById(R.id.textView11);
        email = (TextView) findViewById(R.id.textView8);
        endereço = (TextView) findViewById(R.id.textView);
        cidade = (TextView) findViewById(R.id.textView);
        estado = (TextView) findViewById(R.id.textView);
        username = (TextView) findViewById(R.id.textView);
        senha = (TextView) findViewById(R.id.textView);
        nascimento = (TextView) findViewById(R.id.textView);
        telefone = (TextView) findViewById(R.id.textView);
        foto = (TextView) findViewById(R.id.textView);

        download.execute();
    }

    private class GetJson extends AsyncTask <Void, Void, FakeUser> {
        @Override
        protected  void onPreExecute(){
            load.setVisibility(View.VISIBLE);
        }

        @Override
        protected  FakeUser doInBackground(Void... params){
            Utils util = new Utils();

            return util.getInformacao("https://randomuser.me/api/0.7");
        }
        @Override
        protected void onPostExecute(FakeUser pessoa){
            String strNome = pessoa.getNome().substring(0,1).toUpperCase()
                    +pessoa.getNome().substring(1);
            nome.setText(strNome);
            String strSobrenome = pessoa.getSobrenome().substring(0,1).toUpperCase()
                    +pessoa.getSobrenome().substring(1);
            sobrenome.setText(strSobrenome);
            email.setText(pessoa.getEmail());
            endereco.setText(pessoa.getEndereco());
            String strCidade = pessoa.getCidade().substring(0,1).toUpperCase()
                    +pessoa.getCidade().substring(1);
            cidade.setText(strCidade);
            estado.setText(pessoa.getEstado());
            username.setText(pessoa.getUsername());
            senha.setText(pessoa.getSenha());
            nascimento.setText(pessoa.getNascimento());
            estado.setText(pessoa.getTelefone());
            foto.setImageBitmap(pessoa.getFoto());
            load.setVisibility(View.GONE);

        }
    }
}
