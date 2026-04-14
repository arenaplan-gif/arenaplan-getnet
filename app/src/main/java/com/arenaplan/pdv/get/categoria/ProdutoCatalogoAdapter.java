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
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.util.Monetario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdutoCatalogoAdapter extends RecyclerView.Adapter<ProdutoCatalogoAdapter.ViewHolder> {

    private List<ProdutoEntidade> listaProdutos;
    private OnProdutoClickListener listener;
    private Context context;
    // Base URL conforme o seu servidor fiscal

    public interface OnProdutoClickListener {
        void onProdutoClick(ProdutoEntidade produto);
    }

    public ProdutoCatalogoAdapter(List<ProdutoEntidade> listaProdutos, Context context, OnProdutoClickListener listener) {
        this.listaProdutos = listaProdutos;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do card que você enviou
        View view = LayoutInflater.from(context).inflate(R.layout.item_produto_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProdutoEntidade produto = listaProdutos.get(position);

        atualizarVisibilidadeContador(holder, produto);

        holder.btnMais.setOnClickListener(v -> {
            produto.setQuantidadeSelecionada(produto.getQuantidadeSelecionada() + 1);
            atualizarVisibilidadeContador(holder, produto);
            listener.onProdutoClick(produto); // Avisa a Activity para atualizar o Confirmar (X)
        });

        holder.btnMenos.setOnClickListener(v -> {
            if (produto.getQuantidadeSelecionada() > 0) {
                produto.setQuantidadeSelecionada(produto.getQuantidadeSelecionada() - 1);
                atualizarVisibilidadeContador(holder, produto);
                listener.onProdutoClick(produto);
            }
        });

        holder.imgProduto.setOnClickListener(v -> {
            produto.setQuantidadeSelecionada(produto.getQuantidadeSelecionada() + 1);
            atualizarVisibilidadeContador(holder, produto);
            listener.onProdutoClick(produto);
        });

        // 1. Seta o nome do produto
        holder.txtNome.setText(produto.getNome());

        // 2. Seta o preço formatado (usando sua classe Monetario)
        holder.txtPreco.setText(Monetario.converteValorFloatParaReal(produto.getValor()));
        String urlImagem = BASE_URL_IMAGE + produto.getImageItem();
        Picasso.get()
                .load(urlImagem)
                .placeholder(R.drawable.padrao)
                .error(R.drawable.padrao)
                .fit()
                .centerInside()
                .into(holder.imgProduto);

        // 4. Clique no Card para selecionar e voltar para a Home
        holder.itemView.setOnClickListener(v -> {
            listener.onProdutoClick(produto);
        });
    }

    private void atualizarVisibilidadeContador(ViewHolder holder, ProdutoEntidade produto) {
        if (produto.getQuantidadeSelecionada() > 0) {
            holder.layoutContador.setVisibility(View.VISIBLE);
            holder.txtQuantidadeCard.setText(String.valueOf(produto.getQuantidadeSelecionada()));
        } else {
            holder.layoutContador.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listaProdutos != null ? listaProdutos.size() : 0;
    }

    // Classe interna para segurar os componentes do XML
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduto;
        TextView txtNome, txtPreco, txtQuantidadeCard;
        View layoutContador; // View genérica para o LinearLayout
        android.widget.ImageButton btnMais, btnMenos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduto = itemView.findViewById(R.id.imgProduto);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPreco = itemView.findViewById(R.id.txtPreco);
            txtQuantidadeCard = itemView.findViewById(R.id.txtQuantidadeCard);
            layoutContador = itemView.findViewById(R.id.layoutContador);
            btnMais = itemView.findViewById(R.id.btnMais);
            btnMenos = itemView.findViewById(R.id.btnMenos);
        }
    }
}
