package com.perror.app.kryptocurrent.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.perror.app.kryptocurrent.adapter.CurrencyListAdapter;
import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;
import com.perror.app.kryptocurrent.rest.ApiClient;
import com.perror.app.kryptocurrent.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ndu on 10/21/17.
 */

public class MainViewPresenter {

//    private static final String TAG = "MainActivity";
//
//    Currency BTCCurrency = new Currency();
//    Currency ETHCurrency = new Currency();
//
//    Currency USDCurrency = new Currency();
//    Currency NGNCurrency = new Currency();
//    Currency EURCurrency = new Currency();
//    Currency JPYCurrency = new Currency();
//    Currency CHFCurrency = new Currency();
//    Currency CADCurrency = new Currency();
//    Currency AUDCurrency = new Currency();
//    Currency BRLCurrency = new Currency();
//    Currency CLPCurrency = new Currency();
//    Currency CZKCurrency = new Currency();
//
//    Currency DKKCurrency = new Currency();
//    Currency INRCurrency = new Currency();
//    Currency UEDCurrency = new Currency();
//    Currency GBPCurrency = new Currency();
//    Currency SGDCurrency = new Currency();
//    Currency RUBCurrency = new Currency();
//    Currency QARCurrency = new Currency();
//    Currency RONCurrency = new Currency();
//    Currency GHCCurrency = new Currency();
//    Currency ZARCurrency = new Currency();
//
//    List<Currency> currencyList;
//    Context context;
//
//    public MainViewPresenter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public List<Currency> loadCurrencyFromRest() {
//
//        //try and catch errors for retrofit
////        try {
////            //initialize my client and use it to create a retrofit service
////            ApiClient client = new ApiClient();
////            ApiService converterService = client.getRetrofit()
////                    .create(ApiService.class);
////
////            Call<CurrencyResponse> currencyResponseCall = converterService.getBTCConversion();
////            currencyResponseCall.enqueue(new Callback<CurrencyResponse>() {
////                @Override
////                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
////                    //When There is a response set progress bar out of view
//////                    swipeRefreshLayout.setRefreshing(false);
////                    Log.d(TAG, "BTC Load Response is on ... \n "+ response.raw()+"\n "+ response.body());
////
////                    //Store the response from this call in a variable
////                    CurrencyResponse responseFromApi = response.body();
////
////                    //make all the currency and add them to a list
////                    makeBtcDifferentCurrencies(currencyList, responseFromApi);
//////                    //Populate the recycler view
//////                    recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));
////                }
////
////                @Override
////                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
////                    Log.d(TAG, "Error Sir");
////                }
////            });
////
////            /**
////             * I want to create a dummy to take the eth conversion too
////             */
////
////            currencyResponseCall = converterService.getETHConversion();
////            currencyResponseCall.enqueue(new Callback<CurrencyResponse>() {
////                @Override
////                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
////                    //handle the progress bar hide on response
//////                    progressBar.setVisibility(View.GONE);
//////                    swipeRefreshLayout.setRefreshing(false);
////                    Log.d(TAG, "ETH Load Response is on ... \n "+ response.raw()+"\n "+ response.body());
////
////                    //Currency Response
////                    CurrencyResponse ethResponseFromApi = response.body();
////
////                    //make a list of currencies with their eth value
////                    makeEthDifferentCurrencies(currencyList,ethResponseFromApi);
////
////                }
////
////                @Override
////                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
//////                    Log.d(TAG, "ERROR Not successful");
////                }
////            });
////
////        }catch (Exception e){
////            Log.d(TAG, "Exception currencies not recieved " + e.getMessage());
////        }
//        return null;
//
//    }
//
//    @Override
//    public void onCurrencyItemClicked() {
//
//    }
//
//    @Override
//    public void onSwipeReload() {
//
//    }
//
//    private void setCurrenciesSymbol(){
//
//        BTCCurrency.setSymbol("BTC");
//        ETHCurrency.setSymbol("ETH");
//        USDCurrency.setSymbol("USD");
//        NGNCurrency.setSymbol("NGN");
//        EURCurrency.setSymbol("EUR");
//        JPYCurrency.setSymbol("JPY");
//        CHFCurrency.setSymbol("CHF");
//        CADCurrency.setSymbol("CAD");
//        AUDCurrency.setSymbol("AUD");
//        ZARCurrency.setSymbol("ZAR");
//
//        BRLCurrency.setSymbol("BRL");
//        CLPCurrency.setSymbol("CLP");
//        CZKCurrency.setSymbol("CZK");
//        DKKCurrency.setSymbol("DKK");
//        INRCurrency.setSymbol("INR");
//        UEDCurrency.setSymbol("UED");
//        GBPCurrency.setSymbol("GBP");
//        SGDCurrency.setSymbol("SGD");
//        RUBCurrency.setSymbol("RUB");
//        QARCurrency.setSymbol("QAR");
//        RONCurrency.setSymbol("RON");
//        GHCCurrency.setSymbol("GHC");
//    }
//
//    private void makeEthDifferentCurrencies(List<Currency> currencies , CurrencyResponse currencyResponse){
//
////        Currency BTCCurrency = new Currency();
//        BTCCurrency.setEtcToCurrency(currencyResponse.getBTC());
//
////        Currency ETHCurrency = new Currency();
//        ETHCurrency.setEtcToCurrency(currencyResponse.getETH());
//
////        Currency USDCurrency = new Currency();
//        USDCurrency.setEtcToCurrency(currencyResponse.getUSD());
//
////        Currency NGNCurrency = new Currency();
//        NGNCurrency.setEtcToCurrency(currencyResponse.getNGN());
//
////        Currency EURCurrency = new Currency();
//        EURCurrency.setEtcToCurrency(currencyResponse.getEUR());
//
////        Currency JPYCurrency = new Currency();
//        JPYCurrency.setEtcToCurrency(currencyResponse.getJPY());
//
////        Currency CHFCurrency = new Currency();
//        CHFCurrency.setEtcToCurrency(currencyResponse.getCHF());
//
////        Currency CADCurrency = new Currency();
//        CADCurrency.setEtcToCurrency(currencyResponse.getCAD());
//
////        Currency AUDCurrency = new Currency();
//        AUDCurrency.setEtcToCurrency(currencyResponse.getAUD());
//
////        Currency ZARCurrency = new Currency();
//        ZARCurrency.setEtcToCurrency(currencyResponse.getNGN());
//
//        BRLCurrency.setEtcToCurrency(currencyResponse.getbRL());
//        CLPCurrency.setEtcToCurrency(currencyResponse.getcLP());
//        CZKCurrency.setEtcToCurrency(currencyResponse.getcZK());
//        DKKCurrency.setEtcToCurrency(currencyResponse.getdKK());
//        INRCurrency.setEtcToCurrency(currencyResponse.getiNR());
//        UEDCurrency.setEtcToCurrency(currencyResponse.getuED());
//        GBPCurrency.setEtcToCurrency(currencyResponse.getgBP());
//        SGDCurrency.setEtcToCurrency(currencyResponse.getsGD());
//        RUBCurrency.setEtcToCurrency(currencyResponse.getrUB());
//        QARCurrency.setEtcToCurrency(currencyResponse.getqAR());
//        RONCurrency.setEtcToCurrency(currencyResponse.getrON());
//        GHCCurrency.setEtcToCurrency(currencyResponse.getgHC());
//
//        setCurrenciesSymbol();
//
//        currencies.add(BTCCurrency);
//        currencies.add(ETHCurrency);
//        currencies.add(NGNCurrency);
//        currencies.add(USDCurrency);
//        currencies.add(EURCurrency);
//        currencies.add(JPYCurrency);
//        currencies.add(CHFCurrency);
//        currencies.add(CADCurrency);
//        currencies.add(AUDCurrency);
//        currencies.add(ZARCurrency);
//        currencies.add(BRLCurrency);
//        currencies.add(CLPCurrency);
//        currencies.add(CZKCurrency);
//        currencies.add(DKKCurrency);
//        currencies.add(INRCurrency);
//        currencies.add(UEDCurrency);
//        currencies.add(GBPCurrency);
//        currencies.add(SGDCurrency);
//        currencies.add(RUBCurrency);
//        currencies.add(QARCurrency);
//        currencies.add(RONCurrency);
//        currencies.add(GHCCurrency);
//    }
//
//    private void makeBtcDifferentCurrencies(List<Currency> currencies ,CurrencyResponse currencyResponse){
//
//        BTCCurrency.setBtcToCurrency(currencyResponse.getBTC());
//
//        ETHCurrency.setBtcToCurrency(currencyResponse.getETH());
//
//        USDCurrency.setBtcToCurrency(currencyResponse.getUSD());
//
//        NGNCurrency.setBtcToCurrency(currencyResponse.getNGN());
//
//        EURCurrency.setBtcToCurrency(currencyResponse.getEUR());
//
//        JPYCurrency.setBtcToCurrency(currencyResponse.getJPY());
//
//        CHFCurrency.setBtcToCurrency(currencyResponse.getCHF());
//
//        CADCurrency.setBtcToCurrency(currencyResponse.getCAD());
//
//        AUDCurrency.setBtcToCurrency(currencyResponse.getAUD());
//
//        ZARCurrency.setBtcToCurrency(currencyResponse.getNGN());
//
//        BRLCurrency.setBtcToCurrency(currencyResponse.getbRL());
//        CLPCurrency.setBtcToCurrency(currencyResponse.getcLP());
//        CZKCurrency.setBtcToCurrency(currencyResponse.getcZK());
//        DKKCurrency.setBtcToCurrency(currencyResponse.getdKK());
//        INRCurrency.setBtcToCurrency(currencyResponse.getiNR());
//        UEDCurrency.setBtcToCurrency(currencyResponse.getuED());
//        GBPCurrency.setBtcToCurrency(currencyResponse.getgBP());
//        SGDCurrency.setBtcToCurrency(currencyResponse.getsGD());
//        RUBCurrency.setBtcToCurrency(currencyResponse.getrUB());
//        QARCurrency.setBtcToCurrency(currencyResponse.getqAR());
//        RONCurrency.setBtcToCurrency(currencyResponse.getrON());
//        GHCCurrency.setBtcToCurrency(currencyResponse.getgHC());
//
//    }
}
