package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProdutoReimpressao  implements Parcelable {

    @SerializedName("pi")
    private String pi;

    @SerializedName("nr")
    private String nr;

    @SerializedName("qt")
    private String qt;

    @SerializedName("vr")
    private String vr;

    public ProdutoReimpressao() {

    }

    protected ProdutoReimpressao(Parcel in) {
        pi = in.readString();
        nr = in.readString();
        qt = in.readString();
        vr = in.readString();
    }

    public static final Creator<ProdutoReimpressao> CREATOR = new Creator<ProdutoReimpressao>() {
        @Override
        public ProdutoReimpressao createFromParcel(Parcel in) {
            return new ProdutoReimpressao(in);
        }

        @Override
        public ProdutoReimpressao[] newArray(int size) {
            return new ProdutoReimpressao[size];
        }
    };

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getVr() {
        return vr;
    }

    public void setVr(String vr) {
        this.vr = vr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pi);
        dest.writeString(nr);
        dest.writeString(qt);
        dest.writeString(vr);
    }
}
