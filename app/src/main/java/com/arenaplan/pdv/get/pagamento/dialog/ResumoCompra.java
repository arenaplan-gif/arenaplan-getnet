package com.arenaplan.pdv.get.pagamento.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.util.Monetario;

public class ResumoCompra extends DialogFragment {

    private float valorTotal;
    private float valorDesconto;
    private float valorLiquido;
    private float valorRecebido;
    private float valorTroco;
    private TextView tvValorTotal;
    private TextView tvValorDesconto;
    private TextView tvValorLiquido;
    private TextView tvValorRecebido;
    private TextView tvValorTroco;
    private Button botaoConfirmaCompra;
    private Button desisteCompra;

    private ConfirmaPagamento confirmaPagamento;


    public ResumoCompra(float valorTotal, float valorDesconto, float valorLiquido, float valorRecebido, float valorTroco, ConfirmaPagamento confirmaPagamento) {

        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorLiquido = valorLiquido;
        this.valorRecebido = valorRecebido;
        this.valorTroco = valorTroco;
        this.confirmaPagamento = confirmaPagamento;

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.view_resumo_compra, null);

        pegaDadosView(view);
        exibeValoresTela();
        builder.setView(view);

        return builder.create();

    }

    private void pegaDadosView(View view) {

        tvValorTotal = view.findViewById(R.id.tvValorTotal);
        tvValorDesconto = view.findViewById(R.id.tvValorDesconto);
        tvValorLiquido = view.findViewById(R.id.tvValorLiquido);
        tvValorRecebido = view.findViewById(R.id.tvValorRecebido);
        tvValorTroco = view.findViewById(R.id.tvValorTroco);

        botaoConfirmaCompra = view.findViewById(R.id.botaoConfirmaCompra);
        desisteCompra = view.findViewById(R.id.desisteCompra);
        botaoConfirmaCompra.setOnClickListener(v -> {
            dismiss();
            confirmaPagamento.confirmaPagamento();
        });

        desisteCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void exibeValoresTela() {

        tvValorTotal.setText(Monetario.converteValorFloatParaReal(this.valorTotal));
        tvValorDesconto.setText(Monetario.converteValorFloatParaReal(this.valorDesconto));
        tvValorLiquido.setText(Monetario.converteValorFloatParaReal(this.valorLiquido));
        tvValorRecebido.setText(Monetario.converteValorFloatParaReal(this.valorRecebido));
        tvValorTroco.setText(Monetario.converteValorFloatParaReal(this.valorTroco));
    }
}
