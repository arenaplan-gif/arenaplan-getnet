package com.arenaplan.pdv.get.categoria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.util.Monetario;

import java.util.ArrayList;
import java.util.List;

public class ResumoCatalogoAdapter extends RecyclerView.Adapter<ResumoCatalogoAdapter.ViewHolder>{

    private List<ProdutoEntidade> itens;

    public ResumoCatalogoAdapter(ArrayList<ProdutoEntidade> produtosAcumulados) {
        this.itens = produtosAcumulados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resumo_carrinho, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProdutoEntidade p = itens.get(position);
        holder.tvNome.setText(p.getNome());
        holder.tvQtd.setText(String.valueOf(p.getQuantidadeSelecionada()));
        holder.tvPreco.setText(Monetario.converteValorFloatParaReal(p.getValor()));
        float valor = p.getValor() * p.getQuantidadeSelecionada();
        holder.tvSubtotal.setText(Monetario.converteValorFloatParaReal(valor));
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvQtd, tvPreco, tvSubtotal;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.resumoNome);
            tvQtd = itemView.findViewById(R.id.resumoQtd);
            tvPreco = itemView.findViewById(R.id.resumoPreco);
            tvSubtotal = itemView.findViewById(R.id.resumoSubtotal);
        }
    }
}
