package com.arenaplan.pdv.get.database.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class PendenteEntidade implements Parcelable {

    private long id;
    private String acao;
    private String carrinho;
    private float total;
    private float desc;
    private float troco;
    private String idf;
    private String idnfe;
    private String cpf;
    private String tipo;

    private String nsu;

    private String cvNumber;
    private String band;
    private String mod;
    private String parc;


    public PendenteEntidade() {

    }


    protected PendenteEntidade(Parcel in) {
        id = in.readLong();
        acao = in.readString();
        carrinho = in.readString();
        total = in.readFloat();
        desc = in.readFloat();
        troco = in.readFloat();
        idf = in.readString();
        idnfe = in.readString();
        cpf = in.readString();
        tipo = in.readString();
        nsu = in.readString();
        cvNumber=in.readString();
        band=in.readString();
        mod=in.readString();
        parc=in.readString();
    }

    public static final Creator<PendenteEntidade> CREATOR = new Creator<PendenteEntidade>() {
        @Override
        public PendenteEntidade createFromParcel(Parcel in) {
            return new PendenteEntidade(in);
        }

        @Override
        public PendenteEntidade[] newArray(int size) {
            return new PendenteEntidade[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(String carrinho) {
        this.carrinho = carrinho;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDesc() {
        return desc;
    }

    public void setDesc(float desc) {
        this.desc = desc;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public String getIdnfe() {
        return idnfe;
    }

    public void setIdnfe(String idnfe) {
        this.idnfe = idnfe;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNsu() {
        return nsu;
    }
    public void setNsu(String nsu) {
        this.nsu = nsu;
    }
    public String getCvNumber() {
        return cvNumber;
    }
    public void setCvNumber(String cvNumber) {this.cvNumber = cvNumber;}

    public String getBand() {         return band;     }
    public void setBand(String band) {this.band = band;}

    public String getModal() {
        return mod;
    }
    public void setModal(String mod) {
        this.mod = mod;
    }
    public String getParcel() {
        return parc;
    }
    public void setParcel(String parc) {
        this.parc = parc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(acao);
        dest.writeString(carrinho);
        dest.writeFloat(total);
        dest.writeFloat(desc);
        dest.writeFloat(troco);
        dest.writeString(idf);
        dest.writeString(idnfe);
        dest.writeString(cpf);
        dest.writeString(tipo);
        dest.writeString(nsu);
        dest.writeString(cvNumber);
        dest.writeString(band);
        dest.writeString(mod);
        dest.writeString(parc);
    }
}
