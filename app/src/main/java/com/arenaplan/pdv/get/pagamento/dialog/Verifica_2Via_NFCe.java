package com.arenaplan.pdv.get.pagamento.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;

public class Verifica_2Via_NFCe extends DialogFragment {
    private Verifica_2Via_NFCe_Fiscal verificaViadoClienteNFCe;
    private Button botaoSIMViadoCliente;
    private Button botaoNAOViadoCliente;

    //@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = inflater.inflate(R.layout.view_pop_verifica_segunda_via_nfce, null);
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
        botaoSIMViadoCliente = view.findViewById(R.id.botaoSIMSegundaViadoCliente);
        botaoNAOViadoCliente = view.findViewById(R.id.botaoNAOSegundaViadoCliente);
        botaoSIMViadoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    verificaViadoClienteNFCe.on2ViadoClienteNAO();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dismiss();
            }
        });
        botaoNAOViadoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    verificaViadoClienteNFCe.on2ViadoClienteSIM();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dismiss();
            }
        });
    }

    //public void setViadoCliente(VerificaViadoClienteTEF verificaViadoClienteTEF) {
    //    this.verificaViadoClienteTEF = verificaViadoClienteTEF;
    //}


    public void setVia_do_ClienteNFCe(Verifica_2Via_NFCe_Fiscal verificaDocumento) {
        this.verificaViadoClienteNFCe = verificaDocumento;
    }


    //public void setViadoCliente() {
    //}
}