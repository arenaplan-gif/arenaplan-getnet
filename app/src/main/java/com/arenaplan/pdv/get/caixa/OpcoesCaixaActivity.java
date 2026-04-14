package com.arenaplan.pdv.get.caixa;

import static com.arenaplan.pdv.get.util.Constantes.ABRE_CAIXA;
import static com.arenaplan.pdv.get.util.Constantes.CODIGO_SUCESSO;
import static com.arenaplan.pdv.get.util.Constantes.CONSULTA_CAIXA;
import static com.arenaplan.pdv.get.util.Constantes.FECHA_CAIXA;
import static com.arenaplan.pdv.get.util.Constantes.FORMATO;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.RetrofitConfig;
import com.arenaplan.pdv.get.api.model.AbreCaixaCard;
import com.arenaplan.pdv.get.api.model.ResumoCaixa;
import com.arenaplan.pdv.get.api.model.ResumoCaixaCard;
import com.arenaplan.pdv.get.caixa.dialog.abrecaixa.AbreCaixaAcao;
import com.arenaplan.pdv.get.caixa.dialog.abrecaixa.AbreCaixaPopUp;
import com.arenaplan.pdv.get.caixa.dialog.resumo.ResumoCaixaAcao;
import com.arenaplan.pdv.get.caixa.dialog.resumo.ResumoCaixaPop;
import com.arenaplan.pdv.get.util.BaseActivity;
import com.arenaplan.pdv.get.util.DateUtils;
import com.arenaplan.pdv.get.util.Monetario;
import com.getnet.posdigital.PosDigital;
import com.getnet.posdigital.printer.AlignMode;
import com.getnet.posdigital.printer.FontFormat;
import com.getnet.posdigital.printer.IPrinterCallback;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpcoesCaixaActivity extends BaseActivity {
        //DialogFragment {
//
    ArenaplanPdvApplication mApplication;
    private int timeOut = 35;
    private String codigo;
    private String usuario;
    private String senha;
    //private ConstraintLayout progressOpcoesCaixa;
    private RelativeLayout progressOpcoesCaixa;
    private Button buttonAbrirCaixa;
    private Button buttonFechaCaixa;
    private Button btStatusCaixa;
    private TextView textDataHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_caixa);
        mApplication = (ArenaplanPdvApplication) getApplicationContext();

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

    }

    private void pegaIdTela() {

        progressOpcoesCaixa = findViewById(R.id.progressOpcoesCaixa);
        buttonAbrirCaixa = findViewById(R.id.buttonAbrirCaixa);
        buttonFechaCaixa = findViewById(R.id.buttonFechaCaixa);
        btStatusCaixa = findViewById(R.id.btStatusCaixa);
        textDataHora = findViewById(R.id.textView11);
        cliqueBotao();

        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();

        textDataHora.setText(data + "\n" + hora);
        Timer();
    }

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

    public void Timer() {
        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 30000);
    }

    private void cliqueBotao() {

        buttonAbrirCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrePopAberturaCaixa();
            }
        });

        buttonFechaCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressOpcoesCaixa.setVisibility(View.VISIBLE);
                executaApiFecharCaixa();
            }
        });

        btStatusCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressOpcoesCaixa.setVisibility(View.VISIBLE);
                executaApiStatusCaixa();

            }
        });
    }

    /**
     * Alerta Opcoes Caixa
     **/

    private void alertaSucessoOpcaoCaixa(String mensagem) {
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

    private void abrePopAberturaCaixa() {

        AbreCaixaPopUp abreCaixaPopUp = new AbreCaixaPopUp();

        abreCaixaPopUp.registraAcaoAbreCaixa(new AbreCaixaAcao() {
            @Override
            public void onValorDinheiro(float dinheiro) {

                progressOpcoesCaixa.setVisibility(View.VISIBLE);
                executeApiAbreCaixa(dinheiro);
            }
        });
        abreCaixaPopUp.show(getSupportFragmentManager(), "abreCaixaPopUp");


    }


    private void executeApiAbreCaixa(float valorTroco) {

        Call<AbreCaixaCard> call = new RetrofitConfig(timeOut).getPDVService().abreCaixa(
                usuario,
                senha,
                codigo,
                ABRE_CAIXA,
                String.valueOf(valorTroco),
                FORMATO);

        call.enqueue(new Callback<AbreCaixaCard>() {
            @Override
            public void onResponse(Call<AbreCaixaCard> call, Response<AbreCaixaCard> response) {

                AbreCaixaCard abreCaixaCard = response.body();

                progressOpcoesCaixa.setVisibility(View.GONE);

                if (CODIGO_SUCESSO.equalsIgnoreCase(abreCaixaCard.getAbreCaixa().getError_code())) {

                    alertaSucessoOpcaoCaixa("Caixa Aberto");
                }
            }

            @Override
            public void onFailure(Call<AbreCaixaCard> call, Throwable t) {
                progressOpcoesCaixa.setVisibility(View.GONE);

            }
        });
    }

    private void executaApiFecharCaixa() {

        Call<ResumoCaixaCard> call = new RetrofitConfig(timeOut).getPDVService().fecharCaixa(
                usuario,
                senha,
                codigo,
                FECHA_CAIXA,
                FORMATO
        );

        call.enqueue(new Callback<ResumoCaixaCard>() {
            @Override
            public void onResponse(Call<ResumoCaixaCard> call, Response<ResumoCaixaCard> response) {
                progressOpcoesCaixa.setVisibility(View.GONE);

                ResumoCaixaCard resumoCaixaCard = response.body();

                if (CODIGO_SUCESSO.equalsIgnoreCase(resumoCaixaCard.getResumoCaixa().getError_code())) {
                    abrePopResumoCompra(resumoCaixaCard.getResumoCaixa());
                }
            }

            @Override
            public void onFailure(Call<ResumoCaixaCard> call, Throwable t) {
                progressOpcoesCaixa.setVisibility(View.GONE);

            }
        });
    }

    private void executaApiStatusCaixa() {
        Call<ResumoCaixaCard> call = new RetrofitConfig(timeOut).getPDVService().statusCaixa(
                usuario,
                senha,
                codigo,
                CONSULTA_CAIXA,
                FORMATO
        );

        call.enqueue(new Callback<ResumoCaixaCard>() {
            @Override
            public void onResponse(Call<ResumoCaixaCard> call, Response<ResumoCaixaCard> response) {
                progressOpcoesCaixa.setVisibility(View.GONE);

                ResumoCaixaCard resumoCaixaCard = response.body();

                if (CODIGO_SUCESSO.equalsIgnoreCase(resumoCaixaCard.getResumoCaixa().getError_code())) {
                    abrePopResumoCompra(resumoCaixaCard.getResumoCaixa());
                }
            }

            @Override
            public void onFailure(Call<ResumoCaixaCard> call, Throwable t) {
                progressOpcoesCaixa.setVisibility(View.GONE);

            }
        });
    }


    private void abrePopResumoCompra(ResumoCaixa resumoCaixa) {


        ResumoCaixaPop resumoCaixaPop = new ResumoCaixaPop(resumoCaixa, mApplication.getSetUp().getT_razao(), new ResumoCaixaAcao() {
            @Override
            public void onImprimir(ResumoCaixa resumoCaixa) {
                ImprimirComprovateCaixa(resumoCaixa);
            }
        });

        resumoCaixaPop.show(getSupportFragmentManager(), "resumoCaixaPop");
    }

    private void Mensagem_Erro() {
        Dialog dialog = null;
        Button dialogButton = (Button) dialog.findViewById(R.id.dialog_btn);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    /**
     * Impresao
     **/

    private void ImprimirComprovateCaixa(ResumoCaixa resumoCaixa) {

        try {
            if (PosDigital.getInstance().isInitiated()) {
                try {
                    PosDigital.getInstance().getPrinter().init();
                    PosDigital.getInstance().getPrinter().setGray(5);
                    PosDigital.getInstance().getPrinter().defineFontFormat(FontFormat.MEDIUM);
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "STATUS DE CAIXA");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_razao());
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Term.1");

                    String data = DateUtils.retornaDiaAtual();
                    String hora = DateUtils.retornaHoraAtual();

                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Emissão: " + data + " " + hora);
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");

                    String status = "";
                    if (resumoCaixa.getStatus().equalsIgnoreCase("F")) {
                        status = "Fechado";
                    } else {
                        status = "Aberto";
                    }

                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Status: " + status);

                    float fDinheiro = 0;
                    float fDebito = 0;
                    float fCredito = 0;
                    float fPrepago = 0;
                    float fPix = 0;
                    float fVoucher = 0;
                    float fCheque = 0;
                    float fTroco = 0;


                    if (resumoCaixa.getDinheiro() != null) {
                        fDinheiro = Float.parseFloat(resumoCaixa.getDinheiro());
                    }
                    if (resumoCaixa.getDebito() != null) {
                        fDebito = Float.parseFloat(resumoCaixa.getDebito());
                    }
                    if (resumoCaixa.getCredito() != null) {
                        fCredito = Float.parseFloat(resumoCaixa.getCredito());
                    }
                    if (resumoCaixa.getPrepago() != null) {
                        fPrepago = Float.parseFloat(resumoCaixa.getPrepago());
                    }

                    if (resumoCaixa.getPix() != null) {
                        fPix = Float.parseFloat(resumoCaixa.getPix());
                    }
                    if (resumoCaixa.getVoucher() != null) {
                        fVoucher = Float.parseFloat(resumoCaixa.getVoucher());
                    }
                    if (resumoCaixa.getCheque() != null) {
                        fCheque = Float.parseFloat(resumoCaixa.getCheque());
                    }

                    if (resumoCaixa.getTroco() != null) {
                        fTroco = Float.parseFloat(resumoCaixa.getTroco());
                    }

                    float totalGeral = fDinheiro + fDebito + fCredito + fPrepago + fPix + fVoucher + fCheque + fTroco;

                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Dinheiro: " + Monetario.converteValorFloatParaReal(fDinheiro));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Débito: " + Monetario.converteValorFloatParaReal(fDebito));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Crédito: " + Monetario.converteValorFloatParaReal(fCredito));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Pré Pago: " + Monetario.converteValorFloatParaReal(fPrepago));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Pix: " + Monetario.converteValorFloatParaReal(fPix));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Voucher: " + Monetario.converteValorFloatParaReal(fVoucher));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Cheque: " + Monetario.converteValorFloatParaReal(fCheque));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Troco: " + Monetario.converteValorFloatParaReal(fTroco));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Geral: " + Monetario.converteValorFloatParaReal(totalGeral));
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Abertura: " + resumoCaixa.getData_abertura());
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Fechamento: " + resumoCaixa.getData_fechamento());
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");
                    PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " ");

                    PosDigital.getInstance().getPrinter().print(new IPrinterCallback.Stub() {
                        @Override
                        public void onSuccess() throws RemoteException {
                            //openInfoDialog("Impresso com sucesso");
                            Mensagem_Erro();
                            //return;
                        }

                        @Override
                        public void onError(int i) throws RemoteException {
                            Mensagem_Erro();
                            //return;
                        }
                    });
                } catch (Exception e) {
                    Mensagem_Erro();
                    //return;
                }
            } else {
                // falha no service de impressão
                // refaça o start da activity que
                // extende a BaseActivity para reconectar o service
                //openErrorDialog("Falha na impressão\n Tente novamente.")
                Mensagem_Erro();
            }

        } catch (Exception e) {
            Mensagem_Erro();
            //return;
        }
    }
}



/*

        iGedi = GEDI.getInstance(OpcoesCaixaActivity.this);
                ICL mCL = iGedi.getCL();
                //  try {
                iGedi = GEDI.getInstance(OpcoesCaixaActivity.this);
                mCL = iGedi.getCL();
                //  try {
                IPRNTR iprntr;
                mCL.PowerOff();
                iprntr = iGedi.getPRNTR();
                iprntr.Init();

                configPrint.setItalico(false);
                configPrint.setNegrito(true);
                configPrint.setTamanho(80);
                configPrint.setFonte("Courier_Prime");
                GEDI_PRNTR_st_StringConfig strconfig = new GEDI_PRNTR_st_StringConfig(new Paint());
                strconfig.paint.setTextSize(24);
                strconfig.paint.setFontFeatureSettings("MONOSPACE");
                strconfig.paint.setTextAlign(Paint.Align.valueOf("CENTER"));
                strconfig.offset = 0;
                strconfig.lineSpace = 0;

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "STATUS DE CAIXA");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, mApplication.getSetUp().getT_razao());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Term.1");

                String data = DateUtils.retornaDiaAtual();
                String hora = DateUtils.retornaHoraAtual();

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Emissão: " + data + " " + hora);
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "---------------------------------");

                String status = "";
                if (resumoCaixa.getStatus().equalsIgnoreCase("F")) {
                    status = "Fechado";
                } else {
                    status = "Aberto";
                }

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Status: " + status);

                float fDinheiro = 0;
                float fDebito = 0;
                float fCredito = 0;
                float fPrepago = 0;
                float fPix = 0;
                float fVoucher = 0;
                float fCheque = 0;
                float fTroco = 0;


                if (resumoCaixa.getDinheiro() != null) {
                    fDinheiro = Float.parseFloat(resumoCaixa.getDinheiro());
                }
                if (resumoCaixa.getDebito() != null) {
                    fDebito = Float.parseFloat(resumoCaixa.getDebito());
                }
                if (resumoCaixa.getCredito() != null) {
                    fCredito = Float.parseFloat(resumoCaixa.getCredito());
                }
                if (resumoCaixa.getPrepago() != null) {
                    fPrepago = Float.parseFloat(resumoCaixa.getPrepago());
                }

                if (resumoCaixa.getPix() != null) {
                    fPix = Float.parseFloat(resumoCaixa.getPix());
                }
                if (resumoCaixa.getVoucher() != null) {
                    fVoucher = Float.parseFloat(resumoCaixa.getVoucher());
                }
                if (resumoCaixa.getCheque() != null) {
                    fCheque = Float.parseFloat(resumoCaixa.getCheque());
                }

                if (resumoCaixa.getTroco() != null) {
                    fTroco = Float.parseFloat(resumoCaixa.getTroco());
                }

                float totalGeral = fDinheiro + fDebito + fCredito + fPrepago + fPix + fVoucher + fCheque + fTroco;

                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Dinheiro: " + Monetario.converteValorFloatParaReal(fDinheiro));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Débito: " + Monetario.converteValorFloatParaReal(fDebito));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Crédito: " + Monetario.converteValorFloatParaReal(fCredito));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Pré Pago: " + Monetario.converteValorFloatParaReal(fPrepago));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Pix: " + Monetario.converteValorFloatParaReal(fPix));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Voucher: " + Monetario.converteValorFloatParaReal(fVoucher));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Cheque: " + Monetario.converteValorFloatParaReal(fCheque));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Troco: " + Monetario.converteValorFloatParaReal(fTroco));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Total Geral: " + Monetario.converteValorFloatParaReal(totalGeral));
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Abertura: " + resumoCaixa.getData_abertura());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, "Data Fechamento: " + resumoCaixa.getData_fechamento());
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                PosDigital.getInstance().getPrinter().addText(AlignMode.LEFT, " " );
                iprntr.Output();

            } catch (Exception e) {

            }
*/



