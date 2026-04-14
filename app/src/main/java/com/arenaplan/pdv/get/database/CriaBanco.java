package com.arenaplan.pdv.get.database;

import static com.arenaplan.pdv.get.util.Constantes.ID_CONTATOR;
import static com.arenaplan.pdv.get.util.Constantes.ID_PENDENTE;
import static com.arenaplan.pdv.get.util.Constantes.ID_PRODUTO;
import static com.arenaplan.pdv.get.util.Constantes.ID_SETUP;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_CONTATADOR;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_PENDENTE;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_PRODUTO;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_SETUP;
import static com.arenaplan.pdv.get.util.Constantes.T_ACAO;
import static com.arenaplan.pdv.get.util.Constantes.T_ASSINA;
import static com.arenaplan.pdv.get.util.Constantes.T_BAIRRO;
import static com.arenaplan.pdv.get.util.Constantes.T_BARRAS;
import static com.arenaplan.pdv.get.util.Constantes.T_CARRINHO;
import static com.arenaplan.pdv.get.util.Constantes.T_CATEGORIA;
import static com.arenaplan.pdv.get.util.Constantes.T_CEP;
import static com.arenaplan.pdv.get.util.Constantes.T_CIDADE;
import static com.arenaplan.pdv.get.util.Constantes.T_CLIENTE;
import static com.arenaplan.pdv.get.util.Constantes.T_CNPJ;
import static com.arenaplan.pdv.get.util.Constantes.T_CNPJDES;
import static com.arenaplan.pdv.get.util.Constantes.T_COD;
import static com.arenaplan.pdv.get.util.Constantes.T_CODATIV;
import static com.arenaplan.pdv.get.util.Constantes.T_COMPLEMENTO;
import static com.arenaplan.pdv.get.util.Constantes.T_CPF;
import static com.arenaplan.pdv.get.util.Constantes.T_CUF;
import static com.arenaplan.pdv.get.util.Constantes.T_DESC;
import static com.arenaplan.pdv.get.util.Constantes.T_DUPLACRIPTO;
import static com.arenaplan.pdv.get.util.Constantes.T_ENDERECO;
import static com.arenaplan.pdv.get.util.Constantes.T_GFID;
import static com.arenaplan.pdv.get.util.Constantes.T_HH_IDENT;
import static com.arenaplan.pdv.get.util.Constantes.T_IDF;
import static com.arenaplan.pdv.get.util.Constantes.T_IDF_CONTADOR;
import static com.arenaplan.pdv.get.util.Constantes.T_IDNFE;
import static com.arenaplan.pdv.get.util.Constantes.T_IMP;
import static com.arenaplan.pdv.get.util.Constantes.T_IMT;
import static com.arenaplan.pdv.get.util.Constantes.T_INSCMUN;
import static com.arenaplan.pdv.get.util.Constantes.T_INSCRICAO;
import static com.arenaplan.pdv.get.util.Constantes.T_LAYOUT;
import static com.arenaplan.pdv.get.util.Constantes.T_LEITORA;
import static com.arenaplan.pdv.get.util.Constantes.T_LOGIN;
import static com.arenaplan.pdv.get.util.Constantes.T_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.T_MONITOR;
import static com.arenaplan.pdv.get.util.Constantes.T_NCMID;
import static com.arenaplan.pdv.get.util.Constantes.T_NH;
import static com.arenaplan.pdv.get.util.Constantes.T_NOME;
import static com.arenaplan.pdv.get.util.Constantes.T_NUMERO;
import static com.arenaplan.pdv.get.util.Constantes.T_PASSW;
import static com.arenaplan.pdv.get.util.Constantes.T_PREPAPO;
import static com.arenaplan.pdv.get.util.Constantes.T_RAZAO;
import static com.arenaplan.pdv.get.util.Constantes.T_SEFAZ;
import static com.arenaplan.pdv.get.util.Constantes.T_SENHA;
import static com.arenaplan.pdv.get.util.Constantes.T_SERIE;
import static com.arenaplan.pdv.get.util.Constantes.T_TEF;
import static com.arenaplan.pdv.get.util.Constantes.T_TIMEOUT;
import static com.arenaplan.pdv.get.util.Constantes.T_TIPO;
import static com.arenaplan.pdv.get.util.Constantes.T_TIPO_RECIBO;
import static com.arenaplan.pdv.get.util.Constantes.T_TOTAL;
import static com.arenaplan.pdv.get.util.Constantes.T_TROCO;
import static com.arenaplan.pdv.get.util.Constantes.T_UF;
import static com.arenaplan.pdv.get.util.Constantes.T_UNIDADE;
import static com.arenaplan.pdv.get.util.Constantes.T_URLHOMO;
import static com.arenaplan.pdv.get.util.Constantes.T_URLPRO;
import static com.arenaplan.pdv.get.util.Constantes.T_USAOFF;
import static com.arenaplan.pdv.get.util.Constantes.T_VALOR;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 7;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(criaTabelaSetup());
        db.execSQL(criaTabelaProduto());
        db.execSQL(criaTabelaPendente());
        db.execSQL(criaTabelaContador());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA_SETUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PENDENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CONTATADOR);
        onCreate(db);
    }

    private String criaTabelaSetup() {

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE " + TABELA_SETUP + "(");
        sql.append(ID_SETUP + " integer primary key autoincrement,");
        sql.append(T_LOGIN + " text , ");
        sql.append(T_PASSW + " text , ");
        sql.append(T_HH_IDENT + " INTEGER , ");
        sql.append(T_TIPO_RECIBO + " text , ");
        sql.append(T_SENHA + " text , ");
        sql.append(T_RAZAO +  " text,");
        sql.append(T_ENDERECO + " text," );
        sql.append(T_NUMERO + " text, ");
        sql.append(T_COMPLEMENTO  + " text, ");
        sql.append(T_BAIRRO + " text, ");
        sql.append(T_CIDADE + " text, ");
        sql.append(T_CNPJ + " text, ");
        sql.append(T_UF + " text, ");
        sql.append(T_CEP + " text, ");
        sql.append(T_INSCRICAO + " text, ");
        sql.append(T_CUF + " text, ");
        sql.append(T_USAOFF + " text, ");
        sql.append(T_SERIE + " text, ");
        sql.append(T_URLPRO + " text, ");
        sql.append(T_URLHOMO + " text, ");
        sql.append(T_SEFAZ + " text, ");
        sql.append(T_TEF + " text, ");
        sql.append(T_PREPAPO + " text, ");
        sql.append(T_MONITOR  + " text, ");
        sql.append(T_CLIENTE  + " text, ");
        sql.append(T_LEITORA  + " text, ");
        sql.append(T_TIMEOUT  + " text, ");
        sql.append(T_CODATIV  + " text, ");
        sql.append(T_ASSINA  + " text, ");
        sql.append(T_INSCMUN  + " text, ");
        sql.append(T_CNPJDES  + " text, ");
        sql.append(T_LAYOUT  + " text, ");
        sql.append(T_MENSAGEM  + " text, ");
        sql.append(T_DUPLACRIPTO  + " text ");

        sql.append(")");

        return sql.toString();
    }

    private String criaTabelaProduto() {

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE " + TABELA_PRODUTO + "(");
        sql.append(ID_PRODUTO + " integer primary key autoincrement,");
        sql.append(T_COD  + " text , ");
        sql.append(T_NOME  + " text ,");
        sql.append(T_VALOR  + " text , ");
        sql.append(T_CATEGORIA  + " text , ");
        sql.append(T_BARRAS  + " text , ");
        sql.append(T_UNIDADE  + " text , ");
        sql.append(T_NCMID  + " text , ");
        sql.append(T_GFID  + " text , "); // Adicionei a vírgula que faltava
        // ESTAS LINHAS ABAIXO SÃO AS QUE FALTAVAM NO SEU SCRIPT:
        sql.append(T_NH + " text , ");
        sql.append(T_IMT + " text , ");
        sql.append(T_IMP + " text ");
        sql.append(")");

        return sql.toString();
    }

    private String criaTabelaPendente() {

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS " + TABELA_PENDENTE + "(");
        sql.append(ID_PENDENTE   + " integer primary key autoincrement,");
        sql.append(T_ACAO + " text , ");
        sql.append(T_CARRINHO +  " text , ");
        sql.append(T_TOTAL + " text , ");
        sql.append(T_DESC + " text , ");
        sql.append(T_TROCO + " text , ");
        sql.append(T_IDF + " text , ");
        sql.append(T_IDNFE + " text , ");
        sql.append(T_CPF + " text , ");
        sql.append(T_TIPO + " text ");
        sql.append(")");


        return sql.toString();

    }

    private String criaTabelaContador() {

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE " + TABELA_CONTATADOR + "(");
        sql.append(ID_CONTATOR   + " integer primary key autoincrement,");
        sql.append(T_IDF_CONTADOR + " text ");


        sql.append(")");


        return sql.toString();
    }

}
