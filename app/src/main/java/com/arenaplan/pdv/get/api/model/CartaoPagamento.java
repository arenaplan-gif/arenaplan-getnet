package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CartaoPagamento implements Parcelable {
    private String BANDEIRA;
    private String NUMRRN;
    private String NUMAUTORIZACAO;
    private String MODALIDADE;
    private String NUMPARCELAS;

    public CartaoPagamento(String BANDEIRA, String NUMRRN, String NUMAUTORIZACAO, String MODALIDADE, String NUMPARCELAS) {
        this.BANDEIRA = BANDEIRA;
        this.NUMRRN = NUMRRN;
        this.NUMAUTORIZACAO = NUMAUTORIZACAO;
        this.MODALIDADE = MODALIDADE;
        this.NUMPARCELAS = NUMPARCELAS;
    }

    protected CartaoPagamento(Parcel in) {
        BANDEIRA = in.readString();
        NUMRRN = in.readString();
        NUMAUTORIZACAO = in.readString();
        MODALIDADE = in.readString();
        NUMPARCELAS = in.readString();
    }

    public static final Creator<CartaoPagamento> CREATOR = new Creator<CartaoPagamento>() {
        //@override
        public CartaoPagamento createFromParcel(Parcel in) {
            return new CartaoPagamento(in);
        }

        //@override
        public CartaoPagamento[] newArray(int size) {
            return new CartaoPagamento[size];
        }
    };

    public String getBANDEIRA() {
        return BANDEIRA;
    }

    public String getNUMRRN() {
        return NUMRRN;
    }

    public String getNUMAUTORIZACAO() {
        return NUMAUTORIZACAO;
    }

    public String getMODALIDADE() {
        return MODALIDADE;
    }

    public String getNUMPARCELAS() {
        return NUMPARCELAS;
    }

    public void SetBANDEIRA(String BANDEIRA) {
        this.BANDEIRA=BANDEIRA;
    }
    public void SetNUMRRN(String NUMRRN) {
        this.NUMRRN=NUMRRN;
    }
    public void SetNUMAUTORIZACAO(String NUMAUTORIZACAO) {
        this.NUMAUTORIZACAO=NUMAUTORIZACAO;
    }
    public void SetMODALIDADE(String MODALIDADE) {
        this.MODALIDADE=MODALIDADE;
    }
    public void SetNUMPARCELAS(String NUMPARCELAS) {
        this.NUMPARCELAS=NUMPARCELAS;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(BANDEIRA);
        dest.writeString(NUMRRN);
        dest.writeString(NUMAUTORIZACAO);
        dest.writeString(MODALIDADE);
        dest.writeString(NUMPARCELAS);
    }
}
