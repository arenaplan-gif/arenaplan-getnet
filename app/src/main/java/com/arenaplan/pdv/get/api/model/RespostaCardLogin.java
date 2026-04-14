package com.arenaplan.pdv.get.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RespostaCardLogin implements Parcelable {

    @SerializedName("card")
    private CardLogin cardLogin;

    protected RespostaCardLogin(Parcel in) {
        cardLogin = in.readParcelable(CardLogin.class.getClassLoader());
    }

    public static final Creator<RespostaCardLogin> CREATOR = new Creator<RespostaCardLogin>() {
        @Override
        public RespostaCardLogin createFromParcel(Parcel in) {
            return new RespostaCardLogin(in);
        }

        @Override
        public RespostaCardLogin[] newArray(int size) {
            return new RespostaCardLogin[size];
        }
    };

    public CardLogin getCardLogin() {
        return cardLogin;
    }

    public void setCardLogin(CardLogin cardLogin) {
        this.cardLogin = cardLogin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(cardLogin, flags);
    }
}
