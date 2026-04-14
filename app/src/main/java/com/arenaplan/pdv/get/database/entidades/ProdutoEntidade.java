package com.arenaplan.pdv.get.database.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class ProdutoEntidade implements Parcelable {

    private long id;
    private String codigo;
    private String nome;
    private Float valor;
    private String categoria;
    private String barras;
    private String unidade;
    private String ncmid;
    private String gfid;

    private String tipoProduto;

    private String imageTipoProduto;

    private String imageItem;

    private int quantidadeSelecionada = 0;

    public ProdutoEntidade(){

    }

    protected ProdutoEntidade(Parcel in) {
        id = in.readLong();
        codigo = in.readString();
        nome = in.readString();
        valor = in.readFloat();
        categoria = in.readString();
        barras = in.readString();
        unidade = in.readString();
        ncmid = in.readString();
        gfid = in.readString();
        tipoProduto = in.readString();
        imageTipoProduto = in.readString();
        imageItem = in.readString();
        quantidadeSelecionada = in.readInt();
    }

    public static final Creator<ProdutoEntidade> CREATOR = new Creator<ProdutoEntidade>() {
        @Override
        public ProdutoEntidade createFromParcel(Parcel in) {
            return new ProdutoEntidade(in);
        }

        @Override
        public ProdutoEntidade[] newArray(int size) {
            return new ProdutoEntidade[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNcmid() {
        return ncmid;
    }

    public void setNcmid(String ncmid) {
        this.ncmid = ncmid;
    }

    public String getGfid() {
        return gfid;
    }

    public void setGfid(String gfid) { this.gfid = gfid;
    }


    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(String tipoProduto) { this.tipoProduto = tipoProduto;     }

    public int getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public void setQuantidadeSelecionada(int quantidadeSelecionada) {
        this.quantidadeSelecionada = quantidadeSelecionada;
    }

    public String getImageTipoProduto() { return imageTipoProduto;     }
    public  void setImageTipoProduto(String imageTipoProduto) { this.imageTipoProduto = imageTipoProduto;
    }
    public String getImageItem() {
        return imageItem;
    }
    public  void setImageItem(String imageItem) { this.imageItem = imageItem;    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(codigo);
        dest.writeString(nome);
        dest.writeFloat(valor);
        dest.writeString(categoria);
        dest.writeString(barras);
        dest.writeString(unidade);
        dest.writeString(ncmid);
        dest.writeString(gfid);
        dest.writeString(tipoProduto);
        dest.writeString(imageTipoProduto);
        dest.writeString(imageItem);
        dest.writeInt(quantidadeSelecionada);
    }
}
