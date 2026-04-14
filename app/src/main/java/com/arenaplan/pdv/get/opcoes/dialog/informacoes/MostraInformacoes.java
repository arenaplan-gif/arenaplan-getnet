package com.arenaplan.pdv.get.opcoes.dialog.informacoes;

//package com.arenaplan.pdv.get.caixa.dialog.resumo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.api.model.ResumoCaixa;

public class MostraInformacoes extends DialogFragment { //extends AppCompatActivity  DialogFragment  //extends AppCompatActivity {
    private TextView textnome;
    private TextView cnpj;
    private TextView ie;
    private TextView endereco;
    private TextView num;
    private TextView complemento;
    private TextView bairro;
    private TextView cidade;
    private TextView uf;
    private TextView cep;
    private TextView usuario;
    private TextView usatef;
    private TextView modooffline;
    private TextView serie;
    private TextView hh_ident;
    private TextView timeout;
    private TextView idfiscal;
    private String textnome2;
    private String cnpj2;
    private String ie2;
    private String endereco2;
    private String num2;
    private String complemento2;
    private String bairro2;
    private String cidade2;
    private String uf2;
    private String cep2;
    private String usuario2;
    private String usatef2;
    private String modooffline2;
    private String serie2;
    private String hh_ident2;
    private String timeout2;
    private String idfiscal2;
    private Button buttonSair;
    ArenaplanPdvApplication mApplication;


    //private ResumoCaixaAcao resumoCaixaAcao;
    private ResumoCaixa resumoCaixa;
    private String nomeEmpresa;

    public MostraInformacoes(String t_razao, String tRazao, String t_cnpj, String t_inscricao, String t_endereco, String t_numero, String t_complemento, String t_bairro, String t_cidade, String t_cep,String t_uf, String t_login, String t_tef, String t_usaoff,String t_serie,String t_hh_ident,String t_timeout,String IDFiscal, MostraInformacoesAcao mostraInformacoesAcao) {
        textnome2=t_razao;
        cnpj2=t_cnpj;
        ie2=t_inscricao;
        endereco2=t_endereco;
        num2=t_numero;
        complemento2=t_complemento;
        bairro2=t_bairro;
        cidade2=t_cidade;
        cep2=t_cep;
        uf2=t_uf;
        usuario2=t_login;
        usatef2=t_tef;
        modooffline2=t_usaoff;
        serie2=t_serie;
        hh_ident2=t_hh_ident;
        timeout2=t_timeout;
        idfiscal2=IDFiscal;

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //mApplication =   (ArenaplanPdvApplication) mApplication.getApplicationContext();
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = inflater.inflate(R.layout.view_pop_informacoes, null);

        pegaDadosView(view);
        builder.setView(view);
        return builder.create();

    }

/*
    public  MostraInformacoes(
            String NomeEmpresa,
            String Cnpj,
            String Inscricao,
            String Endereco,
            String Numero,
            String Complemento,
            String Bairro,
            String Cidade,
            String UF,
            String Login,
            String Tef,
            String Usaoff,
            MostraInformacoesAcao mostraInformacoes) {
        //mApplication =   (ArenaplanPdvApplication) mApplication.getApplicationContext();
        textNomeEmpresa.setText(NomeEmpresa);
        cnpj.setText(Cnpj);
        ie.setText(Inscricao);
        endereco.setText(Endereco);
        num.setText(Numero);
        complemento.setText(Complemento);
        bairro.setText(Bairro);
        cidade.setText(Cidade);
        uf.setText(UF);
        usuario.setText(Login);
        usatef.setText(Tef);
        modooffline.setText(Usaoff);
    }*/


    private void pegaDadosView(View view) {
        textnome = view.findViewById(R.id.textnome);
        cnpj = view.findViewById(R.id.cnpj);
        ie = view.findViewById(R.id.ie);
        endereco = view.findViewById(R.id.endereco);
        complemento = view.findViewById(R.id.compl);
        num = view.findViewById(R.id.numero);
        bairro = view.findViewById(R.id.bairro);
        cidade = view.findViewById(R.id.cidade);
        uf = view.findViewById(R.id.uf);
        cep = view.findViewById(R.id.cep);
        usuario = view.findViewById(R.id.usuario);
        usatef = view.findViewById(R.id.usatef);
        modooffline = view.findViewById(R.id.buttonoffline);
        serie= view.findViewById(R.id.serie);
        hh_ident=view.findViewById(R.id.hh_ident);
        timeout=view.findViewById(R.id.timeout);
        idfiscal=view.findViewById(R.id.idfiscal);
        //valorDataFechamento = view.findViewById(R.id.serie);
        buttonSair = view.findViewById(R.id.buttonSair);  //buttonSair
        colocarDadosNaTela();

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alerta("teste");
                dismiss();
            }
        });
    }

    private void colocarDadosNaTela() {
       /* mApplication =   (ArenaplanPdvApplication) mApplication.getApplicationContext();
        //mApplication =   (ArenaplanPdvApplication) mApplication.getApplicationContext();*/
        textnome.setText(textnome2);
        hh_ident.setText(hh_ident2);
        cnpj.setText(cnpj2);
        ie.setText(ie2);
        endereco.setText(endereco2);
        num.setText(num2);
        complemento.setText(complemento2);
        bairro.setText(bairro2);
        cidade.setText(cidade2);
        uf.setText(uf2);
        cep.setText(cep2);
        usuario.setText(usuario2);
        if (usatef2.equals("1"))
            usatef.setText("Ativado");
        else  usatef.setText("Desativado");
        if (modooffline2.equals("1"))
            modooffline.setText("Não (OFFLine)");
        else modooffline.setText("Sim");
        serie.setText(serie2);
        timeout.setText(timeout2);
        idfiscal.setText(idfiscal2);
    }


}
