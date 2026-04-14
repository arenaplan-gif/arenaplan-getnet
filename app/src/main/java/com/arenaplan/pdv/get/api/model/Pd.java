package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pd implements Parcelable {

    @SerializedName("pd")
    private List<Produto> produtoList;

    protected Pd(Parcel in) {
        produtoList = in.createTypedArrayList(Produto.CREATOR);
    }

    public static final Creator<Pd> CREATOR = new Creator<Pd>() {
        @Override
        public Pd createFromParcel(Parcel in) {
            return new Pd(in);
        }

        @Override
        public Pd[] newArray(int size) {
            return new Pd[size];
        }
    };

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
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
