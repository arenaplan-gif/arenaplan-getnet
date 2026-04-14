package com.arenaplan.pdv.get.database;

import static com.arenaplan.pdv.get.util.Constantes.ID_PENDENTE;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_PENDENTE;
import static com.arenaplan.pdv.get.util.Constantes.T_ACAO;
import static com.arenaplan.pdv.get.util.Constantes.T_CARRINHO;
import static com.arenaplan.pdv.get.util.Constantes.T_CPF;
import static com.arenaplan.pdv.get.util.Constantes.T_DESC;
import static com.arenaplan.pdv.get.util.Constantes.T_IDF;
import static com.arenaplan.pdv.get.util.Constantes.T_IDNFE;
import static com.arenaplan.pdv.get.util.Constantes.T_TIPO;
import static com.arenaplan.pdv.get.util.Constantes.T_TOTAL;
import static com.arenaplan.pdv.get.util.Constantes.T_TROCO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.arenaplan.pdv.get.database.entidades.PendenteEntidade;

import java.util.ArrayList;
import java.util.List;

public class PendenteController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public PendenteController(Context context) {
        banco = new CriaBanco(context);
    }

    public Boolean insereDado(PendenteEntidade pendenteEntidade) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(T_ACAO, pendenteEntidade.getAcao());
        valores.put(T_CARRINHO, pendenteEntidade.getCarrinho());
        valores.put(T_TOTAL, String.valueOf(pendenteEntidade.getTotal()));
        valores.put(T_DESC, String.valueOf(pendenteEntidade.getDesc()));
        valores.put(T_TROCO, String.valueOf(pendenteEntidade.getTroco()));
        valores.put(T_IDF, String.valueOf(pendenteEntidade.getIdf()));
        valores.put(T_IDNFE, pendenteEntidade.getIdnfe());
        valores.put(T_CPF, pendenteEntidade.getCpf());
        valores.put(T_TIPO, pendenteEntidade.getTipo());

        resultado = db.insert(TABELA_PENDENTE, null, valores);
        db.close();

        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<PendenteEntidade> listaCarrinhoPendente() {
        Cursor cursor = null;
        List<PendenteEntidade> listaPendentes = new ArrayList<>();

        try {
            db = banco.getWritableDatabase();

            // VALIDAÇÃO: Tenta criar a tabela se ela não existir por algum motivo
            // Isso evita o crash de "no such table"
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA_PENDENTE + "(" +
                    ID_PENDENTE + " integer primary key autoincrement," +
                    T_ACAO + " text , " +
                    T_CARRINHO + " text , " +
                    T_TOTAL + " text , " +
                    T_DESC + " text , " +
                    T_TROCO + " text , " +
                    T_IDF + " text , " +
                    T_IDNFE + " text , " +
                    T_CPF + " text , " +
                    T_TIPO + " text )");

            String[] campos = { ID_PENDENTE, T_ACAO, T_CARRINHO, T_TOTAL, T_DESC, T_TROCO, T_IDF, T_IDNFE, T_CPF, T_TIPO };

            cursor = db.query(TABELA_PENDENTE, campos, null, null, null, null, null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    PendenteEntidade pendenteEntidade = new PendenteEntidade();
                    pendenteEntidade.setId(cursor.getLong(cursor.getColumnIndex(ID_PENDENTE)));
                    pendenteEntidade.setAcao(cursor.getString(cursor.getColumnIndex(T_ACAO)));
                    pendenteEntidade.setCarrinho(cursor.getString(cursor.getColumnIndex(T_CARRINHO)));
                    pendenteEntidade.setTotal(Float.parseFloat(cursor.getString(cursor.getColumnIndex(T_TOTAL))));
                    pendenteEntidade.setDesc(Float.parseFloat(cursor.getString(cursor.getColumnIndex(T_DESC))));
                    pendenteEntidade.setTroco(Float.parseFloat(cursor.getString(cursor.getColumnIndex(T_TROCO))));
                    pendenteEntidade.setIdf(cursor.getString(cursor.getColumnIndex(T_IDF)));
                    pendenteEntidade.setIdnfe(cursor.getString(cursor.getColumnIndex(T_IDNFE)));
                    pendenteEntidade.setCpf(cursor.getString(cursor.getColumnIndex(T_CPF)));
                    pendenteEntidade.setTipo(cursor.getString(cursor.getColumnIndex(T_TIPO)));
                    listaPendentes.add(pendenteEntidade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) cursor.close();
        }

        return listaPendentes;
    }

    public void removeCarinhoPendente(long id) {

        String where = ID_PENDENTE + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(TABELA_PENDENTE, where, null);
        db.close();
    }

    public void deletaTabelaPendente() {

        db = banco.getWritableDatabase();
        db.execSQL("DELETE FROM  " + TABELA_PENDENTE);
        db.close();
    }
}
