package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Produto implements Parcelable {

    @SerializedName("pi")
    private String pi;

    @SerializedName("nr")
    private String nr;

    @SerializedName("vr")
    private String vr;

    @SerializedName("td")
    private String td;

    @SerializedName("cb")
    private String cb;

    @SerializedName("un")
    private String un;

    @SerializedName("ncmid")
    private String ncmid;

    @SerializedName("gfid")
    private String gfid;

    @SerializedName("nH")
    private String nH;

    @SerializedName("imt")
    private String imt;

    @SerializedName("imp")
    private String imp;


    protected Produto(Parcel in) {
        pi = in.readString();
        nr = in.readString();
        vr = in.readString();
        td = in.readString();
        cb = in.readString();
        un = in.readString();
        ncmid = in.readString();
        gfid = in.readString();
        nH = in.readString();
        imt = in.readString();
        imp = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
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

    public String getVr() {
        return vr;
    }

    public void setVr(String vr) {
        this.vr = vr;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getNcmid() {
        return ncmid;
    }

    public void setNcmid(String ncmid) {
        this.ncmid = ncmid;
    }

    public String getGfid() {
        return gfid;
    }

    public void setGfid(String gfid) {
        this.gfid = gfid;
    }

    public String getnH() {
        return nH;
    }

    public void setnH(String nH) {
        this.nH = nH;
    }

    public String getImt() {
        return imt;
    }

    public void setImt(String imt) {
        this.imt = imt;
    }

    public String getImp() {
        return imp;
    }

    public void setIm(String imp) {
        this.imp = imp;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pi);
        dest.writeString(nr);
        dest.writeString(vr);
        dest.writeString(td);
        dest.writeString(cb);
        dest.writeString(un);
        dest.writeString(ncmid);
        dest.writeString(gfid);
        dest.writeString(nH);
        dest.writeString(imt);
        dest.writeString(imp);
    }
}
