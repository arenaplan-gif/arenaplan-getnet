package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class InutilizarCupomCard implements Parcelable {

    @SerializedName("card")
    InutilizarCupom inutilizarCupom;

    protected InutilizarCupomCard(Parcel in) {
        inutilizarCupom = in.readParcelable(InutilizarCupom.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(inutilizarCupom, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<InutilizarCupomCard> CREATOR = new Creator<InutilizarCupomCard>() {
        @Override
        public InutilizarCupomCard createFromParcel(Parcel in) {
            return new InutilizarCupomCard(in);
        }

        @Override
        public InutilizarCupomCard[] newArray(int size) {
            return new InutilizarCupomCard[size];
        }
    };

    public InutilizarCupom getInutilizarCupom() {
        return inutilizarCupom;
    }

    public void setInutilizarCupom(InutilizarCupom inutilizarCupom) {
        this.inutilizarCupom = inutilizarCupom;
    }
}
