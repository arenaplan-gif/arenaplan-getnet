package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReimpresaoCupomSimples implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;

    @SerializedName("version")
    private String version;

    @SerializedName("qs_id")
    private String qs_id;

    @SerializedName("ident_fiscal")
    private String ident_fiscal;

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("tipo")
    private String tipo;

    @SerializedName("status")
    private String status;

    @SerializedName("desconto")
    private  String desconto;

    @SerializedName("pds")
    private PdReimpressaoSimples pds;

    @Expose
    @SerializedName("chave")
    private String chave;

    @Expose
    @SerializedName("protocolo")
    private String protocolo;

    @Expose
    @SerializedName("datahoraprotocolo")
    private String datahoraprotocolo;

    @Expose
    @SerializedName("qrcodecsc")
    private String  qrcodecsc;

    @Expose
    @SerializedName("qrcodeidtoken")
    private String qrcodeidtoken;

    @Expose
    @SerializedName("sefazdigVal")
    private String sefazdigVal;

    @Expose
    @SerializedName("sefazImpostoIcmsTotal")
    private String sefazImpostoIcmsTotal;

    @Expose
    @SerializedName("sefazImpostoPercFed")
    private String sefazImpostoPercFed;

    @Expose
    @SerializedName("sefazImpostoPerEst")
    private String sefazImpostoPerEst;

    @Expose
    @SerializedName("sefazImpostoPercMunic")
    private String sefazImpostoPercMunic;

    @Expose
    @SerializedName("nome")
    private String nome;

    @Expose
    @SerializedName("endereco")
    private String endereco;

    @Expose
    @SerializedName("numero")
    private String numero;

    @Expose
    @SerializedName("complemento")
    private String complemento;

    @Expose
    @SerializedName("bairro")
    private String bairro;

    @Expose
    @SerializedName("cidade")
    private String cidade;

    @Expose
    @SerializedName("uf")
    private String uf;

    @Expose
    @SerializedName("cep")
    private String cep;

    @Expose
    @SerializedName("inscricao")
    private String inscricao;

    @Expose
    @SerializedName("datahoraoriginal")
    private String datahoraoriginal;


    @SerializedName("error_code")
    private String error_code;

    @SerializedName("total")
    private String total;

    protected ReimpresaoCupomSimples(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        qs_id = in.readString();
        ident_fiscal = in.readString();
        cpf = in.readString();
        tipo = in.readString();
        status = in.readString();
        desconto = in.readString();
        pds = in.readParcelable(PdReimpressaoSimples.class.getClassLoader());
        chave = in.readString();
        protocolo = in.readString();
        datahoraprotocolo = in.readString();
        qrcodecsc = in.readString();
        qrcodeidtoken = in.readString();
        sefazdigVal = in.readString();
        sefazImpostoIcmsTotal = in.readString();
        sefazImpostoPercFed = in.readString();
        sefazImpostoPerEst = in.readString();
        sefazImpostoPercMunic = in.readString();
        nome = in.readString();
        endereco = in.readString();
        numero = in.readString();
        complemento = in.readString();
        bairro = in.readString();
        cidade = in.readString();
        uf = in.readString();
        cep = in.readString();
        inscricao = in.readString();
        datahoraoriginal = in.readString();
        error_code = in.readString();
        total = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tr_id);
        dest.writeString(version);
        dest.writeString(qs_id);
        dest.writeString(ident_fiscal);
        dest.writeString(cpf);
        dest.writeString(tipo);
        dest.writeString(status);
        dest.writeString(desconto);
        dest.writeParcelable(pds, flags);
        dest.writeString(chave);
        dest.writeString(protocolo);
        dest.writeString(datahoraprotocolo);
        dest.writeString(qrcodecsc);
        dest.writeString(qrcodeidtoken);
        dest.writeString(sefazdigVal);
        dest.writeString(sefazImpostoIcmsTotal);
        dest.writeString(sefazImpostoPercFed);
        dest.writeString(sefazImpostoPerEst);
        dest.writeString(sefazImpostoPercMunic);
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(numero);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(cidade);
        dest.writeString(uf);
        dest.writeString(cep);
        dest.writeString(inscricao);
        dest.writeString(datahoraoriginal);
        dest.writeString(error_code);
        dest.writeString(total);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReimpresaoCupomSimples> CREATOR = new Creator<ReimpresaoCupomSimples>() {
        @Override
        public ReimpresaoCupomSimples createFromParcel(Parcel in) {
            return new ReimpresaoCupomSimples(in);
        }

        @Override
        public ReimpresaoCupomSimples[] newArray(int size) {
            return new ReimpresaoCupomSimples[size];
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

    public String getQs_id() {
        return qs_id;
    }

    public void setQs_id(String qs_id) {
        this.qs_id = qs_id;
    }

    public String getIdent_fiscal() {
        return ident_fiscal;
    }

    public void setIdent_fiscal(String ident_fiscal) {
        this.ident_fiscal = ident_fiscal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public PdReimpressaoSimples getPds() {
        return pds;
    }

    public void setPds(PdReimpressaoSimples pds) {
        this.pds = pds;
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

    public String getSefazImpostoIcmsTotal() {
        return sefazImpostoIcmsTotal;
    }

    public void setSefazImpostoIcmsTotal(String sefazImpostoIcmsTotal) {
        this.sefazImpostoIcmsTotal = sefazImpostoIcmsTotal;
    }

    public String getSefazImpostoPercFed() {
        return sefazImpostoPercFed;
    }

    public void setSefazImpostoPercFed(String sefazImpostoPercFed) {
        this.sefazImpostoPercFed = sefazImpostoPercFed;
    }

    public String getSefazImpostoPerEst() {
        return sefazImpostoPerEst;
    }

    public void setSefazImpostoPerEst(String sefazImpostoPerEst) {
        this.sefazImpostoPerEst = sefazImpostoPerEst;
    }

    public String getSefazImpostoPercMunic() {
        return sefazImpostoPercMunic;
    }

    public void setSefazImpostoPercMunic(String sefazImpostoPercMunic) {
        this.sefazImpostoPercMunic = sefazImpostoPercMunic;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getDatahoraoriginal() {
        return datahoraoriginal;
    }

    public void setDatahoraoriginal(String datahoraoriginal) {
        this.datahoraoriginal = datahoraoriginal;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
