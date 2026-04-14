package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CategoriaEntidade implements Parcelable {

    private String titulo;
    private String imagem;

    public CategoriaEntidade() {
    }

    protected CategoriaEntidade(Parcel in) {
        titulo = in.readString();
        imagem = in.readString();
    }

    public static final Creator<CategoriaEntidade> CREATOR = new Creator<CategoriaEntidade>() {
        @Override
        public CategoriaEntidade createFromParcel(Parcel in) {
            return new CategoriaEntidade(in);
        }

        @Override
        public CategoriaEntidade[] newArray(int size) {
            return new CategoriaEntidade[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(imagem);
    }
}
