package com.arenaplan.pdv.get.database;

import static com.arenaplan.pdv.get.util.Constantes.ID_SETUP;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_SETUP;
import static com.arenaplan.pdv.get.util.Constantes.T_ASSINA;
import static com.arenaplan.pdv.get.util.Constantes.T_BAIRRO;
import static com.arenaplan.pdv.get.util.Constantes.T_CEP;
import static com.arenaplan.pdv.get.util.Constantes.T_CIDADE;
import static com.arenaplan.pdv.get.util.Constantes.T_CLIENTE;
import static com.arenaplan.pdv.get.util.Constantes.T_CNPJ;
import static com.arenaplan.pdv.get.util.Constantes.T_CNPJDES;
import static com.arenaplan.pdv.get.util.Constantes.T_CODATIV;
import static com.arenaplan.pdv.get.util.Constantes.T_COMPLEMENTO;
import static com.arenaplan.pdv.get.util.Constantes.T_CUF;
import static com.arenaplan.pdv.get.util.Constantes.T_DUPLACRIPTO;
import static com.arenaplan.pdv.get.util.Constantes.T_ENDERECO;
import static com.arenaplan.pdv.get.util.Constantes.T_HH_IDENT;
import static com.arenaplan.pdv.get.util.Constantes.T_INSCMUN;
import static com.arenaplan.pdv.get.util.Constantes.T_INSCRICAO;
import static com.arenaplan.pdv.get.util.Constantes.T_LAYOUT;
import static com.arenaplan.pdv.get.util.Constantes.T_LEITORA;
import static com.arenaplan.pdv.get.util.Constantes.T_LOGIN;
import static com.arenaplan.pdv.get.util.Constantes.T_MENSAGEM;
import static com.arenaplan.pdv.get.util.Constantes.T_MONITOR;
import static com.arenaplan.pdv.get.util.Constantes.T_NUMERO;
import static com.arenaplan.pdv.get.util.Constantes.T_PASSW;
import static com.arenaplan.pdv.get.util.Constantes.T_PREPAPO;
import static com.arenaplan.pdv.get.util.Constantes.T_RAZAO;
import static com.arenaplan.pdv.get.util.Constantes.T_SEFAZ;
import static com.arenaplan.pdv.get.util.Constantes.T_SENHA;
import static com.arenaplan.pdv.get.util.Constantes.T_SERIE;
import static com.arenaplan.pdv.get.util.Constantes.T_TEF;
import static com.arenaplan.pdv.get.util.Constantes.T_TIMEOUT;
import static com.arenaplan.pdv.get.util.Constantes.T_TIPO_RECIBO;
import static com.arenaplan.pdv.get.util.Constantes.T_UF;
import static com.arenaplan.pdv.get.util.Constantes.T_URLHOMO;
import static com.arenaplan.pdv.get.util.Constantes.T_URLPRO;
import static com.arenaplan.pdv.get.util.Constantes.T_USAOFF;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.arenaplan.pdv.get.database.entidades.SetUp;

public class SetUpBancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public SetUpBancoController(Context context) {
        banco = new CriaBanco(context);

    }

    public Boolean insereDado(SetUp setUp) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(T_LOGIN, setUp.getT_login());
        valores.put(T_PASSW, setUp.getT_passw());
        valores.put(T_HH_IDENT, setUp.getT_hh_ident());
        valores.put(T_TIPO_RECIBO, setUp.getT_tipo_recibo());
        valores.put(T_SENHA, setUp.getT_senha());
        valores.put(T_RAZAO, setUp.getT_razao());
        valores.put(T_ENDERECO, setUp.getT_endereco());
        valores.put(T_NUMERO, setUp.getT_numero());
        valores.put(T_COMPLEMENTO, setUp.getT_complemento());
        valores.put(T_BAIRRO, setUp.getT_bairro());
        valores.put(T_CIDADE, setUp.getT_cidade());
        valores.put(T_CNPJ, setUp.getT_cnpj());
        valores.put(T_UF, setUp.getT_uf());
        valores.put(T_CEP, setUp.getT_cep());
        valores.put(T_INSCRICAO, setUp.getT_inscricao());
        valores.put(T_CUF, setUp.getT_cuf());
        valores.put(T_USAOFF, setUp.getT_usaoff());
        valores.put(T_SERIE, setUp.getT_serie());
        valores.put(T_URLPRO, setUp.getT_urlpro());
        valores.put(T_URLHOMO, setUp.getT_urlhomo());
        valores.put(T_SEFAZ, setUp.getT_sefaz());
        valores.put(T_TEF, setUp.getT_tef());
        valores.put(T_PREPAPO, setUp.getT_prepapo());
        valores.put(T_MONITOR, setUp.getT_monitor());
        valores.put(T_CLIENTE, setUp.getT_cliente());
        valores.put(T_LEITORA, setUp.getT_leitora());
        valores.put(T_TIMEOUT, setUp.getT_timeout());
        valores.put(T_CODATIV, setUp.getT_codativ());
        valores.put(T_ASSINA, setUp.getT_assina());
        valores.put(T_INSCMUN, setUp.getT_inscmun());
        valores.put(T_CNPJDES, setUp.getT_cnpjdes());
        valores.put(T_LAYOUT, setUp.getT_layout());
        valores.put(T_MENSAGEM, setUp.getT_mensagem());
        valores.put(T_DUPLACRIPTO, setUp.getT_duplacripto());

        resultado = db.insert(TABELA_SETUP, null, valores);
        db.close();

        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    public SetUp carregaDados() {


        SetUp setUp = new SetUp();
        Cursor cursor;

        String[] campos = {ID_SETUP,
                T_LOGIN,
                T_PASSW,
                T_HH_IDENT,
                T_TIPO_RECIBO,
                T_SENHA,
                T_RAZAO,
                T_ENDERECO,
                T_NUMERO,
                T_COMPLEMENTO,
                T_BAIRRO,
                T_CIDADE,
                T_CNPJ,
                T_UF,
                T_CEP,
                T_INSCRICAO,
                T_CUF,
                T_USAOFF,
                T_SERIE,
                T_URLPRO,
                T_URLHOMO,
                T_SEFAZ,
                T_TEF,
                T_PREPAPO,
                T_MONITOR,
                T_CLIENTE,
                T_LEITORA,
                T_TIMEOUT,
                T_CODATIV,
                T_ASSINA,
                T_INSCMUN,
                T_CNPJDES,
                T_LAYOUT,
                T_MENSAGEM,
                T_DUPLACRIPTO

        };

        db = banco.getReadableDatabase();
        cursor = db.query(TABELA_SETUP, campos, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            setUp.setIdSetUp(cursor.getLong(cursor.getColumnIndex(ID_SETUP)));
            setUp.setT_login(cursor.getString(cursor.getColumnIndex(T_LOGIN)));
            setUp.setT_passw(cursor.getString(cursor.getColumnIndex(T_PASSW)));
            setUp.setT_hh_ident(cursor.getInt(cursor.getColumnIndex(T_HH_IDENT)));
            setUp.setT_tipo_recibo(cursor.getString(cursor.getColumnIndex(T_TIPO_RECIBO)));
            setUp.setT_senha(cursor.getString(cursor.getColumnIndex(T_SENHA)));
            setUp.setT_razao(cursor.getString(cursor.getColumnIndex(T_RAZAO)));
            setUp.setT_endereco(cursor.getString(cursor.getColumnIndex(T_ENDERECO)));
            setUp.setT_numero(cursor.getString(cursor.getColumnIndex(T_NUMERO)));
            setUp.setT_complemento(cursor.getString(cursor.getColumnIndex(T_COMPLEMENTO)));
            setUp.setT_bairro(cursor.getString(cursor.getColumnIndex(T_BAIRRO)));
            setUp.setT_cidade(cursor.getString(cursor.getColumnIndex(T_CIDADE)));
            setUp.setT_cnpj(cursor.getString(cursor.getColumnIndex(T_CNPJ)));
            setUp.setT_uf(cursor.getString(cursor.getColumnIndex(T_UF)));
            setUp.setT_cep(cursor.getString(cursor.getColumnIndex(T_CEP)));
            setUp.setT_inscricao(cursor.getString(cursor.getColumnIndex(T_INSCRICAO)));
            setUp.setT_cuf(cursor.getString(cursor.getColumnIndex(T_CUF)));
            setUp.setT_usaoff(cursor.getString(cursor.getColumnIndex(T_USAOFF)));
            setUp.setT_serie(cursor.getString(cursor.getColumnIndex(T_SERIE)));
            setUp.setT_urlpro(cursor.getString(cursor.getColumnIndex(T_URLPRO)));
            setUp.setT_urlhomo(cursor.getString(cursor.getColumnIndex(T_URLHOMO)));
            setUp.setT_sefaz(cursor.getString(cursor.getColumnIndex(T_SEFAZ)));
            setUp.setT_tef(cursor.getString(cursor.getColumnIndex(T_TEF)));
            setUp.setT_monitor(cursor.getString(cursor.getColumnIndex(T_MONITOR)));
            setUp.setT_cliente(cursor.getString(cursor.getColumnIndex(T_CLIENTE)));
            setUp.setT_leitora(cursor.getString(cursor.getColumnIndex(T_LEITORA)));
            setUp.setT_timeout(cursor.getString(cursor.getColumnIndex(T_TIMEOUT)));
            setUp.setT_codativ(cursor.getString(cursor.getColumnIndex(T_CODATIV)));
            setUp.setT_assina(cursor.getString(cursor.getColumnIndex(T_ASSINA)));
            setUp.setT_inscmun(cursor.getString(cursor.getColumnIndex(T_INSCMUN)));
            setUp.setT_cnpjdes(cursor.getString(cursor.getColumnIndex(T_CNPJDES)));
            setUp.setT_layout(cursor.getString(cursor.getColumnIndex(T_LAYOUT)));
            setUp.setT_mensagem(cursor.getString(cursor.getColumnIndex(T_MENSAGEM)));
            setUp.setT_duplacripto(cursor.getString(cursor.getColumnIndex(T_DUPLACRIPTO)));
        }

        db.close();

        return setUp;
    }

    public void atualizaSetUp(SetUp setUp) {

        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = ID_SETUP + "=" + setUp.getIdSetUp();
        valores = new ContentValues();

        valores.put(T_RAZAO, setUp.getT_razao());
        valores.put(T_LOGIN, setUp.getT_login());
        valores.put(T_PASSW, setUp.getT_passw());
        valores.put(T_HH_IDENT, setUp.getT_hh_ident());
        valores.put(T_TIPO_RECIBO, setUp.getT_tipo_recibo());
        valores.put(T_SENHA, setUp.getT_senha());
        valores.put(T_ENDERECO, setUp.getT_endereco());
        valores.put(T_NUMERO, setUp.getT_numero());
        valores.put(T_COMPLEMENTO, setUp.getT_complemento());
        valores.put(T_BAIRRO, setUp.getT_bairro());
        valores.put(T_CIDADE, setUp.getT_cidade());
        valores.put(T_CNPJ, setUp.getT_cnpj());
        valores.put(T_UF, setUp.getT_uf());
        valores.put(T_CEP, setUp.getT_cep());
        valores.put(T_INSCRICAO, setUp.getT_inscricao());
        valores.put(T_CUF, setUp.getT_cuf());
        valores.put(T_USAOFF, setUp.getT_usaoff());
        valores.put(T_SERIE, setUp.getT_serie());
        valores.put(T_URLPRO, setUp.getT_urlpro());
        valores.put(T_URLHOMO, setUp.getT_urlhomo());
        valores.put(T_SEFAZ, setUp.getT_sefaz());
        valores.put(T_TEF, setUp.getT_tef());
        valores.put(T_PREPAPO, setUp.getT_prepapo());
        valores.put(T_MONITOR, setUp.getT_monitor());
        valores.put(T_CLIENTE, setUp.getT_cliente());
        valores.put(T_LEITORA, setUp.getT_leitora());
        valores.put(T_TIMEOUT, setUp.getT_timeout());
        valores.put(T_CODATIV, setUp.getT_codativ());
        valores.put(T_ASSINA, setUp.getT_assina());
        valores.put(T_INSCMUN, setUp.getT_inscmun());
        valores.put(T_CNPJDES, setUp.getT_cnpjdes());
        valores.put(T_LAYOUT, setUp.getT_layout());
        valores.put(T_MENSAGEM, setUp.getT_mensagem());
        valores.put(T_DUPLACRIPTO, setUp.getT_duplacripto());

        db.update(TABELA_SETUP, valores, where, null);
        db.close();


    }

    public void deletaSetUp() {

        db = banco.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABELA_SETUP);
        db.close();

    }

}
