package com.arenaplan.pdv.get.categoria;

import static com.arenaplan.pdv.get.util.Constantes.BASE_URL_IMAGE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.model.CategoriaEntidade;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

    private List<CategoriaEntidade> lista;
    private Context context;
    private OnCategoriaClickListener listener;

    public interface OnCategoriaClickListener {
        void onCategoriaClick(String nomeCategoria);
    }

    public CategoriaAdapter(List<CategoriaEntidade> lista, Context context, OnCategoriaClickListener listener) {
        this.lista = lista;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria_chip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoriaEntidade cat = lista.get(position);
       holder.txtNome.setText(cat.getTitulo());
        // Carrega a imagem da categoria (campo imt do seu JSON)
        String urlImagem = BASE_URL_IMAGE + cat.getImagem();
        Picasso.get()
                .load(urlImagem)
                .placeholder(R.drawable.padrao)
                .error(R.drawable.padrao)
                .fit()
                .centerInside()
                .into(holder.imgCategoria);

        holder.itemView.setOnClickListener(v -> listener.onCategoriaClick(cat.getTitulo()));
    }

    @Override
    public int getItemCount() { return lista.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategoria;
        TextView txtNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategoria = itemView.findViewById(R.id.imgCategoria);
            txtNome = itemView.findViewById(R.id.txtNomeCategoria);
        }
    }
}
