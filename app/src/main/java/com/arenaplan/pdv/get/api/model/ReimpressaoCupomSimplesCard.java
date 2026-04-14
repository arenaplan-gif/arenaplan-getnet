package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ReimpressaoCupomSimplesCard implements Parcelable {

    @SerializedName("card")
    private ReimpresaoCupomSimples reimpresaoCupom;

    protected ReimpressaoCupomSimplesCard(Parcel in) {
        reimpresaoCupom = in.readParcelable(ReimpresaoCupomSimples.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(reimpresaoCupom, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReimpressaoCupomSimplesCard> CREATOR = new Creator<ReimpressaoCupomSimplesCard>() {
        @Override
        public ReimpressaoCupomSimplesCard createFromParcel(Parcel in) {
            return new ReimpressaoCupomSimplesCard(in);
        }

        @Override
        public ReimpressaoCupomSimplesCard[] newArray(int size) {
            return new ReimpressaoCupomSimplesCard[size];
        }
    };

    public ReimpresaoCupomSimples getReimpresaoCupom() {
        return reimpresaoCupom;
    }

    public void setReimpresaoCupom(ReimpresaoCupomSimples reimpresaoCupom) {
        this.reimpresaoCupom = reimpresaoCupom;
    }
}
