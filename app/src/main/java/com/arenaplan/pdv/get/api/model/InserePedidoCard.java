package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class InserePedidoCard implements Parcelable {

    @SerializedName("card")
    private InserePedido inserePedido;

    protected InserePedidoCard(Parcel in) {
        inserePedido = in.readParcelable(InserePedido.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(inserePedido, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<InserePedidoCard> CREATOR = new Creator<InserePedidoCard>() {
        @Override
        public InserePedidoCard createFromParcel(Parcel in) {
            return new InserePedidoCard(in);
        }

        @Override
        public InserePedidoCard[] newArray(int size) {
            return new InserePedidoCard[size];
        }
    };



    public InserePedido getInserePedido() {
        return inserePedido;
    }

    public void setInserePedido(InserePedido inserePedido) {
        this.inserePedido = inserePedido;
    }
}
