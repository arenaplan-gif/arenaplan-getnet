package com.arenaplan.pdv.get.api;


import static com.arenaplan.pdv.get.util.Constantes.BASE_URL;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    final OkHttpClient okHttpClient;



    public RetrofitConfig(int time) {


         okHttpClient = new OkHttpClient.Builder()
                .readTimeout(time, TimeUnit.SECONDS)
                //.sslSocketFactory(time,)
                .connectTimeout(time, TimeUnit.SECONDS)
                .build();

        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public PDVService getPDVService() {
        return
                this.retrofit.create(PDVService.class);
    }

}
