package com.arenaplan.pdv.get.principal.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemCarrinho implements Parcelable {

    private String idProduto;
    private String  nomeProduto;
    private String quantidade;
    private String valor;
    private String unidade;
    private String codigoProduto;

    public ItemCarrinho() {

    }

    protected ItemCarrinho(Parcel in) {
        idProduto = in.readString();
        nomeProduto = in.readString();
        quantidade = in.readString();
        valor = in.readString();
        unidade = in.readString();
        codigoProduto = in.readString();
    }

    public static final Creator<ItemCarrinho> CREATOR = new Creator<ItemCarrinho>() {
        @Override
        public ItemCarrinho createFromParcel(Parcel in) {
            return new ItemCarrinho(in);
        }

        @Override
        public ItemCarrinho[] newArray(int size) {
            return new ItemCarrinho[size];
        }
    };

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idProduto);
        dest.writeString(nomeProduto);
        dest.writeString(quantidade);
        dest.writeString(valor);
        dest.writeString(unidade);
        dest.writeString(codigoProduto);
    }
}
