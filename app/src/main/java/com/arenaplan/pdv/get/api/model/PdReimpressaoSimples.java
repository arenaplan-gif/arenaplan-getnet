package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PdReimpressaoSimples implements Parcelable {

    @SerializedName("pd")
    private ProdutoReimpressao produtoReimpressao;

    protected PdReimpressaoSimples(Parcel in) {
        produtoReimpressao = in.readParcelable(ProdutoReimpressao.class.getClassLoader());
    }

    public static final Creator<PdReimpressaoSimples> CREATOR = new Creator<PdReimpressaoSimples>() {
        @Override
        public PdReimpressaoSimples createFromParcel(Parcel in) {
            return new PdReimpressaoSimples(in);
        }

        @Override
        public PdReimpressaoSimples[] newArray(int size) {
            return new PdReimpressaoSimples[size];
        }
    };

    public ProdutoReimpressao getProdutoReimpressao() {
        return produtoReimpressao;
    }

    public void setProdutoReimpressao(ProdutoReimpressao produtoReimpressao) {
        this.produtoReimpressao = produtoReimpressao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(produtoReimpressao, flags);
    }
}
