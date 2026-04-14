package com.arenaplan.pdv.get.pagamento.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;

public class VerificaDocumentoPagamento extends DialogFragment {
    private  VerificaDocumento verificaDocumento;
    private Button botaoSemDocumento;
    private Button botaoDocumento;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.view_pop_verifica_documento_pagamento, null);

        pegaDadosView(view);
        builder.setView(view);
        return builder.create();
    }

    private void pegaDadosView(View view) {
        botaoDocumento = view.findViewById(R.id.botaoDocumento);
        botaoSemDocumento = view.findViewById(R.id.botaoSemDocumento);
        botaoDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaDocumento.onInformarDocumento();
                dismiss();
            }
        });
        botaoSemDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaDocumento.onNaoInformarDocumento();
                dismiss();
            }
        });
    }

    public void setVerificaDocumento(VerificaDocumento verificaDocumento) {
        this.verificaDocumento = verificaDocumento;
    }


}
