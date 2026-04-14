package com.arenaplan.pdv.get.opcoes.dialog.ajusteidfiscal;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.database.ContadorController;
import com.arenaplan.pdv.get.database.entidades.ContadorEntidade;

public class AjusteIdFiscalPopUp extends DialogFragment {

    private EditText valorIdFiscalAtual;
    private Button buttonRegistrar;
    private Button sairConfirmar;
    private TextView textViewErro;
    ContadorController contadorController;
    ContadorEntidade contadorEntidade;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        contadorController  = new ContadorController(getActivity());

        View view = inflater.inflate(R.layout.view_pop_ajuste_id_fiscal, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    private void pegaDadosView(View view) {

        valorIdFiscalAtual = view.findViewById(R.id.valorIdFiscalAtual);
        buttonRegistrar = view.findViewById(R.id.buttonRegistrar);
        sairConfirmar = view.findViewById(R.id.sairConfirmar);
        textViewErro = view.findViewById(R.id.textViewErro);
        pegaUltimoId();

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(valorIdFiscalAtual.getText().toString().trim().length() > 0) {

                    float valor = Float.parseFloat(valorIdFiscalAtual.getText().toString());
                    contadorEntidade.setT_idf((long) valor);
                    contadorController.alterarValorContador(contadorEntidade);
                    dismiss();
                }
            }
        });

        sairConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void pegaUltimoId() {

        contadorEntidade = contadorController.getUltimoContador();
        valorIdFiscalAtual.setText(String.valueOf(contadorEntidade.getT_idf()));


    }
}
