package com.arenaplan.pdv.get.pagamento;

import static com.arenaplan.pdv.get.R.id;
import static com.arenaplan.pdv.get.util.Constantes.ARG_CIDADE;
import static com.arenaplan.pdv.get.util.Constantes.ARG_CNPJ;
import static com.arenaplan.pdv.get.util.Constantes.ARG_EC;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NAME;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NUM_LOGIC;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NUM_SERIE;
import static com.arenaplan.pdv.get.util.Constantes.ARG_RAZAO_SOCIAL;
import static com.arenaplan.pdv.get.util.Constantes.ARG_VERSION;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G1;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G10;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G10_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G11;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G11_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G1_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G2;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G2_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G3;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G3_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G4;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G4_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G5;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G5_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G6;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G6_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G7;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G7_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G8;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G8_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G9;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G9_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.ERRO_GENERICO;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_CHEQUE;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_CREDITO;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_DEBITO;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_DINHEIRO;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_PIX;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_PRE_PAGA;
import static com.arenaplan.pdv.get.util.Constantes.REGISTRA_COMPRA_VOUCHER;
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
import static java.lang.Integer.parseInt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.Pagamento;
import com.arenaplan.pdv.get.api.model.PagamentoCard;
import com.arenaplan.pdv.get.database.ContadorController;
import com.arenaplan.pdv.get.database.PendenteController;
import com.arenaplan.pdv.get.database.entidades.ContadorEntidade;
import com.arenaplan.pdv.get.database.entidades.PendenteEntidade;
import com.arenaplan.pdv.get.ger7.Produto;
import com.arenaplan.pdv.get.pagamento.dialog.ConfirmaPagamento;
import com.arenaplan.pdv.get.pagamento.dialog.PopDinheiro;
import com.arenaplan.pdv.get.pagamento.dialog.PopInfo;
import com.arenaplan.pdv.get.pagamento.dialog.PopParcelamento;
import com.arenaplan.pdv.get.pagamento.dialog.PopParcelamentoCallBack;
import com.arenaplan.pdv.get.pagamento.dialog.PopStatusGetNet;
import com.arenaplan.pdv.get.pagamento.dialog.ResumoCompra;
import com.arenaplan.pdv.get.pagamento.dialog.TipoDocumento;
import com.arenaplan.pdv.get.pagamento.dialog.TipoDocumentoPagamento;
import com.arenaplan.pdv.get.pagamento.dialog.ValorInformado;
import com.arenaplan.pdv.get.pagamento.dialog.VerificaDocumento;
import com.arenaplan.pdv.get.pagamento.dialog.VerificaDocumentoPagamento;
import com.arenaplan.pdv.get.pagamento.dialog.Verifica_2Via_NFCe;
import com.arenaplan.pdv.get.pagamento.dialog.Verifica_2Via_NFCe_Fiscal;
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosInfoPop;
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosStatusGetNet;
import com.arenaplan.pdv.get.principal.modelo.ItemCarrinho;
import com.arenaplan.pdv.get.util.BaseActivity;
import com.arenaplan.pdv.get.util.CNF;
import com.arenaplan.pdv.get.util.CalculaDigitoVerificador;
import com.arenaplan.pdv.get.util.Constantes;
import com.arenaplan.pdv.get.util.DadosGetNet;
import com.arenaplan.pdv.get.util.DateUtils;
import com.arenaplan.pdv.get.util.Monetario;
import com.arenaplan.pdv.get.util.PreparaIdentificadorFiscal;
import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.printer.AlignMode;
import com.getnet.posdigital.printer.FontFormat;
import com.getnet.posdigital.printer.IPrinterCallback;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagamentoActivity extends BaseActivity {
    private static final int RESQUEST_CODE_PAGAMENTO = 1001;
    private static final int REQUEST_CODE_ESTORNO = 1002;

    private static final int REQUEST_CODE_STATUS = 1003;

    private static final int REQUEST_CODE_REIMPRIMIR = 1004;

    private static final int REQUEST_CODE_INFOS = 1005;
    private final String ARG_RESULT = "result";
    private final String ARG_RESULT_DETAILS = "resultDetails";
    private final String ARG_AMOUNT = "amount";
    private final String ARG_TYPE = "type";
    private final String ARG_INPUT_TYPE = "inputType";
    private final String ARG_INSTALLMENTS = "installments";
    private final String ARG_AUTHORIZATION_CODE = "authorizationCode";

    private final String ARG_NSU_PIX="transactionId";

    private TextView labelValorSubTotal;
    private TextView textViewHoraPagamento;
    private TextView labelValorDesconto;
    private TextView labelValorLiquido;

    private final String ARG_NSU = "nsu";
    private final String ARG_BRAND = "brand";

    private final String ARG_CV_NUMBER = "cvNumber";

    private String FORMATO_GET_NET = "json";

    private String cvNumeroEstorno = "";

    //Parametros retorno da API GER7
/*    private String t_oper;
    private String t_seq;
    private String t_aut;
    private String t_mod;
    private String t_par;*/
    private String BANDEIRA;
    private String NUMRRN;
    private String NUMAUTORIZACAO;
    private String MODALIDADE;
    private String NUMPARCELAS;
    private String resultado;
    private EditText edValorDescontoDigitado;
    private EditText edPercentualDesconto;
    private float valorTotalCarrinho = (float) 0.0;
    private float valorDesconto = (float) 0.0;
    private float valorLiquido = (float) 0.0;
    private float valorRecebido = (float) 0.0;
    private float valorTroco = (float) 0.0;
    private Button botaoDinheiro;
    private Button buttonCredito;
    private Button buttonDebito;
    private Button buttonVoucher;
    private Button buttonCheque;
    private Button buttonPrePago;
    private Button buttonPix;
    private Button buttonTEF;
    private Button buttonMODOOFF;
    private int timeOut = 35;
    private String codigo;
    private String usuario;
    private String senha;
    private String identificadorFiscal;
    private String carrinho;
    private String idnfe;
    private ConstraintLayout progressPagamento;
    ArenaplanPdvApplication mApplication;
    //ArenaplanPdvApplication ultimocallid;
    //private ConfigPrint configPrint;
    private String documento = "00000000000";
    private String tipoPagamento = "";
    long idTrs;
    private String cv = "";
    Menu menuopcoescartao;

    //variaveis da tela de parcelamento
    private TextView mResumoPedido;
    private TextView mTotal;
    private Button mBotaoTrs;
    private int parcelas = 0;
    private int tipoTransacao = 0;
    private int tipoParcela = 0;
    private int valorTotal = 0;
    private String idPedido = null;
    private String pedidoComprovante = null;
    private double valortotalcartaopagamento = 0.00;
    private String valortotalcartaopagamentostr;
    private String TIPODEPAGAMENTO;
    String reciboestabelecimento = null;
    String recibocliente = null;
    private int semaforo=0; //1=ligado (não pode usar) 0=desligado (pode usar recurso)
    private RadioGroup mProdutos;
    private int statuserro=0; //Status de erro da impressora


    private String deepLink = "getnet://pagamento/v3/payment";

    //private String deepLinkw = "https://www.escolasemfilas.com.br/site/api_hh/testagetnet.php";
    private String estorno = "getnet://pagamento/v1/refund";
    private String consultarStatus = "getnet://pagamento/v1/checkstatus";
    private String reimprime = "getnet://pagamento/v1/reprint";
    private String informacao = "getnet://pagamento/v1/getinfos";
    private Object group;
    private Object dialog;

    public PagamentoActivity() {
    }


    private void startIntent(Bundle bundle, String deeplink){ //},String amount) {
        try {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deepLink));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            //String amount;
  /*          Call<PagamentoCard> call = new RetrofitConfig(timeOut).getPDVService().testagetnet(
                    amount);
            call.enqueue(new Callback<PagamentoCard>() {
                @Override
                public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {

                }

                @Override
                public void onFailure(Call<PagamentoCard> call, Throwable t) {

                }
            });*/


            startActivityForResult(intent, RESQUEST_CODE_PAGAMENTO);
        } catch (Exception e) {
            Log.e("Pagamento", e.getMessage());
        }
    }

    private void startIntentEstorno() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(estorno));
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            startActivityForResult(intent, REQUEST_CODE_ESTORNO);
        } catch (Exception e) {
            Log.e("Pagamento", e.getMessage());
        }

    }

    private void startIntentConsutlaStatus(String callerId) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(consultarStatus));
            Bundle bundle = new Bundle();
            //String callerIdFormatado = String.format("%12s", callerId).replace(' ', '0');
            bundle.putString("callerId",callerId); // callerIdFormatado);
            //bundle.putString("allowPrintCurrentTransaction", "false");
            intent.putExtras(bundle);
            startActivityForResult(intent, REQUEST_CODE_STATUS);
        } catch (Exception e) {

        }
    }

    private void startIntentInfo() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(informacao));
            startActivityForResult(intent, REQUEST_CODE_INFOS);
        } catch (Exception e) {

        }
    }

    private void startReimprime() {
        try {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(reimprime));
            startActivityForResult(intent, REQUEST_CODE_REIMPRIMIR);
        } catch (Exception e) {

        }

    }

    private ArrayList<Produto> mPedido;
    private ListView listView;
    public int resultadopagcartao = 0; //status do resultado
    public int resulcartao = 0;

    //Function para retonar o valor total líquido da compra pro pagamento do cartao
    public float Valor_Liquido_Final() {
        return valorLiquido;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar_adm); ///Seta de retorno
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setTitle("");


        mApplication = (ArenaplanPdvApplication) getApplicationContext();
        //ultimocallid=(ArenaplanPdvApplication) getApplicationContext();
        pegarIdTela();
        colocaSubTotalTela();
        digitaDescontoOuPercentual();
        cliqueBotao();

    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this::onMenuItemClick);
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }


    //@Override
    public boolean onMenuItemClick(MenuItem item) { //onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int type = 0;
        try {

            switch (id) {

                case R.id.estorno:
                    startIntentEstorno();
                    break;
                case R.id.reimprimir:
                    startReimprime();
                    //type = 3;
                    break;
                case R.id.infos:
                    startIntentInfo();
                    //type = 4;
                    break;
                //case R.id.licenca:
                //  type = 5;
                //break;
                case R.id.status:
                    //ContadorController contadorController = new ContadorController(this);
                    //ContadorEntidade contadorEntidade = contadorController.getUltimoContador();
                    //pagamento.getIdent_fiscal()
                    startIntentConsutlaStatus(mApplication.ultimocallid); //PreparaIdentificadorFiscal.preparaIdentificadorFiscal(String.valueOf(contadorEntidade.getT_idf())));
                    type = 6;
                    break;
                default:
                    return super.onOptionsItemSelected(item);
              }
        } catch (Exception e) {
            //trataResultado(null);
        }
        return super.onOptionsItemSelected(item);
    }

       @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }


    public void fazerPedido() { //(View view) {
        carrinho = preparaProdutosEnvioCarrinho();
        idnfe = preparaChaveIdnfe();
        mApplication.Chave = idnfe;
        mApplication.Idfiscal = identificadorFiscal;

        Float value = valorTotalCarrinho - valorDesconto;
        String vtotal = String.format("%13s", Monetario.convertValorDuasCasas(value)).replace(' ', '0');


        if (tipoPagamento == "registra_compra_debito") {
            Bundle bundle = new Bundle();
            bundle.putString("paymentType", "debit");
            bundle.putString("installments", "1");
            //bundle.putString("amount", vtotal.toString().replace(".", ""));
            bundle.putString("amount", vtotal.toString().replace(".", "").replace(",",""));
            String callerIdFormatado = String.format("%12s", mApplication.Idfiscal).replace(' ', '0');
            mApplication.ultimocallid=callerIdFormatado;
            bundle.putString("callerId", callerIdFormatado);
            startIntent(bundle, deepLink); //w,vtotal.toString().replace(".", ""));
        } else if (tipoPagamento == "registra_compra_credito") {
            String Strparcelas;
            AbreTelaParcelamento(vtotal, mApplication.Idfiscal, value);
        } else if (tipoPagamento == "registra_compra_voucher") {
            Bundle bundle = new Bundle();
            bundle.putString("paymentType", "voucher");
            bundle.putString("installments", "1");
            bundle.putString("amount", vtotal.toString().replace(".", "").replace(",",""));
            String callerIdFormatado = String.format("%12s", mApplication.Idfiscal).replace(' ', '0');
            bundle.putString("callerId", callerIdFormatado);
            mApplication.ultimocallid=callerIdFormatado;
            startIntent(bundle, deepLink); //w,vtotal.toString().replace(".", ""));
        } else if (tipoPagamento == "registra_compra_pix") {

            Bundle bundle = new Bundle();
            bundle.putString("paymentType", "pix");
            bundle.putString("installments", "1");
            bundle.putString("amount", vtotal.toString().replace(".", "").replace(",",""));
            String callerIdFormatado = String.format("%12s", mApplication.Idfiscal).replace(' ', '0');
            bundle.putString("callerId", callerIdFormatado);
            mApplication.ultimocallid=callerIdFormatado;
            startIntent(bundle, deepLink); //w,vtotal.toString().replace(".", ""));
        }
    }

    private void AbreTelaParcelamento(String vtotal, String identificadorFiscal, Float value) {
        PopParcelamento popParcelamento = new PopParcelamento(
                identificadorFiscal,
                value,
                new PopParcelamentoCallBack() {
                    @Override
                    public void selectParcelamento(Integer value) {
                       String Strparcelas;
                        Strparcelas = Integer.toString(value);
                        Bundle bundle = new Bundle();
                        bundle.putString("paymentType", "credit");
                        if (!Strparcelas.equals("1"))
                            bundle.putString("creditType", "creditMerchant");//opcional se for a vista
                        bundle.putString("installments", Strparcelas);
                        bundle.putString("amount", vtotal.toString().replace(".", "").replace(",",""));
                        String callerIdFormatado = String.format("%12s", identificadorFiscal).replace(' ', '0');
                        bundle.putString("callerId", callerIdFormatado);
                        mApplication.ultimocallid=callerIdFormatado;
                        startIntent(bundle, deepLink); //w,vtotal.toString().replace(".", ""));

                    }
                });
        popParcelamento.show(getSupportFragmentManager(), "Pop Parcelamento");
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //PAGAMENTO COM CARTAO
        if (RESULT_OK == resultCode && RESQUEST_CODE_PAGAMENTO == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            if (result.equalsIgnoreCase("0")) {
                String resultDetails = data.getStringExtra(ARG_RESULT_DETAILS);
                String amount = data.getStringExtra(ARG_AMOUNT);
                String type = data.getStringExtra(ARG_TYPE);
                String inputType = data.getStringExtra(ARG_INPUT_TYPE);
                cv = data.getStringExtra(ARG_CV_NUMBER);
                cvNumeroEstorno = cv;
                if (data.getStringExtra(ARG_INSTALLMENTS)==null)
                    NUMPARCELAS="1";
                else
                    NUMPARCELAS = data.getStringExtra(ARG_INSTALLMENTS);
                NUMRRN = data.getStringExtra(ARG_AUTHORIZATION_CODE);
                NUMAUTORIZACAO = data.getStringExtra(ARG_NSU);
                BANDEIRA = data.getStringExtra(ARG_BRAND);
                //if (tipoPagamento == "registra_compra_pix") {
                //    Bundle bundle = new Bundle();
                //    NUMAUTORIZACAO=bundle.getString("Payload ","transactionId");
                //    NUMAUTORIZACAO = data.getStringExtra(ARG_NSU_PIX);
                //}
                MODALIDADE = "0";
                runThreadPagamento("Pagamento realizado com sucesso");
                semaforo = 0;
                //progressPagamento.setVisibility(View.GONE);
            } else {
                alertaGetNet(result);
                semaforo = 0;
                //progressPagamento.setVisibility(View.GONE);
            } //STATUS
        }

        if (RESULT_CANCELED == resultCode && RESQUEST_CODE_PAGAMENTO == requestCode) {
            alertaGetNet("3");
        }
        if (RESULT_OK == resultCode && REQUEST_CODE_STATUS == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            if (result.equalsIgnoreCase("0")) {
                DadosStatusGetNet dadosStatusGetNet = new DadosStatusGetNet();
                dadosStatusGetNet.setAmout(Monetario.converteValorRetornoGetNetParaReal(data.getStringExtra(Constantes.ARG_AMOUNT)));
                dadosStatusGetNet.setCallerid(data.getStringExtra(Constantes.ARG_CALLER_ID));
                dadosStatusGetNet.setNsu(data.getStringExtra(Constantes.ARG_NSU));
                dadosStatusGetNet.setNsulastsucessful(data.getStringExtra(Constantes.ARG_NSU_LAST_SUCESSFUL));
                dadosStatusGetNet.setCvnumber(data.getStringExtra(Constantes.ARG_CV_NUMBER));
                dadosStatusGetNet.setType(DadosGetNet.converteTipo(data.getStringExtra(Constantes.ARG_TYPE)));
                dadosStatusGetNet.setBrand(data.getStringExtra(Constantes.ARG_BRAND));
                dadosStatusGetNet.setInputtype(DadosGetNet.converteInputType(Constantes.ARG_INPUT_TYPE));
                dadosStatusGetNet.setInstallments(data.getStringExtra(Constantes.ARG_INSTALLMENTS));
                dadosStatusGetNet.setGmdatatime(DateUtils.converteHoraGetNet(Constantes.ARG_GMDATATIME));
                dadosStatusGetNet.setNsulocal(data.getStringExtra(Constantes.ARG_NSU_LOCAL));
                dadosStatusGetNet.setAutorizationcode(data.getStringExtra(Constantes.ARG_AUTORIZATION_CODE));
                dadosStatusGetNet.setCardbin(data.getStringExtra(Constantes.ARG_CARD_BIN));
                dadosStatusGetNet.setCardlastdigitis(data.getStringExtra(Constantes.ARG_CARDLAST_DIGITIS));
                dadosStatusGetNet.setExtrascreensresult(data.getStringExtra(Constantes.ARG_EXTRASCREENS_RESULT));
                dadosStatusGetNet.setCardholdername(data.getStringExtra(Constantes.ARG_CARD_HOLDER_NAME));
                dadosStatusGetNet.setAutomationslip(data.getStringExtra(Constantes.ARG_AUTOMATION_SLIP));
                PopStatusGetNet popStatusGetNet = new PopStatusGetNet(dadosStatusGetNet);
                popStatusGetNet.show(getSupportFragmentManager(), " Status Get Net");
            } else {
                alertaGetNet(result);
            }  //ESTORNO
        }
        if (RESULT_OK == resultCode && REQUEST_CODE_ESTORNO == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            if (result.equalsIgnoreCase("0")) {
                cvNumeroEstorno = "";
                alerta("Estorno realizado com sucesso");
            } else {
                alertaGetNet(result);
            }
            //REIMPRIMIR
        }
        if (RESULT_OK == resultCode && REQUEST_CODE_REIMPRIMIR == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            alerta("Reimpressão realizada com sucesso");
            //INFO
        }
        if (RESULT_OK == resultCode && REQUEST_CODE_INFOS == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            if (result.equalsIgnoreCase("0")) {
                DadosInfoPop dadosInfoPop = new DadosInfoPop();
                dadosInfoPop.setNumeroEstabelecimento(data.getStringExtra(ARG_EC));
                dadosInfoPop.setNumeroSerieEquipamento(data.getStringExtra(ARG_NUM_SERIE));
                dadosInfoPop.setNumeroLogicoEquipamento(ARG_NUM_LOGIC);
                dadosInfoPop.setVersaoApi(ARG_VERSION);
                dadosInfoPop.setCnpjEstabelecimentoVinculado(ARG_CNPJ);
                dadosInfoPop.setNomeEstabelecimentoVinculado(ARG_NAME);
                dadosInfoPop.setRazaoSocialEstabelecimento(ARG_RAZAO_SOCIAL);
                dadosInfoPop.setCidadeEstabelecimento(ARG_CIDADE);
                PopInfo popInfo = new PopInfo(dadosInfoPop);
                popInfo.show(getSupportFragmentManager(), " Info Get Net");
            } else {
                alertaGetNet(result);
            }
        }
    }


    private void alertaGetNet(String result) {
        switch (result) {
            case "1":
                alertaerropagamentogetnet("Transação negada");
                break;
            case "2":
                alertaerropagamentogetnet("Transação cancelada");
                break;
            case "3":
                alertaerropagamentogetnet("Falha ao Completar uma transação (internet, servidor ou operadora)");
                break;
            case "4":
                alertaerropagamentogetnet("Erro desconhecido");
                break;
            case "5":
                alertaerropagamentogetnet("Transação Pendente");
                break;
            default:
                alertaerropagamentogetnet("Erro desconhecido");
                break;
        }
    }


    private void cliqueBotao() {
        //progressPagamento.setVisibility(View.VISIBLE);
        botaoDinheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0){
                    semaforo=1;          //ocupado
                    carrinho = preparaProdutosEnvioCarrinho();
                    idnfe = preparaChaveIdnfe();
                    mApplication.Chave = idnfe;
                    mApplication.Idfiscal = identificadorFiscal;
                    tipoPagamento = REGISTRA_COMPRA_DINHEIRO;
                    if (valorLiquido<=10000)
                       abrePopVerificaDocumento(); //Pergunta se deseja CPF na nota
                    else alertaerropagamentogetnet("SEFAZ não aceita total acima de\nR$10mil para Pagto em Dinheiro");
                }
            }
        });

        buttonDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0) {
                    semaforo = 1;          //ocupado
                    //progressPagamento.setVisibility(View.VISIBLE);
                    tipoPagamento = REGISTRA_COMPRA_DEBITO;
                    if (mApplication.getSetUp().getT_tef().equals("1")) {
                        fazerPedido();
                    } else {
                        if (mApplication.getSetUp().getT_tef().equals("0")) {
                            carrinho = preparaProdutosEnvioCarrinho();
                            idnfe = preparaChaveIdnfe();
                            mApplication.Chave = idnfe;
                            mApplication.Idfiscal = identificadorFiscal;
                        }
                        abrePopVerificaDocumento(); //Pergunta se deseja CPF na nota
                    }
                }
            }
        });

        buttonCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0) {
                    semaforo = 1;          //ocupado
                    //progressPagamento.setVisibility(View.VISIBLE);
                    tipoPagamento = REGISTRA_COMPRA_CREDITO;
                    if (mApplication.getSetUp().getT_tef().equals("1")) {
                        fazerPedido();
                    } else {
                        if (mApplication.getSetUp().getT_tef().equals("0")) {
                            carrinho = preparaProdutosEnvioCarrinho();
                            idnfe = preparaChaveIdnfe();
                            mApplication.Chave = idnfe;
                            mApplication.Idfiscal = identificadorFiscal;
                        }
                        abrePopVerificaDocumento();//Pergunta se deseja CPF na nota
                    } //ACIONA PAGAMENTO CARTAO
                }
            }
        });

        buttonVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0) {
                    semaforo = 1;          //ocupado
                    //progressPagamento.setVisibility(View.VISIBLE);
                    tipoPagamento = REGISTRA_COMPRA_VOUCHER;
                    if (mApplication.getSetUp().getT_tef().equals("1")) {
                        fazerPedido();
                    } else {
                        if (mApplication.getSetUp().getT_tef().equals("0")) {
                            carrinho = preparaProdutosEnvioCarrinho();
                            idnfe = preparaChaveIdnfe();
                            mApplication.Chave = idnfe;
                            mApplication.Idfiscal = identificadorFiscal;
                        }
                        abrePopVerificaDocumento();//Pergunta se deseja CPF na nota
                    }
                }
            }
        });

        buttonCheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0) {
                    semaforo = 1;          //ocupado
                    //progressPagamento.setVisibility(View.VISIBLE);
                    carrinho = preparaProdutosEnvioCarrinho();
                    idnfe = preparaChaveIdnfe();
                    mApplication.Chave = idnfe;
                    mApplication.Idfiscal = identificadorFiscal;
                    tipoPagamento = REGISTRA_COMPRA_CHEQUE;
                    abrePopVerificaDocumento();//Pergunta se deseja CPF na nota
                }

            }
        });

        buttonPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semaforo==0) {
                    semaforo = 1;          //ocupado
                    //progressPagamento.setVisibility(View.VISIBLE);
                    tipoPagamento = REGISTRA_COMPRA_PIX;
                    //SE mApplication.getSetUp().getT_duplacripto().equals("1") indica que pagamento PIX SANTANDER
                    if ((mApplication.getSetUp().getT_tef().equals("1"))&&(mApplication.getSetUp().getT_duplacripto().equals("1"))) {
                        fazerPedido();
                    } else {
                        //if (mApplication.getSetUp().getT_tef().equals("0")) {
                            carrinho = preparaProdutosEnvioCarrinho();
                            idnfe = preparaChaveIdnfe();
                            mApplication.Chave = idnfe;
                            mApplication.Idfiscal = identificadorFiscal;
                        //}
                        abrePopVerificaDocumento();//Pergunta se deseja CPF na nota
                    }
                }
            }
        });

        buttonPrePago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progressPagamento.setVisibility(View.VISIBLE);

            }
        });


    }


    private void abreTelaResumo() {

        ResumoCompra resumoCompra = new ResumoCompra(valorTotalCarrinho, valorDesconto, valorLiquido, valorRecebido, valorTroco, new ConfirmaPagamento() {
            @Override
            public void confirmaPagamento() {

                progressPagamento.setVisibility(View.VISIBLE);
                enviaPagamento(null, null);
            }
        });
        resumoCompra.show(getSupportFragmentManager(), "Resumo Compra");
    }

    //enviaPagamento(null, null);
    private void pegarIdTela() {

        labelValorSubTotal = findViewById(id.labelValorSubTotal);
        textViewHoraPagamento = findViewById(id.textViewHoraPagamento);
        labelValorDesconto = findViewById(id.labelValorDesconto);
        labelValorLiquido = findViewById(id.labelValorLiquido);
        edValorDescontoDigitado = findViewById(id.edValorDescontoDigitado);
        edPercentualDesconto = findViewById(id.edPercentualDesconto);
        botaoDinheiro = findViewById(id.botaoDinheiro);
        buttonCredito = findViewById(id.buttonCredito);
        buttonDebito = findViewById(id.buttonDebito);
        buttonVoucher = findViewById(id.buttonVoucher);
        buttonCheque = findViewById(id.buttonCheque);
        buttonPrePago = findViewById(id.buttonPrePago);
        buttonPix = findViewById(id.buttonPix);
        progressPagamento = findViewById(id.progress_pagamento);


        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();

        textViewHoraPagamento.setText(data + "\n" + hora);
        Timer();

    }

    private void colocaSubTotalTela() {

        valorTotalCarrinho = 0;

        for (ItemCarrinho item : mApplication.getListaItemCarrinho()) {

            valorTotalCarrinho += Float.parseFloat(item.getValor()) * Float.parseFloat(item.getQuantidade());
        }

        labelValorSubTotal.setText(Monetario.converteValorFloatParaReal(valorTotalCarrinho));
        valorLiquido = valorTotalCarrinho;
        labelValorLiquido.setText(Monetario.converteValorFloatParaReal(valorLiquido));
        labelValorDesconto.setText(Monetario.converteValorFloatParaReal((float) 0.0));
    }

    private void digitaDescontoOuPercentual() {

        edValorDescontoDigitado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() > 0) {

                    informaDesconto(Float.parseFloat(edValorDescontoDigitado.getText().toString()));
                } else {
                    informaDesconto(0);
                }
            }
        });
        edPercentualDesconto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().trim().length() > 0) {


                    float percentual = Float.parseFloat(String.valueOf(edPercentualDesconto.getText()));

                    float calculoPercentual = percentual / 100;

                    float valorDesconto = valorTotalCarrinho * calculoPercentual;

                    informaDesconto(valorDesconto);


                } else {
                    informaDesconto(0);
                }

            }
        });


        edPercentualDesconto.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    informaDesconto(0);
                    edValorDescontoDigitado.setText("");
                }
            }
        });

        edValorDescontoDigitado.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    informaDesconto(0);
                    edPercentualDesconto.setText("");

                }
            }
        });

    }

    private void informaDesconto(float value) {

        valorDesconto = value;

        labelValorDesconto.setText(Monetario.converteValorFloatParaReal(valorDesconto));
        valorLiquido = valorTotalCarrinho - valorDesconto;
        labelValorLiquido.setText(Monetario.converteValorFloatParaReal(valorLiquido));
    }

    public void SairConfirmaRecebimento(View view) {
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

                    textViewHoraPagamento.setText(data + "\n" + hora);
                }
            });
        }
    }

    public void Timer() {
        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 30000);
    }

    private String preparaChaveIdnfe() {


        try {
            timeOut = Integer.valueOf(mApplication.getSetUp().getT_timeout());
        } catch (Exception e) {
            timeOut = 35;
        }

        usuario = mApplication.getSetUp().getT_login();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();

        ContadorController contadorController = new ContadorController(this);

        StringBuilder chave = new StringBuilder();

        // cuf
        chave.append(mApplication.getSetUp().getT_cuf());

        // ano corrente
        chave.append(DateUtils.pegaAnoAtual());

        // mes corrente
        chave.append(DateUtils.pegaMesAtual());

        //cnpj da empresa
        chave.append(mApplication.getSetUp().getT_cnpj());

        // danfe nfce
        chave.append("65");

        //número de serie

        chave.append(PreparaIdentificadorFiscal.preparaHH(mApplication.getSetUp().getT_serie()));

        // identificador fiscal

        ContadorEntidade contadorEntidade = contadorController.getUltimoContador();

        identificadorFiscal = PreparaIdentificadorFiscal.preparaIdentificadorFiscal(String.valueOf(contadorEntidade.getT_idf()));

        chave.append(identificadorFiscal);

        // atualizar o contador
        contadorController.atualizaContador(contadorEntidade);

        // numero fixo
        chave.append("1");

        //CNF são 9 digitos formatado assim: 99 (ano) + 99 (mês) + 4 Digitos randomicos

        String cnf = DateUtils.pegaAnoAtual() + DateUtils.pegaMesAtual() + CNF.getRandomicoCNF();
        chave.append(cnf);

        // digito verificador

        String digito = CalculaDigitoVerificador.calculaDigitoVerificador(chave.toString());

        chave.append(digito);


        return chave.toString();

    }

    private String preparaProdutosEnvioCarrinho() {

        String carrinho = "";


        for (ItemCarrinho itemCarrinho : mApplication.getListaItemCarrinho()) {

            if (carrinho.trim().length() > 0) {

                carrinho = carrinho + "p";
            }

            carrinho = carrinho + itemCarrinho.getCodigoProduto() + "*" + itemCarrinho.getQuantidade();


        }

        return carrinho;

    }

    private void enviaPagamento(String nsu, String cv) {
        statuserro=0;
        ///////////////////////////////////////
        //Se pagamento for Credito,Debito ou Voucher ou PIX
        ///////////////////////////////////////
        if ((tipoPagamento == "registra_compra_credito") || (tipoPagamento == "registra_compra_debito") || (tipoPagamento == "registra_compra_voucher") || (tipoPagamento == "registra_compra_pix")) {
            if (mApplication.getSetUp().getT_usaoff().equals("0")) { //Emissao online
                //if ((NUMPARCELAS.equals("")||(NUMPARCELAS.equals("null"))||(NUMPARCELAS.equals(null))))
                  //  NUMPARCELAS = "1";


                Call<PagamentoCard> call = new RetrofitConfig(timeOut).getPDVService().enviaPagamentoCartao(
                        usuario,
                        senha,
                        codigo,
                        tipoPagamento,
                        carrinho,
                        String.valueOf(valorTotalCarrinho),
                        String.valueOf(valorDesconto),
                        String.valueOf(valorTroco),
                        identificadorFiscal,
                        idnfe,
                        documento,
                        "normal",
                        BANDEIRA,
                        NUMAUTORIZACAO,
                        NUMRRN,
                        MODALIDADE,
                        NUMPARCELAS,
                        FORMATO_GET_NET);
                progressPagamento.setVisibility(View.VISIBLE);

                call.enqueue(new Callback<PagamentoCard>() {
                    @Override
                    public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {

                        PagamentoCard pagamentoCard = response.body();
                        // voce esta usando o carrinho lá em baixo entao deve se limpar o carrinho depois
                        // mApplication.limpaCarrinhoSessao();
                        if (CODIGO_SUCESSO.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                            // dados para imprimir o comprovante
                            SystemClock.sleep(300);
                            try {
                                //Pagamento pagamento = null;
                                Impressao(pagamentoCard, "1");
                                progressPagamento.setVisibility(View.GONE);
                            } catch (Exception e) {
                                progressPagamento.setVisibility(View.GONE);
                                e.printStackTrace();
                            }

                        } else {
                            String erro = pagamentoCard.getPagamento().getErrorCode();
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G1)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G1_MENSAGEM + "\n" + pagamentoCard.getPagamento().getMensagem());
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G2)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G2_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G3)) {
                                alerta(CODIGO_ERRO_G3_MENSAGEM);
                                Pagamento pagamento = null;
                                try {
                                    mApplication.Contingencia = "1";
                                    salvaPendente(NUMRRN,NUMAUTORIZACAO,BANDEIRA,MODALIDADE,NUMPARCELAS);
                                    Impressao(pagamentoCard, "1");
                                    mApplication.Contingencia = "0";
                                    progressPagamento.setVisibility(View.GONE);
                                    return;
                                } catch (Exception e) {
                                    alerta("Erro na Impressão do Cupom em Contingência");
                                    mApplication.limpaCarrinhoSessao();
                                    progressPagamento.setVisibility(View.GONE);
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G4)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G4_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G5)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G5_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G6)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G6_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G7)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G7_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G8)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G8_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G9)) {
                                // salvaPendente();
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G9_MENSAGEM);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G10)) {
                                Pagamento pagamento = null;
                                salvaPendente(NUMRRN,NUMAUTORIZACAO,BANDEIRA,MODALIDADE,NUMPARCELAS);
                                alertaERRONFCECONTINGENCIA(CODIGO_ERRO_G10_MENSAGEM, pagamentoCard);
                                progressPagamento.setVisibility(View.GONE);
                            }
                            if (erro.equalsIgnoreCase(CODIGO_ERRO_G11)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G11_MENSAGEM);
                            }
                            progressPagamento.setVisibility(View.GONE);
                            alertaERRONFCE(ERRO_GENERICO);//
                        }
                    }

                    @Override
                    public void onFailure(Call<PagamentoCard> call, Throwable t) {
                        PagamentoCard pagamentoCard = null;
                        alertaERRONFCE("Erro de Comunicação\nGerando Cupom em Contingência");
                        mApplication.Contingencia = "1";
                        try {
                            salvaPendente(NUMRRN,NUMAUTORIZACAO,BANDEIRA,MODALIDADE,NUMPARCELAS);//(nsu, cv);
                            Impressao(pagamentoCard, "1");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                        mApplication.Contingencia = "0";
                        progressPagamento.setVisibility(View.GONE);

                    }
                });
            } else {  //Contingencia
                //Pagamento pagamento = null;
                PagamentoCard pagamentoCard = null;
                try {
                    salvaPendente(NUMRRN,NUMAUTORIZACAO,BANDEIRA,MODALIDADE,NUMPARCELAS);
                    Impressao(pagamentoCard, "1"); //IMPRIME CUPOM FISCAL
                    progressPagamento.setVisibility(View.GONE);
                } catch (Exception e) {
                    alertaERRONFCE("Erro na Impressão do Cupom em Contingência");
                }
            }

            ///////////////////////////////////////
        } else { //Pagamento DINHEIRO, PREPAGO ou CHEQUE
            ///////////////////////////////////////
            if (mApplication.getSetUp().getT_usaoff().equals("0")) { //Emissao online
                Call<PagamentoCard> call = new RetrofitConfig(timeOut).getPDVService().enviaPagamento(
                        usuario,
                        senha,
                        codigo,
                        tipoPagamento,
                        carrinho,
                        String.valueOf(valorTotalCarrinho),
                        String.valueOf(valorDesconto),
                        String.valueOf(valorTroco),
                        identificadorFiscal,
                        idnfe,
                        documento,
                        "normal",
                        FORMATO_GET_NET);
                progressPagamento.setVisibility(View.VISIBLE);
                call.enqueue(new Callback<PagamentoCard>() {
                    @Override
                    public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {

                        PagamentoCard pagamentoCard = response.body();
                        // voce esta usando o carrinho lá em baixo entao deve se limpar o carrinho depois
                        // mApplication.limpaCarrinhoSessao();
                        if (CODIGO_SUCESSO.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                            // dados para imprimir o comprovante
                            progressPagamento.setVisibility(View.GONE);
                            try {
                                Pagamento pagamento = null;
                                Impressao(pagamentoCard, "1"); //IMPRIME CUPOM FISCAL
                            } catch (Exception e) {
                                progressPagamento.setVisibility(View.GONE);
                                e.printStackTrace();
                                return;
                            }

                        } else {
                            //String erro = pagamentoCard.getPagamento().getErrorCode();
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G1)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G1_MENSAGEM + "\n" + pagamentoCard.getPagamento().getMensagem());
                                mApplication.limpaCarrinhoSessao();
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G2)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G2_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G3)) {
                                alerta(CODIGO_ERRO_G3_MENSAGEM);
                                Pagamento pagamento = null;
                                try {
                                    mApplication.Contingencia = "1";
                                    salvaPendente(null,null,null,null,null);//(nsu, cv);
                                    Impressao(pagamentoCard, "1");//IMPRIME CUPOM FISCAL
                                    mApplication.Contingencia = "0";
                                    progressPagamento.setVisibility(View.GONE);
                                    //return;
                                } catch (Exception e) {
                                    alertaERRONFCE("Erro na Impressão do Cupom em Contingência");
                                    mApplication.limpaCarrinhoSessao();
                                    progressPagamento.setVisibility(View.GONE);
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G4)) {
                                salvaPendente(null,null,null,null,null); //(nsu, cv);
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G4_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G5)) {
                                //salvaPendente();
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G5_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G6)) {
                                //salvaPendente();
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G6_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G7)) {
                                //salvaPendente();
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G7_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G8)) {
                                salvaPendente(null,null,null,null,null); //(nsu, cv);
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G8_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G9)) {
                                //salvaPendente();
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G9_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G11)) {
                                progressPagamento.setVisibility(View.GONE);
                                alertaERRONFCE(CODIGO_ERRO_G11_MENSAGEM);
                                return;
                            }
                            if (pagamentoCard.getPagamento().getErrorCode().equals(CODIGO_ERRO_G10)) {
                                Pagamento pagamento = null;
                                alerta(CODIGO_ERRO_G10_MENSAGEM);
                                salvaPendente(null,null,null,null,null);;//(nsu, cv);
                                try {
                                    Impressao(pagamentoCard, "1");//IMPRIME CUPOM FISCAL
                                    progressPagamento.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return;
                            } else {
                                //salvaPendente();
                                try {
                                    Impressao(pagamentoCard, "1");//IMPRIME CUPOM FISCAL
                                    return;
                                    //alerta(ERRO_GENERICO);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PagamentoCard> call, Throwable t) {
                        alerta("Erro de Comunicacao\nGerando Cupom em Contingencia");
                        Pagamento pagamento = null;
                        try {
                            mApplication.Contingencia = "1";
                            salvaPendente(null,null,null,null,null);;  //(nsu, cv);
                            PagamentoCard pagamentoCard = null;
                            Impressao(pagamentoCard, "1");//IMPRIME CUPOM FISCAL
                            //Deseja_Imprimir_2avia(pagamento);//PERGUNTA SE DESEJA 2A VIA CUPOM FISCAL
                            mApplication.Contingencia = "0";
                            progressPagamento.setVisibility(View.GONE);
                        } catch (Exception e) {
                            alerta("Erro na Impressao do Cupom em Contingencia");
                            mApplication.limpaCarrinhoSessao();
                            progressPagamento.setVisibility(View.GONE);
                            e.printStackTrace();
                            return;
                        }
                    }
                });

            } else {  //Contingencia
                Pagamento pagamento = null;
                //alerta("Gerando Cupom em Contingencia");
                try {
                    salvaPendente(null,null,null,null,null); //(nsu, cv);
                    PagamentoCard pagamentoCard = null;
                    Impressao(pagamentoCard, "1");//IMPRIME CUPOM FISCAL

                    progressPagamento.setVisibility(View.GONE);
                } catch (Exception e) {
                    alerta("Erro na Geração do Cupom em Contingencia");
                    mApplication.limpaCarrinhoSessao();
                    progressPagamento.setVisibility(View.GONE);
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    //PagamentoCard pagamentoCard = response.body();
    private void Deseja_Imprimir_2aviaGETNET() {
        Dialog dialog = new Dialog(PagamentoActivity.this);// Dialog();
        Verifica_2Via_NFCe popVerificaViaNFCe = new Verifica_2Via_NFCe();
        popVerificaViaNFCe.setVia_do_ClienteNFCe(new Verifica_2Via_NFCe_Fiscal() {
            //@Override
            public void on2ViadoClienteNAO() throws Exception {
                startReimprime();
                abrePopVerificaDocumento(); //Pergunta se deseja CPF na nota
            }

            //@Override
            public void on2ViadoClienteSIM() throws Exception {
                        // Reimprime recibo GETNET
                abrePopVerificaDocumento(); //Pergunta se deseja CPF na nota
            }
        });

        popVerificaViaNFCe.show(getSupportFragmentManager(), "ImprimeVia_do_Cliente");
    }


    private void salvaPendente(String cv, String ns,String Bandeira,String Modalidade,String Parcelas) {
        PendenteController pendenteController = new PendenteController(PagamentoActivity.this);
        PendenteEntidade pendenteEntidade = new PendenteEntidade();
        pendenteEntidade.setAcao(tipoPagamento);
        pendenteEntidade.setCarrinho(carrinho);
        pendenteEntidade.setTotal(valorTotalCarrinho);
        pendenteEntidade.setDesc(valorDesconto);
        pendenteEntidade.setTroco(valorTroco);
        pendenteEntidade.setIdnfe(idnfe);
        pendenteEntidade.setIdf(identificadorFiscal);
        pendenteEntidade.setCpf(documento);
        pendenteEntidade.setTipo("normal");
        pendenteEntidade.setNsu(ns);
        pendenteEntidade.setCvNumber(cv);
        pendenteEntidade.setBand(Bandeira);
        pendenteEntidade.setModal(Modalidade);
        pendenteEntidade.setParcel(Parcelas);
        pendenteController.insereDado(pendenteEntidade);
    }

    private void alertaerropagamentogetnet(String mensagem) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContadorController contadorController = new ContadorController(PagamentoActivity.this); // Ele
                        ContadorEntidade contadorEntidade = contadorController.getUltimoContador();
                        contadorController.decrementaContador(contadorEntidade); // Eu criei a função pra decrementar no controller
                        mApplication.limpaCarrinhoSessao();
                        dialog.dismiss();
                        finish();
                    }
                })
                .show();
    }

    private void alerta(String mensagem) {
        new android.app.AlertDialog.Builder(this)
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

    private void alertaERRONFCE(String mensagem) {
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

    private void alertaERRONFCECONTINGENCIA(String mensagem, PagamentoCard pagamentoCard) {
        new AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Impressao(pagamentoCard, "1");
                        } catch (Exception e) {
                            throw new RuntimeException(e);

                        }
                    }
                })
                .show();
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

            private void runThread(String message,String via,PagamentoCard pagamentoCard){
                runOnUiThread (new Thread(new Runnable() {
                    public void run() {
                        alertaSucessoCupomFiscal(message,via,pagamentoCard);
                    }
                }));
            }


            private void alertaSucessoCupomFiscal(String message,String via,PagamentoCard pagamentoCard) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Aviso");
                builder.setMessage(message);
                builder.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            if (statuserro != 0) {
                                try {
                                    //dialog.dismiss();
                                    Mensagem_Erro(statuserro);
                                } catch (RemoteException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                if (via != "2") {
                                    Deseja_Imprimir_2avia(pagamentoCard, "2"); //Somente na 1a vez solicita
                                } else {
                                    mApplication.limpaCarrinhoSessao();
                                    finish();
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
        builder.show();

    }


    private void runThreadPagamento(String message){
        runOnUiThread (new Thread(new Runnable() {
            public void run() {
                alertaSucessoPagamento(message);
            }
        }));
    }

    private void alertaSucessoPagamento(String mensagem) {
        new AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.dismiss();
                        try {
                            if (PosDigital.getInstance().isInitiated()) {
                                try {
                                    PosDigital.getInstance().getPrinter().init();
                                    statuserro = PosDigital.getInstance().getPrinter().getStatus();
                                    if (statuserro != 0) {
                                        Mensagem_Erro_ImpressoraGETNET(statuserro);
                                        abrePopVerificaDocumento();
                                    } else {
                                        abrirPopSegundaViaGetNet();
                                    }
                                } catch (RemoteException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                abrePopVerificaDocumento();
                            }
                        } catch (Exception e) {
                            abrePopVerificaDocumento();
                            //throw new RuntimeException(e);
                        }
                    }
                })
                .show();

    }

    private void abrirPopSegundaViaGetNet() {
        Deseja_Imprimir_2aviaGETNET();
        //mApplication.limpaCarrinhoSessao();
    }


    public void Impressao(PagamentoCard pagamentoCard, String via) throws Exception {
        //int statuserro;
        try {
            if (PosDigital.getInstance().isInitiated()) {
                try {
                    PosDigital.getInstance().getPrinter().init();
                    statuserro = PosDigital.getInstance().getPrinter().getStatus();
                    if (statuserro != 0) {
                        //VAI MOSTRAR MENSAGEM do CUPOM PROCESSADO e checar o status da impressora
                        //Se status tiver erro roda alertaERROIMPRESSORA para encerrar sessao voltar ao menu
                        //Se nao tiver erro chama mensagem de pergunta se deseja 2a via cupom fiscal
                        if (mApplication.getSetUp().getT_usaoff().equals("0")) //"Cupom " + pagamentoCard.getPagamento().getIdent_fiscal().toString() + "
                            alertaSucessoCupomFiscal( "Processado com Sucesso!",via,pagamentoCard);
                        else
                            alertaSucessoCupomFiscal("Processado em CONTINGÊNCIA com Sucesso!",via,pagamentoCard);
                    } else {
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CNPJ:" + mApplication.getSetUp().getT_cnpj());
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_razao());
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Inscr.Estadual: " + mApplication.getSetUp().getT_inscricao());
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_endereco() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_complemento() + "," + mApplication.getSetUp().getT_bairro() + "," + mApplication.getSetUp().getT_cidade() + "," + mApplication.getSetUp().getT_uf());
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Documento Auxiliar da Nota");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Fiscal do Consumidor Eletronica");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Codigo Descr Qtd Un VlrUnt VltTot");
                        String carrinho = "";
                        Integer tamanhocarrinho = 0;
                        for (ItemCarrinho itemCarrinho : mApplication.getListaItemCarrinho()) {
                            if (carrinho.trim().length() > 0) {
                                carrinho = carrinho + "p";
                            }
                            carrinho = carrinho + itemCarrinho.getCodigoProduto() + "*" + itemCarrinho.getQuantidade();
                        }
                        for (ItemCarrinho itemCarrinho : mApplication.getListaItemCarrinho()) {
                            String CodigoPro;
                            DecimalFormat df = new DecimalFormat("0000000000000");
                            CodigoPro = df.format(parseInt(itemCarrinho.getCodigoProduto()));
                            String QtdePro;
                            DecimalFormat df2 = new DecimalFormat("000000");
                            QtdePro = df2.format(parseInt(itemCarrinho.getQuantidade()));
                            String Valor1;
                            DecimalFormat v1 = new DecimalFormat("####0.00");
                            Valor1 = v1.format(Double.parseDouble(itemCarrinho.getValor()));
                            String Valor2;
                            DecimalFormat v2 = new DecimalFormat("####0.00");
                            Valor2 = v2.format(parseInt(itemCarrinho.getQuantidade()) * Double.parseDouble(itemCarrinho.getValor()));

                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, CodigoPro + " " +
                                    itemCarrinho.getNomeProduto());
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "             " + QtdePro + " " +
                                    itemCarrinho.getUnidade() + " X R$" +
                                    Valor1 + " R$" + Valor2
                            );
                            tamanhocarrinho = tamanhocarrinho + 1;
                        }
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Qtd. total de itens:" + tamanhocarrinho);//carrinho.trim().length());
                        DecimalFormat sub = new DecimalFormat("####0.00");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "SubTotal           :R$" +
                                sub.format(Double.parseDouble(Float.toString(valorTotalCarrinho))));
                        DecimalFormat descon = new DecimalFormat("####0.00");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Desconto           :R$" +
                                descon.format(Double.parseDouble(Float.toString(valorDesconto))));
                        DecimalFormat vtotal = new DecimalFormat("####0.00");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Valor Total        :R$" +
                                vtotal.format(Double.parseDouble(Float.toString(valorLiquido))));
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "FORMA DE PAGAMENTO VALOR PAGO");
                        DecimalFormat vformapagto = new DecimalFormat("####0.00");
                        if (tipoPagamento == REGISTRA_COMPRA_DINHEIRO) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "DINHEIRO          :R$" +
                                    vformapagto.format(Double.parseDouble(Float.toString(valorRecebido)))
                            );
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_CREDITO) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CARTAO DE CREDITO  :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_DEBITO) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CARTAO DE DEBITO   :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_VOUCHER) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "VOUCHER            :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_CHEQUE) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CHEQUE             :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_PIX) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "PIX                :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if (tipoPagamento == REGISTRA_COMPRA_PRE_PAGA) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "PRE-PAGO           :R$" + vformapagto.format(Double.parseDouble(Float.toString(valorLiquido))));
                        }
                        if ((tipoPagamento == REGISTRA_COMPRA_DINHEIRO) && (valorTroco > 0)) {
                            DecimalFormat vtroco = new DecimalFormat("####0.00");
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "TROCO              :R$" +
                                    vtroco.format(Double.parseDouble(Float.toString(valorTroco))));

                        }
                        if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1"))) {
                            //configPrint.setAlinhamento("CENTER");
                            //gertecPrinter.setConfigImpressao(configPrint);
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "EMITIDA EM CONTINGENCIA");
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Pendente de Autorizacao");
                        }
                        PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.SMALL);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Consulte pela chave de acesso em");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_urlpro());
                        PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);
                        String k;
                        k = mApplication.Chave;
                        String linha1chave;
                        String linha2chave;
                        linha1chave = k.substring(0, 4) + " " + k.substring(4, 8) + " " + k.substring(8, 12) + " " + k.substring(12, 16) + " " + k.substring(16, 20) + " " + k.substring(20, 24);
                        linha2chave = k.substring(24, 28) + " " + k.substring(28, 32) + " " + k.substring(32, 36) + " " + k.substring(36, 40) + " " + k.substring(40, 44);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha1chave);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha2chave);
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "");
                        if (documento == "00000000000")
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CONSUMIDOR NAO IDENTIFICADO");
                        else {
                            if (documento.length() == 11) {
                                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CPF: " + documento);
                            } else {
                                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CNPJ: " + documento);
                            }
                        }
                        if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1")))
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "NFC-e " + mApplication.Idfiscal + " Serie " + mApplication.getSetUp().getT_serie());
                        else

                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "NFC-e " + pagamentoCard.getPagamento().getIdent_fiscal() + " Serie " + mApplication.getSetUp().getT_serie());
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Protocolo de Autorizacao");
                        if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1")))
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "000000000000000");
                        else
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, pagamentoCard.getPagamento().getprotocolo());
                        if ((mApplication.Contingencia == "0") && (mApplication.ModoOffline == "0") && (mApplication.getSetUp().getT_usaoff().equals("0"))) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Data de Autorizacao");
                            String dt;
                            dt = pagamentoCard.getPagamento().getDatahoraprotocolo();
                            String datahoraprotocolo;
                            datahoraprotocolo = dt.substring(8, 10) + "/" + dt.substring(5, 7) + "/" + dt.substring(0, 4) + " " + dt.substring(11, 13) + ":" + dt.substring(14, 16) + ":" + dt.substring(17, 19);
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, datahoraprotocolo);//pagamento.getDatahoraprocotolo());
                            //gertecPrinter.ImpressoraOutput();
                        }
                        if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1"))) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "EMITIDA EM CONTINGENCIA");
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Pendente de Autorizacao");
                        }
                        PosDigital.getInstance().getPrinter().addQrCode(AlignMode.CENTER, 280, mApplication.getSetUp().getT_urlpro());

                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Tributos Incidentes Lei Federal");
                        if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1"))) {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "(12741/12)Total R$ 0.00 Fed.0.00");
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Estadual 0 Municipal 0");
                        } else {
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "(12741/12)Total R$" + pagamentoCard.getPagamento().getSefazimpostoIcmsTotal() + " Fed." + pagamentoCard.getPagamento().getSefazimpostoPercFed());
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Estadual " + pagamentoCard.getPagamento().getSefazimpostoPerEst() + "% Municipal " + pagamentoCard.getPagamento().getSefazimpostoPercMunic() + " %");
                        }
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "----------------------------------------");
                        if (mApplication.getSetUp().getT_mensagem().length() < 33){
                            PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_mensagem());
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        }else{
                            int menss=mApplication.getSetUp().getT_mensagem().length();
                            int resto=mApplication.getSetUp().getT_mensagem().length()-32;
                            int mensscomplem=32+resto;
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_mensagem().substring(0,32));
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_mensagem().substring(32,mensscomplem));
                            PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        }
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                        PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                            @Override
                            public void onSuccess() throws RemoteException {
                                //Vai mostrar aviso de fim e solicitar 2a via cupom fiscal
                                try {
                                    statuserro = PosDigital.getInstance().getPrinter().getStatus();
                                    //VAI MOSTRAR MENSAGEM do CUPOM PROCESSADO e checar o status da impressora
                                    //Se status tiver erro roda alertaERROIMPRESSORA para encerrar sessao voltar ao menu
                                    //Se nao tiver erro chama mensagem de pergunta se deseja 2a via cupom fiscal
                                    if (mApplication.getSetUp().getT_usaoff().equals("0")) {
                                        runThread("Cupom " + mApplication.Idfiscal + " Processado em com Sucesso!", via, pagamentoCard);
                                        //alertaSucessoCupomFiscal("Cupom " +mApplication.Idfiscal + " Processado com Sucesso!\nImprimindo Cupom..",via,pagamentoCard);
                                    }else {
                                        runThread("Cupom " + mApplication.Idfiscal + " Processado em CONTINGÊNCIA com Sucesso!", via, pagamentoCard);
                                    }
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
                    }
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
            //return;
        }
    }



    //2A VIA DO CUPOM FISCAL POPUP
    private void Deseja_Imprimir_2avia(PagamentoCard pagamentoCard, String via) {
        Dialog dialog = new Dialog(PagamentoActivity.this);// Dialog();
        Verifica_2Via_NFCe popVerificaViaNFCe = new Verifica_2Via_NFCe();
        popVerificaViaNFCe.setVia_do_ClienteNFCe(new Verifica_2Via_NFCe_Fiscal() {
            //@Override
            public void on2ViadoClienteNAO() throws Exception {/// AO CONTRARIO APERTOU SIM NA TELA IMPRIME
                Impressao(pagamentoCard, "2"); //IMPRIME CUPOM FISCAL
            }

            //@Override
            public void on2ViadoClienteSIM() throws Exception {   /// AO CONTRARIO APERTOU NA TELA NAO ENCERRA
                mApplication.limpaCarrinhoSessao();
                finish();

            }
        });
        popVerificaViaNFCe.show(getSupportFragmentManager(), "ImprimeVia_do_Cliente");
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

    private void abrePopPagamentoDinheiro() {

        PopDinheiro popDinheiro = new PopDinheiro(valorLiquido, new ValorInformado() {
            @Override
            public void onValorInformado(float valor, float troco) {  //

                valorRecebido = valor;
                valorTroco = troco;

                abreTelaResumo();

            }
        });

        popDinheiro.show(getSupportFragmentManager(), "Pop Dinheiro");
    }

    //////////////////////////////////////
    //deseja  INFORMAR CPF NA NOTA FISCAL?
    /////////////////////////////////////
    private void abrePopVerificaDocumento() {

        VerificaDocumentoPagamento popVerificaDocumento = new VerificaDocumentoPagamento();
        popVerificaDocumento.show(getSupportFragmentManager(), "VerificaDocumento");
        popVerificaDocumento.setVerificaDocumento(new VerificaDocumento() {
            @Override
            public void onInformarDocumento() {
                abrePopTipoDocumento();   //informa CPF CNPJ NA NOTA
            }

            @Override
            public void onNaoInformarDocumento() {

                if (tipoPagamento == REGISTRA_COMPRA_DINHEIRO) {
                    abrePopPagamentoDinheiro();  //informa CPF CNPJ NA NOTA
                } else {


                    progressPagamento.setVisibility(View.VISIBLE);
                    enviaPagamento(null, null); //REGISTRA CUPOM FISCAL NA SEFAZ
                }
            }
        });


    }

    private void abrePopTipoDocumento() {

        TipoDocumento popTipoDocumento = new TipoDocumento();

        popTipoDocumento.setInterfaceDocumento(new TipoDocumentoPagamento() {
            @Override
            public void onDocumentoInformado(String documento) {

                setDocumento(documento);
                if (tipoPagamento == REGISTRA_COMPRA_DINHEIRO) {
                    abrePopPagamentoDinheiro();
                } else {
                    //  progressPagamento.setVisibility(View.VISIBLE);
                    enviaPagamento(null, null);
                }

            }

            @Override
            public void onNaoQueroDocumento() {
                if (tipoPagamento == REGISTRA_COMPRA_DINHEIRO) {

                    abrePopPagamentoDinheiro();
                }
            }
        });

        popTipoDocumento.show(getSupportFragmentManager(), "Tipo Documento");

    }

    private void setDocumento(String documento) {

        this.documento = documento;
    }



}
