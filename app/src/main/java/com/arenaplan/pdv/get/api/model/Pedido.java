package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pedido implements Parcelable {
    @SerializedName("mp_pr_id")
    private String mpprid;

    @SerializedName("mp_nome_res")
    private String mpnome;

    @SerializedName("mp_pr_qtde")
    private String mpprqtde;

    @SerializedName("mp_pr_valor")
    private String mpprvalor;

    @SerializedName("mp_garcom_id")
    private String mpgarcomid;
    @SerializedName("mp_data_hora")
    private String mpdatahora;

    @SerializedName("mp_obs")
    private String mpobs;

    public Pedido(Parcel in) {
        mpprid = in.readString();
        mpnome = in.readString();
        mpprqtde = in.readString();
        mpprvalor = in.readString();
        mpgarcomid = in.readString();
        mpdatahora = in.readString();
        mpobs = in.readString();
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {

            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };


    public String getMpprid() {
        return mpprid;
    }

    public void setMpprid(String pi) {
        this.mpprid = mpprid;
    }

    public String getMpnome() {
        return mpnome;
    }

    public void setMpnome(String pi) {
        this.mpnome = mpnome;
    }


    public String getMpprqtde() {
        return mpprqtde;
    }

    public void setMpprqtde(String nr) {
        this.mpprqtde = mpprqtde;
    }


    public String getMpprvalor() {
        return mpprvalor;
    }

    public void setMpprvalor(String qt) {
        this.mpprvalor = mpprvalor;
    }

    public String getMpgarcomid() {
        return mpgarcomid;
    }

    public void setMpgarcomid(String qt) {
        this.mpgarcomid = mpgarcomid;
    }

    public void setMpdatahora(String vr) {
        this.mpdatahora = mpdatahora;
    }

    public String getMpdatahora() {         return mpdatahora;     }

    public void setMpobs(String vr) {
        this.mpobs = mpobs;
    }

    public String getMpobs() {         return mpobs;     }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mpprid);
        dest.writeString(mpnome);
        dest.writeString(mpprqtde);
        dest.writeString(mpprvalor);
        dest.writeString(mpgarcomid);
        dest.writeString(mpdatahora);
        dest.writeString(mpobs);
    }

}
