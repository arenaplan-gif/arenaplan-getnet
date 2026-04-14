package com.arenaplan.pdv.get.categoria;

import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;
import static com.arenaplan.pdv.get.util.Constantes.PEDIDO_MESA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.CategoriaEntidade;
import com.arenaplan.pdv.get.api.model.InserePedido;
import com.arenaplan.pdv.get.api.model.InserePedidoCard;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.pedidos.dialog.MostraInformacoesPedido;
import com.arenaplan.pdv.get.util.Monetario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogoActivity extends AppCompatActivity {

    private RecyclerView rvCategorias, rvItensCarrinho;
    private TextView tvTotal;
    private ArrayList<ProdutoEntidade> produtosAcumulados = new ArrayList<>();
    private ProdutoBancoController dbController;

    private static final int CODIGO_PRODUTOS = 101;

    private Button btnEnviarPedido;
    private Button btnEnviarMesa;

    private String usuario;
    private String codigo;
    private String senha;
    private float totalSession;
    private int timeOut = 35;
    ArenaplanPdvApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        mApplication = (ArenaplanPdvApplication) getApplicationContext();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();

        dbController = new ProdutoBancoController(this);
        rvCategorias = findViewById(R.id.rvCategorias);
        rvItensCarrinho = findViewById(R.id.rvItensCarrinho);
        tvTotal = findViewById(R.id.tvTotalCatalogo);
        btnEnviarPedido = findViewById(R.id.btnEnviarPedido);
        btnEnviarMesa = findViewById(R.id.btnEnviarMesa);
        rvItensCarrinho.setLayoutManager(new LinearLayoutManager(this));
        carregarCategorias();

        btnEnviarPedido.setOnClickListener(v -> {
            if (produtosAcumulados.isEmpty()) {
                Toast.makeText(this, "Nenhum item selecionado", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent returnIntent = new Intent();
            returnIntent.putParcelableArrayListExtra("lista_selecionada", produtosAcumulados);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        });

        btnEnviarMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText etNumeroMesa = findViewById(R.id.etNumeroMesa);
                    EditText etApelido = findViewById(R.id.etApelido);
                    EditText etObservacao = findViewById(R.id.etobservacao);

                    String numeroMesa = etNumeroMesa.getText().toString().trim();
                    String apelido = etApelido.getText().toString().trim();
                    String observacao = etObservacao.getText().toString().trim();

                    String carrinhoJson = montarCarrinhoFormatoP(produtosAcumulados); // você precisa implementar

                    //String totalStr = tvTotal.getText().toString(); // ou valor numérico formatado

                    registrapedido(numeroMesa, carrinhoJson, apelido, observacao, totalSession);


                    finish();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private String montarCarrinhoFormatoP(List<ProdutoEntidade> produtos) {
        if (produtos == null || produtos.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        boolean primeiro = true;
        for (ProdutoEntidade p : produtos) {
            String codigo = p.getCodigo() != null ? p.getCodigo().trim() : "";
            int qtd = p.getQuantidadeSelecionada(); // assume int
            if (codigo.isEmpty() || qtd <= 0) continue;
            if (!primeiro) sb.append("p");
            sb.append(codigo).append("*").append(qtd);
            primeiro = false;
        }
        return sb.toString();
    }



    private void alerta(String mensagem) {
        if (!isFinishing()) {
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("botao: ")
                    .setMessage(mensagem)
                    .setPositiveButton("ok", null)
                    .show();
        }
    }

    private void AbreTelaResumoPedidoMesa(String numeromesa, String Apelido) {
        Intent intent = new Intent(this, MostraInformacoesPedido.class);
        Bundle b = new Bundle();
        b.putString("numeromesa", numeromesa);
        //if (clientids.get(numeromesa)==null) {
        b.putString("clienteid", "-");
        b.putString("apelido", Apelido);
        //}
        /*else {
            b.putString("clienteid", clientids.get(numeromesa));
            if (!Apelido.equals("")) {
                if(!Apelido.equals("-")){
                    nomeformatado = Apelido.substring(0, Apelido.indexOf("\nR"));
                    b.putString("apelido", nomeformatado);
                }else b.putString("apelido", "-");
            }else{
                b.putString("apelido", "-");
            }

        }*/
        intent.putExtras(b);
        startActivity(intent);
    }

    private void registrapedido(String menumero, String carrinho, String nome, String obs, float total) {
        //Log.d("CatalogoActivity", "Iniciando registro de pedido");
        Call<InserePedidoCard> call = new RetrofitConfig(timeOut).getPDVService().process_pedido_mesa(
                usuario,
                senha,
                codigo,
                PEDIDO_MESA,
                total,
                carrinho,
                menumero,
                nome,
                obs,
                FORMATO
        );
        call.enqueue(new Callback<InserePedidoCard>() {
            @Override
            public void onResponse(Call<InserePedidoCard> call, Response<InserePedidoCard> response) {
                //Log.d("CatalogoActivity", "Iniciando registro de pedido");
                if (response.isSuccessful() && response.body() != null) {
                    InserePedidoCard inserePedidoCard = response.body();
                    InserePedido p = inserePedidoCard.getInserePedido();
                    if (p != null && CODIGO_SUCESSO.equalsIgnoreCase(p.getError_code())) {
                        AbreTelaResumoPedidoMesa(menumero, nome);
                    } else {
                        alerta("Erro na resposta do servidor");
                    }
                } else {
                    alerta("Resposta inválida do servidor: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<InserePedidoCard> call, Throwable t) {
                //Log.e("CatalogoActivity", "Erro ao registrar pedido: " + t.getMessage());
                if (!isFinishing()) {
                    alerta("Erro ao registrar Pedido: " + t.getMessage());
                }
            }
        });
       }
        private void abrirProdutos (String nome){
            Intent intent = new Intent(this, com.arenaplan.pdv.get.categoria.ProdutoCategoriaActivity.class);
            intent.putExtra("categoria_nome", nome);
            startActivityForResult(intent, CODIGO_PRODUTOS);
        }


        private void carregarCategorias () {
            List<CategoriaEntidade> categorias = dbController.getCategorias();

            CategoriaAdapter adapter = new CategoriaAdapter(categorias, this, nome -> {
                abrirProdutos(nome);
            });

            GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            rvCategorias.setLayoutManager(layoutManager);
            rvCategorias.setAdapter(adapter);
        }

        private void atualizarTabelinhaRodape () {
            // Criaremos um Adapter simples que usa a lista 'produtosAcumulados'
            ResumoCatalogoAdapter adapter = new ResumoCatalogoAdapter(produtosAcumulados);
            rvItensCarrinho.setAdapter(adapter);

            totalSession = 0;
            for (ProdutoEntidade p : produtosAcumulados) {
                totalSession += (p.getValor() * p.getQuantidadeSelecionada());
            }
            tvTotal.setText(Monetario.converteValorFloatParaReal(totalSession));
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CODIGO_PRODUTOS && resultCode == RESULT_OK && data != null) {
                ArrayList<ProdutoEntidade> selecionadosNestaVez = data.getParcelableArrayListExtra("lista_selecionada");

                if (selecionadosNestaVez != null) {
                    for (ProdutoEntidade pNovo : selecionadosNestaVez) {
                        // Verifica se o produto já foi adicionado antes para somar a quantidade
                        boolean encontrado = false;
                        for (ProdutoEntidade pAcumulado : produtosAcumulados) {
                            if (pAcumulado.getCodigo().equals(pNovo.getCodigo())) {
                                pAcumulado.setQuantidadeSelecionada(pAcumulado.getQuantidadeSelecionada() + pNovo.getQuantidadeSelecionada());
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            produtosAcumulados.add(pNovo);
                        }
                    }
                    atualizarTabelinhaRodape();
                }
            }
        }


        public void voltar (View view){
            finish();
        }
    }


