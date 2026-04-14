package com.arenaplan.pdv.get.database;

import static com.arenaplan.pdv.get.util.Constantes.ID_PRODUTO;
import static com.arenaplan.pdv.get.util.Constantes.TABELA_PRODUTO;
import static com.arenaplan.pdv.get.util.Constantes.T_BARRAS;
import static com.arenaplan.pdv.get.util.Constantes.T_CATEGORIA;
import static com.arenaplan.pdv.get.util.Constantes.T_COD;
import static com.arenaplan.pdv.get.util.Constantes.T_GFID;
import static com.arenaplan.pdv.get.util.Constantes.T_IMP;
import static com.arenaplan.pdv.get.util.Constantes.T_IMT;
import static com.arenaplan.pdv.get.util.Constantes.T_NCMID;
import static com.arenaplan.pdv.get.util.Constantes.T_NH;
import static com.arenaplan.pdv.get.util.Constantes.T_NOME;
import static com.arenaplan.pdv.get.util.Constantes.T_UNIDADE;
import static com.arenaplan.pdv.get.util.Constantes.T_VALOR;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.arenaplan.pdv.get.api.model.CategoriaEntidade;
import com.arenaplan.pdv.get.database.entidades.ProdutoEntidade;

import java.util.ArrayList;
import java.util.List;

public class ProdutoBancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ProdutoBancoController(Context context){
        banco = new CriaBanco(context);
    }

    public Boolean insereDado(ProdutoEntidade produtoEntidade) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(T_COD, produtoEntidade.getCodigo());
        valores.put(T_NOME, produtoEntidade.getNome());
        valores.put(T_VALOR , produtoEntidade.getValor());
        valores.put(T_CATEGORIA , produtoEntidade.getCategoria());
        valores.put(T_BARRAS , produtoEntidade.getBarras());
        valores.put(T_UNIDADE , produtoEntidade.getUnidade());
        valores.put(T_NCMID , produtoEntidade.getNcmid());
        valores.put(T_GFID , produtoEntidade.getGfid());
        valores.put(T_NH, produtoEntidade.getTipoProduto());
        valores.put(T_IMT, produtoEntidade.getImageTipoProduto());
        valores.put(T_IMP, produtoEntidade.getImageItem());
        resultado = db.insert(TABELA_PRODUTO, null, valores);
        db.close();

        if(resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ProdutoEntidade getProdutoPorCodigo(String codigo) {

        ProdutoEntidade produtoEntidade = new ProdutoEntidade();
        if(codigo.trim().length() == 0) {

            return  produtoEntidade;
        }

        Cursor cursor;
        String where;



        db = banco.getWritableDatabase();

        where = T_COD + "=" + codigo;

        String[] campos = {
                ID_PRODUTO,
                T_COD,
                T_NOME,
                T_VALOR,
                T_CATEGORIA,
                T_BARRAS,
                T_UNIDADE,
                T_NCMID,
                T_GFID,
                T_NH,
                T_IMT,
                T_IMP
        };

      cursor =  db.query(TABELA_PRODUTO, campos, where,  null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            produtoEntidade.setId(cursor.getLong(cursor.getColumnIndex(ID_PRODUTO)));
            produtoEntidade.setCodigo(cursor.getString(cursor.getColumnIndex(T_COD)));
            produtoEntidade.setNome(cursor.getString(cursor.getColumnIndex(T_NOME)));
            produtoEntidade.setValor(cursor.getFloat(cursor.getColumnIndex(T_VALOR)));
            produtoEntidade.setCategoria(cursor.getString(cursor.getColumnIndex(T_CATEGORIA)));
            produtoEntidade.setBarras(cursor.getString(cursor.getColumnIndex(T_BARRAS)));
            produtoEntidade.setUnidade(cursor.getString(cursor.getColumnIndex(T_UNIDADE)));
            produtoEntidade.setNcmid(cursor.getString(cursor.getColumnIndex(T_NCMID)));
            produtoEntidade.setGfid(cursor.getString(cursor.getColumnIndex(T_GFID)));
            produtoEntidade.setTipoProduto(cursor.getString(cursor.getColumnIndex(T_NH)));
            produtoEntidade.setImageTipoProduto(cursor.getString(cursor.getColumnIndex(T_IMT)));
            produtoEntidade.setImageItem(cursor.getString(cursor.getColumnIndex(T_IMP)));
        }

        db.close();

        return  produtoEntidade;
    }

    public ProdutoEntidade getProdutoPorCodigoDeBarra(String codeBarra) {

        String[] campos = {
                ID_PRODUTO,
                T_COD,
                T_NOME,
                T_VALOR,
                T_CATEGORIA,
                T_BARRAS,
                T_UNIDADE,
                T_NCMID,
                T_GFID,
                T_NH,
                T_IMT,
                T_IMP
        };

        Cursor cursor;

        String where = T_BARRAS + "=" + codeBarra;


        ProdutoEntidade produtoEntidade = new ProdutoEntidade();

        db = banco.getWritableDatabase();



        cursor =  db.query(TABELA_PRODUTO, campos, where,  null, null, null, null, null);

        while (cursor.moveToNext()) {
            produtoEntidade.setId(cursor.getLong(cursor.getColumnIndex(ID_PRODUTO)));
            produtoEntidade.setCodigo(cursor.getString(cursor.getColumnIndex(T_COD)));
            produtoEntidade.setNome(cursor.getString(cursor.getColumnIndex(T_NOME)));
            produtoEntidade.setValor(cursor.getFloat(cursor.getColumnIndex(T_VALOR)));
            produtoEntidade.setCategoria(cursor.getString(cursor.getColumnIndex(T_CATEGORIA)));
            produtoEntidade.setBarras(cursor.getString(cursor.getColumnIndex(T_BARRAS)));
            produtoEntidade.setUnidade(cursor.getString(cursor.getColumnIndex(T_UNIDADE)));
            produtoEntidade.setNcmid(cursor.getString(cursor.getColumnIndex(T_NCMID)));
            produtoEntidade.setGfid(cursor.getString(cursor.getColumnIndex(T_GFID)));
            produtoEntidade.setTipoProduto(cursor.getString(cursor.getColumnIndex(T_NH)));
            produtoEntidade.setImageTipoProduto(cursor.getString(cursor.getColumnIndex(T_IMT)));
            produtoEntidade.setImageItem(cursor.getString(cursor.getColumnIndex(T_IMP)));
        }

        db.close();
        return produtoEntidade ;
    }

    public List<ProdutoEntidade> getProdutoTodosProdutos() {

        Cursor cursor;

        List<ProdutoEntidade> listaProduto = new ArrayList<>();


        db = banco.getWritableDatabase();


        cursor =  db.rawQuery("select * from " + TABELA_PRODUTO
               , null);


        while (cursor.moveToNext()) {

            ProdutoEntidade produtoEntidade = new ProdutoEntidade();

            produtoEntidade.setId(cursor.getLong(cursor.getColumnIndex(ID_PRODUTO)));
            produtoEntidade.setCodigo(cursor.getString(cursor.getColumnIndex(T_COD)));
            produtoEntidade.setNome(cursor.getString(cursor.getColumnIndex(T_NOME)));
            produtoEntidade.setValor(cursor.getFloat(cursor.getColumnIndex(T_VALOR)));
            produtoEntidade.setCategoria(cursor.getString(cursor.getColumnIndex(T_CATEGORIA)));
            produtoEntidade.setBarras(cursor.getString(cursor.getColumnIndex(T_BARRAS)));
            produtoEntidade.setUnidade(cursor.getString(cursor.getColumnIndex(T_UNIDADE)));
            produtoEntidade.setNcmid(cursor.getString(cursor.getColumnIndex(T_NCMID)));
            produtoEntidade.setGfid(cursor.getString(cursor.getColumnIndex(T_GFID)));
            produtoEntidade.setTipoProduto(cursor.getString(cursor.getColumnIndex(T_NH)));
            produtoEntidade.setImageTipoProduto(cursor.getString(cursor.getColumnIndex(T_IMT)));
            produtoEntidade.setImageItem(cursor.getString(cursor.getColumnIndex(T_IMP)));
            listaProduto.add(produtoEntidade);
        }

        db.close();
        return  listaProduto;
    }

    public void deletaTabelaProduto() {

        db = banco.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABELA_PRODUTO);
        db.close();
    }

    @SuppressLint("Range")
    public List<CategoriaEntidade> getCategorias() {
        List<CategoriaEntidade> lista = new ArrayList<>();
        SQLiteDatabase db = banco.getReadableDatabase();
        String query = "SELECT DISTINCT " + T_NH + ", " + T_IMT +
                " FROM " + TABELA_PRODUTO +
                " WHERE " + T_NH + " != '-' " +
                " ORDER BY " + T_NH + " ASC";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                CategoriaEntidade cat = new CategoriaEntidade();
                cat.setTitulo(cursor.getString(cursor.getColumnIndexOrThrow(T_NH)));
                cat.setImagem(cursor.getString(cursor.getColumnIndexOrThrow(T_IMT)));
                lista.add(cat);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lista;
    }

    @SuppressLint("Range")
    public List<ProdutoEntidade> getProdutosPorCategoria(String categoriaNome) {
        List<ProdutoEntidade> lista = new ArrayList<>();
        SQLiteDatabase db = banco.getReadableDatabase();
        String query = "SELECT * FROM " + TABELA_PRODUTO +
                " WHERE " + T_NH + " = ?" +
                " ORDER BY " + T_NOME + " ASC";

        Cursor cursor = db.rawQuery(query, new String[]{categoriaNome});

        if (cursor.moveToFirst()) {
            do {
                ProdutoEntidade p = new ProdutoEntidade();
                p.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ID_PRODUTO)));
                p.setNome(cursor.getString(cursor.getColumnIndexOrThrow(T_NOME)));
                p.setValor(cursor.getFloat(cursor.getColumnIndexOrThrow(T_VALOR)));
                p.setCodigo(cursor.getString(cursor.getColumnIndexOrThrow(T_COD)));
                p.setImageItem(cursor.getString(cursor.getColumnIndexOrThrow(T_IMP))); // Imagem do Produto
                lista.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lista;
    }
}
