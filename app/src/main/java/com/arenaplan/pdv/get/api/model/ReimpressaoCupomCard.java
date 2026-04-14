package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ReimpressaoCupomCard implements Parcelable {

    @SerializedName("card")
    private ReimpresaoCupom reimpresaoCupom;

    public ReimpressaoCupomCard() {

    }


    protected ReimpressaoCupomCard(Parcel in) {
        reimpresaoCupom = in.readParcelable(ReimpresaoCupom.class.getClassLoader());
    }

    public static final Creator<ReimpressaoCupomCard> CREATOR = new Creator<ReimpressaoCupomCard>() {
        @Override
        public ReimpressaoCupomCard createFromParcel(Parcel in) {
            return new ReimpressaoCupomCard(in);
        }

        @Override
        public ReimpressaoCupomCard[] newArray(int size) {
            return new ReimpressaoCupomCard[size];
        }
    };

    public ReimpresaoCupom getReimpresaoCupom() {
        return reimpresaoCupom;
    }

    public void setReimpresaoCupom(ReimpresaoCupom reimpresaoCupom) {
        this.reimpresaoCupom = reimpresaoCupom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(reimpresaoCupom, flags);
    }
}
