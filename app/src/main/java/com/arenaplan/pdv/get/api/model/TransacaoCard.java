package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TransacaoCard implements Parcelable {

    @SerializedName("card")
    private Transacao transacao;

    protected TransacaoCard(Parcel in) {
        transacao = in.readParcelable(Transacao.class.getClassLoader());
    }

    public static final Creator<TransacaoCard> CREATOR = new Creator<TransacaoCard>() {
        @Override
        public TransacaoCard createFromParcel(Parcel in) {
            return new TransacaoCard(in);
        }

        @Override
        public TransacaoCard[] newArray(int size) {
            return new TransacaoCard[size];
        }
    };

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(transacao, flags);
    }
}
