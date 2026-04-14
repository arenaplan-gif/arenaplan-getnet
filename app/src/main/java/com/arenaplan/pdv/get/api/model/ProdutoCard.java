package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProdutoCard implements Parcelable {

    @SerializedName("qm")
    private String qm;

    @SerializedName("qe")
    private String qe;

    @SerializedName("qn")
    private String qn;

    @SerializedName("qp")
    private String qp;

    @SerializedName("qb")
    private String qb;

    @SerializedName("qc")
    private String qc;

    @SerializedName("qj")
    private String qj;

    @SerializedName("qu")
    private String qu;

    @SerializedName("qz")
    private String qz;

    @SerializedName("qi")
    private String qi;

    @SerializedName("cuf")
    private String cuf;

    @SerializedName("uo")
    private String uo;

    @SerializedName("hh")
    private String hh;

    @SerializedName("uf_url_sefaz_prod")
    private String ufUrlSefazProd;

    @SerializedName("uf_url_sefaz_homolog")
    private String ufUrlSefazHomolog;

    @SerializedName("qs_status_sefaz_nfce")
    private String qsStatusSefazNfce;

    @SerializedName("pds")
    private Pd pd;

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("tef")
    private String tef;

    @SerializedName("pp")
    private String pp;

    @SerializedName("mo")
    private String mo;

    @SerializedName("cc")
    private String cc;

    @SerializedName("le")
    private String le;

    @SerializedName("to")
    private String to;

    @SerializedName("cdat")
    private String cdat;

    @SerializedName("asst")
    private String asst;

    @SerializedName("inscm")
    private String inscm;

    @SerializedName("cnpjd")
    private String cnpjd;

    @SerializedName("layout")
    private String layout;

    @SerializedName("mr")
    private String mr;

    @SerializedName("crd")
    private String crd;

    protected ProdutoCard(Parcel in) {
        qm = in.readString();
        qe = in.readString();
        qn = in.readString();
        qp = in.readString();
        qb = in.readString();
        qc = in.readString();
        qj = in.readString();
        qu = in.readString();
        qz = in.readString();
        qi = in.readString();
        cuf = in.readString();
        uo = in.readString();
        hh = in.readString();
        ufUrlSefazProd = in.readString();
        ufUrlSefazHomolog = in.readString();
        qsStatusSefazNfce = in.readString();
        pd = in.readParcelable(Pd.class.getClassLoader());
        errorCode = in.readString();
        tef = in.readString();
        pp = in.readString();
        mo = in.readString();
        cc = in.readString();
        le = in.readString();
        to = in.readString();
        cdat = in.readString();
        asst = in.readString();
        inscm = in.readString();
        cnpjd = in.readString();
        layout = in.readString();
        mr = in.readString();
        crd = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(qm);
        dest.writeString(qe);
        dest.writeString(qn);
        dest.writeString(qp);
        dest.writeString(qb);
        dest.writeString(qc);
        dest.writeString(qj);
        dest.writeString(qu);
        dest.writeString(qz);
        dest.writeString(qi);
        dest.writeString(cuf);
        dest.writeString(uo);
        dest.writeString(hh);
        dest.writeString(ufUrlSefazProd);
        dest.writeString(ufUrlSefazHomolog);
        dest.writeString(qsStatusSefazNfce);
        dest.writeParcelable(pd, flags);
        dest.writeString(errorCode);
        dest.writeString(tef);
        dest.writeString(pp);
        dest.writeString(mo);
        dest.writeString(cc);
        dest.writeString(le);
        dest.writeString(to);
        dest.writeString(cdat);
        dest.writeString(asst);
        dest.writeString(inscm);
        dest.writeString(cnpjd);
        dest.writeString(layout);
        dest.writeString(mr);
        dest.writeString(crd);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProdutoCard> CREATOR = new Creator<ProdutoCard>() {
        @Override
        public ProdutoCard createFromParcel(Parcel in) {
            return new ProdutoCard(in);
        }

        @Override
        public ProdutoCard[] newArray(int size) {
            return new ProdutoCard[size];
        }
    };

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm;
    }

    public String getQe() {
        return qe;
    }

    public void setQe(String qe) {
        this.qe = qe;
    }

    public String getQn() {
        return qn;
    }

    public void setQn(String qn) {
        this.qn = qn;
    }

    public String getQp() {
        return qp;
    }

    public void setQp(String qp) {
        this.qp = qp;
    }

    public String getQb() {
        return qb;
    }

    public void setQb(String qb) {
        this.qb = qb;
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc;
    }

    public String getQj() {
        return qj;
    }

    public void setQj(String qj) {
        this.qj = qj;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getQz() {
        return qz;
    }

    public void setQz(String qz) {
        this.qz = qz;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }

    public String getCuf() {
        return cuf;
    }

    public void setCuf(String cuf) {
        this.cuf = cuf;
    }

    public String getUo() {
        return uo;
    }

    public void setUo(String uo) {
        this.uo = uo;
    }

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getUfUrlSefazProd() {
        return ufUrlSefazProd;
    }

    public void setUfUrlSefazProd(String ufUrlSefazProd) {
        this.ufUrlSefazProd = ufUrlSefazProd;
    }

    public String getUfUrlSefazHomolog() {
        return ufUrlSefazHomolog;
    }

    public void setUfUrlSefazHomolog(String ufUrlSefazHomolog) {
        this.ufUrlSefazHomolog = ufUrlSefazHomolog;
    }

    public String getQsStatusSefazNfce() {
        return qsStatusSefazNfce;
    }

    public void setQsStatusSefazNfce(String qsStatusSefazNfce) {
        this.qsStatusSefazNfce = qsStatusSefazNfce;
    }

    public Pd getPd() {
        return pd;
    }

    public void setPd(Pd pd) {
        this.pd = pd;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getTef() {
        return tef;
    }

    public void setTef(String tef) {
        this.tef = tef;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCdat() {
        return cdat;
    }

    public void setCdat(String cdat) {
        this.cdat = cdat;
    }

    public String getAsst() {
        return asst;
    }

    public void setAsst(String asst) {
        this.asst = asst;
    }

    public String getInscm() {
        return inscm;
    }

    public void setInscm(String inscm) {
        this.inscm = inscm;
    }

    public String getCnpjd() {
        return cnpjd;
    }

    public void setCnpjd(String cnpjd) {
        this.cnpjd = cnpjd;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getCrd() {
        return crd;
    }

    public void setCrd(String crd) {
        this.crd = crd;
    }
}
