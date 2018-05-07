package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LivroViewHolder extends RecyclerView.ViewHolder {
    final TextView titulo;
    final TextView autor;
    final TextView descricao;


    public LivroViewHolder(View itemView){
        super(itemView);
        titulo = itemView.findViewById(R.id.txtTitulo);
        autor = itemView.findViewById(R.id.txtAutor);
        descricao = itemView.findViewById(R.id.txtDesc);
    }

}
