package com.arenaplan.pdv.get.database.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class ContadorEntidade  implements Parcelable {

    private long id;
    private long t_idf;

    public ContadorEntidade() {
    }

    protected ContadorEntidade(Parcel in) {
        id = in.readLong();
        t_idf = in.readLong();
    }

    public static final Creator<ContadorEntidade> CREATOR = new Creator<ContadorEntidade>() {
        @Override
        public ContadorEntidade createFromParcel(Parcel in) {
            return new ContadorEntidade(in);
        }

        @Override
        public ContadorEntidade[] newArray(int size) {
            return new ContadorEntidade[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getT_idf() {
        return t_idf;
    }

    public void setT_idf(long t_idf) {
        this.t_idf = t_idf;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(t_idf);
    }
}
