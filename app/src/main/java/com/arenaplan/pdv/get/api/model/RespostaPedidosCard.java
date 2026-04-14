package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RespostaPedidosCard implements Parcelable {
    @SerializedName("card")
    private PedidoCard pedidoCard;

    protected RespostaPedidosCard(Parcel in) {
        pedidoCard = in.readParcelable(MesaCard.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(pedidoCard, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RespostaPedidosCard> CREATOR = new Creator<RespostaPedidosCard>() {
        @Override
        public RespostaPedidosCard createFromParcel(Parcel in) {
            return new RespostaPedidosCard(in);
        }

        @Override
        public RespostaPedidosCard[] newArray(int size) {             return new RespostaPedidosCard[size];         }
    };

    public PedidoCard getPedidoCard() {
        return pedidoCard;
    }

    public void setPedidoCard(PedidoCard pedidoCard) {
        this.pedidoCard = pedidoCard;
    }



}
