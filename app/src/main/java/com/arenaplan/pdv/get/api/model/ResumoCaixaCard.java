package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResumoCaixaCard implements Parcelable {

    @SerializedName("card")
    private ResumoCaixa resumoCaixa;

    protected ResumoCaixaCard(Parcel in) {
        resumoCaixa = in.readParcelable(ResumoCaixa.class.getClassLoader());
    }

    public static final Creator<ResumoCaixaCard> CREATOR = new Creator<ResumoCaixaCard>() {
        @Override
        public ResumoCaixaCard createFromParcel(Parcel in) {
            return new ResumoCaixaCard(in);
        }

        @Override
        public ResumoCaixaCard[] newArray(int size) {
            return new ResumoCaixaCard[size];
        }
    };

    public ResumoCaixa getResumoCaixa() {
        return resumoCaixa;
    }

    public void setResumoCaixa(ResumoCaixa resumoCaixa) {
        this.resumoCaixa = resumoCaixa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(resumoCaixa, flags);
    }
}
