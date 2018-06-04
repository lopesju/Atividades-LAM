package com.example.alunos.androidtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.alunos.androidtoolbar.*model.Pessoa;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


}
public class AddItemsFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup contrainer, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_add_items_layout,
                contrainer, false);
        return v;

        ArrayList<Pessoa> lista = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void mostrarLista(View v) {
            Intent it = new Intent(this, Toolbar.class);
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

}
