package com.arenaplan.pdv.get.util.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;

public class PopSetup extends DialogFragment {

    private Button botaoConfirma;
    private Button botaoSair;

    private SetUp setUp;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.view_pop_setup, null);

        builder.setView(view);
        pegaDadosView(view);

        return builder.create();

    }

    private void pegaDadosView(View view) {

        botaoConfirma = view.findViewById(R.id.botaoConfirma);
        botaoSair = view.findViewById(R.id.botaoSair);

        botaoConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUp.onConfirma();
                dismiss();
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setSetUp(SetUp setUp) {
        this.setUp = setUp;
    }
}
