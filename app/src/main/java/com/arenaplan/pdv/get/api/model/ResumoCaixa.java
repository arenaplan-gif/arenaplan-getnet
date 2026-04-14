package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResumoCaixa implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;

    @SerializedName("version")
    private String version;

    @SerializedName("error_code")
    private String error_code;

    @SerializedName("status")
    private String status;

    @SerializedName("dinheiro")
    private String dinheiro;

    @SerializedName("debito")
    private String debito;

    @SerializedName("credito")
    private String credito;

    @SerializedName("prepago")
    private String prepago;

    @SerializedName("pix")
    private String pix;

    @SerializedName("voucher")
    private String voucher;

    @SerializedName("cheque")
    private String cheque;

    @SerializedName("desconto")
    private String desconto;

    @SerializedName("troco")
    private String troco;

    @SerializedName("data_abertura")
    private String data_abertura;

    @SerializedName("data_fechamento")
    private String data_fechamento;

    protected ResumoCaixa(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        error_code = in.readString();
        status = in.readString();
        dinheiro = in.readString();
        debito = in.readString();
        credito = in.readString();
        prepago = in.readString();
        pix = in.readString();
        voucher = in.readString();
        cheque = in.readString();
        desconto = in.readString();
        troco = in.readString();
        data_abertura = in.readString();
        data_fechamento = in.readString();
    }

    public static final Creator<ResumoCaixa> CREATOR = new Creator<ResumoCaixa>() {
        @Override
        public ResumoCaixa createFromParcel(Parcel in) {
            return new ResumoCaixa(in);
        }

        @Override
        public ResumoCaixa[] newArray(int size) {
            return new ResumoCaixa[size];
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getPrepago() {
        return prepago;
    }

    public void setPrepago(String prepago) {
        this.prepago = prepago;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getTroco() {
        return troco;
    }

    public void setTroco(String troco) {
        this.troco = troco;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento) {
        this.data_fechamento = data_fechamento;
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
        dest.writeString(status);
        dest.writeString(dinheiro);
        dest.writeString(debito);
        dest.writeString(credito);
        dest.writeString(prepago);
        dest.writeString(pix);
        dest.writeString(voucher);
        dest.writeString(cheque);
        dest.writeString(desconto);
        dest.writeString(troco);
        dest.writeString(data_abertura);
        dest.writeString(data_fechamento);
    }
}
