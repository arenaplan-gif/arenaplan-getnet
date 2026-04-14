package com.arenaplan.pdv.get.pagamento.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosStatusGetNet;

public class PopStatusGetNet extends DialogFragment {

    private TextView textValorTransacao;
    private TextView textValorIdentificador;
    private TextView textValorNsu;
    private TextView textNsuGet;
    private TextView textCvNumero;
    private TextView textValueTipo;
    private TextView textValueBandeira;
    private TextView textValueInputType;
    private TextView textQuantidadeParcela;
    private DadosStatusGetNet dadosStatusGetNet;
    private TextView textValueDataTransacao;
    private TextView textValueNsuLocal;
    private TextView textCodigoAutorizacaoOperadora;

    private TextView textNumeroCartao;
    private TextView textValueUltimosDIgitosCartao;

    private TextView textValueExtraScreens;

    private TextView textValorNomePortadorCartao;

    private TextView textValorAutomationSlip;

    private Button buttonOk;

    public PopStatusGetNet(DadosStatusGetNet dadosStatusGetNet) {
        this.dadosStatusGetNet = dadosStatusGetNet;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_status_get_net, null);
        pegaDadosView(view);
        builder.setView(view);




        return builder.create();

    }

    private void pegaDadosView(View view) {
        textValorTransacao = view.findViewById(R.id.textValorTransacao);
        textValorIdentificador = view.findViewById(R.id.textValorIdentificador);
        textValorNsu = view.findViewById(R.id.textValorNsu);
        textNsuGet = view.findViewById(R.id.textNsuGet);
        textCvNumero = view.findViewById(R.id.textCvNumero);
        textValueTipo = view.findViewById(R.id.textValueTipo);
        textValueBandeira = view.findViewById(R.id.textValueBandeira);
        textValueInputType = view.findViewById(R.id.textValueInputType);
        textQuantidadeParcela = view.findViewById(R.id.textQuantidadeParcela);
        textValueDataTransacao = view.findViewById(R.id.textValueDataTransacao);
        textValueNsuLocal = view.findViewById(R.id.textValueNsuLocal);
        textCodigoAutorizacaoOperadora = view.findViewById(R.id.textCodigoAutorizacaoOperadora);
        textNumeroCartao = view.findViewById(R.id.textNumeroCartao);
        textValueUltimosDIgitosCartao = view.findViewById(R.id.textValueUltimosDIgitosCartao);
        textValueExtraScreens = view.findViewById(R.id.textValueExtraScreens);
        textValorNomePortadorCartao = view.findViewById(R.id.textValorNomePortadorCartao);
        textValorAutomationSlip = view.findViewById(R.id.textValorAutomationSlip);
        buttonOk = view.findViewById(R.id.buttonOk);
        if(dadosStatusGetNet != null) {
            textValorTransacao.setText(this.dadosStatusGetNet.getAmout());
            textValorIdentificador.setText(this.dadosStatusGetNet.getCallerid());
            textValorNsu.setText(this.dadosStatusGetNet.getNsu());
            textNsuGet.setText(this.dadosStatusGetNet.getNsulastsucessful());
            textCvNumero.setText(this.dadosStatusGetNet.getCvnumber());
            textValueTipo.setText(this.dadosStatusGetNet.getType());
            textValueBandeira.setText(this.dadosStatusGetNet.getBrand());
            textValueInputType.setText(this.dadosStatusGetNet.getInputtype());
            textQuantidadeParcela.setText(this.dadosStatusGetNet.getInstallments());
            textValueDataTransacao.setText(this.dadosStatusGetNet.getGmdatatime());
            textValueNsuLocal.setText(this.dadosStatusGetNet.getNsulocal());
            textCodigoAutorizacaoOperadora.setText(this.dadosStatusGetNet.getAutorizationcode());
            textNumeroCartao.setText(this.dadosStatusGetNet.getCardbin());
            textValueUltimosDIgitosCartao.setText(this.dadosStatusGetNet.getCardlastdigitis());
            textValueExtraScreens.setText(this.dadosStatusGetNet.getExtrascreensresult());
            textValorNomePortadorCartao.setText(this.dadosStatusGetNet.getCardholdername());
            textValorAutomationSlip.setText(this.dadosStatusGetNet.getAutomationslip());
        }

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }
}
