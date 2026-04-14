package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CardLogin implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;
    @SerializedName("version")
    private String version;
    @SerializedName("error_code")
    private String error_code;
    @SerializedName("datahora")
    private String datahora;

    public CardLogin(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        error_code = in.readString();
        datahora = in.readString();
    }

    public static final Creator<CardLogin> CREATOR = new Creator<CardLogin>() {
        @Override
        public CardLogin createFromParcel(Parcel in) {
            return new CardLogin(in);
        }

        @Override
        public CardLogin[] newArray(int size) {
            return new CardLogin[size];
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

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
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
        dest.writeString(datahora);
    }
}
