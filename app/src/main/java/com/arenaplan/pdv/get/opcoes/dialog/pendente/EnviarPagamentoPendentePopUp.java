package com.arenaplan.pdv.get.opcoes.dialog.pendente;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.PendenteController;

public class EnviarPagamentoPendentePopUp extends DialogFragment {

    private TextView textoEnvioPendentes;
    private Button botaoEnviarPagamentoPendente;
    private Button botaoRemoverPendentes;
    private Button botaoCancelar;
    private PendenteController pendenteController;
    private EnviarPagamentoPendenteAcao enviarPagamentoPendenteAcao;

    public EnviarPagamentoPendentePopUp(EnviarPagamentoPendenteAcao enviarPagamentoPendenteAcao) {
        this.enviarPagamentoPendenteAcao = enviarPagamentoPendenteAcao;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        pendenteController = new PendenteController(getActivity());
        View view = inflater.inflate(R.layout.view_pop_pagamento_pendente, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    private void pegaDadosView(View view) {
        textoEnvioPendentes = view.findViewById(R.id.texto_envio_pendentes);
        botaoEnviarPagamentoPendente = view.findViewById(R.id.botaoEnviarPagamentoPendente);
        botaoCancelar = view.findViewById(R.id.botaoCancelar);
        botaoRemoverPendentes = view.findViewById(R.id.botaoRemoverPendentes);
        pegaTotalPendentes();

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        botaoEnviarPagamentoPendente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enviarPagamentoPendenteAcao.onEnviarPendente();
                dismiss();
            }
        });

        botaoRemoverPendentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pendenteController.deletaTabelaPendente();
                dismiss();
            }
        });


    }

    private void pegaTotalPendentes() {

        int total = pendenteController.listaCarrinhoPendente().size();

        textoEnvioPendentes.setText("Existem "+ total  +" pendentes\n Enviar agora?");

    }
}
