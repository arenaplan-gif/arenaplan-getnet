package com.arenaplan.pdv.get.busca.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;

import java.util.ArrayList;
import java.util.List;

public class BuscaProdutoAdapter extends RecyclerView.Adapter<ItemBuscaProdutoViewHolder> implements Filterable {


    private List<ProdutoEntidade> produtoEntidadeList;
    private List<ProdutoEntidade> listaOriginal;
    private CliqueBuscaProduto onItemClickListener;


    public BuscaProdutoAdapter(List<ProdutoEntidade> produtoEntidadeList) {

        this.produtoEntidadeList = produtoEntidadeList;
        this.listaOriginal = produtoEntidadeList;
    }

    public void setOnItemClickListener(CliqueBuscaProduto onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void atualizaLista(List<ProdutoEntidade> produtoEntidadeList) {
        this.produtoEntidadeList = produtoEntidadeList;
        this.listaOriginal = produtoEntidadeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemBuscaProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_busca_pedido, parent, false);


        return new ItemBuscaProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBuscaProdutoViewHolder holder, int position) {

        final ProdutoEntidade produtoEntidade = produtoEntidadeList.get(position);
        holder.build(produtoEntidade);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickListener.onItemClick(produtoEntidade);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.produtoEntidadeList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<ProdutoEntidade> results = new ArrayList<>();
                if (listaOriginal == null)
                    listaOriginal = new ArrayList<>(produtoEntidadeList);
                if (constraint != null && constraint.length() > 0) {
                    if (listaOriginal != null && listaOriginal.size() > 0) {
                        for (final ProdutoEntidade cd : listaOriginal) {
                            if (cd.getNome().toLowerCase()
                                    .contains(constraint.toString().toLowerCase()))
                                results.add(cd);
                        }
                    }
                    oReturn.values = results;
                    oReturn.count = results.size();//newly Aded by ZA
                } else {
                    oReturn.values = listaOriginal;
                    oReturn.count = listaOriginal.size();//newly added by ZA
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                produtoEntidadeList = new ArrayList<>((ArrayList<ProdutoEntidade>) results.values);

                notifyDataSetChanged();
            }
        };
    }
}
