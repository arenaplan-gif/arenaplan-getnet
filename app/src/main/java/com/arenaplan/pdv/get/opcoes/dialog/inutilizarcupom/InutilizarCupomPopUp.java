package com.arenaplan.pdv.get.opcoes.dialog.inutilizarcupom;

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

public class InutilizarCupomPopUp extends DialogFragment {

    private Button buttonInutilizarIdFiscal;
    private Button SairConfirmarIDFiscal;
    private EditText numeroCumpomFiscal;
    private TextView textViewErro;
    private InutilizarCupomAcao inutilizarCupomAcao;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_inutilizar_cupom, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    private void pegaDadosView(View view){

        buttonInutilizarIdFiscal = view.findViewById(R.id.buttonInutilizarIdFiscal);
        SairConfirmarIDFiscal = view.findViewById(R.id.SairConfirmarIDFiscal);
        numeroCumpomFiscal = view.findViewById(R.id.numeroCumpomFiscal);
        textViewErro = view.findViewById(R.id.textViewErro);

        buttonInutilizarIdFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numeroCumpomFiscal.getText().toString().trim().length() == 0) {
                    textViewErro.setVisibility(View.VISIBLE);
                } else {
                    inutilizarCupomAcao.onInutilizar(numeroCumpomFiscal.getText().toString().trim());
                    dismiss();

                }
            }
        });

        SairConfirmarIDFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void registraAcaoInutilizar(InutilizarCupomAcao inutilizarCupomAcao) {
        this.inutilizarCupomAcao = inutilizarCupomAcao;
    }
}
