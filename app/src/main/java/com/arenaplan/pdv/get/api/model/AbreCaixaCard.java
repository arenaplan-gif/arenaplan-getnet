package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AbreCaixaCard implements Parcelable {

    @SerializedName("card")
    private AbreCaixa abreCaixa;

    protected AbreCaixaCard(Parcel in) {
        abreCaixa = in.readParcelable(AbreCaixa.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(abreCaixa, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AbreCaixaCard> CREATOR = new Creator<AbreCaixaCard>() {
        @Override
        public AbreCaixaCard createFromParcel(Parcel in) {
            return new AbreCaixaCard(in);
        }

        @Override
        public AbreCaixaCard[] newArray(int size) {
            return new AbreCaixaCard[size];
        }
    };

    public AbreCaixa getAbreCaixa() {
        return abreCaixa;
    }

    public void setAbreCaixa(AbreCaixa abreCaixa) {
        this.abreCaixa = abreCaixa;
    }
}
