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
import com.arenaplan.pdv.get.util.CpfCnpjMascara;
import com.arenaplan.pdv.get.util.MaskType;
import com.arenaplan.pdv.get.util.ValidaCNPJ;
import com.arenaplan.pdv.get.util.ValidaCPF;

public class TipoDocumento extends DialogFragment {

    private Button botaoCPF;
    private Button botaoCNPJ;
    private Button botaoNaoInformar;
    private Button botaoConfirmar;
    private EditText campoEdicaoCpf;
    private EditText campoEdicaoCnpj;
    private TextView textViewErroCpf;
    private TextView textViewErroCnpj;

    private boolean isCpf  = false;
    private boolean isCnpj = false;


    private TipoDocumentoPagamento tipoDocumentoPagamento;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.view_pop_tipo_documento, null);

        pegaDadosView(view);
        setMascaraCampo();
        builder.setView(view);

        return builder.create();
    }

    private void pegaDadosView(View view) {

        botaoCPF = view.findViewById(R.id.botaoCPF);
        botaoCNPJ = view.findViewById(R.id.botaoCNPJ);
        botaoNaoInformar = view.findViewById(R.id.botaoNaoInformar);
        campoEdicaoCpf = view.findViewById(R.id.campoEdicaoCpf);
        campoEdicaoCnpj = view.findViewById(R.id.campoEdicaoCnpj);
        botaoConfirmar = view.findViewById(R.id.botaoConfirmar);
        textViewErroCnpj = view.findViewById(R.id.textViewErroCnpj);
        textViewErroCpf = view.findViewById(R.id.textViewErroCpf);

        botaoCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCpf = true;
                isCnpj = false;
                informarCpf();
                textViewErroCnpj.setVisibility(View.GONE);
                textViewErroCpf.setVisibility(View.GONE);
            }
        });

        botaoCNPJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCpf = false;
                isCnpj = true;
                informarCnpj();
                textViewErroCnpj.setVisibility(View.GONE);
                textViewErroCpf.setVisibility(View.GONE);
            }
        });

        botaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validaFormulario();
            }
        });

        botaoNaoInformar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipoDocumentoPagamento.onNaoQueroDocumento();
                dismiss();
            }
        });


    }

    private void validaFormulario() {

        if(isCpf) {

            String cpf = campoEdicaoCpf.getText().toString();

            cpf = cpf.replaceAll("[^0-9]*", "");


            if(!ValidaCPF.isCPF(cpf)) {
                textViewErroCpf.setVisibility(View.VISIBLE);
            } else {
                tipoDocumentoPagamento.onDocumentoInformado(cpf);
                dismiss();

            }
        }

        else if(isCnpj) {
            String cnpj = campoEdicaoCnpj.getText().toString();

            cnpj = cnpj.replaceAll("[^0-9]*", "");

            if(!ValidaCNPJ.isCNPJ(cnpj)) {
                textViewErroCnpj.setVisibility(View.VISIBLE);
            } else {
                tipoDocumentoPagamento.onDocumentoInformado(cnpj);
                dismiss();
            }
        }
    }

    public void setInterfaceDocumento(TipoDocumentoPagamento tipoDocumentoPagamento) {

        this.tipoDocumentoPagamento = tipoDocumentoPagamento;
    }

    private void informarCpf() {
        campoEdicaoCpf.setVisibility(View.VISIBLE);
        campoEdicaoCnpj.setVisibility(View.GONE);
        botaoConfirmar.setVisibility(View.VISIBLE);
    }

    private void informarCnpj() {
        campoEdicaoCpf.setVisibility(View.GONE);
        campoEdicaoCnpj.setVisibility(View.VISIBLE);
        botaoConfirmar.setVisibility(View.VISIBLE);
    }

    private void setMascaraCampo() {

        campoEdicaoCpf.addTextChangedListener(CpfCnpjMascara.insert(campoEdicaoCpf, MaskType.CPF));
        campoEdicaoCnpj.addTextChangedListener(CpfCnpjMascara.insert(campoEdicaoCnpj, MaskType.CNPJ));
    }
}
