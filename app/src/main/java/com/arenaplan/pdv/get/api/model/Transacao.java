package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Transacao implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;

    @SerializedName("version")
    private String version;

    @SerializedName("error_code")
    private String error_code;

    @SerializedName("valor")
    private String valor;

    @SerializedName("chave")
    private String chave;

    @SerializedName("protocolo")
    private String protocolo;

    @SerializedName("datahoraprotocolo")
    private String datahoraprotocolo;

    @SerializedName("qrcodecsc")
    private String qrcodecsc;

    @SerializedName("qrcodeidtoken")
    private String qrcodeidtoken;

    @SerializedName("sefazdigVal")
    private String sefazdigVal;

    @SerializedName("mensagem")
    private String mensagem; //estava faltando

    protected Transacao(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        error_code = in.readString();
        valor = in.readString();
        chave = in.readString();
        protocolo = in.readString();
        datahoraprotocolo = in.readString();
        qrcodecsc = in.readString();
        qrcodeidtoken = in.readString();
        sefazdigVal = in.readString();
        mensagem= in.readString();
    }

    public static final Creator<Transacao> CREATOR = new Creator<Transacao>() {
        @Override
        public Transacao createFromParcel(Parcel in) {
            return new Transacao(in);
        }

        @Override
        public Transacao[] newArray(int size) {
            return new Transacao[size];
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getDatahoraprotocolo() {
        return datahoraprotocolo;
    }

    public void setDatahoraprotocolo(String datahoraprotocolo) {
        this.datahoraprotocolo = datahoraprotocolo;
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

    public String getSefazdigVal() {
        return sefazdigVal;
    }

    public void setSefazdigVal(String sefazdigVal) {
        this.sefazdigVal = sefazdigVal;
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
        dest.writeString(valor);
        dest.writeString(chave);
        dest.writeString(protocolo);
        dest.writeString(datahoraprotocolo);
        dest.writeString(qrcodecsc);
        dest.writeString(qrcodeidtoken);
        dest.writeString(sefazdigVal);
        dest.writeString(mensagem);
    }
}
