package com.arenaplan.pdv.get.api.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PagamentoCard implements Parcelable {

    @SerializedName("card")
    private Pagamento pagamento;

    protected PagamentoCard(Parcel in) {
        pagamento = in.readParcelable(Pagamento.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(pagamento, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PagamentoCard> CREATOR = new Creator<PagamentoCard>() {
        @Override
        public PagamentoCard createFromParcel(Parcel in) {
            return new PagamentoCard(in);
        }

        @Override
        public PagamentoCard[] newArray(int size) {
            return new PagamentoCard[size];
        }
    };

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
