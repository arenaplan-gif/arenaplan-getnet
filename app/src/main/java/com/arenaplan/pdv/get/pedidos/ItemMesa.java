package com.arenaplan.pdv.get.pedidos;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemMesa implements Parcelable {

    private String menumero;
    private String mestatus;
    private String metotal;
    private String medatahora;
    private String meapelido;

    private String merevenda;

    private String meclid;
    public ItemMesa() {
    }

    protected ItemMesa(Parcel in) {
        menumero = in.readString();
        mestatus = in.readString();
        metotal = in.readString();
        medatahora = in.readString();
        meapelido = in.readString();
        merevenda=in.readString();
        meclid=in.readString();
    }

    public static final Creator<ItemMesa> CREATOR = new Creator<ItemMesa>() {
        @Override
        public ItemMesa createFromParcel(Parcel in) {
            return new ItemMesa(in);
        }

        @Override
        public ItemMesa[] newArray(int size) {
            return new ItemMesa[size];
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

    public void setMerevenda(String rv) {
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
