package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AbreCaixa implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;

    @SerializedName("version")
    private String version;

    @SerializedName("error_code")
    private String error_code;

    protected AbreCaixa(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        error_code = in.readString();
    }

    public static final Creator<AbreCaixa> CREATOR = new Creator<AbreCaixa>() {
        @Override
        public AbreCaixa createFromParcel(Parcel in) {
            return new AbreCaixa(in);
        }

        @Override
        public AbreCaixa[] newArray(int size) {
            return new AbreCaixa[size];
        }
    };

    public String getTr_id() {
        return tr_id;
    }

    public void setTr_id(String tr_id) {
        this.tr_id = tr_id;
    }

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
        dest.writeString(tr_id);
        dest.writeString(version);
        dest.writeString(error_code);
    }
}
