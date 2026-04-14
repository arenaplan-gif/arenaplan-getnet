package com.arenaplan.pdv.get.caixa.dialog.abrecaixa;

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
import com.arenaplan.pdv.get.util.MoneyTextWatcher;

public class AbreCaixaPopUp extends DialogFragment {

    private AbreCaixaAcao abreCaixaAcao;
    private EditText valorTroco;
    private Button buttonRegistrar;
    private Button sairConfirmar;
    private TextView textViewErro;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_abre_caixa, null);
        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

    private void pegaDadosView(View view) {

        valorTroco = view.findViewById(R.id.usuario);

        valorTroco.addTextChangedListener(new MoneyTextWatcher(valorTroco));
        sairConfirmar = view.findViewById(R.id.sairConfirmar);
        buttonRegistrar = view.findViewById(R.id.buttonRegistrar);
        textViewErro = view.findViewById(R.id.textViewErro);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(valorTroco.getText().toString().length() > 0) {
                    textViewErro.setVisibility(View.GONE);
                    float valorTela = Float.parseFloat(valorTroco.getText().toString().replace(",","."));

                    abreCaixaAcao.onValorDinheiro(valorTela);
                    dismiss();

                } else {
                    textViewErro.setVisibility(View.VISIBLE);

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

    public void registraAcaoAbreCaixa(AbreCaixaAcao abreCaixaAcao) {
        this.abreCaixaAcao = abreCaixaAcao;
    }
}
