package com.arenaplan.pdv.get.busca.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.util.Monetario;

public class ItemBuscaProdutoViewHolder  extends RecyclerView.ViewHolder {

    private final TextView textViewCodigo;
    private final TextView textNomeProduto;
    private final TextView textValorUnitario;


    public ItemBuscaProdutoViewHolder(@NonNull View itemView) {
        super(itemView);

        textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
        textViewCodigo = itemView.findViewById(R.id.textViewCodigo);
        textValorUnitario = itemView.findViewById(R.id.textValorUnitario);
    }

    public void build(ProdutoEntidade produtoEntidade) {

        textNomeProduto.setText(produtoEntidade.getNome());
        textViewCodigo.setText(produtoEntidade.getCodigo());
        textValorUnitario.setText(Monetario.converteValorFloatParaReal(produtoEntidade.getValor()));
    }
}
