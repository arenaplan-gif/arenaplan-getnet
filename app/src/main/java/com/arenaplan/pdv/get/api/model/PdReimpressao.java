package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdReimpressao implements Parcelable {

    @SerializedName("pd")
    private List<ProdutoReimpressao> produtoList;

    public PdReimpressao() {

    }

    protected PdReimpressao(Parcel in) {
        produtoList = in.createTypedArrayList(ProdutoReimpressao.CREATOR);
    }

    public static final Creator<PdReimpressao> CREATOR = new Creator<PdReimpressao>() {
        @Override
        public PdReimpressao createFromParcel(Parcel in) {
            return new PdReimpressao(in);
        }

        @Override
        public PdReimpressao[] newArray(int size) {
            return new PdReimpressao[size];
        }
    };

    public List<ProdutoReimpressao> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<ProdutoReimpressao> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(produtoList);
    }
}
