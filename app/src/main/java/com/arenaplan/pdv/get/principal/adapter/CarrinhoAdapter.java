package com.arenaplan.pdv.get.principal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;
import java.util.ArrayList;

public class CarrinhoAdapter extends RecyclerView.Adapter<ItemCarrinhoVIewHolder>{

    private ArrayList<ItemCarrinho> listaItemCarrinho;

    private CliqueRemoveCarrinho cliqueRemoveCarrinho;

    public CarrinhoAdapter(ArrayList<ItemCarrinho> listaItemCarrinho, CliqueRemoveCarrinho cliqueRemoveCarrinho) {

        this.listaItemCarrinho = listaItemCarrinho;
        this.cliqueRemoveCarrinho = cliqueRemoveCarrinho;
    }


    public void atualizaListaCarrinho(ArrayList<ItemCarrinho> listaItemCarrinho) {

        this.listaItemCarrinho = listaItemCarrinho;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemCarrinhoVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrinho, parent, false);


        return new ItemCarrinhoVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCarrinhoVIewHolder holder, int position) {

        ItemCarrinho itemCarrinho = listaItemCarrinho.get(position);
        holder.build(itemCarrinho);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliqueRemoveCarrinho.onRemoverItem(itemCarrinho);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listaItemCarrinho.size();
    }
}
