package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdMesa implements Parcelable {

    @SerializedName("pd")
    private List<Mesa> mesaList;

    protected PdMesa(Parcel in) {
        mesaList = in.createTypedArrayList(Mesa.CREATOR);
    }

    public static final Creator<PdMesa> CREATOR = new Creator<PdMesa>() {
        @Override
        public PdMesa createFromParcel(Parcel in) {
            return new PdMesa(in);
        }

        @Override
        public PdMesa[] newArray(int size) {
            return new PdMesa[size];
        }
    };

    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mesaList);
    }
}