package com.arenaplan.pdv.get.opcoes.dialog.reimpressao;

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

public class ReimpressaoTransacaoPopUp extends DialogFragment {

    private Button buttonReimprimirIdFiscal;
    private Button SairConfirmarIDFiscal;
    private TextView textViewErro;
    private EditText numeroCumpomFiscal;
    private ReimpressaoTransacaoAcao reimpressaoTransacaoAcao;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_reimpressao_transacao, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    public void setReimpressaoTransacaoAcao(ReimpressaoTransacaoAcao reimpressaoTransacaoAcao) {

        this.reimpressaoTransacaoAcao = reimpressaoTransacaoAcao;
    }

    private void pegaDadosView(View view) {

        buttonReimprimirIdFiscal = view.findViewById(R.id.buttonReimprimirIdFiscal);
        SairConfirmarIDFiscal = view.findViewById(R.id.SairConfirmarIDFiscal);
        textViewErro = view.findViewById(R.id.textViewErro);
        numeroCumpomFiscal = view.findViewById(R.id.numeroCumpomFiscal);

        SairConfirmarIDFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        buttonReimprimirIdFiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numeroCumpomFiscal.getText().toString().trim().length() == 0) {
                    textViewErro.setVisibility(View.VISIBLE);
                } else {
                    reimpressaoTransacaoAcao.onReimpresao(numeroCumpomFiscal.getText().toString().trim());
                    dismiss();

                }
            }
        });
    }
}
