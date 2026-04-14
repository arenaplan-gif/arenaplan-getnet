package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class InutilizarCupom implements Parcelable {


    @SerializedName("version")
    private String version;

    @SerializedName("error_code")
    private String error_code;

    protected InutilizarCupom(Parcel in) {
        version = in.readString();
        error_code = in.readString();
    }

    public static final Creator<InutilizarCupom> CREATOR = new Creator<InutilizarCupom>() {
        @Override
        public InutilizarCupom createFromParcel(Parcel in) {
            return new InutilizarCupom(in);
        }

        @Override
        public InutilizarCupom[] newArray(int size) {
            return new InutilizarCupom[size];
        }
    };


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(version);
        dest.writeString(error_code);
    }
}
