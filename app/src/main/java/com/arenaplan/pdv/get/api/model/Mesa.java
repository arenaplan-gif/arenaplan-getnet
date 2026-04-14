package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Mesa implements Parcelable {
    @SerializedName("me_numero")
    private String menumero;

    @SerializedName("me_status")
    private String mestatus;

    @SerializedName("me_total")
    private String metotal;

    @SerializedName("me_data_hora")
    private String medatahora;

    @SerializedName("me_apelido")
    private String meapelido;

    @SerializedName("me_revenda")
    private String merevenda;

    @SerializedName("me_clienteid")
    private String meclid;

    public Mesa(Parcel in) {
        menumero = in.readString();
        mestatus = in.readString();
        metotal = in.readString();
        medatahora = in.readString();
        meapelido = in.readString();
        merevenda = in.readString();
        meclid= in.readString();
    }

    public static final Creator<Mesa> CREATOR = new Creator<Mesa>() {
        @Override
        public Mesa createFromParcel(Parcel in) {

            return new Mesa(in);
        }

        @Override
        public Mesa[] newArray(int size) {
            return new Mesa[size];
        }
    };




    public String getMenumero() {
        return menumero;
    }

    public void setMenumero(String pi) {
        this.menumero = menumero;
    }

    public String getMestatus() {
        return mestatus;
    }

    public void setMestatus(String nr) {
        this.mestatus = mestatus;
    }

    public String getMetotal() {
        return metotal;
    }

    public void setMetotal(String qt) {
        this.metotal = metotal;
    }

    public String getMedatahora() {
        return medatahora;
    }

    public void setMedatahora(String vr) {
        this.medatahora = medatahora;
    }

    public String getMeapelido() {
        return meapelido;
    }

    public void setMeapelido(String vr) {
        this.meapelido = meapelido;
    }

    public String getMerevenda() {
        return merevenda;
    }

    public void setMerevenda(String vr) {
        this.merevenda = merevenda;
    }

    public String getMeclid() {
        return meclid;
    }

    public void setMeclid(String cl) {
        this.meclid = meclid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menumero);
        dest.writeString(mestatus);
        dest.writeString(metotal);
        dest.writeString(medatahora);
        dest.writeString(meapelido);
        dest.writeString(merevenda);
        dest.writeString(meclid);
    }

}
