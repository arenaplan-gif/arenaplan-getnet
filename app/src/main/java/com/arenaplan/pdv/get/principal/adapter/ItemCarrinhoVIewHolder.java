package com.arenaplan.pdv.get.principal.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;
import com.arenaplan.pdv.get.util.Monetario;

public class ItemCarrinhoVIewHolder extends RecyclerView.ViewHolder {

    private final TextView tvCodigoProduto;
    private final TextView tvNomeProduto;
    private final TextView tvQuantidade;
    private final TextView tvUnidade;
    private final TextView tvValorUnitario;
    private final TextView tvValorTotal;
    private final ImageView buttonCancelar;


    public ItemCarrinhoVIewHolder(@NonNull View itemView) {
        super(itemView);

        tvCodigoProduto = itemView.findViewById(R.id.tvCodigoProduto);
        tvNomeProduto = itemView.findViewById(R.id.tvNomeProduto);
        tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
        tvUnidade = itemView.findViewById(R.id.tvUnidade);
        tvValorUnitario = itemView.findViewById(R.id.tvValorUnitario);
        tvValorTotal = itemView.findViewById(R.id.tvValorTotal);
        buttonCancelar = itemView.findViewById(R.id.buttonCancelar);
    }

    public void build(ItemCarrinho itemCarrinho) {

        tvCodigoProduto.setText(itemCarrinho.getIdProduto());
        tvNomeProduto.setText(itemCarrinho.getNomeProduto());
        tvQuantidade.setText("X " + itemCarrinho.getQuantidade());
        tvUnidade.setText(itemCarrinho.getUnidade());
        tvValorUnitario.setText(Monetario.converteValorFloatParaReal(Float.parseFloat(itemCarrinho.getValor())));

        float valorTotal = Float.parseFloat(itemCarrinho.getValor()) * Float.parseFloat(itemCarrinho.getQuantidade());

        tvValorTotal.setText(Monetario.converteValorFloatParaReal(valorTotal));

    }
}
