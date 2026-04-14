package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pagamento implements Parcelable {

    @SerializedName("tr_id")
    private long trId;

    @SerializedName("version")   //estava faltando
    private String version;      //estava faltando

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("qs_id")
    private long qs_id; //estava faltando

    @SerializedName("ident_fiscal")
    private String ident_fiscal; //estava faltando

    @SerializedName("imposto")
    private double imposto; //estava faltando

    @SerializedName("ve_id")
    private double ve_id; //estava faltando

    @SerializedName("mensagem")
    private String mensagem; //estava faltando

    @SerializedName("chave")
    private String chave;

    @SerializedName("datahoraprotocolo")
    private String datahoraprotocolo;

    @SerializedName("protocolo")
    private String protocolo;

    @SerializedName("qrcodecsc")
    private String qrcodecsc;

    @SerializedName("qrcodeidtoken")
    private String qrcodeidtoken;

    @SerializedName("digVal")
    private String digVal;

    @SerializedName("sefazImpostoIcmsTotal")
    private String sefazimpostoIcmsTotal;

    @SerializedName("sefazImpostoPercFed")
    private String sefazimpostoPercFed;

    @SerializedName("sefazImpostoPerEst")
    private String sefazimpostoPerEst;

    @SerializedName("sefazImpostoPercMunic")
    private String sefazimpostoPercMunic;


    public Pagamento() {

    }


    public long getTrId() {
        return trId;
    }

    public void setTrId(long trId) {
        this.trId = trId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public long getQs_id() {
        return qs_id;
    }

    public void setQs_id(long qs_id) {
        this.qs_id = qs_id;
    }

    public String getIdent_fiscal() {
        return ident_fiscal;
    }

    public void setIdent_fiscal(String ident_fiscal) {
        this.ident_fiscal = ident_fiscal;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getVe_id() {
        return ve_id;
    }

    public void setVe_id(double ve_id) {
        this.ve_id = ve_id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDatahoraprotocolo() {
        return datahoraprotocolo;
    }

    public void setDatahoraprotocolo(String datahoraprotocolo) {
        this.datahoraprotocolo = datahoraprotocolo;
    }

    public String getprotocolo() {
        return protocolo;
    }

    public void setprotocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getQrcodecsc() {
        return qrcodecsc;
    }

    public void setQrcodecsc(String qrcodecsc) {
        this.qrcodecsc = qrcodecsc;
    }

    public String getQrcodeidtoken() {
        return qrcodeidtoken;
    }

    public void setQrcodeidtoken(String qrcodeidtoken) {
        this.qrcodeidtoken = qrcodeidtoken;
    }

    public String getDigVal() {
        return digVal;
    }

    public void setDigVal(String digVal) {
        this.digVal = digVal;
    }

    public String getSefazimpostoIcmsTotal() {
        return sefazimpostoIcmsTotal;
    }

    public void setSefazimpostoIcmsTotal(String sefazimpostoIcmsTotal) {
        this.sefazimpostoIcmsTotal = sefazimpostoIcmsTotal;
    }

    public String getSefazimpostoPercFed() {
        return sefazimpostoPercFed;
    }

    public void setSefazimpostoPercFed(String sefazimpostoPercFed) {
        this.sefazimpostoPercFed = sefazimpostoPercFed;
    }

    public String getSefazimpostoPerEst() {
        return sefazimpostoPerEst;
    }

    public void setSefazimpostoPerEst(String sefazimpostoPerEst) {
        this.sefazimpostoPerEst = sefazimpostoPerEst;
    }

    public String getSefazimpostoPercMunic() {
        return sefazimpostoPercMunic;
    }

    public void setSefazimpostoPercMunic(String sefazimpostoPercMunic) {
        this.sefazimpostoPercMunic = sefazimpostoPercMunic;
    }

    protected Pagamento(Parcel in) {
        trId = in.readLong();
        version = in.readString();
        errorCode = in.readString();
        qs_id = in.readLong();
        ident_fiscal = in.readString();
        imposto = in.readDouble();
        ve_id = in.readDouble();
        mensagem = in.readString();
        chave = in.readString();
        datahoraprotocolo = in.readString();
        protocolo = in.readString();
        qrcodecsc = in.readString();
        qrcodeidtoken = in.readString();
        digVal = in.readString();
        sefazimpostoIcmsTotal = in.readString();
        sefazimpostoPercFed = in.readString();
        sefazimpostoPerEst = in.readString();
        sefazimpostoPercMunic = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(trId);
        dest.writeString(version);
        dest.writeString(errorCode);
        dest.writeLong(qs_id);
        dest.writeString(ident_fiscal);
        dest.writeDouble(imposto);
        dest.writeDouble(ve_id);
        dest.writeString(mensagem);
        dest.writeString(chave);
        dest.writeString(datahoraprotocolo);
        dest.writeString(protocolo);
        dest.writeString(qrcodecsc);
        dest.writeString(qrcodeidtoken);
        dest.writeString(digVal);
        dest.writeString(sefazimpostoIcmsTotal);
        dest.writeString(sefazimpostoPercFed);
        dest.writeString(sefazimpostoPerEst);
        dest.writeString(sefazimpostoPercMunic);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pagamento> CREATOR = new Creator<Pagamento>() {
        @Override
        public Pagamento createFromParcel(Parcel in) {
            return new Pagamento(in);
        }

        @Override
        public Pagamento[] newArray(int size) {
            return new Pagamento[size];
        }
    };
}
