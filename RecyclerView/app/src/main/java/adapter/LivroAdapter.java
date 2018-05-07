package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LivroAdapter extends RecyclerView.ViewHolder {
    private List<Livro> lista;
    private Context context;

    public LivroAdapter(List<Livro> l, Context c){
        this.lista = l;
        this.context = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType
            ){
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_lista, parent, false );
        return new LivroViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder, int position
    ){
        LivroViewHolder theHolder = (LivroViewHolder) holder;
        Livro livro = lista.get(position);
        theHolder.titulo.setText(livro.getTitulo());
        theHolder.titulo.setText(livro.getAutor());
        theHolder.titulo.setText(livro.getDescricao());
    }
    @Override
    public int getItemCount(){
        return lista.size();
    }
}
