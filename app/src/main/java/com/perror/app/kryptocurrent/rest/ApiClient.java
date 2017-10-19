package com.perror.app.kryptocurrent.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ndu on 10/17/17.
 */

public class ApiClient {

    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/";

    private static Retrofit retrofit =  null;

    public static Retrofit getRetrofit() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
