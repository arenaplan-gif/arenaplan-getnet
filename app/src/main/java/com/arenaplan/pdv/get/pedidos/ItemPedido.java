package com.arenaplan.pdv.get.pedidos;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemPedido implements Parcelable {

    private String mpprid;
    private String mpprqtde;
    private String mpprvalor;
    private String mpgarcomid;
    private String mpdatahora;

    public ItemPedido() {
    }

    protected ItemPedido(Parcel in) {
        mpprid = in.readString();
        mpprqtde=in.readString();
        mpprvalor=in.readString();
        mpgarcomid = in.readString();
        mpdatahora = in.readString();
    }

    public static final Creator<ItemPedido> CREATOR = new Creator<ItemPedido>() {
        @Override
        public ItemPedido createFromParcel(Parcel in) {
            return new ItemPedido(in);
        }

        @Override
        public ItemPedido[] newArray(int size) {
            return new ItemPedido[size];
        }
    };

    public String getMpprid() {
        return mpprid;
    }

    public void setMpprid(String pi) { this.mpprid = mpprid;     }

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

    public String getMpdatahora() {
        return mpdatahora;
    }

    public void setMpdatahora(String vr) {
        this.mpdatahora = mpdatahora;
    }

    public String getMpgarcomid() {
        return mpgarcomid;
    }

    public void setMpgarcomid(String vr) {
        this.mpgarcomid = mpgarcomid;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mpprid);
        dest.writeString(mpprqtde);
        dest.writeString(mpprvalor);
        dest.writeString(mpdatahora);
        dest.writeString(mpgarcomid);
    }
}
