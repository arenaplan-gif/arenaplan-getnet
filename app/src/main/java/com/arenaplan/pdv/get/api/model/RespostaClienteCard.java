package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RespostaClienteCard implements Parcelable {

    @SerializedName("card")
    private com.arenaplan.pdv.api.model.ClienteCard clienteCard;

    protected RespostaClienteCard(Parcel in) {
        clienteCard = in.readParcelable(com.arenaplan.pdv.api.model.ClienteCard.class.getClassLoader());
    }

    public static final Creator<RespostaClienteCard> CREATOR = new Creator<RespostaClienteCard>() {
        @Override
        public RespostaClienteCard createFromParcel(Parcel in) {
            return new RespostaClienteCard(in);
        }

        @Override
        public RespostaClienteCard[] newArray(int size) {
            return new RespostaClienteCard[size];
        }
    };

    public com.arenaplan.pdv.api.model.ClienteCard getClienteCard() {
        return clienteCard;
    }

    public void setClienteCard(com.arenaplan.pdv.api.model.ClienteCard clienteCard) {
        this.clienteCard = clienteCard;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(clienteCard, flags);
    }
}

