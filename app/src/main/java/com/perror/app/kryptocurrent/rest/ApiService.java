package com.perror.app.kryptocurrent.rest;


import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ndu on 10/17/17.
 */

public interface ApiService {

    @GET("price/price?fsym=BTC&tsyms=BTC,ETH,NGN,USD,EUR,JPY,GRP,CHF,CAD,AUD,ZAR")
    Call<CurrencyResponse> getBTCConversion();

    @GET("price?fsym=ETH&tsyms=ETH,BTC,NGN,USD,EUR,JPY,GRP,CHF,CAD,AUD,ZAR&sign")
    Call<CurrencyResponse> getETHConversion();

    @GET("price?fsym=BTC&tsyms=ETH,NGN,USD,EUR,JPY,GRP,CHF,CAD,AUD,ZAR&sign")
    Call<CurrencyResponse> getCurrencySymbol();

}
