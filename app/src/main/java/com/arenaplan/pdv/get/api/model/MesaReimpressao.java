package com.arenaplan.pdv.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MesaReimpressao  implements Parcelable {

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

    public MesaReimpressao() {

    }

    protected MesaReimpressao(Parcel in) {
        menumero = in.readString();
        mestatus = in.readString();
        metotal = in.readString();
        medatahora = in.readString();
        meapelido = in.readString();
    }

    public static final Creator<MesaReimpressao> CREATOR = new Creator<MesaReimpressao>() {
        @Override
        public MesaReimpressao createFromParcel(Parcel in) {
            return new MesaReimpressao(in);
        }

        @Override
        public MesaReimpressao[] newArray(int size) {
            return new MesaReimpressao[size];
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
    }
}