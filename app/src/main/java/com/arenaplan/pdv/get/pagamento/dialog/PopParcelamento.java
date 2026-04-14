package com.arenaplan.pdv.get.pagamento.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.util.Monetario;

public class PopParcelamento  extends DialogFragment {


    RadioGroup rgproduto;

    PopParcelamentoCallBack popParcelamentoCallBack;
    String numeroPedido;
    Float valorCompra;

    TextView pedido;
    TextView total;

    public PopParcelamento(String numeroPedido , Float valorCompra , PopParcelamentoCallBack popParcelamentoCallBack) {
        this.popParcelamentoCallBack = popParcelamentoCallBack;
        this.numeroPedido = numeroPedido;
        this.valorCompra = valorCompra;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.pagamento, null);
        pegaDadosView(view);
        builder.setView(view);




        return builder.create();
    }

    private void pegaDadosView(View view) {

        rgproduto = view.findViewById(R.id.rgproduto);
        pedido = view.findViewById(R.id.pedido);
        total = view.findViewById(R.id.total);

        pedido.setText(String.format("Número Pedido: %s", this.numeroPedido));
        total.setText( Monetario.converteValorFloatParaReal(this.valorCompra));

        rgproduto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (rgproduto.getCheckedRadioButtonId()) {
                    case R.id.creditoVista:
                        setParcelas(1);
                        break;
                    case R.id.creditoParc2:
                        setParcelas(2);
                        break;
                    case R.id.creditoParc3:
                        setParcelas(3);
                        break;
                    case R.id.creditoParc4:
                        setParcelas(4);
                        break;
                    case R.id.creditoParc5:
                         setParcelas(5);
                        break;
                    case R.id.creditoParc6:
                        setParcelas(6);
                        break;
                    case R.id.creditoParc7:
                        setParcelas(7);
                        break;
                    case R.id.creditoParc8:
                        setParcelas(8);
                        break;
                    case R.id.creditoParc9:
                        setParcelas(9);
                        break;
                    case R.id.creditoParc10:
                        setParcelas(10);
                        break;
                    case R.id.creditoParc11:
                        setParcelas(11);
                        break;
                    case R.id.creditoParc12:
                        setParcelas(12);
                        break;
                    default:
                        setParcelas(0);
                        break;
                }
            }
        });
    }

    private void setParcelas(Integer value) {
        this.popParcelamentoCallBack.selectParcelamento(value);
        dismiss();
    }
}
