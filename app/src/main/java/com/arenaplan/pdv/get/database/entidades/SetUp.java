package com.arenaplan.pdv.get.database.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class SetUp implements Parcelable {

    private long idSetUp;
    private String t_login;
    private String t_passw;
    private Integer t_hh_ident;
    private String t_tipo_recibo;
    private String t_senha;
    private String t_razao;
    private String t_endereco;
    private String t_numero;
    private String t_complemento;
    private String t_bairro;
    private String t_cidade;
    private String t_cnpj;
    private String t_uf;
    private String t_cep;
    private String t_inscricao;
    private String t_cuf;
    private String t_usaoff;
    private String t_serie;
    private String t_urlpro;
    private String t_urlhomo;
    private String t_sefaz;
    private String t_tef;
    private String t_prepapo;
    private String t_monitor;
    private String t_cliente;
    private String t_leitora;
    private String t_timeout;
    private String t_codativ;
    private String t_assina;
    private String t_inscmun;
    private String t_cnpjdes;
    private String t_layout;
    private String t_mensagem;
    private String t_duplacripto;

    public SetUp() {

    }

    protected SetUp(Parcel in) {
        idSetUp = in.readLong();
        t_login = in.readString();
        t_passw = in.readString();
        t_tipo_recibo = in.readString();
        t_hh_ident = in.readInt();
        t_senha = in.readString();
        t_razao = in.readString();
        t_endereco = in.readString();
        t_numero = in.readString();
        t_complemento = in.readString();
        t_bairro = in.readString();
        t_cidade = in.readString();
        t_cnpj = in.readString();
        t_uf = in.readString();
        t_cep = in.readString();
        t_inscricao = in.readString();
        t_cuf = in.readString();
        t_usaoff = in.readString();
        t_serie = in.readString();
        t_urlpro = in.readString();
        t_urlhomo = in.readString();
        t_sefaz = in.readString();
        t_tef = in.readString();
        t_prepapo = in.readString();
        t_monitor = in.readString();
        t_cliente = in.readString();
        t_leitora = in.readString();
        t_timeout = in.readString();
        t_codativ = in.readString();
        t_assina = in.readString();
        t_inscmun = in.readString();
        t_cnpjdes = in.readString();
        t_layout = in.readString();
        t_mensagem = in.readString();
        t_duplacripto = in.readString();
    }

    public static final Creator<SetUp> CREATOR = new Creator<SetUp>() {
        @Override
        public SetUp createFromParcel(Parcel in) {
            return new SetUp(in);
        }

        @Override
        public SetUp[] newArray(int size) {
            return new SetUp[size];
        }
    };

    public long getIdSetUp() {
        return idSetUp;
    }

    public void setIdSetUp(long idSetUp) {
        this.idSetUp = idSetUp;
    }


    public String getT_login() {
        return t_login;
    }

    public void setT_login(String t_login) {
        this.t_login = t_login;
    }

    public String getT_passw() {
        return t_passw;
    }

    public void setT_passw(String t_passw) {
        this.t_passw = t_passw;
    }

    public Integer getT_hh_ident() {
        return t_hh_ident;
    }

    public void setT_hh_ident(Integer t_hh_ident) {
        this.t_hh_ident = t_hh_ident;
    }

    public String getT_tipo_recibo() {
        return t_tipo_recibo;
    }

    public void setT_tipo_recibo(String t_tipo_recibo) {
        this.t_tipo_recibo = t_tipo_recibo;
    }

    public String getT_senha() {
        return t_senha;
    }

    public void setT_senha(String t_senha) {
        this.t_senha = t_senha;
    }

    public String getT_razao() {
        return t_razao;
    }

    public void setT_razao(String t_razao) {
        this.t_razao = t_razao;
    }

    public String getT_endereco() {
        return t_endereco;
    }

    public void setT_endereco(String t_endereco) {
        this.t_endereco = t_endereco;
    }

    public String getT_numero() {
        return t_numero;
    }

    public void setT_numero(String t_numero) {
        this.t_numero = t_numero;
    }

    public String getT_complemento() {
        return t_complemento;
    }

    public void setT_complemento(String t_complemento) {
        this.t_complemento = t_complemento;
    }

    public String getT_bairro() {
        return t_bairro;
    }

    public void setT_bairro(String t_bairro) {
        this.t_bairro = t_bairro;
    }

    public String getT_cidade() {
        return t_cidade;
    }

    public void setT_cidade(String t_cidade) {
        this.t_cidade = t_cidade;
    }

    public String getT_cnpj() {
        return t_cnpj;
    }

    public void setT_cnpj(String t_cnpj) {
        this.t_cnpj = t_cnpj;
    }

    public String getT_uf() {
        return t_uf;
    }

    public void setT_uf(String t_uf) {
        this.t_uf = t_uf;
    }

    public String getT_cep() {
        return t_cep;
    }

    public void setT_cep(String t_cep) {
        this.t_cep = t_cep;
    }

    public String getT_inscricao() {
        return t_inscricao;
    }

    public void setT_inscricao(String t_inscricao) {
        this.t_inscricao = t_inscricao;
    }

    public String getT_cuf() {
        return t_cuf;
    }

    public void setT_cuf(String t_cuf) {
        this.t_cuf = t_cuf;
    }

    public String getT_usaoff() {
        return t_usaoff;
    }

    public void setT_usaoff(String t_usaoff) {
        this.t_usaoff = t_usaoff;
    }

    public String getT_serie() {
        return t_serie;
    }

    public void setT_serie(String t_serie) {
        this.t_serie = t_serie;
    }

    public String getT_urlpro() {
        return t_urlpro;
    }

    public void setT_urlpro(String t_urlpro) {
        this.t_urlpro = t_urlpro;
    }

    public String getT_urlhomo() {
        return t_urlhomo;
    }

    public void setT_urlhomo(String t_urlhomo) {
        this.t_urlhomo = t_urlhomo;
    }

    public String getT_sefaz() {
        return t_sefaz;
    }

    public void setT_sefaz(String t_sefaz) {
        this.t_sefaz = t_sefaz;
    }

    public String getT_tef() {
        return t_tef;
    }

    public void setT_tef(String t_tef) {
        this.t_tef = t_tef;
    }

    public String getT_prepapo() {
        return t_prepapo;
    }

    public void setT_prepapo(String t_prepapo) {
        this.t_prepapo = t_prepapo;
    }

    public String getT_monitor() {
        return t_monitor;
    }

    public void setT_monitor(String t_monitor) {
        this.t_monitor = t_monitor;
    }

    public String getT_cliente() {
        return t_cliente;
    }

    public void setT_cliente(String t_cliente) {
        this.t_cliente = t_cliente;
    }

    public String getT_leitora() {
        return t_leitora;
    }

    public void setT_leitora(String t_leitora) {
        this.t_leitora = t_leitora;
    }

    public String getT_timeout() {
        return t_timeout;
    }

    public void setT_timeout(String t_timeout) {
        this.t_timeout = t_timeout;
    }

    public String getT_codativ() {
        return t_codativ;
    }

    public void setT_codativ(String t_codativ) {
        this.t_codativ = t_codativ;
    }

    public String getT_assina() {
        return t_assina;
    }

    public void setT_assina(String t_assina) {
        this.t_assina = t_assina;
    }

    public String getT_inscmun() {
        return t_inscmun;
    }

    public void setT_inscmun(String t_inscmun) {
        this.t_inscmun = t_inscmun;
    }

    public String getT_cnpjdes() {
        return t_cnpjdes;
    }

    public void setT_cnpjdes(String t_cnpjdes) {
        this.t_cnpjdes = t_cnpjdes;
    }

    public String getT_layout() {
        return t_layout;
    }

    public void setT_layout(String t_layout) {
        this.t_layout = t_layout;
    }

    public String getT_mensagem() {
        return t_mensagem;
    }

    public void setT_mensagem(String t_mensagem) {
        this.t_mensagem = t_mensagem;
    }

    public String getT_duplacripto() {
        return t_duplacripto;
    }

    public void setT_duplacripto(String t_duplacripto) {
        this.t_duplacripto = t_duplacripto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idSetUp);
        dest.writeString(t_login);
        dest.writeString(t_passw);
        dest.writeInt(t_hh_ident);
        dest.writeString(t_tipo_recibo);
        dest.writeString(t_senha);
        dest.writeString(t_razao);
        dest.writeString(t_endereco);
        dest.writeString(t_numero);
        dest.writeString(t_complemento);
        dest.writeString(t_bairro);
        dest.writeString(t_cidade);
        dest.writeString(t_cnpj);
        dest.writeString(t_uf);
        dest.writeString(t_cep);
        dest.writeString(t_inscricao);
        dest.writeString(t_cuf);
        dest.writeString(t_usaoff);
        dest.writeString(t_serie);
        dest.writeString(t_urlpro);
        dest.writeString(t_urlhomo);
        dest.writeString(t_sefaz);
        dest.writeString(t_tef);
        dest.writeString(t_prepapo);
        dest.writeString(t_monitor);
        dest.writeString(t_cliente);
        dest.writeString(t_leitora);
        dest.writeString(t_timeout);
        dest.writeString(t_codativ);
        dest.writeString(t_assina);
        dest.writeString(t_inscmun);
        dest.writeString(t_cnpjdes);
        dest.writeString(t_layout);
        dest.writeString(t_mensagem);
        dest.writeString(t_duplacripto);
    }
}
