package com.example.alunos.androidtoolbar.adapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alunos.androidtoolbar.adapter.*R;
import com.example.alunos.androidtoolbar.adapter.*model.Pessoa;
import java.util.List;

public class PessoaAdapter extends BaseAdapter {

    private Activity atividade;
    private List<Pessoa> toolbar;

    public PessoaAdapter(Activity atividade, List<Pessoa> lista){
        this.atividade = atividade;
        this.toolbar = lista;
    }
    @Override
    public int getCount(){
        return lista.size();
    }
    @Override
    public Object getItem(int position){
        return lista.get(position);
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Pessoa obj = toolbar.get(position);

        View v = atividade.getLayoutInflater().inflate(R.layout.row_layout,parent,false);

        TextView textnome = v.findViewById(R.id.lblFirst);
        textnome.setText(obj.getNome());

        TextView textTelefone = v.findViewById(R.id.lblSecond);
        textTelefone.setText(obj.getTelefone());

        ImageView imgImagem = v.findViewById(R.id.imgImagem);
        imgImagem.setImageResource(obj.getImagem());

        return v;
    }
}
