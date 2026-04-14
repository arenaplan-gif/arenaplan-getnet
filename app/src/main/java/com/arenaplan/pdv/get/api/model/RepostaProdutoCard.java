package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RepostaProdutoCard implements Parcelable {

    @SerializedName("card")
    private ProdutoCard produtoCard;

    protected RepostaProdutoCard(Parcel in) {
        produtoCard = in.readParcelable(ProdutoCard.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(produtoCard, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RepostaProdutoCard> CREATOR = new Creator<RepostaProdutoCard>() {
        @Override
        public RepostaProdutoCard createFromParcel(Parcel in) {
            return new RepostaProdutoCard(in);
        }

        @Override
        public RepostaProdutoCard[] newArray(int size) {
            return new RepostaProdutoCard[size];
        }
    };

    public ProdutoCard getProdutoCard() {
        return produtoCard;
    }

    public void setProdutoCard(ProdutoCard produtoCard) {
        this.produtoCard = produtoCard;
    }
}
