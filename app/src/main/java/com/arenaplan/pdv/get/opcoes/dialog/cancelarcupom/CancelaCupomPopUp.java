package com.arenaplan.pdv.get.opcoes.dialog.cancelarcupom;

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

public class CancelaCupomPopUp extends DialogFragment {

    private Button buttonCancelarIdFiscal;
    private Button SairConfirmarIDFiscal;
    private EditText numeroCumpomFiscal;
    private TextView textViewErro;
    private CancelarCupomAcao cancelarCupomAcao;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_cancelar_cupom, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    public void registraAcaoCancelar(CancelarCupomAcao cancelarCupomAcao) {
        this.cancelarCupomAcao = cancelarCupomAcao;
    }

    private void pegaDadosView(View view) {

        buttonCancelarIdFiscal = view.findViewById(R.id.buttonCancelarIdFiscal);
        SairConfirmarIDFiscal = view.findViewById(R.id.SairConfirmarIDFiscal);
        numeroCumpomFiscal = view.findViewById(R.id.numeroCumpomFiscal);
        textViewErro = view.findViewById(R.id.textViewErro);

        buttonCancelarIdFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numeroCumpomFiscal.getText().toString().trim().length() == 0) {
                    textViewErro.setVisibility(View.VISIBLE);
                } else {
                    cancelarCupomAcao.onCancelar(numeroCumpomFiscal.getText().toString().trim());
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
}
