package com.perror.app.kryptocurrent.rest;


import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ndu on 10/17/17.
 */

public interface ApiService {

    @GET("price?fsym=BTC&tsyms=ETH,BTC,NGN,USD,EUR,JPY,GRP,CHF,CAD,AUD,ZAR,BRL," +
            "CLP,CZK,DKK,INR,UED,GBP,SGD,RUB,QAR,RON,GHC&sign")
    Call<CurrencyResponse> getBTCConversion();

    @GET("price?fsym=ETH&tsyms=ETH,BTC,NGN,USD,EUR,JPY,GRP,CHF,CAD,AUD,ZAR,BRL," +
            "CLP,CZK,DKK,INR,UED,GBP,SGD,RUB,QAR,RON,GHC&sign")
    Call<CurrencyResponse> getETHConversion();

//    @GET("price?fsym=BTC&tsyms=ETH,BTC,NGN,USD,EUR,JPY,GRP&sign")
//    Call<CurrencyResponse> getBTCConversion();
//
//    @GET("price?fsym=ETH&tsyms=ETH,BTC,NGN,USD,EUR,JPY,GRP&sign")
//    Call<CurrencyResponse> getETHConversion();

}
