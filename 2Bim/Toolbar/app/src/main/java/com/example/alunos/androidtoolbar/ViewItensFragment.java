package com.example.alunos.androidtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import java.util.ArrayList;

public class ViewItensFragment extends Fragment {
    @Nullable
    @Override
    MainActivity atividade = (MainActivity) getActivity();

    public ArrayList<Pessoa> getLista(){
        Intent it = new Intent(this, Toolbar.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos",toolbar);
        it.putExtras(bundle);
        startActivity(it);
    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup contrainer, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_items_layout,
                contrainer, false);
        return v;
    }
}
