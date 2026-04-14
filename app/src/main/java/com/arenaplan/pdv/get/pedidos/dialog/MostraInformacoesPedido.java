package com.arenaplan.pdv.get.pedidos.dialog;

import static com.arenaplan.pdv.get.util.Constantes.BUSCA_CLIENTE_PEDIDO;
import static com.arenaplan.pdv.get.util.Constantes.FECHAR_MESA;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;
import static com.arenaplan.pdv.get.util.Constantes.LISTA_CONSUMO;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_BUFOVERFLOW;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_LIFTHEAD;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_LOWTEMP;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_LOWVOL;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_MOTORERR;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_NOT_INIT;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_NO_PAPER;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_OVERHEAT;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_PAPERENDING;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_PAPERJAM;
import static com.arenaplan.pdv.get.util.Constantes.finalERROR_PARAM;
import static com.arenaplan.pdv.get.util.Constantes.finalUNKNOW;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.Pedido;
import com.arenaplan.pdv.get.api.model.RespostaClienteCard;
import com.arenaplan.pdv.get.api.model.RespostaPedidosCard;
import com.arenaplan.pdv.get.api.model.ResumoCaixa;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;
import com.arenaplan.pdv.get.util.Monetario;
import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.printer.AlignMode;
import com.getnet.posdigital.printer.IPrinterCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostraInformacoesPedido extends AppCompatActivity {
    private          String guardadatahora="";
    //private IGEDI iGedi = null;
    //private IPRNTR iPrint = null;
    //private GEDI_PRNTR_e_Status status;

    private int statuserro=0; //Status de erro da impressora
    //private ConfigPrint configPrint = new ConfigPrint();

    private LinearLayout nomeendereco;
    private LinearLayout bairrofone;

    private String usuario;
    private String codigo;
    private String senha;

    private String menumero;

    private String meclienteid;

    private String numeromesa;
    private String clienteid;
    private String apelido;
    ArenaplanPdvApplication mApplication;
    private int timeOut = 35;
    //private GertecPrinter gertecPrinter;

    private RespostaPedidosCard pedidos;
    private RespostaClienteCard cliente;
    //private ResumoCaixaAcao resumoCaixaAcao;
    private ResumoCaixa resumoCaixa;
    private String nomeEmpresa;

    //dados do cliente
    private String cnome;
    private String cfone;
    private String cendereco;
    private String cnumero;
    private String ccomplemento;
    private String cbairro;
    private String ccidade;
    private
    TextView x;
    private TextView cod1;
    private TextView cod2;
    private TextView cod3;
    private TextView cod4;
    private TextView cod5;
    private TextView cod6;
    private TextView cod7;
    private TextView cod8;
    private TextView cod9;
    private TextView cod10;
    private TextView cod11;
    private TextView cod12;
    private TextView cod13;
    private TextView nome1;
    private TextView nome2;
    private TextView nome3;
    private TextView nome4;
    private TextView nome5;
    private TextView nome6;
    private TextView nome7;
    private TextView nome8;
    private TextView nome9;
    private TextView nome10;
    private TextView nome11;
    private TextView nome12;
    private TextView nome13;
    private TextView valor1;
    private TextView valor2;
    private TextView valor3;
    private TextView valor4;
    private TextView valor5;
    private TextView valor6;
    private TextView valor7;
    private TextView valor8;
    private TextView valor9;
    private TextView valor10;
    private TextView valor11;
    private TextView valor12;
    private TextView valor13;
    private TextView qtde1;
    private TextView qtde2;
    private TextView qtde3;
    private TextView qtde4;
    private TextView qtde5;
    private TextView qtde6;
    private TextView qtde7;
    private TextView qtde;
    private TextView qtde9;
    private TextView qtde10;
    private TextView qtde11;
    private TextView qtde12;
    private TextView qtde13;
    private String nomeformatado;
    private Button buttonSair;
    private Button buttonEncerrar;
    private Button buttonImprimir;
    private Button buttonImprimirUltimo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pop_resumo_mesa);
        //mApplication =   (ArenaplanPdvApplication) mApplication.getApplicationContext();
        // LayoutInflater inflater = requireActivity().getLayoutInflater();
        //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //View view = inflater.inflate(R.layout.view_pop_resumo_mesa, null);
        //Bundle bundle = getIntent().getExtras();
        //numeromesa= getIntent().getStringExtra("numeromesa");
        mApplication = (ArenaplanPdvApplication) getApplicationContext();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();
        //menumero=mApplication.numeromesa;
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        numeromesa="";
        //meunumero = b.getString("numeromesa",meunumero);
        numeromesa= getIntent().getStringExtra("numeromesa");
        clienteid=getIntent().getStringExtra("clienteid");
        apelido=getIntent().getStringExtra("apelido");
        //String nomeformatado=nomeformatado.substring(apelido.indexOf("\\") + 1);

        //menumero="5";
        //GEDI.init(MostraInformacoesPedido.this);
        //gertecPrinter = new GertecPrinter(MostraInformacoesPedido.this);//this.getApplicationContext());
        //gertecPrinter.setConfigImpressao(configPrint);
        listarpedidos(numeromesa,clienteid);
        if ((!clienteid.equals("-"))&&(!clienteid.equals(null))&&(!clienteid.equals("null"))&&(!clienteid.equals("0"))){
            buscaclientid(clienteid);
            nomeendereco = findViewById(R.id.nomeendereco);
            nomeendereco.setVisibility(View.VISIBLE);
            x= findViewById(R.id.endtxt);
            x.setVisibility(View.VISIBLE);
            bairrofone = findViewById(R.id.bairrofone);
            bairrofone.setVisibility(View.VISIBLE);
        }else {
            if (!apelido.equals("")){
                nomeendereco = findViewById(R.id.nomeendereco);
                nomeendereco.setVisibility(View.VISIBLE);
                x= findViewById(R.id.endtxt);
                x.setVisibility(View.INVISIBLE);
                x = findViewById(R.id.nometxt);
                x.setVisibility(View.VISIBLE);
                x = findViewById(R.id.nomecliente);
                x.setText(String.valueOf(apelido));
                x.setVisibility(View.VISIBLE);
            }
        }
        pegaIdTela();
        cliqueBotao();
    }
    private void pegaIdTela() {
        buttonSair = findViewById(R.id.buttonSair);
        buttonImprimir = findViewById(R.id.buttonImprimir);
        buttonImprimirUltimo= findViewById(R.id.buttonImprimirUltimo);
        buttonEncerrar= findViewById(R.id.buttonEncerrar);
    }

    private void cliqueBotao() {
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buttonImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Impressao(pedidos);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        buttonImprimirUltimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ImpressaoUltimo(pedidos);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        buttonEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ProdutoBancoController produtoBancoController;
                    produtoBancoController = new ProdutoBancoController(MostraInformacoesPedido.this);
                   // MainActivity tela = null;
                    float totalcarrinho=0f;

                    int contador = 1;
                    for (Pedido item : pedidos.getPedidoCard().getPdPedido().getPedidoList()) {
                        if (item.getMpprid().toString().equals("-")) {
                            break;
                        }
                        ProdutoEntidade produtoEntidade =produtoBancoController.getProdutoPorCodigo((item.getMpprid().toString()));
                        ItemCarrinho itemCarrinho = new ItemCarrinho();
                        itemCarrinho.setCodigoProduto(item.getMpprid().toString());
                        itemCarrinho.setQuantidade(item.getMpprqtde().toString());
                        itemCarrinho.setUnidade(produtoEntidade.getUnidade());
                        itemCarrinho.setNomeProduto(item.getMpnome().toString());
                        itemCarrinho.setIdProduto(String.valueOf(item.getMpprid().toString())); //produtoEntidade.getId()));
                        itemCarrinho.setValor(item.getMpprvalor().toString());
                        //Float.parseFloat(produtoEntidade.getValor()) * Float.parseFloat(produtoEntidade.getQuantidade());
                        totalcarrinho=totalcarrinho+Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString());
                        mApplication.adicionaitemCarrinho(itemCarrinho);
                    }
                    //tela.MudaValorTotalCarrinho_Mesa(totalcarrinho);
                    //textViewValorTotalCarrinho.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
                    mApplication.ModoFechaMesa="1";
                    fecharmesa(numeromesa);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void fecharmesa(String menumero) {
        Call<RespostaPedidosCard> call = new RetrofitConfig(timeOut).getPDVService().fechar_mesa(
                usuario,
                senha,
                codigo,
                FECHAR_MESA,
                menumero,
                FORMATO
        );
        call.enqueue(new Callback<RespostaPedidosCard>() {
            @Override
            public void onResponse(Call<RespostaPedidosCard> call, Response<RespostaPedidosCard> response) {
                alerta("Fecha "+menumero+" Encerrada");
                finish();
            }
            @Override
            public void onFailure(Call<RespostaPedidosCard> call, Throwable t) {
                alerta("Não existe pedido nesta mesa");
            }
        });
    }



      private void alerta(String mensagem) {
           new androidx.appcompat.app.AlertDialog.Builder(this)
                   .setTitle("botao: ")
                   .setMessage(mensagem)
                   .setPositiveButton("ok", null)
                   .show();
       }

    private void buscaclientid(String clienteid) {
        Call<RespostaClienteCard> call = new RetrofitConfig(timeOut).getPDVService().detalha_cliente_mesa(
                usuario,
                senha,
                codigo,
                BUSCA_CLIENTE_PEDIDO,
                clienteid,
                FORMATO
        );
        call.enqueue(new Callback<RespostaClienteCard>() {
            @Override
            public void onResponse(Call<RespostaClienteCard> call, Response<RespostaClienteCard> response) {
                RespostaClienteCard clienteParam = response.body();
                 //cliente= clienteParam;
                 cnome=clienteParam.getClienteCard().getnome();
                 cfone=clienteParam.getClienteCard().getcelular();
                 cendereco=clienteParam.getClienteCard().getEndereco();
                 cnumero=clienteParam.getClienteCard().getNumero();
                 ccomplemento=clienteParam.getClienteCard().getComplemento();
                 cbairro=clienteParam.getClienteCard().getBairro();
                 ccidade=clienteParam.getClienteCard().getCidade();
                x = findViewById(R.id.nomecliente);
                x.setText(String.valueOf(cnome));
                x = findViewById(R.id.fone);
                x.setText(String.valueOf(cfone));
                x = findViewById(R.id.endereco);
                x.setText(String.valueOf(cendereco));
                x = findViewById(R.id.numero);
                x.setText(String.valueOf(cnumero));
                x = findViewById(R.id.complemento);
                x.setText(String.valueOf(ccomplemento));
                x = findViewById(R.id.bairro);
                x.setText(String.valueOf(cbairro));
                x = findViewById(R.id.cidade);
                x.setText(String.valueOf(ccidade));
                //alerta("atualizou mesas");
            }
            @Override
            public void onFailure(Call<RespostaClienteCard> call, Throwable t) {
                alerta("Erro ao carregar dados do cliente");
            }
        });
    }


    private void listarpedidos(String menumero,String clienteid) {
        Call<RespostaPedidosCard> call = new RetrofitConfig(timeOut).getPDVService().lista_consumo(
                usuario,
                senha,
                codigo,
                LISTA_CONSUMO,
                menumero,
                FORMATO
        );
        call.enqueue(new Callback<RespostaPedidosCard>() {
            @Override
            public void onResponse(Call<RespostaPedidosCard> call, Response<RespostaPedidosCard> response) {
                RespostaPedidosCard pedidosParam = response.body();
                pedidos = pedidosParam;

                MostraPopupItensdaMesa(pedidosParam,clienteid);
                //alerta("atualizou mesas");
            }
            @Override
            public void onFailure(Call<RespostaPedidosCard> call, Throwable t) {
                alerta("Não existe pedido nesta mesa");
            }
        });
    }


    private void alertaERROIMPRESSORA(String mensagem) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            mApplication.limpaCarrinhoSessao();
                            finish();
                            dialog.dismiss();
                            //return;
                        } catch (Exception e) {
                            throw new RuntimeException(e);

                        }
                    }
                })
                .show();
    }

    private void Mensagem_Erro(int statuserro) throws RemoteException {
        switch (statuserro) {
            case finalERROR_NOT_INIT:
                alertaERROIMPRESSORA("Impressora Não Iniciada.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_OVERHEAT:
                alertaERROIMPRESSORA("Impressora Super Aquecida.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_BUFOVERFLOW:
                alertaERROIMPRESSORA("Fila de Impressão muito grande.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_PARAM:
                SystemClock.sleep(300);
                alertaERROIMPRESSORA("Parâmetros Incorretos.\nReimprima Depois o Cupom em Opções.");
                break;
            case finalERROR_LIFTHEAD:
                alertaERROIMPRESSORA("Porta de Impressora Aberta.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_LOWVOL:
                alertaERROIMPRESSORA("Sem bateria suficiente para impressão.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_LOWTEMP:
                alertaERROIMPRESSORA("Temperatura baixa demais para impressão.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_MOTORERR:
                alertaERROIMPRESSORA("Motor de Passo com problemas.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                finish();
                break;
            case finalERROR_NO_PAPER:
                alertaERROIMPRESSORA("Sem bobina de papel.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_PAPERENDING:
                alertaERROIMPRESSORA("Bobina acabando");
                SystemClock.sleep(300);
                break;
            case finalERROR_PAPERJAM:
                alertaERROIMPRESSORA("Bobina travando.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
            case finalUNKNOW:
                alertaERROIMPRESSORA("Não foi possível definir erro de Impressão.\nReimprima Depois o Cupom em Opções");
                SystemClock.sleep(300);
                break;
        }
    }
    private void alertaERROIMPRESSORAGETNET(String mensagem) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                })
                .show();
    }

    private void Mensagem_Erro_ImpressoraGETNET(int statuserro) throws RemoteException {
        switch (statuserro) {
            case finalERROR_NOT_INIT:
                alertaERROIMPRESSORAGETNET("Impressora Não Iniciada.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_OVERHEAT:
                alertaERROIMPRESSORAGETNET("Impressora Super Aquecida.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_BUFOVERFLOW:
                alertaERROIMPRESSORAGETNET("Fila de Impressão muito grande.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_PARAM:
                SystemClock.sleep(300);
                alertaERROIMPRESSORAGETNET("Parâmetros Incorretos.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                break;
            case finalERROR_LIFTHEAD:
                alertaERROIMPRESSORAGETNET("Porta de Impressora Aberta.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_LOWVOL:
                alertaERROIMPRESSORAGETNET("Sem bateria suficiente para impressão.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_LOWTEMP:
                alertaERROIMPRESSORAGETNET("Temperatura baixa demais para impressão.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_MOTORERR:
                alertaERROIMPRESSORAGETNET("Motor de Passo com problemas.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                finish();
                break;
            case finalERROR_NO_PAPER:
                alertaERROIMPRESSORAGETNET("Sem bobina de papel.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalERROR_PAPERENDING:
                alertaERROIMPRESSORAGETNET("Bobina acabando");
                SystemClock.sleep(300);
                break;
            case finalERROR_PAPERJAM:
                alertaERROIMPRESSORAGETNET("Bobina travando.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
            case finalUNKNOW:
                alertaERROIMPRESSORAGETNET("Não foi possível definir erro de Impressão.\nReimprima Depois o Recibo TEF em Pagamento Opções");
                SystemClock.sleep(300);
                break;
        }
    }

    private void Impressao(RespostaPedidosCard pedidos) throws Exception{
        try {
            if (PosDigital.getInstance().isInitiated()) {
                try{
                        PosDigital.getInstance().getPrinter().init();
                        ProdutoBancoController produtoBancoController;
                        produtoBancoController = new ProdutoBancoController(MostraInformacoesPedido.this);

                        //iGedi = GEDI.getInstance(MostraInformacoesPedido.this);
                        //ICL mCL = iGedi.getCL();
                        //  try {
                        //iGedi = GEDI.getInstance(MostraInformacoesPedido.this);
                        //mCL = iGedi.getCL();
                        //  try {
                        //IPRNTR iprntr;
                        //mCL.PowerOff();
                        //iprntr = iGedi.getPRNTR();
                        //iprntr.Init();

                        /*configPrint.setItalico(false);
                        configPrint.setNegrito(true);
                        configPrint.setTamanho(80);
                        configPrint.setFonte("Courier_Prime");
                        GEDI_PRNTR_st_StringConfig strconfig = new GEDI_PRNTR_st_StringConfig(new Paint());*/
                        //strconfig.paint.setTextSize(20);
                        //strconfig.paint.setFontFeatureSettings("MONOSPACE");
                        //strconfig.paint.setTextAlign(Paint.Align.valueOf("CENTER"));
                        //strconfig.offset = 0;
                        //strconfig.lineSpace = 0;
                        float totalcarrinho=0f;
                        //configPrint.setNegrito(true);
                        //gertecPrinter.setConfigImpressao(configPrint);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "-------------------------------------");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, " Consumo da Mesa/Comanda "+numeromesa);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "-------------------------------------");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "N  Produto      Qtde VlUnt Tot");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                        String a,b,c,d,e;
                        String t = "";
                               // float e;
                        int contador=1;
                        String obs="";
                        for (Pedido item : pedidos.getPedidoCard().getPdPedido().getPedidoList()) {
                            if (item.getMpprid().toString().equals("-")) {
                                break;
                            }
                            ProdutoEntidade produtoEntidade =produtoBancoController.getProdutoPorCodigo((item.getMpprid().toString()));
                            ItemCarrinho itemCarrinho = new ItemCarrinho();
                            totalcarrinho=totalcarrinho+Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString());
                            String nome=item.getMpnome().toString();
                            int contanome=nome.length();
                            if (contanome<12){
                                for(contanome=contanome; contanome<12; contanome++){
                                    nome=nome+".";
                                }
                            }
                            a=String.format("%-12s",nome);
                            b=String.format("%04d", Integer.parseInt(item.getMpprqtde().toString()));
                            c=String.format("%4.2f",Float.parseFloat(item.getMpprvalor().toString()));
                            d=String.format("%02d", contador);
                            d=String.format("%02d", contador);
                            e=String.format("%4.2f",Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString()));
                            t=String.format("%4.2f",totalcarrinho);

                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, d +" "+ a + " " + b + " " + c+" "+e );
                            //
                            contador++;
                            obs=item.getMpobs().toString();
                        }
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"-------------------------------------");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"Total.................R$"+t);
                        //if (!clienteid.equals("0")) {
                        if ((!clienteid.equals("-"))&&(!clienteid.equals(null))&&(!clienteid.equals("null"))&&(!clienteid.equals("0"))){
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                            //if ((!cnome.equals(""))&&(!cendereco.equals(""))){
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Entregar em:");
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Nome: " + cnome);
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "End.: " + cendereco);
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "       " + cnumero + "/" + ccomplemento);
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Bair: " + cbairro);
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Cid.: " + ccidade);
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Fone: " + cfone);
                            //}
                        }
                        else{
                            if (!x.equals("")) { //mostrar o apelido se houver
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Entregar em:");
                                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Nome: " + apelido);
                            }
                        }
                    if (!obs.equals("")){
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"Obs..: " + obs);
                    }
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    //PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    //PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                        @Override
                        public void onSuccess() throws RemoteException {
                            //Vai mostrar aviso de fim e solicitar 2a via cupom fiscal
                            try {
                                statuserro = PosDigital.getInstance().getPrinter().getStatus();
                            } catch (RemoteException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        @Override
                        public void onError(int i) throws RemoteException {
                            int statuserro = PosDigital.getInstance().getPrinter().getStatus();
                            if (statuserro != 0) {
                                Mensagem_Erro(statuserro);
                            } else {
                                mApplication.limpaCarrinhoSessao();
                                finish(); // ENCERRA E VOLTA PRA HOME
                            }
                        }
                    });
                    } catch (Exception e) {
                        statuserro = PosDigital.getInstance().getPrinter().getStatus();
                        if (statuserro != 0) {
                            Mensagem_Erro(statuserro);
                        } else {
                            mApplication.limpaCarrinhoSessao();
                            finish(); // ENCERRA E VOLTA PRA HOME
                        }
                        //return;
                    }


                } else {
                    // falha no service de impressão
                    // refaça o start da activity que
                    // extende a BaseActivity para reconectar o service
                    //openErrorDialog("Falha na impressão\n Tente novamente.")
                    statuserro = PosDigital.getInstance().getPrinter().getStatus();
                    if (statuserro != 0) {
                        Mensagem_Erro(statuserro);
                    } else {
                        mApplication.limpaCarrinhoSessao();
                        finish(); // ENCERRA E VOLTA PRA HOME
                    }
                }

        } catch (Exception e) {
            statuserro = PosDigital.getInstance().getPrinter().getStatus();
            if (statuserro != 0) {
                Mensagem_Erro(statuserro);
            } else {
                mApplication.limpaCarrinhoSessao();
                finish(); // ENCERRA E VOLTA PRA HOME
            }

        }

    }
    private void ImpressaoUltimo(RespostaPedidosCard pedidos) throws Exception{
        try {
            if (PosDigital.getInstance().isInitiated()) {
                try{
                    PosDigital.getInstance().getPrinter().init();
                    ProdutoBancoController produtoBancoController;
                    produtoBancoController = new ProdutoBancoController(MostraInformacoesPedido.this);

                    //iGedi = GEDI.getInstance(MostraInformacoesPedido.this);
                    //ICL mCL = iGedi.getCL();
                    //  try {
                    //iGedi = GEDI.getInstance(MostraInformacoesPedido.this);
                    //mCL = iGedi.getCL();
                    //  try {
                    //IPRNTR iprntr;
                    //mCL.PowerOff();
                    //iprntr = iGedi.getPRNTR();
                    //iprntr.Init();

                        /*configPrint.setItalico(false);
                        configPrint.setNegrito(true);
                        configPrint.setTamanho(80);
                        configPrint.setFonte("Courier_Prime");
                        GEDI_PRNTR_st_StringConfig strconfig = new GEDI_PRNTR_st_StringConfig(new Paint());*/
                    //strconfig.paint.setTextSize(20);
                    //strconfig.paint.setFontFeatureSettings("MONOSPACE");
                    //strconfig.paint.setTextAlign(Paint.Align.valueOf("CENTER"));
                    //strconfig.offset = 0;
                    //strconfig.lineSpace = 0;
                    float totalcarrinho=0f;
                    //configPrint.setNegrito(true);
                    //gertecPrinter.setConfigImpressao(configPrint);
                    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "-------------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, " Consumo da Mesa/Comanda "+numeromesa);
                    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "-------------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "N  Produto      Qtde VlUnt Tot");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                    String a,b,c,d,e;
                    String obs="";
                    String t = "";
                    // float e;
                    int contador=1;
                    for (Pedido item : pedidos.getPedidoCard().getPdPedido().getPedidoList()) {
                        //para armazenar a data hora do ultimo pedido
                        guardadatahora=item.getMpdatahora().toString();
                    }
                    for (Pedido item : pedidos.getPedidoCard().getPdPedido().getPedidoList())
                      if (item.getMpdatahora().toString().equals(guardadatahora)) {
                            if (item.getMpprid().toString().equals("-")) {
                                break;
                            }
                        if (item.getMpprid().toString().equals("-")) {
                            break;
                        }
                        ProdutoEntidade produtoEntidade =produtoBancoController.getProdutoPorCodigo((item.getMpprid().toString()));
                        ItemCarrinho itemCarrinho = new ItemCarrinho();
                        totalcarrinho=totalcarrinho+Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString());
                        String nome=item.getMpnome().toString();
                        int contanome=nome.length();
                        if (contanome<12){
                            for(contanome=contanome; contanome<12; contanome++){
                                nome=nome+".";
                            }
                        }
                        a=String.format("%-12s",nome);
                        b=String.format("%04d", Integer.parseInt(item.getMpprqtde().toString()));
                        c=String.format("%4.2f",Float.parseFloat(item.getMpprvalor().toString()));
                        d=String.format("%02d", contador);
                        d=String.format("%02d", contador);
                        e=String.format("%4.2f",Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString()));
                        t=String.format("%4.2f",totalcarrinho);

                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, d +" "+ a + " " + b + " " + c+" "+e );
                        //
                        contador++;
                        obs = item.getMpobs().toString();

                    }
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"-------------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"Total.................R$"+t);
                    //if (!clienteid.equals("0")) {
                    if ((!clienteid.equals("-"))&&(!clienteid.equals(null))&&(!clienteid.equals("null"))&&(!clienteid.equals("0"))){
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                        //if ((!cnome.equals(""))&&(!cendereco.equals(""))){
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Entregar em:");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Nome: " + cnome);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "End.: " + cendereco);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "       " + cnumero + "/" + ccomplemento);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Bair: " + cbairro);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Cid.: " + ccidade);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Fone: " + cfone);
                        //}
                    }
                    else{
                        if (!x.equals("")) { //mostrar o apelido se houver
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Entregar em:");
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Nome: " + apelido);
                        }
                    }
                    if (!obs.equals("")){
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT,"Obs..: " + obs);
                    }
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "-------------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    //PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    //PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                        @Override
                        public void onSuccess() throws RemoteException {
                            //Vai mostrar aviso de fim e solicitar 2a via cupom fiscal
                            try {
                                statuserro = PosDigital.getInstance().getPrinter().getStatus();
                            } catch (RemoteException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        @Override
                        public void onError(int i) throws RemoteException {
                            int statuserro = PosDigital.getInstance().getPrinter().getStatus();
                            if (statuserro != 0) {
                                Mensagem_Erro(statuserro);
                            } else {
                                mApplication.limpaCarrinhoSessao();
                                finish(); // ENCERRA E VOLTA PRA HOME
                            }
                        }
                    });
                } catch (Exception e) {
                    statuserro = PosDigital.getInstance().getPrinter().getStatus();
                    if (statuserro != 0) {
                        Mensagem_Erro(statuserro);
                    } else {
                        mApplication.limpaCarrinhoSessao();
                        finish(); // ENCERRA E VOLTA PRA HOME
                    }
                    //return;
                }


            } else {
                // falha no service de impressão
                // refaça o start da activity que
                // extende a BaseActivity para reconectar o service
                //openErrorDialog("Falha na impressão\n Tente novamente.")
                statuserro = PosDigital.getInstance().getPrinter().getStatus();
                if (statuserro != 0) {
                    Mensagem_Erro(statuserro);
                } else {
                    mApplication.limpaCarrinhoSessao();
                    finish(); // ENCERRA E VOLTA PRA HOME
                }
            }

        } catch (Exception e) {
            statuserro = PosDigital.getInstance().getPrinter().getStatus();
            if (statuserro != 0) {
                Mensagem_Erro(statuserro);
            } else {
                mApplication.limpaCarrinhoSessao();
                finish(); // ENCERRA E VOLTA PRA HOME
            }

        }

    }


    @SuppressLint("WrongViewCast")
    private void MostraPopupItensdaMesa(RespostaPedidosCard pedidos, String clienteid) {
        //mApplication.adicionaitemMesa(itemMesa);
        //RepostaMesaCard mesa = response.body();
        /*if (!clienteid.equals("-")) {
            buscaclientid(clienteid);
            x = findViewById(R.id.nomecliente);
            x.setText(String.valueOf(cnome));
            x = findViewById(R.id.fone);
            x.setText(String.valueOf(cfone));
            x = findViewById(R.id.endereco);
            x.setText(String.valueOf(cendereco));
            x = findViewById(R.id.numero);
            x.setText(String.valueOf(cnumero));
            x = findViewById(R.id.complemento);
            x.setText(String.valueOf(ccomplemento));
            x = findViewById(R.id.bairro);
            x.setText(String.valueOf(cbairro));
            nomeendereco = findViewById(R.id.nomeendereco);
            nomeendereco.setVisibility(View.VISIBLE);
            bairrofone = findViewById(R.id.bairrofone);
            bairrofone.setVisibility(View.VISIBLE);
            //x = findViewById(R.id.cidade);
            //x.setText(String.valueOf(ccidade));
        }*/

        float valorTotalMesa = 0;
        int contador = 1;

        for (Pedido item : pedidos.getPedidoCard().getPdPedido().getPedidoList()) {
            if (item.getMpprid().toString().equals("-")) {
                break;
            }
            if (contador==1) {
                x = findViewById(R.id.cod2);
                x.setText(String.valueOf(contador));
                x = findViewById(R.id.nome2);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor2);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde2);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora2);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==2) {
                x = findViewById(R.id.cod3);
                x.setText(String.valueOf(contador));
                x = findViewById(R.id.nome3);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor3);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde3);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora3);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==3) {
                x = findViewById(R.id.cod4);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome4);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor4);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde4);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora4);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==4) {
                x = findViewById(R.id.cod5);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome5);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor5);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde5);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora5);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==5) {
                x = findViewById(R.id.cod6);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome6);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor6);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde6);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora6);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==6) {
                x = findViewById(R.id.cod7);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome7);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor7);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde7);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora7);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==7) {
                x = findViewById(R.id.cod8);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome8);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor8);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde8);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora8);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==8) {
                x = findViewById(R.id.cod9);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome9);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor9);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde9);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora9);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==9) {
                x = findViewById(R.id.cod10);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome10);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor10);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde10);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora10);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==10) {
                x = findViewById(R.id.cod11);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome11);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor11);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde11);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora11);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==11) {
                x = findViewById(R.id.cod12);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome12);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor12);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde12);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora12);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==12) {
                x = findViewById(R.id.cod13);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome13);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor13);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde13);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora13);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==13) {
                x = findViewById(R.id.cod14);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome14);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor14);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde14);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora14);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==14) {
                x = findViewById(R.id.cod15);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome15);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor15);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde15);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora15);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==15) {
                x = findViewById(R.id.cod16);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome16);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor16);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde16);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora16);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==16) {
                x = findViewById(R.id.cod17);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome17);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor17);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde17);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora17);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==17) {
                x = findViewById(R.id.cod18);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome18);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor18);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde18);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora18);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==18) {
                x = findViewById(R.id.cod19);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome19);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor19);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde19);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora19);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==19) {
                x = findViewById(R.id.cod20);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome20);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor20);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde20);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora20);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==20) {
                x = findViewById(R.id.cod21);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome21);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor21);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde21);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora21);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==21) {
                x = findViewById(R.id.cod22);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome22);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor22);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde22);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora22);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==22) {
                x = findViewById(R.id.cod23);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome23);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor23);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde23);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora23);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==23) {
                x = findViewById(R.id.cod24);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome24);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor24);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde24);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora24);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==24) {
                x = findViewById(R.id.cod25);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome25);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor25);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde25);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora25);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==25) {
                x = findViewById(R.id.cod26);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome26);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor26);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde26);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora26);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==26) {
                x = findViewById(R.id.cod27);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome27);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor27);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde27);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora27);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==27) {
                x = findViewById(R.id.cod28);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome28);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor28);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde28);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora28);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==28) {
                x = findViewById(R.id.cod29);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome29);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor29);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde29);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora29);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==29) {
                x = findViewById(R.id.cod30);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome30);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor30);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde30);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora30);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==30) {
                x = findViewById(R.id.cod31);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome31);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor31);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde31);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora31);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==31) {
                x = findViewById(R.id.cod32);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome32);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor32);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde32);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora32);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==32) {
                x = findViewById(R.id.cod33);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome33);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor33);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde33);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora33);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==33) {
                x = findViewById(R.id.cod34);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome34);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor34);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde34);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora34);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==34) {
                x = findViewById(R.id.cod35);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome35);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor35);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde35);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora35);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==35) {
                x = findViewById(R.id.cod36);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome36);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor36);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde36);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora36);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==36) {
                x = findViewById(R.id.cod37);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome37);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor37);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde37);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora37);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==37) {
                x = findViewById(R.id.cod38);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome38);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor38);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde38);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora38);
                x.setText(item.getMpdatahora().toString());
            }
            if (contador==38) {
                x = findViewById(R.id.cod39);
                x.setText(item.getMpprid().toString());
                x = findViewById(R.id.nome39);
                x.setText(item.getMpnome().toString());
                x = findViewById(R.id.valor39);
                x.setText(item.getMpprvalor());
                x = findViewById(R.id.qtde39);
                x.setText(item.getMpprqtde().toString());
                x = findViewById(R.id.datahora39);
                x.setText(item.getMpdatahora().toString());

                x = findViewById(R.id.cod40);
                x.setText("...");
                x = findViewById(R.id.nome40);
                x.setText("...");
                x = findViewById(R.id.valor40);
                x.setText("...");
                x = findViewById(R.id.qtde40);
                x.setText("...");
                x = findViewById(R.id.datahora40);
                x.setText("...");
            }
            valorTotalMesa=valorTotalMesa+Float.parseFloat(item.getMpprvalor().toString())*Float.parseFloat(item.getMpprqtde().toString());
            contador++;
        }
        x = findViewById(R.id.total);
        x.setText(String.valueOf(valorTotalMesa));
        x = findViewById(R.id.NumeroMesa);
        x.setText(numeromesa);
        x = findViewById(R.id.totaldamesa);
        //Monetario.converteValorFloatParaReal(valorTotalMesa)
        x.setText(String.valueOf(Monetario.converteValorFloatParaReal(valorTotalMesa)));
        if (pedidos.getPedidoCard().getPdPedido().getPedidoList()==null){
            alerta("Não há pedidos registrados");
            return;
        }

    }



  /*  private void pegaDadosView(View view) {
        textnome = view.findViewById(R.id.textnome);
        buttonSair = view.findViewById(R.id.buttonSair);  //buttonSair
        colocarDadosNaTela();
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alerta("teste");
                dismiss();
            }
        });
    }

    private void colocarDadosNaTela() {
        textnome.setText(textnome2);
    }
*/

}
