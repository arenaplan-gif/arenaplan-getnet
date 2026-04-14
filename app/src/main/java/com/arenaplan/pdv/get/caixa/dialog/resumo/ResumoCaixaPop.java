package com.arenaplan.pdv.get.caixa.dialog.resumo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.model.ResumoCaixa;
import com.arenaplan.pdv.get.util.DateUtils;
import com.arenaplan.pdv.get.util.Monetario;

public class ResumoCaixaPop extends DialogFragment {



    private TextView textNomeEmpresa;
    private TextView valorDataEmissao;
    private TextView textSituacaoStatus;
    private TextView valorDinheiro;
    private TextView textoValorDebito;
    private TextView valorCredito;
    private TextView valorPrepago;
    private TextView valorPix;
    private TextView valorVoucher;
    private TextView valorCheque;
    private TextView valorTroco;
    private TextView valorTotalGeral;
    private TextView valorDataAbertura;
    private TextView valorDataFechamento;
    private Button buttonImprimir;
    private Button buttonSair;

    private ResumoCaixaAcao resumoCaixaAcao;
    private ResumoCaixa resumoCaixa;
    private String nomeEmpresa;
    float fDinheiro =  0;
    float fDebito =  0;
    float fCredito =  0;
    float fPrepago =  0;
    float fPix =  0;
    float fVoucher =  0;
    float fCheque =  0;
    float fTroco = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_resumo_caixa, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    public  ResumoCaixaPop(ResumoCaixa resumoCaixa, String nomeEmpresa, ResumoCaixaAcao resumoCaixaAcao) {

        this.resumoCaixa = resumoCaixa;
        this.nomeEmpresa = nomeEmpresa;
        this.resumoCaixaAcao = resumoCaixaAcao;
    }


    private void pegaDadosView(View view) {

        textNomeEmpresa = view.findViewById(R.id.textNomeEmpresa);
        valorDataEmissao = view.findViewById(R.id.valorDataEmissao);
        textSituacaoStatus = view.findViewById(R.id.textSituacaoStatus);
        valorDinheiro = view.findViewById(R.id.valorDinheiro);
        valorCredito = view.findViewById(R.id.valorCredito);
        textoValorDebito = view.findViewById(R.id.textoValorDebito);
        valorPrepago = view.findViewById(R.id.valorPrepago);
        valorPix = view.findViewById(R.id.valorPix);
        valorVoucher = view.findViewById(R.id.valorVoucher);
        valorCheque = view.findViewById(R.id.valorCheque);
        valorTroco = view.findViewById(R.id.valorTroco);
        valorTotalGeral = view.findViewById(R.id.valorTotalGeral);
        valorDataAbertura = view.findViewById(R.id.valorDataAbertura);
        valorDataFechamento = view.findViewById(R.id.valorDataFechamento);

        buttonImprimir = view.findViewById(R.id.buttonImprimir);
        buttonSair = view.findViewById(R.id.buttonSair);
        colocarDadosNaTela();

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        buttonImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumoCaixaAcao.onImprimir(resumoCaixa);
            }
        });
    }

    private void colocarDadosNaTela() {

        textNomeEmpresa.setText(this.nomeEmpresa);

        String data = DateUtils.retornaDiaAtual();
        String hora = DateUtils.retornaHoraAtual();

        valorDataEmissao.setText(data + " " + hora);

        if(this.resumoCaixa.getStatus().equalsIgnoreCase("F") ) {
            textSituacaoStatus.setText("Fechado");
        } else {
            textSituacaoStatus.setText("Aberto");
        }

        if(this.resumoCaixa.getDinheiro() != null) {
            fDinheiro = Float.parseFloat(this.resumoCaixa.getDinheiro());
        }
        if(this.resumoCaixa.getDebito() != null) {
            fDebito = Float.parseFloat(this.resumoCaixa.getDebito());
        }
        if(this.resumoCaixa.getCredito() != null) {
            fCredito = Float.parseFloat(this.resumoCaixa.getCredito());
        }

        if(this.resumoCaixa.getPrepago() != null) {
            fPrepago = Float.parseFloat(this.resumoCaixa.getPrepago());
        }
        if(this.resumoCaixa.getPix() != null) {
            fPix = Float.parseFloat(this.resumoCaixa.getPix());
        }
        if(this.resumoCaixa.getVoucher() != null) {
            fVoucher = Float.parseFloat(this.resumoCaixa.getVoucher());
        }
        if(this.resumoCaixa.getCheque() != null) {
            fCheque = Float.parseFloat(this.resumoCaixa.getCheque());
        }

        if(this.resumoCaixa.getTroco() != null) {
            fTroco = Float.parseFloat(this.resumoCaixa.getTroco());
        }

        float totalGeral = fDinheiro + fDebito + fCredito + fPrepago + fPix + fVoucher + fCheque + fTroco;

        valorDinheiro.setText(Monetario.converteValorFloatParaReal(fDinheiro));
        textoValorDebito.setText(Monetario.converteValorFloatParaReal(fDebito));
        valorCredito.setText(Monetario.converteValorFloatParaReal(fCredito));
        valorPrepago.setText(Monetario.converteValorFloatParaReal(fPrepago));
        valorPix.setText(Monetario.converteValorFloatParaReal(fPix));
        valorVoucher.setText(Monetario.converteValorFloatParaReal(fVoucher));
        valorCheque.setText(Monetario.converteValorFloatParaReal(fCheque));
        valorTroco.setText(Monetario.converteValorFloatParaReal(fTroco));
        valorTotalGeral.setText(Monetario.converteValorFloatParaReal((totalGeral)));


        valorDataAbertura.setText(this.resumoCaixa.getData_abertura());
        valorDataFechamento.setText(this.resumoCaixa.getData_fechamento());

    }


}
