package com.arenaplan.pdv.get.pagamento.dialog;

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
import com.arenaplan.pdv.get.util.MoneyTextWatcherBr;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class PopDinheiro extends DialogFragment {

    float valorCarrinho;
    private  ValorInformado valorInformado;
    private TextView textViewErro;
    private Button botaoConfirmarRecebimento;
    private Button sairConfirmarRecebimento;


    private EditText editValorInformado;

    public PopDinheiro(float valorCarrinho, ValorInformado valorInformado) {

        this.valorCarrinho  = valorCarrinho;
        this.valorInformado = valorInformado;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.view_pop_dinheiro, null);
        pegaDadosView(view);
        builder.setView(view);




        return builder.create();

    }

    private void pegaDadosView(View view) {

        editValorInformado = view.findViewById(R.id.editValorInformado);
        editValorInformado.addTextChangedListener(new MoneyTextWatcherBr(editValorInformado));
        textViewErro = view.findViewById(R.id.textViewErro);
        botaoConfirmarRecebimento = view.findViewById(R.id.botaoConfirmarRecebimento);
        sairConfirmarRecebimento = view.findViewById(R.id.SairConfirmarRecebimento);
        cliqueConfirma();

    }

    private void cliqueConfirma() {

        botaoConfirmarRecebimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editValorInformado.getText().toString().length() > 0) {
                    String valorTelax = editValorInformado.getText().toString().replace(".","");
                    String valorTelax2=valorTelax.toString().replace(",",".");
                    String valorTelax3=valorTelax2.toString().replaceAll("\\s+","");
                    float valorTela = Float.parseFloat(valorTelax3);

                    if(valorTela < valorCarrinho) {
                        textViewErro.setVisibility(View.VISIBLE);
                    } else {
                        textViewErro.setVisibility(View.GONE);
                        retornaTelaPagamento();
                    }
                }
            }
        });

        sairConfirmarRecebimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }


    public static float parseFloatBR(String valor) {
        try {
            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            Number number = format.parse(valor);
            return number.floatValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0f;
        }
    }

    private void retornaTelaPagamento() {
        //float valorTela1 = Float.parseFloat(editValorInformado.getText().toString().replace("",","));
        String valorTelax = editValorInformado.getText().toString().replace(".","");
        //float valorTela = Float.parseFloat(valorTelax.toString().replace(",","."));
        //float valorTela = Float.parseFloat(editValorInformado.getText().toString().replace(",","."));
        String valorTelax2=valorTelax.toString().replace(",",".");
        String valorTelax3=valorTelax2.toString().replaceAll("\\s+","");
        float valorTela = Float.parseFloat(valorTelax3);

        float valorTroco = valorTela - valorCarrinho;
        this.valorInformado.onValorInformado(valorTela,valorTroco);
        dismiss();
    }
}
