package com.arenaplan.pdv.get.opcoes;

import static com.arenaplan.pdv.get.util.Constantes.ARG_CIDADE;
import static com.arenaplan.pdv.get.util.Constantes.ARG_CNPJ;
import static com.arenaplan.pdv.get.util.Constantes.ARG_EC;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NAME;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NUM_LOGIC;
import static com.arenaplan.pdv.get.util.Constantes.ARG_NUM_SERIE;
import static com.arenaplan.pdv.get.util.Constantes.ARG_RAZAO_SOCIAL;
import static com.arenaplan.pdv.get.util.Constantes.ARG_VERSION;
import static com.arenaplan.pdv.get.util.Constantes.CANCELA_TRANSACAO;
import static com.arenaplan.pdv.get.util.Constantes.CARREGA_PRODUTOS_POS;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_E7;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_E7_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G10;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G11;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G1_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_ERRO_G3;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.ERRO_GENERICO;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;
import static com.arenaplan.pdv.get.util.Constantes.INUTILIZA_TRANSACAO;
import static com.arenaplan.pdv.get.util.Constantes.OFF_LINE;
import static com.arenaplan.pdv.get.util.Constantes.REIMPRESSAO_TRANSACAO;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.InutilizarCupomCard;
import com.arenaplan.pdv.get.api.model.PagamentoCard;
import com.arenaplan.pdv.get.api.model.PdReimpressao;
import com.arenaplan.pdv.get.api.model.Produto;
import com.arenaplan.pdv.get.api.model.ProdutoReimpressao;
import com.arenaplan.pdv.get.api.model.ReimpresaoCupom;
import com.arenaplan.pdv.get.api.model.ReimpressaoCupomCard;
import com.arenaplan.pdv.get.api.model.ReimpressaoCupomSimplesCard;
import com.arenaplan.pdv.get.api.model.RepostaProdutoCard;
import com.arenaplan.pdv.get.api.model.TransacaoCard;
import com.arenaplan.pdv.get.caixa.OpcoesCaixaActivity;
import com.arenaplan.pdv.get.database.ContadorController;
import com.arenaplan.pdv.get.database.PendenteController;
import com.arenaplan.pdv.get.database.ProdutoBancoController;
import com.arenaplan.pdv.get.database.SetUpBancoController;
import com.arenaplan.pdv.get.database.entidades.ContadorEntidade;
import com.arenaplan.pdv.get.database.entidades.PendenteEntidade;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;
import com.arenaplan.pdv.get.opcoes.dialog.ajusteidfiscal.AjusteIdFiscalPopUp;
import com.arenaplan.pdv.get.opcoes.dialog.cancelarcupom.CancelaCupomPopUp;
import com.arenaplan.pdv.get.opcoes.dialog.cancelarcupom.CancelarCupomAcao;
import com.arenaplan.pdv.get.opcoes.dialog.informacoes.MostraInformacoes;
import com.arenaplan.pdv.get.opcoes.dialog.informacoes.MostraInformacoesAcao;
import com.arenaplan.pdv.get.opcoes.dialog.inutilizarcupom.InutilizarCupomAcao;
import com.arenaplan.pdv.get.opcoes.dialog.inutilizarcupom.InutilizarCupomPopUp;
import com.arenaplan.pdv.get.opcoes.dialog.pendente.EnviarPagamentoPendenteAcao;
import com.arenaplan.pdv.get.opcoes.dialog.pendente.EnviarPagamentoPendentePopUp;
import com.arenaplan.pdv.get.opcoes.dialog.reimpressao.ReimpressaoTransacaoAcao;
import com.arenaplan.pdv.get.opcoes.dialog.reimpressao.ReimpressaoTransacaoPopUp;
import com.arenaplan.pdv.get.pagamento.dialog.PopInfo;
import com.arenaplan.pdv.get.pagamento.dialog.PopStatusGetNet;
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosInfoPop;
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosStatusGetNet;
import com.arenaplan.pdv.get.setup.ui.SetUpActivity;
import com.arenaplan.pdv.get.util.BaseActivity;
import com.arenaplan.pdv.get.util.Constantes;
import com.arenaplan.pdv.get.util.DadosGetNet;
import com.arenaplan.pdv.get.util.DateUtils;
import com.arenaplan.pdv.get.util.Monetario;
import com.arenaplan.pdv.get.util.PreparaIdentificadorFiscal;
import com.arenaplan.pdv.get.util.dialog.PopSetup;
import com.arenaplan.pdv.get.util.dialog.SetUp;
import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.printer.AlignMode;
import com.getnet.posdigital.printer.FontFormat;
import com.getnet.posdigital.printer.IPrinterCallback;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpcoesActivity extends BaseActivity {
    private Button btTransmitiPedente;

    //private Button progressOpcoes;
    private Button buttonCancelarCumpom;
    private Button btInutilizarCumpom;
    private RelativeLayout progressOpcoes;
    //private ConstraintLayout progressOpcoes;
    private Button btAjustarIdFiscal;
    private Button btAtualizarProduto;
    private Button btReemprimirCupom;
    private Button btInformacoes;
    private PendenteController pendenteController;
    ArenaplanPdvApplication mApplication;
    // private GertecPrinter gertecPrinter;
    private ConstraintLayout progressPagamento;
    private int timeOut = 35;
    private int EnviadaComSucesso = 0;
    private String codigo;
    private String usuario;
    private String senha;
    private TextView textDataHora;

    private Button buttonOpcoesCaixa;
    private Button btnSetup;

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

    private TextView labelValorSubTotal;
    private TextView textViewHoraPagamento;
    private TextView labelValorDesconto;
    private TextView labelValorLiquido;

    private final String ARG_NSU = "nsu";
    private final String ARG_BRAND = "brand";

    private final String ARG_CV_NUMBER = "cvNumber";

    private String FORMATO_GET_NET = "json";

    private String cvNumeroEstorno = "";

    private String deepLink = "getnet://pagamento/v3/payment";
    private String estorno = "getnet://pagamento/v1/refund";
    private String consultarStatus = "getnet://pagamento/v1/checkstatus";
    private String reimprime = "getnet://pagamento/v1/reprint";
    private String informacao = "getnet://pagamento/v1/getinfos";

    class Task extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = DateUtils.retornaDiaAtual();
                    String hora = DateUtils.retornaHoraAtual();
                    if (textDataHora != null) {
                        textDataHora.setText(data + "\n" + hora);
                    }
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);
        pendenteController = new PendenteController(this);
        mApplication = (ArenaplanPdvApplication) getApplicationContext();
        try {
            timeOut = Integer.parseInt(mApplication.getSetUp().getT_timeout());
        } catch (Exception e) {
            timeOut = 35;
        }
        //usuario = mApplication.getSetUp().getT_login();
        usuario = mApplication.getSetUp().getT_login();
        codigo = String.valueOf(mApplication.getSetUp().getT_hh_ident());
        senha = mApplication.getSetUp().getT_passw();
        pegaIdTela();
        //Alerta("teste");
        cliqueBotao();

        //  gertecPrinter = new GertecPrinter(OpcoesActivity.this);//this.getApplicationContext());
        //  gertecPrinter.setConfigImpressao(configPrint);
        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();
        textDataHora.setText(data + "\n" + hora);
        Timer();
    }

    private void pegaIdTela() {

        btTransmitiPedente = findViewById(R.id.btTransmitiPedente);
        progressOpcoes     = findViewById(R.id.progress_opcoes);
        btnSetup = findViewById(R.id.btnSetup);
        buttonCancelarCumpom = findViewById(R.id.buttonCancelarCumpom);
        btInutilizarCumpom = findViewById(R.id.btInutilizarCumpom);
        buttonOpcoesCaixa = findViewById(R.id.buttonOpcoesCaixa);
        btAjustarIdFiscal = findViewById(R.id.btAjustarIdFiscal);
        btAtualizarProduto = findViewById(R.id.btAtualizarProduto);
        btReemprimirCupom = findViewById(R.id.btReemprimirCupom);
        btInformacoes = findViewById(R.id.btinformacoes);
        textDataHora = findViewById(R.id.textView11);
    }

    public void Timer() {
        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 30000);
    }

    private void cliqueBotao() {

        btTransmitiPedente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrePopPendente();

            }
        });

        btnSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbreTelaOpcoes();
            }
        });

        buttonCancelarCumpom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrePopCancelarCumpo();
            }
        });

        btInutilizarCumpom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrePopInutilizarCupom();
            }
        });


        buttonOpcoesCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), OpcoesCaixaActivity.class);
                startActivity(intent);
            }
        });

        btAjustarIdFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrePopAjusteIdFiscal();
            }
        });

        btAtualizarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressOpcoes.setVisibility(View.VISIBLE);
                carregaDadosProduto();
            }
        });

        btReemprimirCupom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrePopReimpresaoCupom();
            }
        });
        btInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alerta("teste");
                AbreTelaInformacoes();
            }
        });

    }

    private void Alerta(String mensagem) {
        //mensagem="Falha na Comunicação";
        new android.app.AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }


    private void enviaPagamento(PendenteEntidade pendenteEntidade) {

        if (    (pendenteEntidade.getAcao() == "registra_compra_dinheiro") ||
                (pendenteEntidade.getAcao() == "registra_compra") ||
                (pendenteEntidade.getAcao() == "registra_compra_cheque") ||
               ((pendenteEntidade.getAcao() == "registra_compra_pix")&&(mApplication.getSetUp().getT_duplacripto().equals("0"))))
        {
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
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G11.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G10.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G3.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                }

                @Override
                public void onFailure(Call<PagamentoCard> call, Throwable t) {
                    Alerta("Falha na Comunicação");
                }
            });
        }
        else {
            Call<PagamentoCard> call = new RetrofitConfig(timeOut).getPDVService().enviaPagamentoCartao(
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
                    pendenteEntidade.getBand(),
                    pendenteEntidade.getNsu(),
                    pendenteEntidade.getCvNumber(),
                    pendenteEntidade.getModal(),
                    pendenteEntidade.getParcel(),
                    FORMATO_GET_NET);
            call.enqueue(new Callback<PagamentoCard>() {
                @Override
                public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {
                    PagamentoCard pagamentoCard = response.body();
                    if (CODIGO_SUCESSO.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G11.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G10.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                    if (CODIGO_ERRO_G3.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                        pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                        EnviadaComSucesso++;
                    }
                }

                @Override
                public void onFailure(Call<PagamentoCard> call, Throwable t) {
                    Alerta("Falha na Comunicação");
                }
            });
        }
        /*call.enqueue(new Callback<PagamentoCard>() {
            @Override
            public void onResponse(Call<PagamentoCard> call, Response<PagamentoCard> response) {
                PagamentoCard pagamentoCard = response.body();
                if (CODIGO_SUCESSO.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                    pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                    EnviadaComSucesso++;
                }
                if (CODIGO_ERRO_G11.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                    pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                    EnviadaComSucesso++;
                }
                if (CODIGO_ERRO_G10.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                    pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                    EnviadaComSucesso++;
                }
                if (CODIGO_ERRO_G3.equalsIgnoreCase(pagamentoCard.getPagamento().getErrorCode())) {
                    pendenteController.removeCarinhoPendente(pendenteEntidade.getId());
                    EnviadaComSucesso++;
                }
            }

            @Override
            public void onFailure(Call<PagamentoCard> call, Throwable t) {
                Alerta("Falha na Comunicação");
            }
        });*/
    }

    private void AbreTelaInformacoes() {
        ContadorController contadorController = new ContadorController(this);
        ContadorEntidade contadorEntidade = contadorController.getUltimoContador();
        //ContadorEntidade idfiscal=new ContadorEntidade();
        //long Idfiscal
        String IDFISCAL = PreparaIdentificadorFiscal.preparaIdentificadorFiscal(String.valueOf(contadorEntidade.getT_idf()));

        //      =idfiscal.getT_idf();
        //String Idfiscal2=Long.toString(Idfiscal);

        MostraInformacoes popInformacoes = new MostraInformacoes(
                mApplication.getSetUp().getT_razao(),
                mApplication.getSetUp().getT_razao(),
                mApplication.getSetUp().getT_cnpj(),
                mApplication.getSetUp().getT_inscricao(),
                mApplication.getSetUp().getT_endereco(),
                mApplication.getSetUp().getT_numero(),
                mApplication.getSetUp().getT_complemento(),
                mApplication.getSetUp().getT_bairro(),
                mApplication.getSetUp().getT_cidade(),
                mApplication.getSetUp().getT_cep(),
                mApplication.getSetUp().getT_uf(),
                mApplication.getSetUp().getT_login(),
                mApplication.getSetUp().getT_tef(),
                mApplication.getSetUp().getT_usaoff(),
                mApplication.getSetUp().getT_serie(),
                mApplication.getSetUp().getT_hh_ident().toString(),
                mApplication.getSetUp().getT_timeout().toString(),
                IDFISCAL,
                new MostraInformacoesAcao() {
                    public void onClick(View v) {
                        finish();
                    }
                });
        popInformacoes.show(getSupportFragmentManager(), "Pop Setup");


    }


    private void AbreTelaOpcoes() {


        PopSetup popSetup = new PopSetup();

        popSetup.setSetUp(new SetUp() {
            @Override
            public void onCancelar() {

            }

            @Override
            public void onConfirma() {

                abreTelaSetup();

            }
        });

        popSetup.show(getSupportFragmentManager(), "Pop Setup");

    }

    private void abreTelaSetup() {
        Intent intent = new Intent(this, SetUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("refazerSetup", true);
        startActivity(intent);
        finish();
    }


    private void abrePopCancelarCumpo() {

        CancelaCupomPopUp cancelaCupomPopUp = new CancelaCupomPopUp();
        cancelaCupomPopUp.registraAcaoCancelar(new CancelarCupomAcao() {
            @Override
            public void onCancelar(String idFiscal) {

                executaApiCancelarCumpom(idFiscal);
            }
        });

        cancelaCupomPopUp.show(getSupportFragmentManager(), "Cancelar Cupom");
    }

    private void abrePopInutilizarCupom() {

        InutilizarCupomPopUp inutilizarCupomPopUp = new InutilizarCupomPopUp();

        inutilizarCupomPopUp.registraAcaoInutilizar(new InutilizarCupomAcao() {
            @Override
            public void onInutilizar(String idFiscal) {
                executaApiInutilizarIdFiscal(idFiscal);
            }
        });

        inutilizarCupomPopUp.show(getSupportFragmentManager(), "inutilizarCupomPopUp");

    }

    private void abrePopAjusteIdFiscal() {

        AjusteIdFiscalPopUp ajusteIdFiscalPopUp = new AjusteIdFiscalPopUp();

        ajusteIdFiscalPopUp.show(getSupportFragmentManager(), "ajusteIdFiscalPopUp");
    }

    private void abrePopReimpresaoCupom() {

        ReimpressaoTransacaoPopUp reimpressaoTransacaoPopUp = new ReimpressaoTransacaoPopUp();

        reimpressaoTransacaoPopUp.setReimpressaoTransacaoAcao(new ReimpressaoTransacaoAcao() {
            @Override
            public void onReimpresao(String idFiscal) {

                executaReimpresaoCupom(idFiscal);
            }
        });

        reimpressaoTransacaoPopUp.show(getSupportFragmentManager(), "reimpressaoTransacaoPopUp");
    }

    private void alerta(String mensagem) {

        new AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", null)
                .show();

    }

    /***Chama api POp**/
    private void executaApiCancelarCumpom(String idFiscal) {

        Call<TransacaoCard> call = new RetrofitConfig(timeOut).getPDVService().cancelarTransacao(
                usuario,
                senha,
                codigo,
                CANCELA_TRANSACAO,
                idFiscal,
                FORMATO);

        call.enqueue(new Callback<TransacaoCard>() {


            @Override
            public void onResponse(Call<TransacaoCard> call, Response<TransacaoCard> response) {
                TransacaoCard transacaoCard = response.body();
                if (CODIGO_SUCESSO.equalsIgnoreCase(transacaoCard.getTransacao().getError_code())) {
                    progressOpcoes.setVisibility(View.GONE);
                    alertaSucessoOpcao(" Cupom " + idFiscal + " cancelado com sucesso");
                    imprimiComprovanteCancelamento(transacaoCard);
                } else {
                    if (transacaoCard.getTransacao().getError_code().equals(CODIGO_ERRO_E7)) {
                        progressOpcoes.setVisibility(View.GONE);
                        alerta(CODIGO_ERRO_E7_MENSAGEM);
                        return;
                    } else {
                        alerta(CODIGO_ERRO_G1_MENSAGEM + "\n" + transacaoCard.getTransacao().getMensagem());
                        progressOpcoes.setVisibility(View.GONE);
                        alertaSucessoOpcao(ERRO_GENERICO);
                    }
                }
            }

            @Override
            public void onFailure(Call<TransacaoCard> call, Throwable t) {
               /* TransacaoCard transacaoCard = t.body();
                if (transacaoCard.getTransacao().getError_code().equals(CODIGO_ERRO_E7)) {
                    progressOpcoes.setVisibility(View.GONE);
                    alerta(CODIGO_ERRO_E7_MENSAGEM);
                    return;
                }*/

                progressOpcoes.setVisibility(View.GONE);
                alertaSucessoOpcao(CODIGO_ERRO_G1_MENSAGEM);

            }

        });

    }


    private void executaApiInutilizarIdFiscal(String idFiscal) {


        Call<InutilizarCupomCard> call = new RetrofitConfig(timeOut).getPDVService().inutilizarCupom(
                usuario,
                senha,
                codigo,
                INUTILIZA_TRANSACAO,
                idFiscal,
                idFiscal,
                FORMATO);

        call.enqueue(new Callback<InutilizarCupomCard>() {

            @Override
            public void onResponse(Call<InutilizarCupomCard> call, Response<InutilizarCupomCard> response) {

                InutilizarCupomCard inutilizarCupomCard = response.body();

                progressOpcoes.setVisibility(View.GONE);

                if (CODIGO_SUCESSO.equalsIgnoreCase(inutilizarCupomCard.getInutilizarCupom().getError_code())) {
                    alertaSucessoOpcao("Número " + idFiscal + " Inutilizado");

                } else {
                    alertaSucessoOpcao(ERRO_GENERICO);
                }

            }

            @Override
            public void onFailure(Call<InutilizarCupomCard> call, Throwable t) {
                alertaSucessoOpcao(ERRO_GENERICO);
                progressOpcoes.setVisibility(View.GONE);
            }
        });
    }

    private void carregaDadosProduto() {

        Call<RepostaProdutoCard> call = new RetrofitConfig(timeOut).getPDVService().getProduto(
                usuario,
                senha,
                codigo,
                CARREGA_PRODUTOS_POS,
                FORMATO
        );

        call.enqueue(new Callback<RepostaProdutoCard>() {
            @Override
            public void onResponse(Call<RepostaProdutoCard> call, Response<RepostaProdutoCard> response) {

                RepostaProdutoCard produto = response.body();
                registrarInformacaoTabelaSetUp(produto);
            }

            @Override
            public void onFailure(Call<RepostaProdutoCard> call, Throwable t) {
                progressOpcoes.setVisibility(View.GONE);
                //Log.e("PDVService   ", "Erro ao buscar o produto:" + t.getMessage());
                alertaSucessoOpcao(ERRO_GENERICO);
            }
        });
    }

    private void executaReimpresaoCupom(String idFiscal) {


        Call<JsonObject> call = new RetrofitConfig(timeOut).getPDVService().reimpressaoTransacao(

                usuario,
                senha,
                codigo,
                REIMPRESSAO_TRANSACAO,
                FORMATO,
                idFiscal

        );
        //progressPagamento.setVisibility(View.VISIBLE);
        //progressPagamento.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                JsonObject obj = response.body();
                Gson gson = new Gson();
                try {

                    ReimpressaoCupomCard reimpressaoCupomCard = gson.fromJson(obj, ReimpressaoCupomCard.class);

                    if (CODIGO_SUCESSO.equalsIgnoreCase(reimpressaoCupomCard.getReimpresaoCupom().getError_code())) {
                        impressao(reimpressaoCupomCard.getReimpresaoCupom());
                        //progressPagamento.setVisibility(View.GONE);
                    } else {
                        //progressPagamento.setVisibility(View.GONE);
                        //alertaSucessoOpcao(ERRO_GENERICO);
                    }


                } catch (Exception e) {

                    try {
                        //ReimpressaoCupomSimplesCard  reimpressaoCupomSimplesCard = ReimpressaoCupomSimplesCard.class.cast(obj);

                        ReimpressaoCupomSimplesCard reimpressaoCupomSimplesCard = gson.fromJson(obj, ReimpressaoCupomSimplesCard.class);

                        if (CODIGO_SUCESSO.equalsIgnoreCase(reimpressaoCupomSimplesCard.getReimpresaoCupom().getError_code())) {

                            converteReimpresaoSimplesReimpressaoCard(reimpressaoCupomSimplesCard);
                            //progressPagamento.setVisibility(View.GONE);
                        } else {
                            //progressPagamento.setVisibility(View.GONE);
                            //alertaSucessoOpcao(ERRO_GENERICO);
                        }

                    } catch (Exception error) {
                        error.getStackTrace();
                        //progressPagamento.setVisibility(View.GONE);
                        //alertaSucessoOpcao(ERRO_GENERICO);
                    }
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progressPagamento.setVisibility(View.GONE);
                //alertaSucessoOpcao(ERRO_GENERICO);
            }
        });
    }


    /***********/

    /***Impressão**/
    private void imprimiComprovanteCancelamento(TransacaoCard transacaoCard) {

        try {


            if (PosDigital.getInstance().isInitiated()) {
                PosDigital.getInstance().getPrinter().init();
                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CNPJ:" + mApplication.getSetUp().getT_cnpj());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_razao());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Inscr.Estadual: " + mApplication.getSetUp().getT_inscricao());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_endereco() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_complemento() + "," + mApplication.getSetUp().getT_bairro() + "," + mApplication.getSetUp().getT_cidade() + "," + mApplication.getSetUp().getT_uf());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Comprovante de Cancelamento");

                DecimalFormat vtotal = new DecimalFormat("####0.00");

                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Valor Total        :R$" +
                        vtotal.format(Double.parseDouble(transacaoCard.getTransacao().getValor().toString())));
                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.SMALL);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Consulte pela chave de acesso em");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_urlpro());
                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);
                String k;
                k = transacaoCard.getTransacao().getChave();
                String linha1chave;
                String linha2chave;
                linha1chave = k.substring(0, 4) + " " + k.substring(4, 8) + " " + k.substring(8, 12) + " " + k.substring(12, 16) + " " + k.substring(16, 20) + " " + k.substring(20, 24);
                linha2chave = k.substring(24, 27) + " " + k.substring(28, 32) + " " + k.substring(32, 36) + " " + k.substring(36, 40) + " " + k.substring(40, 44);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha1chave);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha2chave);
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "NFC-e " + transacaoCard.getTransacao().getTr_id() + " Série " + mApplication.getSetUp().getT_serie());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Protocolo de Autorização");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, transacaoCard.getTransacao().getProtocolo());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Data de Autorização");
                String dt;
                dt = transacaoCard.getTransacao().getDatahoraprotocolo();
                String datahoraprotocolo;
                datahoraprotocolo = dt.substring(8, 10) + "/" + dt.substring(5, 7) + "/" + dt.substring(0, 4) + " " + dt.substring(11, 13) + ":" + dt.substring(14, 16) + ":" + dt.substring(17, 19);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, datahoraprotocolo);
                PosDigital.getInstance().getPrinter().addQrCode(AlignMode.CENTER, 280, mApplication.getSetUp().getT_urlpro());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");

                PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                    @Override
                    public void onSuccess() throws RemoteException {
                        alertaSucessoOpcao("Reimpressao Realizada com Sucesso");
                    }

                    @Override
                    public void onError(int i) throws RemoteException {

                    }
                });
            }


        } catch (Exception e) {
            e.printStackTrace();
            progressOpcoes.setVisibility(View.GONE);
        }

    }


    /*********/

    /**
     * Alerta Opcoes
     **/

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

    private void registrarInformacaoTabelaSetUp(RepostaProdutoCard produto) {

        int NProdutos = 0;
        //String NPROD="";
        com.arenaplan.pdv.get.database.entidades.SetUp setUp = new com.arenaplan.pdv.get.database.entidades.SetUp();


        setUp.setT_login(usuario);
        setUp.setT_passw(senha);
        setUp.setT_hh_ident(Integer.valueOf(codigo));
        setUp.setT_tipo_recibo(String.valueOf(mApplication.getSetUp().getT_tipo_recibo()));
        setUp.setT_senha(mApplication.getSetUp().getT_senha());
        setUp.setT_razao(produto.getProdutoCard().getQm());
        setUp.setT_endereco(produto.getProdutoCard().getQe());
        setUp.setT_numero(produto.getProdutoCard().getQn());
        setUp.setT_complemento(produto.getProdutoCard().getQp());
        setUp.setT_bairro(produto.getProdutoCard().getQb());
        setUp.setT_cidade(produto.getProdutoCard().getQc());
        setUp.setT_cnpj(produto.getProdutoCard().getQj());
        setUp.setT_cep(produto.getProdutoCard().getQz());
        setUp.setT_inscricao(produto.getProdutoCard().getQi());
        setUp.setT_cuf(produto.getProdutoCard().getCuf());
        setUp.setT_uf(produto.getProdutoCard().getQu());
        setUp.setT_serie(produto.getProdutoCard().getHh());
        setUp.setT_sefaz(produto.getProdutoCard().getQsStatusSefazNfce());
        setUp.setT_tef(produto.getProdutoCard().getTef());
        setUp.setT_prepapo(produto.getProdutoCard().getUo());
        setUp.setT_monitor(produto.getProdutoCard().getMo());
        setUp.setT_cliente(produto.getProdutoCard().getCc());
        setUp.setT_leitora(produto.getProdutoCard().getLe());
        setUp.setT_timeout(produto.getProdutoCard().getTo());
        setUp.setT_codativ(produto.getProdutoCard().getCdat());
        setUp.setT_assina(produto.getProdutoCard().getAsst());
        setUp.setT_inscmun(produto.getProdutoCard().getInscm());
        setUp.setT_cnpjdes(produto.getProdutoCard().getCnpjd());
        setUp.setT_layout(produto.getProdutoCard().getLayout());
        setUp.setT_mensagem(produto.getProdutoCard().getMr());
        setUp.setT_duplacripto(produto.getProdutoCard().getCrd());
        setUp.setT_usaoff(String.valueOf(mApplication.getSetUp().getT_usaoff()));
        setUp.setT_urlhomo(produto.getProdutoCard().getUfUrlSefazHomolog());
        setUp.setT_urlpro(produto.getProdutoCard().getUfUrlSefazProd());


        SetUpBancoController setUpBancoController = new SetUpBancoController(this);
        setUpBancoController.deletaSetUp();
        boolean resultado = setUpBancoController.insereDado(setUp);

        // produtos
        ProdutoBancoController produtoBancoController = new ProdutoBancoController(this);
        produtoBancoController.deletaTabelaProduto();
        for (Produto item : produto.getProdutoCard().getPd().getProdutoList()) {

            ProdutoEntidade produtoEntidade = new ProdutoEntidade();

            produtoEntidade.setCodigo(item.getPi());
            produtoEntidade.setNome(item.getNr());
            produtoEntidade.setValor(Float.valueOf(item.getVr()));
            produtoEntidade.setCategoria(item.getTd());
            produtoEntidade.setBarras(item.getCb());
            produtoEntidade.setUnidade(item.getUn());
            produtoEntidade.setNcmid(item.getNcmid());
            produtoEntidade.setGfid(item.getGfid());
            produtoEntidade.setTipoProduto(item.getnH());
            produtoEntidade.setImageTipoProduto(item.getImt());
            produtoEntidade.setImageItem(item.getImp());
            produtoBancoController.insereDado(produtoEntidade);
            NProdutos++;

        }
        String nprodutos = Integer.toString(NProdutos); //
        alertaSucessoOpcao(" Produtos Carregados: " + nprodutos);


        progressOpcoes.setVisibility(View.GONE);

    }


    public void impressao(ReimpresaoCupom reimpresaoCupom) throws Exception {


        try {

            if (PosDigital.getInstance().isInitiated()) {
                PosDigital.getInstance().getPrinter().init();
                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CNPJ:" + mApplication.getSetUp().getT_cnpj());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_razao());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Inscr.Estadual: " + mApplication.getSetUp().getT_inscricao());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_endereco() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_numero() + "," + mApplication.getSetUp().getT_complemento() + "," + mApplication.getSetUp().getT_bairro() + "," + mApplication.getSetUp().getT_cidade() + "," + mApplication.getSetUp().getT_uf());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Documento Auxiliar da Nota");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Fiscal do Consumidor Eletrônica");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Codigo Descr Qtd Un VlrUnt VltTot");
                for (ProdutoReimpressao produtoReimpressao : reimpresaoCupom.getPds().getProdutoList()) {
                    String CodigoPro;
                    DecimalFormat df = new DecimalFormat("0000000000000");
                    CodigoPro = df.format(Integer.parseInt(produtoReimpressao.getPi()));
                    String QtdePro;
                    DecimalFormat df2 = new DecimalFormat("000000");
                    QtdePro = df2.format(Integer.parseInt(produtoReimpressao.getQt()));
                    String Valor1;
                    DecimalFormat v1 = new DecimalFormat("####0.00");
                    Valor1 = v1.format(Double.parseDouble(produtoReimpressao.getVr()));
                    String Valor2;
                    DecimalFormat v2 = new DecimalFormat("####0.00");
                    Valor2 = v2.format(Integer.parseInt(produtoReimpressao.getQt()) * Double.parseDouble(produtoReimpressao.getVr()));


                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, CodigoPro + " " +
                            produtoReimpressao.getNr());

                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "               " + QtdePro + " " +
                            produtoReimpressao.getQt() + " X R$" +
                            Valor1 + " R$" + Valor2);

                }

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Qtd. total de itens:" + reimpresaoCupom.getPds().getProdutoList().size());

                float valorCarrinho = 0;

                if (reimpresaoCupom.getTotal() != null) {

                    valorCarrinho = Float.parseFloat(reimpresaoCupom.getTotal());
                }

                float valorDesconto = 0;

                if (reimpresaoCupom.getDesconto() != null) {
                    valorDesconto = Float.parseFloat(reimpresaoCupom.getDesconto());
                }


                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Desconto           :" + Monetario.converteValorFloatParaReal(valorDesconto));


                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Valor Total        :" + Monetario.converteValorFloatParaReal(valorCarrinho));

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "FORMA DE PAGAMENTO VALOR PAGO");
                DecimalFormat vformapagto = new DecimalFormat("####0.00");
                if (reimpresaoCupom.getTipo().toString().equals("1")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "DINHEIRO          :R$" +
                            vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal()))
                    );
                }
                if (reimpresaoCupom.getTipo().toString().equals("3")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CARTAO DE CREDITO  :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                if (reimpresaoCupom.getTipo().toString().equals("2")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CARTAO DE DEBITO   :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                if (reimpresaoCupom.getTipo().toString().equals("5")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "VOUCHER            :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                if (reimpresaoCupom.getTipo().toString().equals("6")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "CHEQUE             :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                if (reimpresaoCupom.getTipo().toString().equals("7")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "PIX                :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                if (reimpresaoCupom.getTipo().toString().equals("4")) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "PRE-PAGO           :R$" + vformapagto.format(Double.parseDouble(reimpresaoCupom.getTotal())));
                }
                /*if ((reimpresaoCupom.getTipo().toString()  == REGISTRA_COMPRA_DINHEIRO) && (reimpresaoCupom.valorTroco > 0)) {
                    DecimalFormat vtroco = new DecimalFormat("####0.00");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "TROCO              :R$" +
                            vtroco.format(Double.parseDouble(Float.toString(valorTroco))));

                }*/



                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.SMALL);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Consulte pela chave de acesso em");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_urlpro());
                PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);

                String k;
                k = reimpresaoCupom.getChave();
                String linha1chave;
                String linha2chave;
                linha1chave = k.substring(0, 4) + " " + k.substring(4, 8) + " " + k.substring(8, 12) + " " + k.substring(12, 16) + " " + k.substring(16, 20) + " " + k.substring(20, 24);
                linha2chave = k.substring(24, 27) + " " + k.substring(28, 32) + " " + k.substring(32, 36) + " " + k.substring(36, 40) + " " + k.substring(40, 44);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha1chave);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, linha2chave);
                if (reimpresaoCupom.getCpf().equals("00000000000"))
                    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CONSUMIDOR NÃO IDENTIFICADO");
                else {
                    if (reimpresaoCupom.getCpf().length() == 11) {
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CPF: " + reimpresaoCupom.getCpf());
                    } else {
                        PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "CNPJ: " + reimpresaoCupom.getCpf());
                    }
                }

                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "NFC-e " + reimpresaoCupom.getIdent_fiscal() + " Série " + mApplication.getSetUp().getT_serie());

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Protocolo de Autorizacao");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, reimpresaoCupom.getProtocolo());
                // if ((mApplication.Contingencia == "0") && (mApplication.ModoOffline == "0") && (mApplication.getSetUp().getT_usaoff().equals("0"))) {
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Data de Autorizacao");
                String dt;
                dt = reimpresaoCupom.getDatahoraprotocolo();
                String datahoraprotocolo;
                datahoraprotocolo = dt.substring(8, 10) + "/" + dt.substring(5, 7) + "/" + dt.substring(0, 4) + " " + dt.substring(11, 13) + ":" + dt.substring(14, 16) + ":" + dt.substring(17, 19);
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, datahoraprotocolo);//pagamento.getDatahoraprocotolo());
                //gertecPrinter.ImpressoraOutput();

                //if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1"))) {
                //    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "EMITIDA EM CONTINGENCIA");
                //    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Pendente de Autorizacao");
                //}
                PosDigital.getInstance().getPrinter().addQrCode(AlignMode.CENTER, 280, mApplication.getSetUp().getT_urlpro());

                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Tributos Incidentes Lei Federal");
                //if ((mApplication.Contingencia == "1") || (mApplication.ModoOffline == "1") || (mApplication.getSetUp().getT_usaoff().equals("1"))) {
                //    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "(12741/12)Total R$ 0.00 Fed.0.00");
                //    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Estadual 0 Municipal 0");
                //} else {
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "(12741/12)Total R$" + reimpresaoCupom.getSefazImpostoIcmsTotal() + " Fed." + reimpresaoCupom.getSefazImpostoPercFed());
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "Estadual " + reimpresaoCupom.getSefazImpostoPerEst() + " Municipal " + reimpresaoCupom.getSefazImpostoPercMunic() + " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, "----------------------------------------");
                if (mApplication.getSetUp().getT_mensagem().length() < 33) {
                    PosDigital.getInstance().getPrinter().addText(AlignMode.CENTER, mApplication.getSetUp().getT_mensagem());
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                } else {
                    int menss = mApplication.getSetUp().getT_mensagem().length();
                    int resto = mApplication.getSetUp().getT_mensagem().length() - 32;
                    int mensscomplem = 32 + resto;
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_mensagem().substring(0, 32));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_mensagem().substring(32, mensscomplem));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                }
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                    @Override
                    public void onSuccess() throws RemoteException {

                    }

                    @Override
                    public void onError(int i) throws RemoteException {


                    }
                });
            }
        } catch (Exception e) {

        }
}

    private void converteReimpresaoSimplesReimpressaoCard(ReimpressaoCupomSimplesCard reimpressaoCupomSimplesCard) {


        ReimpresaoCupom reimpresaoCupom = new ReimpresaoCupom();

        reimpresaoCupom.setTr_id(reimpressaoCupomSimplesCard.getReimpresaoCupom().getTr_id());
        reimpresaoCupom.setVersion(reimpressaoCupomSimplesCard.getReimpresaoCupom().getVersion());
        reimpresaoCupom.setQs_id(reimpressaoCupomSimplesCard.getReimpresaoCupom().getQs_id());
        reimpresaoCupom.setIdent_fiscal(reimpressaoCupomSimplesCard.getReimpresaoCupom().getIdent_fiscal());
        reimpresaoCupom.setCpf(reimpressaoCupomSimplesCard.getReimpresaoCupom().getCpf());
        reimpresaoCupom.setTipo(reimpressaoCupomSimplesCard.getReimpresaoCupom().getTipo());
        reimpresaoCupom.setStatus(reimpressaoCupomSimplesCard.getReimpresaoCupom().getStatus());
        reimpresaoCupom.setDesconto(reimpressaoCupomSimplesCard.getReimpresaoCupom().getDesconto());

        /** converte o item unico do PD numa lista de PD para usar a mesma rotina de impressao**/
        PdReimpressao pdReimpressao = new PdReimpressao();

        ProdutoReimpressao produtoReimpressao = new ProdutoReimpressao();

        produtoReimpressao.setNr(reimpressaoCupomSimplesCard.getReimpresaoCupom().getPds().getProdutoReimpressao().getNr());
        produtoReimpressao.setPi(reimpressaoCupomSimplesCard.getReimpresaoCupom().getPds().getProdutoReimpressao().getPi());
        produtoReimpressao.setQt(reimpressaoCupomSimplesCard.getReimpresaoCupom().getPds().getProdutoReimpressao().getQt());
        produtoReimpressao.setVr(reimpressaoCupomSimplesCard.getReimpresaoCupom().getPds().getProdutoReimpressao().getVr());

        ArrayList<ProdutoReimpressao> list = new ArrayList<>();
        list.add(produtoReimpressao);
        pdReimpressao.setProdutoList(list);
        reimpresaoCupom.setPds(pdReimpressao);

        /************************************/


        reimpresaoCupom.setChave(reimpressaoCupomSimplesCard.getReimpresaoCupom().getChave());
        reimpresaoCupom.setProtocolo(reimpressaoCupomSimplesCard.getReimpresaoCupom().getProtocolo());
        reimpresaoCupom.setDatahoraprotocolo(reimpressaoCupomSimplesCard.getReimpresaoCupom().getDatahoraprotocolo());
        reimpresaoCupom.setQrcodecsc(reimpressaoCupomSimplesCard.getReimpresaoCupom().getQrcodecsc());
        reimpresaoCupom.setQrcodeidtoken(reimpressaoCupomSimplesCard.getReimpresaoCupom().getQrcodeidtoken());
        reimpresaoCupom.setSefazdigVal(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazdigVal());
        reimpresaoCupom.setSefazImpostoIcmsTotal(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazImpostoIcmsTotal());
        reimpresaoCupom.setSefazImpostoPercFed(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazImpostoPercFed());
        reimpresaoCupom.setSefazImpostoPercFed(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazImpostoPercFed());
        reimpresaoCupom.setSefazImpostoPerEst(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazImpostoPerEst());
        reimpresaoCupom.setSefazImpostoPercMunic(reimpressaoCupomSimplesCard.getReimpresaoCupom().getSefazImpostoPercMunic());
        reimpresaoCupom.setNome(reimpressaoCupomSimplesCard.getReimpresaoCupom().getNome());
        reimpresaoCupom.setEndereco(reimpressaoCupomSimplesCard.getReimpresaoCupom().getEndereco());
        reimpresaoCupom.setNumero(reimpressaoCupomSimplesCard.getReimpresaoCupom().getNumero());
        reimpresaoCupom.setComplemento(reimpressaoCupomSimplesCard.getReimpresaoCupom().getComplemento());
        reimpresaoCupom.setBairro(reimpressaoCupomSimplesCard.getReimpresaoCupom().getBairro());
        reimpresaoCupom.setCidade(reimpressaoCupomSimplesCard.getReimpresaoCupom().getCidade());
        reimpresaoCupom.setUf(reimpressaoCupomSimplesCard.getReimpresaoCupom().getUf());
        reimpresaoCupom.setCep(reimpressaoCupomSimplesCard.getReimpresaoCupom().getCep());
        reimpresaoCupom.setInscricao(reimpressaoCupomSimplesCard.getReimpresaoCupom().getInscricao());
        reimpresaoCupom.setDatahoraoriginal(reimpressaoCupomSimplesCard.getReimpresaoCupom().getDatahoraoriginal());
        reimpresaoCupom.setError_code(reimpressaoCupomSimplesCard.getReimpresaoCupom().getError_code());
        reimpresaoCupom.setTotal(reimpressaoCupomSimplesCard.getReimpresaoCupom().getTotal());

        try {
            impressao(reimpresaoCupom);
        } catch (Exception e) {
            e.getStackTrace();
        }
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

    private void alertaerropagamentogetnet(String mensagem) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage(mensagem)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ContadorController contadorController = new ContadorController(PagamentoActivity.this); // Ele
                        //ContadorEntidade contadorEntidade = contadorController.getUltimoContador();
                        //identificadorFiscal=PreparaIdentificadorFiscal.preparaIdentificationFiscal(String.valueOf(parseInt(identificadorFiscal)-1));
                        //contadorController.decrementaContador(contadorEntidade); // Eu criei a função pra decrementar no controller
                        //mApplication.limpaCarrinhoSessao();
                        dialog.dismiss();
                        //finish();
                    }
                })
                .show();
    }
    private void alertaGetNet(String result) {
        switch (result) {
            case "1":
                alertaerropagamentogetnet("Transação negada");
                //SystemClock.sleep(300);
                //finish();
                break;
            case "2":
                alertaerropagamentogetnet("Transação cancelada");
                //SystemClock.sleep(300);
                //finish();
                break;
            case "3":
                alertaerropagamentogetnet("Falha ao Completar uma transação (internet, servidor ou operadora)");
                //SystemClock.sleep(300);
                //finish();
                break;
            case "4":
                alertaerropagamentogetnet("Erro desconhecido");
                //SystemClock.sleep(300);
                //finish();
                break;
            case "5":
                alertaerropagamentogetnet("Transação Pendente");
                //SystemClock.sleep(300);
                //finish();
                break;
            default:
                alertaerropagamentogetnet("Erro desconhecido");
                ///SystemClock.sleep(300);
                //finish();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Intent it =getIntent();
        //val dados=intent.extras
        //PAGAMENTO COM CARTAO

        if (RESULT_CANCELED == resultCode && RESQUEST_CODE_PAGAMENTO == requestCode) {

            //alertaGetNet("3");
            // alertaSucessoPagamento("3");
        }
        if (RESULT_OK == resultCode && REQUEST_CODE_STATUS == requestCode) {
            String result = data.getStringExtra(ARG_RESULT);
            //String nsu = data.getStringExtra(ARG_NSU);
            // String cv = data.getStringExtra(ARG_CV_NUMBER);
            if (result.equalsIgnoreCase("0")) {
                //salvaPendente(cv, nsu);
                // enviaPagamento(nsu, cv);
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
                //String result = data.getStringExtra(ARG_RESULT);
                alertaGetNet(result);
            }
        }
        //else {
        //       String result = data.getStringExtra(ARG_RESULT);
        //       alertaGetNet(result);
        //   }
    }
    private void enviarPagamentoPendente() {
        //int npendentes;
        //int transmitiu;
        List<PendenteEntidade> pendenteEntidadeList = pendenteController.listaCarrinhoPendente();

        if (pendenteEntidadeList.size() > 0) {
            progressOpcoes.setVisibility(View.VISIBLE);

            for (PendenteEntidade item : pendenteEntidadeList) {
                enviaPagamento(item);
            }
            progressOpcoes.setVisibility(View.GONE);
        }
        /*if(EnviadaComSucesso>0) {
            String envsucesso = Integer.toString(EnviadaComSucesso); //
            alertaSucessoOpcao(envsucesso+" Cupons Pendentes Transmitidos com Sucesso");
            EnviadaComSucesso=0;
        }*/
    }
    private void startIntent(Bundle bundle, String deeplink) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deeplink));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivityForResult(intent, RESQUEST_CODE_PAGAMENTO);
        } catch (Exception e) {
            Log.e("Pagamento", e.getMessage());
        }
    }

    private void startIntentEstorno() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(estorno));
            Bundle bundle = new Bundle();
            //Float value = valorTotalCarrinho - valorDesconto;
            //String vtotal = String.format("%12s", Monetario.convertValorDuasCasas(value)).replace(' ', '0');
            //bundle.putString("amount", vtotal.replace(".", ""));
            //bundle.putString("cvNumber", cvNumeroEstorno);
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
            bundle.putString("callerId", callerId);
            bundle.putString("allowPrintCurrentTransaction", "false");
            //bundle.putString("allowPrintCurrentTransaction", "true");
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
            //if (tipoPagamento == "registra_compra_pix") {
            //    bundle.putString("paymentType", "pix");
            //}
            startActivityForResult(intent, REQUEST_CODE_REIMPRIMIR);
        } catch (Exception e) {

        }

    }


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
              /*  case R.id.desisteCompra:
                    //Pega a ultima transacao e verifica se foi aprovada ou nao obteve resposta do servidor
                    //Em caso afirmativo desfaz a ultima transacao, senao apenas retorna sem enviar para API.
                    LastTransaction lr = api.getLastTransaction();
                    if (lr != null) {
                        if (lr.getTrsStatus() == LastTransaction.TransactionStatus.APPROVED ||
                                lr.getTrsStatus() == LastTransaction.TransactionStatus.NO_ANSWER) {
                            in.setTrsVoidId(lr.getTrsId());
                            type = 20;
                        }
                    } else {
                        return super.onOptionsItemSelected(item);
                    }
                    break;

                case R.id.logTransacoes:
                    File logTrs = new TransactionReport().getReport();
                    readFromTransactionLog(logTrs);
                    return super.onOptionsItemSelected(item);

                case R.id.cancelar:
                    // in.setTrsReceipt(true);
                    //in.setMerchantPwd(false);
                    //type = 2;

                    startIntentEstorno();
                    break;
                case R.id.config:
                    type = 3;
                    break;
                case R.id.param:
                    type = 4;
                    break;
                case R.id.licenca:
                    type = 5;
                    break;
                case R.id.telecarga:
                    type = 6;
                    break;
                default:
                    return super.onOptionsItemSelected(item);*/


            }
          /*  in.setTrsType(type);

            api.processTransaction(in, new POS7API.Pos7apiCallback() {
                @Override
                public void onResult(ParamOut paramOut) {
                    trataResultado(paramOut);
                }
            });*/
        } catch (Exception e) {
            //trataResultado(null);
        }
        return super.onOptionsItemSelected(item);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this::onMenuItemClick);
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }


}
