package com.arenaplan.pdv.get.principal.ui;

import static android.hardware.Camera.Parameters.FLASH_MODE_ON;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G11;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;
import static com.arenaplan.pdv.get.util.Constantes.OFF_LINE;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.PagamentoCard;
import com.arenaplan.pdv.get.busca.LayoutActivity;
import com.arenaplan.pdv.get.categoria.CatalogoActivity;
import com.arenaplan.pdv.get.database.PendenteController;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.entidades.PendenteEntidade;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.opcoes.OpcoesActivity;
import com.arenaplan.pdv.get.opcoes.dialog.pendente.EnviarPagamentoPendenteAcao;
import com.arenaplan.pdv.get.opcoes.dialog.pendente.EnviarPagamentoPendentePopUp;
import com.arenaplan.pdv.get.pagamento.PagamentoActivity;
import com.arenaplan.pdv.get.pedidos.PedidosActivity;
import com.arenaplan.pdv.get.principal.adapter.CarrinhoAdapter;
import com.arenaplan.pdv.get.principal.adapter.CliqueRemoveCarrinho;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;
import com.arenaplan.pdv.get.util.BaseActivity;
import com.arenaplan.pdv.get.util.DateUtils;
import com.arenaplan.pdv.get.util.Monetario;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements CliqueRemoveCarrinho {
    //private final Calendar PosDigital;
    //IGEDI iGedi = null;
    //IPRNTR iprntr;
//    public ConfigPrint configPrint = new ConfigPrint();
//    public GertecPrinter gertecPrinter;
//    private ConfigPrint impressao = new Impressao();

    private static final int LAUNCH_SECOND_ACTIVITY_TWO = 2;
    private ImageButton buttonCategoria;
    private ImageButton buttonFaleConosco;
    //private Button buttonFaleConosco;

    public static final String G700 = "A8";
    private static final String version = "v2.0.0";
    public static String Model = Build.MODEL;

    private TextView tvDataHoraPrincipal;
    private EditText codigoProduto;
    private EditText qtdeProduto;
    private TextView precoUnitario;
    private TextView edValorTotal;
    private TextView textViewNomeProduto;
    private ImageButton buttonConsulta;
    private ImageButton buttonAdicionar;
    private ImageButton buttonQrcode;
    //private ImageButton buttonoffline;
    //private ImageButton buttoncredoff;
    private float valorTotalCarrinho = (float) 0.0;
    private TextView textViewValorTotalCarrinho;
    ArenaplanPdvApplication mApplication;

    private ProdutoEntidade produtoSelecionado = null;
    private RecyclerView carrinhoCompra;
    private Button buttonOpcoes;
    private Button buttonPedidos;
    private Button buttonOpcoesCaixa;
    private IntentIntegrator qrScan;
    private Button buttonPagar;
    private Button buttonOffline;
    private Button buttonCredoff;


    private CarrinhoAdapter carrinhoAdapter;
    private PendenteController pendenteController;
    private int timeOut = 35;
    private String codigo;
    private String usuario;
    private String senha;
    private static String tag = "MainActivity";
    //public TextView modooffline;
    //public TextView pagcredoff;


    private static final int LAUNCH_SECOND_ACTIVITY = 1;

    private ArrayList<String> arrayListTipo;

    private String tipoCode;
    private EditText editText;

    ProdutoBancoController produtoBancoController;

    private final Handler handlerTime = new Handler(Looper.getMainLooper());
    private final Runnable runnableTime = new Runnable() {
        @Override
        public void run() {
            String data = DateUtils.retornaDiaAtual();
            String hora = DateUtils.retornaHoraAtual();
            //tvDataHoraPrincipal.setText(data + "\n" + hora);
            //handlerTime.postDelayed(this, 30000); // Roda a cada 30s
            if (tvDataHoraPrincipal != null) {
                tvDataHoraPrincipal.setText(data + "\n" + hora);
            } else {
                Log.w("MainActivity","tvDataHoraPrincipal is null in runnableTime");
            }
            handlerTime.postDelayed(this, 30000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate after setContentView");
        //connectPosDigitalService();
       // connectPosDigitalService(); //posdigital da getnet coloquei a chamada aqui
        mApplication = (ArenaplanPdvApplication) getApplicationContext();

        //TextView linearLayout= (TextView) findViewById(R.id.credoff);

        //LayoutInflater inflater = requireActivity().getLayoutInflater();
        //View view = inflater.inflate(R.layout.activity_main, null);
        //TextView view=new TextView();
        //EditText editText;

        /*modooffline=(TextView) findViewById(R.id.buttoncredoff); //editText.findViewById(R.id.credoff);
        pagcredoff=(TextView) findViewById(R.id.buttonoffline); //editText.findViewById(R.id.offline);

        if (mApplication.getSetUp().getT_usaoff().equals("1"))
            modooffline.setVisibility(View.VISIBLE);
        else
            modooffline.setVisibility(View.INVISIBLE);

        if (mApplication.getSetUp().getT_tef().equals("1"))
            pagcredoff.setVisibility(View.VISIBLE);
        else
            pagcredoff.setVisibility(View.INVISIBLE);*/

        mApplication.configurePinpadSkin(this);

        produtoBancoController = new ProdutoBancoController(this);
        try {
            timeOut = Integer.parseInt(mApplication.getSetUp().getT_timeout());
        } catch (Exception e) {
            timeOut = 35;
        }
        usuario = mApplication.getSetUp().getT_login();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();

        pegaIdTela();
        Log.d("MainActivity","after pegaIdTela tv null? " + (tvDataHoraPrincipal==null));
        if (mApplication.getSetUp().getT_usaoff().equals("0")) {
            buttonOffline.setBackgroundColor(Color.GRAY);
        }
        else {
            buttonOffline.setBackgroundColor(Color.RED);
        }
        if (mApplication.getSetUp().getT_tef().equals("0")) {
            buttonCredoff.setBackgroundColor(Color.RED);
        }
        else {
            buttonCredoff.setBackgroundColor(Color.GRAY);
        }

        ouvinteCliqueBotoes();
        this.tipoCode = "EAN_13";
        this.arrayListTipo = new ArrayList<String>();
        arrayListTipo.add(this.tipoCode);


    }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (PosDigital.getInstance().isInitiated())
                PosDigital.unregister(MainActivity.this);
        } catch (Exception e) {
            Log.e(tag, "Erro de exception no Destroy da Activity");
        }

    }*/
    //este é o trecho que eu copiei preciso fazer funcionar. vou apagar a appcompactactividy pois nao vai la
    /*private void connectPosDigitalService() {
         PosDigital.register(MainActivity.this, new PosDigital.BindCallback() {
             @Override
             public void onError(Exception e) {
                 connectPosDigitalService();
             }

             @Override
             public void onConnected() {

             }

             @Override
             public void onDisconnected() {

             }
         });
    }*/




    @Override
    public void onBackPressed() {
        mApplication.limpaCarrinhoSessao();
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();

        carrinhoAdapter = new CarrinhoAdapter(mApplication.getListaItemCarrinho(), this);

        carrinhoCompra.setLayoutManager(new LinearLayoutManager(this));
        carrinhoCompra.setAdapter(carrinhoAdapter);

        if (mApplication.getListaItemCarrinho() == null || mApplication.getListaItemCarrinho().size() == 0) {
            textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(0));
            valorTotalCarrinho=0;
        }
        if (mApplication.ModoFechaMesa=="1") {  //apresenta o tototal dos produtos vindos do fechamento da mesa
            for (ItemCarrinho item : mApplication.getListaItemCarrinho()) {
                valorTotalCarrinho += Float.parseFloat(item.getValor()) * Float.parseFloat(item.getQuantidade());
            }
            textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
            mApplication.ModoFechaMesa="0"; //Desliga o recalculo do carrinho na apresentação
        }

        if(getIntent().hasExtra("ConsultaPendente")) {

            boolean consularPendentes = getIntent().getBooleanExtra("ConsultaPendente" , false);
            pendenteController = new PendenteController(MainActivity.this);

            int total = pendenteController.listaCarrinhoPendente().size();
            if(consularPendentes && total > 0) {

                abrePopPendente();

            }

            getIntent().removeExtra("ConsultaPendente");
        }
        handlerTime.removeCallbacks(runnableTime);
        handlerTime.post(runnableTime);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handlerTime.removeCallbacks(runnableTime);
    }

    private void adicionarItemCarrinho(ItemCarrinho itemCarrinho) {

        mApplication.adicionaitemCarrinho(itemCarrinho);
        carrinhoAdapter.atualizaListaCarrinho(mApplication.getListaItemCarrinho());

        valorTotalCarrinho = 0;

        for (ItemCarrinho item : mApplication.getListaItemCarrinho()) {

            valorTotalCarrinho += Float.parseFloat(item.getValor()) * Float.parseFloat(item.getQuantidade());
        }

        textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
        produtoSelecionado = null;

        codigoProduto.setText("");
        qtdeProduto.setText("");
        precoUnitario.setText("");
        edValorTotal.setText("");
        textViewNomeProduto.setText("");

        InputMethodManager imm = (InputMethodManager) qtdeProduto.getContext().getSystemService(Context
                .INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(qtdeProduto.getWindowToken(), 0);


    }

    private void pegaIdTela() {
        tvDataHoraPrincipal = findViewById(R.id.tvDataHoraPrincipal);
        buttonFaleConosco = findViewById(R.id.buttonFaleConosco);
        buttonCategoria = findViewById(R.id.button_categoria);
        buttonConsulta = findViewById(R.id.button_consulta);
        codigoProduto = findViewById(R.id.CodigoProduto);
        qtdeProduto = findViewById(R.id.QtdeProduto);
        precoUnitario = findViewById(R.id.PrecoUnitario);
        edValorTotal = findViewById(R.id.edValorTotal);
        buttonAdicionar = findViewById(R.id.button_adicionar);
        buttonQrcode = findViewById(R.id.button_qrcode);
        textViewValorTotalCarrinho = findViewById(R.id.textViewValorTotalCarrinho);
        carrinhoCompra = findViewById(R.id.carrinhoCompra);
        buttonPagar = findViewById(R.id.buttonPagar);
        textViewNomeProduto = findViewById(R.id.textViewNomeProduto);
        buttonOpcoes = findViewById(R.id.buttonOpcoes);
        buttonPedidos=findViewById(R.id.buttonPedidos);
        buttonCredoff= findViewById(R.id.buttoncredoff);
        buttonOffline= findViewById(R.id.buttonoff);
        precoUnitario.setEnabled(true);
        edValorTotal.setEnabled(true);
        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();

       // tvDataHoraPrincipal.setText(data+"       ");
        Log.d("MainActivity","tvDataHoraPrincipal bound = " + (tvDataHoraPrincipal!=null));
        //Timer();

    }

    private void ouvinteCliqueBotoes() {
        try {

            buttonFaleConosco.setOnClickListener(v -> {
                showPopupFaleConosco(v);
            });


            buttonCategoria.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, CatalogoActivity.class);
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY_TWO);
            });

            buttonConsulta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(MainActivity.this, LayoutActivity.class);
                    startActivityForResult(i, LAUNCH_SECOND_ACTIVITY);

                }
            });

            buttonAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (codigoProduto.getText().toString().trim().length() == 0)
                        return;

                    if (qtdeProduto.getText().toString().trim().length() > 0 && codigoProduto.getText().toString().trim().length() > 0) {


                        ItemCarrinho itemCarrinho = new ItemCarrinho();
                        itemCarrinho.setIdProduto(String.valueOf(produtoSelecionado.getId()));
                        itemCarrinho.setCodigoProduto(produtoSelecionado.getCodigo());
                        itemCarrinho.setValor(String.valueOf(produtoSelecionado.getValor()));
                        itemCarrinho.setQuantidade(qtdeProduto.getText().toString());
                        itemCarrinho.setUnidade(produtoSelecionado.getUnidade());
                        itemCarrinho.setNomeProduto(produtoSelecionado.getNome());
                        if (produtoSelecionado.getNome() != null)
                            adicionarItemCarrinho(itemCarrinho);
                        else
                            return;
                    }
                }
            });

            codigoProduto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        if (codigoProduto.getText().toString().length() == 13)
                            produtoSelecionado = produtoBancoController.getProdutoPorCodigoDeBarra(codigoProduto.getText().toString());
                        else
                            produtoSelecionado = produtoBancoController.getProdutoPorCodigo(codigoProduto.getText().toString());

                        if (produtoSelecionado != null && produtoSelecionado.getValor() != null) {
                            setInformacaoBusca(produtoSelecionado);
                        } else {
                            precoUnitario.setText("");
                            qtdeProduto.setText("");
                            textViewNomeProduto.setText("");
                            return;
                        }
                    }
                }
            });

            qtdeProduto.addTextChangedListener(new TextWatcher() {


                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    if (s.toString().trim().length() > 0) {

                        try {
                            float valorTotal = Float.parseFloat(precoUnitario.getText().toString()) * Integer.parseInt(s.toString());
                            atualizaValorCarrinho(valorTotal);

                        } catch (Exception e) {

                        }
                    }
                }
            });

            buttonQrcode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startCamera();
                }
            });

            buttonOffline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mApplication.getSetUp().getT_usaoff().equals("0")) {
                        mApplication.getSetUp().setT_usaoff("1");
                        alertaSucessoOpcao("Modo Offline Sefaz\nContingência");
                        buttonOffline.setBackgroundColor(Color.RED);
                    } else {
                        mApplication.getSetUp().setT_usaoff("0");
                        alertaSucessoOpcao("Modo Online Sefaz");
                        buttonOffline.setBackgroundColor(Color.GRAY);
                    }
                }
            });

            buttonCredoff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mApplication.getSetUp().getT_tef().equals("0")) {
                        mApplication.getSetUp().setT_tef("1");
                        alertaSucessoOpcao("Pagamento com Cartão Ativado");
                        buttonCredoff.setBackgroundColor(Color.GRAY);
                    } else {
                        mApplication.getSetUp().setT_tef("0");
                        alertaSucessoOpcao("Pagamento com Cartão Desativado");
                        buttonCredoff.setBackgroundColor(Color.RED);
                    }

                }

            });


            buttonPagar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if ((valorTotalCarrinho > 0) && (mApplication.getListaItemCarrinho().size() > 0)) {
                        Bundle data = new Bundle();
                        //  data.putParcelableArrayList("produtos", listaItemCarrinho);
                        Intent intent = new Intent(MainActivity.this, PagamentoActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);

                    }
                }
            });

            buttonPedidos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PedidosActivity.class);
                    startActivity(intent);
                }
            });


            buttonOpcoes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OpcoesActivity.class);
                    startActivity(intent);
                }
            });


       /* buttonPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PedidosActivity.class);
                startActivity(intent);
            }
        });*/

            /*buttonOpcoesCaixa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.activity_opcoes_caixa);
                    //Intent intent = new Intent(OpcoesActivity.this,OpcoesActivity.class);
                    //startActivity(intent);
                }
            });*/

        }catch (Exception e) {
            Log.e("MainActivity", "Erro ao configurar listeners: " + e.getMessage());
        }



    }

    private void atualizaValorCarrinho(float valor) {
        edValorTotal.setText(String.valueOf(valor));
        valorTotalCarrinho = valorTotalCarrinho + valor;
    }

    private void setInformacaoBusca(ProdutoEntidade item) {

        if (item != null) {

            if (item.getValor() != null) {
                precoUnitario.setText(String.valueOf(item.getValor()));

            }

            if (item.getNome() != null) {
                textViewNomeProduto.setText(item.getNome());
            }


            if (item.getCodigo() != null && item.getCodigo().trim().length() > 0) {
                codigoProduto.setText(item.getCodigo());
                qtdeProduto.requestFocus();

            }
        }

    }

    @Override
    public void onRemoverItem(ItemCarrinho itemCarrinho) {

        mApplication.removeItemCarrinho(itemCarrinho);
        valorTotalCarrinho = 0;

        for (ItemCarrinho item : mApplication.getListaItemCarrinho()) {

            valorTotalCarrinho += Float.parseFloat(item.getValor()) * Float.parseFloat(item.getQuantidade());
        }

        carrinhoAdapter.atualizaListaCarrinho(mApplication.getListaItemCarrinho());

        textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));


    }

    public void Encerrar(View view) {
        finish();
        System.exit(0);
    }

    public class Task extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = DateUtils.retornaDiaAtual();
                    String hora = DateUtils.retornaHoraAtual();
                    //textViewHoraPagamento.setText(data + "\n" + hora);
                    if (tvDataHoraPrincipal != null) {
                        tvDataHoraPrincipal.setText(data + "\n" + hora);
                    } else {
                        Log.w("MainActivity","tvDataHoraPrincipal is null in runnableTime");
                    }
                    handlerTime.postDelayed(this, 30000);


                    //tvDataHoraPrincipal.setText(data + "\n" + hora);
                    //Timer();
                }
            });
        }
    }

    public void Timer() {
        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if (requestCode == LAUNCH_SECOND_ACTIVITY) {
                if (resultCode == Activity.RESULT_OK) {
                    produtoSelecionado = data.getParcelableExtra("result");

                    codigoProduto.setText(produtoSelecionado.getCodigo());
                    precoUnitario.setText(String.valueOf(produtoSelecionado.getValor()));
                    textViewNomeProduto.setText(produtoSelecionado.getNome());
                    qtdeProduto.requestFocus();


                }
                if (resultCode == Activity.RESULT_CANCELED) {
                    // Write your code if there's no result
                }
            }  // ... dentro do onActivityResult ...
            else if(requestCode == LAUNCH_SECOND_ACTIVITY_TWO) {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    ArrayList<ProdutoEntidade> selecionados = data.getParcelableArrayListExtra("lista_selecionada");

                    if (selecionados != null && !selecionados.isEmpty()) {

                        // 1. Processamos a inserção na lista da Application
                        for (ProdutoEntidade p : selecionados) {
                            adicionarProdutoDiretoAoCarrinho(p);
                        }

                        // 2. Calculamos o total acumulado de uma só vez
                        // Isso evita rodar o loop de soma várias vezes desnecessariamente
                        float novoTotal = 0;
                        ArrayList<ItemCarrinho> listaAtual = mApplication.getListaItemCarrinho();

                        if (listaAtual != null) {
                            for (ItemCarrinho item : listaAtual) {
                                try {
                                    float v = Float.parseFloat(item.getValor());
                                    float q = Float.parseFloat(item.getQuantidade());
                                    novoTotal += (v * q);
                                } catch (Exception e) {
                                    Log.e("SOMA", "Erro ao somar item: " + item.getNomeProduto());
                                }
                            }
                        }

                        // 3. Atualizamos a variável global e a Interface de uma só vez
                        valorTotalCarrinho = novoTotal;
                        carrinhoAdapter.atualizaListaCarrinho(listaAtual);
                        textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
                    }
                }
            } else if (requestCode == IntentIntegrator.REQUEST_CODE) {
                IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

                if (intentResult.getContents() != null) {
                    Log.i(this.tipoCode, intentResult.getContents());

                    produtoSelecionado = produtoBancoController.getProdutoPorCodigoDeBarra(intentResult.getContents());

                    Log.i(this.tipoCode, "retorno erro " + produtoSelecionado.getNome() + " " + produtoSelecionado.getCodigo() + " " + produtoSelecionado.getValor());
                    if (produtoSelecionado != null) {
                        setInformacaoBusca(produtoSelecionado);
                    }


                } else {
                    Log.i(this.tipoCode, "retorno erro " + intentResult.getContents());
                }

            }

            super.onActivityResult(requestCode, resultCode, data);

        }



    private void startCamera() {
        qrScan = new IntentIntegrator(this);
        qrScan.setPrompt("Digitalizar o código ");
        qrScan.setBeepEnabled(true);
        qrScan.setBarcodeImageEnabled(true);
        qrScan.setTimeout(30000); // 30 * 1000 => 3 minuto
        qrScan.addExtra("FLASH_MODE_ON", FLASH_MODE_ON);
        qrScan.initiateScan(this.arrayListTipo);
    }

        private void abrePopPendente() {

            EnviarPagamentoPendentePopUp enviarPagamentoPendentePopUp = new EnviarPagamentoPendentePopUp(new EnviarPagamentoPendenteAcao() {
                @Override
                public void onEnviarPendente() {

                    enviarPagamentoPendente();
                }
            });

            enviarPagamentoPendentePopUp.show(getSupportFragmentManager(), "enviarPagamentoPendentePopUp");
        }

        private void enviarPagamentoPendente() {

            List<PendenteEntidade> pendenteEntidadeList = pendenteController.listaCarrinhoPendente();

            if (pendenteEntidadeList.size() > 0) {
                // .setVisibility(View.VISIBLE);

                for (PendenteEntidade item : pendenteEntidadeList) {

                    enviaPagamento(item);
                }

                //progressOpcoes.setVisibility(View.GONE);
            }


            if(pendenteEntidadeList.size() == 0) {

                alertaSucessoOpcao("Cupons Pendentes Transmitidos com Sucesso");
            }



        }


        private void enviaPagamento(PendenteEntidade pendenteEntidade) {


            Call<PagamentoCard> call = new RetrofitConfig(timeOut).getPDVService().enviaPagamento(
                    usuario,
                    senha,
                    codigo,
                    pendenteEntidade.getAcao(),
                    pendenteEntidade.getCarrinho(),
                    String.valueOf(pendenteEntidade.getTotal()),
                    String.valueOf(pendenteEntidade.getDesc()),
                    String.valueOf(pendenteEntidade.getTroco()),
                    pendenteEntidade.getIdf(),
                    pendenteEntidade.getIdnfe(),
                    pendenteEntidade.getCpf(),
                    OFF_LINE,
                    FORMATO


            );

            call.enqueue(new Callback<PagamentoCard>() {
                @Override
                public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {
                    PagamentoCard pagamentoCard = response.body();
                    if (CODIGO_SUCESSO.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {

                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                    }
                    if (CODIGO_ERRO_G11.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());

                    }

                }

                @Override
                public void onFailure(Call<PagamentoCard> call, Throwable t) {


                }
            });
        }

        private void alertaSucessoOpcao(String mensagem) {
            new AlertDialog.Builder(this)
                    .setTitle("Aviso")
                    .setMessage(mensagem)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();


        }

        private void adicionarProdutoDiretoAoCarrinho(ProdutoEntidade p) {
            if (p == null || p.getQuantidadeSelecionada() <= 0) return;
            ItemCarrinho item = new ItemCarrinho();
            item.setIdProduto(p.getCodigo());
            item.setCodigoProduto(p.getCodigo());
            item.setValor(String.valueOf(p.getValor()));
            item.setQuantidade(String.valueOf(p.getQuantidadeSelecionada()));
            item.setUnidade(p.getUnidade());
            item.setNomeProduto(p.getNome());
            mApplication.adicionaitemCarrinho(item);
        }

    public void showPopupFaleConosco(View v) {
        alertaSucessoOpcao("Fale Conosco\nLigue Whats (11)98791-8980");
    }
    }