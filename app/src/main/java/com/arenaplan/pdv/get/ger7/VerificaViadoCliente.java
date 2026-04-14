package com.arenaplan.pdv.get.ger7;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;

public class VerificaViadoCliente extends DialogFragment {
    private VerificaViadoClienteTEF verificaViadoCliente;
    private Button botaoSIMViadoCliente;
    private Button botaoNAOViadoCliente;

    //@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = inflater.inflate(R.layout.view_pop_verifica_via_do_cliente_pagto_cartao, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();
    }

    /*@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = inflater.inflate(R.layout.view_pop_verifica_via_do_cliente_pagto_cartao, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();
    }*/

    private void pegaDadosView(View view) {
        botaoSIMViadoCliente = view.findViewById(R.id.botaoSIMViadoCliente);
        botaoNAOViadoCliente = view.findViewById(R.id.botaoNAOViadoCliente);
        botaoSIMViadoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    verificaViadoCliente.onViadoClienteNAO();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //dismiss();
            }
        });
        botaoNAOViadoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    verificaViadoCliente.onViadoClienteSIM();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //dismiss();
            }
        });
    }

    //public void setViadoCliente(VerificaViadoClienteTEF verificaViadoClienteTEF) {
    //    this.verificaViadoClienteTEF = verificaViadoClienteTEF;
    //}


    public void setVia_do_Cliente(VerificaViadoClienteTEF verificaDocumento) {
        this.verificaViadoCliente = verificaDocumento;
    }


    //public void setViadoCliente() {
    //}
}