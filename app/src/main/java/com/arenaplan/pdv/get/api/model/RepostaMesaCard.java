package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RepostaMesaCard implements Parcelable {

    @SerializedName("card")
    private MesaCard mesaCard;

    protected RepostaMesaCard(Parcel in) {
        mesaCard = in.readParcelable(MesaCard.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mesaCard, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RepostaMesaCard> CREATOR = new Creator<RepostaMesaCard>() {
        @Override
        public RepostaMesaCard createFromParcel(Parcel in) {
            return new RepostaMesaCard(in);
        }

        @Override
        public RepostaMesaCard[] newArray(int size) {             return new RepostaMesaCard[size];         }
    };

    public MesaCard getMesaCard() {
        return mesaCard;
    }

    public void setMesaCard(MesaCard mesaCard) {
        this.mesaCard = mesaCard;
    }



}
