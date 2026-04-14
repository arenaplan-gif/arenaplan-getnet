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
import com.arenaplan.pdv.get.pagamento.dialog.data.DadosInfoPop;

public class PopInfo extends DialogFragment {

    private TextView textNumeroEstabelecimento;
    private TextView textValueNumeroSerie;
    private TextView textValorLogicoEquipamento;
    private TextView textValorVersaoApi;
    private TextView textValorCnpj;
    private TextView textValorEstabelecimento;

    private TextView textValorCidade;

    private TextView textRazaoSocial;

    private DadosInfoPop dadosInfoPop;

    private Button butInfo;

    public PopInfo(DadosInfoPop dadosInfoPop) {
        this.dadosInfoPop = dadosInfoPop;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_get_net, null);
        pegaDadosView(view);
        builder.setView(view);




        return builder.create();

    }

    private void pegaDadosView(View view) {
        textNumeroEstabelecimento = view.findViewById(R.id.textNumeroEstabelecimento);
        textValueNumeroSerie = view.findViewById(R.id.textValueNumeroSerie);
        textValorLogicoEquipamento = view.findViewById(R.id.textValorLogicoEquipamento);
        textValorVersaoApi = view.findViewById(R.id.textValorVersaoApi);
        textValorCnpj = view.findViewById(R.id.textValorCnpj);
        textValorEstabelecimento = view.findViewById(R.id.textValorEstabelecimento);
        textRazaoSocial = view.findViewById(R.id.textRazaoSocial);
        textValorCidade = view.findViewById(R.id.textValorCidade);

        if(this.dadosInfoPop != null) {

            textNumeroEstabelecimento.setText(dadosInfoPop.getNumeroEstabelecimento());
            textValueNumeroSerie.setText(dadosInfoPop.getNumeroSerieEquipamento());
            textValorLogicoEquipamento.setText(dadosInfoPop.getNumeroLogicoEquipamento());
            textValorVersaoApi.setText(dadosInfoPop.getVersaoApi());
            textValorCnpj.setText(dadosInfoPop.getCnpjEstabelecimentoVinculado());
            textValorEstabelecimento.setText(dadosInfoPop.getNomeEstabelecimentoVinculado());
            textRazaoSocial.setText(dadosInfoPop.getRazaoSocialEstabelecimento());
            textValorCidade.setText(dadosInfoPop.getCidadeEstabelecimento());
        }


        butInfo = view.findViewById(R.id.butInfo);

        butInfo.setOnClickListener(v -> dismiss());


    }

}
