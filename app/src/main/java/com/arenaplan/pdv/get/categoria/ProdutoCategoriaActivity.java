package com.arenaplan.pdv.get.categoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProdutoCategoriaActivity extends AppCompatActivity {

    private RecyclerView rvProdutos;
    private ProdutoBancoController dbController;

    private ExtendedFloatingActionButton btnConfirmarSelecao;
    private ArrayList<ProdutoEntidade> listaSelecionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_produto);
        dbController = new ProdutoBancoController(this);
        rvProdutos = findViewById(R.id.rvProdutosCatalogo);
        btnConfirmarSelecao = findViewById(R.id.btnConfirmarSelecao);
        String nomeCategoria = getIntent().getStringExtra("categoria_nome");
        carregarProdutos(nomeCategoria);

        // Configuração do botão de confirmação (para retornar à Home)
        btnConfirmarSelecao.setOnClickListener(v -> {
            if (listaSelecionados.isEmpty()) {
                finish(); // Ou mostre um Toast
                return;
            }
            Intent returnIntent = new Intent();
            returnIntent.putParcelableArrayListExtra("lista_selecionada", listaSelecionados);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        });

    }


    private void carregarProdutos(String categoriaNome) {
        List<ProdutoEntidade> produtos;
        if (categoriaNome == null || categoriaNome.isEmpty()) {
            produtos = dbController.getProdutoTodosProdutos();
        } else {
            produtos = dbController.getProdutosPorCategoria(categoriaNome);
        }

        if (produtos != null) {
            ProdutoCatalogoAdapter adapter = new ProdutoCatalogoAdapter(produtos, this, produto -> {

                // 1. Atualiza a lista de selecionados de forma inteligente
                if (produto.getQuantidadeSelecionada() > 0) {
                    // Se o produto já está na lista, não faz nada (o objeto já guarda a qtd)
                    if (!listaSelecionados.contains(produto)) {
                        listaSelecionados.add(produto);
                    }
                } else {
                    // Se a quantidade chegou a zero, remove da lista
                    listaSelecionados.remove(produto);
                }

                // 2. Calcula o total de itens (soma das quantidades de cada produto)
                int totalItens = 0;
                for (ProdutoEntidade p : listaSelecionados) {
                    totalItens += p.getQuantidadeSelecionada();
                }

                // 3. Atualiza o botão com o total real
                btnConfirmarSelecao.setText("Confirmar (" + totalItens + ")");
            });

            rvProdutos.setLayoutManager(new GridLayoutManager(this, 3));
            rvProdutos.setAdapter(adapter);
        }
    }
}
