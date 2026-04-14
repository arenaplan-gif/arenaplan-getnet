package com.arenaplan.pdv.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ClienteCard implements Parcelable {
    @SerializedName("tr_id")
    private String tr_id;
    @SerializedName("version")
    private String version;
    @SerializedName("error_code")
    private String error_code;

    @SerializedName("nome")
    private String nome;

    @SerializedName("celular")
    private String celular;

    @SerializedName("endereco")
    private String endereco;

    @SerializedName("numero")
    private String numero;

    @SerializedName("complemento")
    private String complemento;

    @SerializedName("bairro")
    private String bairro;

    @SerializedName("cidade")
    private String cidade;

    protected ClienteCard(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        error_code = in.readString();
        nome = in.readString();
        celular= in.readString();
        endereco= in.readString();
        numero= in.readString();
        complemento= in.readString();
        bairro= in.readString();
        cidade= in.readString();
    }

    public static final Creator<ClienteCard> CREATOR = new Creator<ClienteCard>() {
        @Override
        public ClienteCard createFromParcel(Parcel in) {
            return new ClienteCard(in);
        }

        @Override
        public ClienteCard[] newArray(int size) {
            return new ClienteCard[size];
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

    public String getnome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
        dest.writeString(nome);
        dest.writeString(celular);
        dest.writeString(endereco);
        dest.writeString(numero);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(cidade);
    }
}
