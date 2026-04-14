package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdPedido implements Parcelable {
    @SerializedName("pd")
    private List<Pedido> pedidoList;

    protected PdPedido(Parcel in) {
        pedidoList = in.createTypedArrayList(Pedido.CREATOR);
    }

    public static final Creator<PdPedido> CREATOR = new Creator<PdPedido>() {
        @Override
        public PdPedido createFromParcel(Parcel in) {
            return new PdPedido(in);
        }

        @Override
        public PdPedido[] newArray(int size) {
            return new PdPedido[size];
        }
    };

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidosList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(pedidoList);
    }
}