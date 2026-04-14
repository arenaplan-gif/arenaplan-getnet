package com.arenaplan.pdv.get.busca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.busca.adapter.BuscaProdutoAdapter;
import com.arenaplan.pdv.get.busca.adapter.CliqueBuscaProduto;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.util.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LayoutActivity extends AppCompatActivity {


    ProdutoBancoController produtoBancoController;
    private BuscaProdutoAdapter buscaProdutoAdapter;
    private EditText edtNomeProduto;
    private TextView textViewHoraConsultaProduto;

    List<ProdutoEntidade> produtoEntidadeList = new ArrayList<>();
    private RecyclerView listaProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        produtoBancoController = new ProdutoBancoController(this);
        recuperaIdTela();

    }

    private void recuperaIdTela() {

        listaProduto = findViewById(R.id.lista_produto);
        edtNomeProduto = findViewById(R.id.edtNomeProduto);
        textViewHoraConsultaProduto = findViewById(R.id.textViewHoraConsultaProduto);

        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();

        textViewHoraConsultaProduto.setText(data + "\n" + hora);
        Timer();

    }

    private void executaBuscaNaLista() {

        edtNomeProduto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().trim().length() > 0) {

                    buscaProdutoAdapter.getFilter().filter(s);
                } else {
                    buscaProdutoAdapter.atualizaLista(produtoEntidadeList);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        produtoEntidadeList =  produtoBancoController.getProdutoTodosProdutos();

        buscaProdutoAdapter = new BuscaProdutoAdapter(produtoEntidadeList);

        buscaProdutoAdapter.setOnItemClickListener(new CliqueBuscaProduto() {
            @Override
            public void onItemClick(ProdutoEntidade produtoEntidade) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",produtoEntidade);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        listaProduto.setLayoutManager(new LinearLayoutManager(this));

        listaProduto.setAdapter(buscaProdutoAdapter);

        executaBuscaNaLista();
    }

    public void Timer() {
        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 30000);
    }

    public void VoltaPagamento(View view) {
        return;
    }

    class Task extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = DateUtils.retornaDiaAtual();
                    String hora = DateUtils.retornaHoraAtual();

                    textViewHoraConsultaProduto.setText(data + "\n" + hora);
                }
            });
        }
    }
}
