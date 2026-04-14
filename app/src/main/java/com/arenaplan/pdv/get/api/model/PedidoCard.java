package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PedidoCard implements Parcelable {

    @SerializedName("tr_id")
    private String tr_id;

    @SerializedName("version")
    private String version;

   // @SerializedName("apelido")
    //private String apelido;

    @SerializedName("error_code")
    private String error_code;
    @SerializedName("qs_id")
    private String qs_id;
    @SerializedName("pds")
    private PdPedido pe;

    protected PedidoCard(Parcel in) {
        tr_id = in.readString();
        version = in.readString();
        //apelido= in.readString();
        qs_id = in.readString();
        error_code = in.readString();
        pe = in.readParcelable(PdMesa.class.getClassLoader());
    }

    public static final Creator<PedidoCard> CREATOR = new Creator<PedidoCard>() {
        @Override
        public PedidoCard createFromParcel(Parcel in) {
            return new PedidoCard(in);
        }

        @Override
        public PedidoCard[] newArray(int size) {
            return new PedidoCard[size];
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

    //public String getApelido() {
    ////   return apelido;
    ////}

    ////public void setApelido(String apelido) {
    //v    this.apelido = apelido;
    ////}

    public String getQs_id() {
        return qs_id;
    }

    public void setQs_id(String qs_id) {
        this.qs_id = qs_id;
    }

    //public PdReimpressao getPds() {        return pds;     }

    //public void setPds(PdReimpressao pds) {          this.pds = pds;    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public PdPedido getPdPedido() {
        return pe;
    }

    public void setPdPedido(PdPedido md) {
        this.pe = pe;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tr_id);
        dest.writeString(version);
        dest.writeString(qs_id);
        dest.writeString(error_code);
        dest.writeParcelable(pe, flags);
    }
}
