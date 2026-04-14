package com.arenaplan.pdv.get.database;

import static com.arenaplan.pdv.get.util.Constantes.ID_CONTATOR;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_CONTATADOR;
import static com.arenaplan.pdv.get.util.Constantes.T_IDF_CONTADOR;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.arenaplan.pdv.get.database.entidades.ContadorEntidade;

public class ContadorController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ContadorController(Context context) {
        banco = new CriaBanco(context);
    }


    public Boolean insereDado(ContadorEntidade contadorEntidade) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(T_IDF_CONTADOR, contadorEntidade.getT_idf());

        resultado = db.insert(TABELA_CONTATADOR, null, valores);
        db.close();

        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ContadorEntidade getUltimoContador() {
        Cursor cursor;
        ContadorEntidade contadorEntidade = new ContadorEntidade();

        db = banco.getWritableDatabase();


        cursor = db.rawQuery("SELECT " + ID_CONTATOR + " , " + T_IDF_CONTADOR + " FROM " + TABELA_CONTATADOR + " ORDER BY " + ID_CONTATOR + " DESC LIMIT 1", null);

        while (cursor.moveToNext()) {

            contadorEntidade.setId(cursor.getLong(cursor.getColumnIndex(ID_CONTATOR)));
            contadorEntidade.setT_idf(cursor.getLong(cursor.getColumnIndex(T_IDF_CONTADOR)));
        }

        db.close();

        return contadorEntidade;
    }

    public void atualizaContador(ContadorEntidade contadorEntidade) {

        db = banco.getWritableDatabase();


        ContentValues valores = new ContentValues();

        valores.put(T_IDF_CONTADOR, contadorEntidade.getT_idf() + 1);

        String where = ID_CONTATOR + "=" + contadorEntidade.getId();

        db.update(TABELA_CONTATADOR, valores, where, null);
        db.close();

    }


    public void decrementaContador(ContadorEntidade contadorEntidade) {

        db = banco.getWritableDatabase();


        ContentValues valores = new ContentValues();

        valores.put(T_IDF_CONTADOR, contadorEntidade.getT_idf() - 1);

        String where = ID_CONTATOR + "=" + contadorEntidade.getId();

        db.update(TABELA_CONTATADOR, valores, where, null);
        db.close();

    }

    public void alterarValorContador(ContadorEntidade contadorEntidade) {

        db = banco.getWritableDatabase();


        ContentValues valores = new ContentValues();

        valores.put(T_IDF_CONTADOR, contadorEntidade.getT_idf() );

        String where = ID_CONTATOR + "=" + contadorEntidade.getId();

        db.update(TABELA_CONTATADOR, valores, where, null);
        db.close();

    }
}
