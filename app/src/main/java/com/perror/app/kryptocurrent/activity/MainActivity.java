package com.perror.app.kryptocurrent.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.perror.app.kryptocurrent.R;
import com.perror.app.kryptocurrent.adapter.CurrencyListAdapter;
import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;
import com.perror.app.kryptocurrent.rest.ApiClient;
import com.perror.app.kryptocurrent.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //initialize TAG for debugging
    private static final String TAG = "MainActivity";

    //Initialize the objects needed
    RecyclerView recyclerView;
    CurrencyListAdapter currencyListAdapter;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    Currency BTCCurrency = new Currency();
    Currency ETHCurrency = new Currency();
    Currency USDCurrency = new Currency();
    Currency NGNCurrency = new Currency();
    Currency EURCurrency = new Currency();
    Currency JPYCurrency = new Currency();
    Currency CHFCurrency = new Currency();
    Currency CADCurrency = new Currency();
    Currency AUDCurrency = new Currency();
    Currency ZARCurrency = new Currency();

    List<Currency> currencyList;


    /**
     * This method is called when the activity is started
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind my progress bar and the recylcer view
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_container);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiper_container);
        swipeRefreshLayout.setColorSchemeResources(R.color.GREEN);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadCurrencyConversion();

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set the progress bar to be rolling
        progressBar.setVisibility(View.VISIBLE);

        setCurrenciesSymbol();

        currencyList = new ArrayList<>();

        //Then update the recylcer view with the content from web
        loadCurrencyConversion();
    }

    /**
     * This method loads the value from the Api and update the recycler view with the response
     */
    private void loadCurrencyConversion() {
        //try and catch errors for retrofit
        try {
            //initialize my client and use it to create a retrofit service
            ApiClient client = new ApiClient();
            ApiService converterService = client.getRetrofit()
                    .create(ApiService.class);

            final Call<CurrencyResponse> currencyResponseCall = converterService.getBTCConversion();
            currencyResponseCall.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                    //When There is a response set progress bar out of view
                    progressBar.setVisibility(View.GONE);
                    swipeRefreshLayout.setRefreshing(false);
                    Log.d(TAG, "Load Response is on ... \n "+ response.raw()+"\n "+ response.body());

                    //Store the response from this call in a variable
                    CurrencyResponse responseFromApi = response.body();

                    //make all the currency and add them to a list
                    makeBtcDifferentCurrencies(currencyList, responseFromApi);

                    //Populate the recycler view
                    recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));
                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Log.d(TAG, "Error Sir");
                }
            });

            /**
             * I want to create a dummy to take the eth conversion too
             */

            Call<CurrencyResponse> ethCall = converterService.getETHConversion();
            ethCall.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                    //handle the progress bar hide on response
                    progressBar.setVisibility(View.GONE);
                    Log.d(TAG, "Load Response is on ... \n "+ response.raw()+"\n "+ response.body());

                    //Currency Response
                    CurrencyResponse ethResponseFromApi = response.body();

                    //make a list of currencies with their eth value
                    makeEthDifferentCurrencies(currencyList,ethResponseFromApi);

                    //Populate the recycler view
                    recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));

                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    Log.d(TAG, "ERROR Not successful");
                }
            });


            /**
             * This is a dummy Test for getting Currency Response instead of CurrencyResponse response
             */




        }catch (Exception e){
            Log.d(TAG, "Exception currencies not recieved " + e.getMessage());
        }
    }

    private void setCurrenciesSymbol(){

        BTCCurrency.setSymbol("BTC");
        ETHCurrency.setSymbol("ETH");
        USDCurrency.setSymbol("USD");
        NGNCurrency.setSymbol("NGN");
        EURCurrency.setSymbol("EUR");
        JPYCurrency.setSymbol("JPY");
        CHFCurrency.setSymbol("CHF");
        CADCurrency.setSymbol("CAD");
        AUDCurrency.setSymbol("AUD");
        ZARCurrency.setSymbol("ZAR");
    }

    private void makeEthDifferentCurrencies(List<Currency> currencies ,CurrencyResponse currencyResponse){

//        Currency BTCCurrency = new Currency();
        BTCCurrency.setEtcToCurrency(currencyResponse.getBTC());

//        Currency ETHCurrency = new Currency();
        ETHCurrency.setEtcToCurrency(currencyResponse.getETH());

//        Currency USDCurrency = new Currency();
        USDCurrency.setEtcToCurrency(currencyResponse.getUSD());

//        Currency NGNCurrency = new Currency();
        NGNCurrency.setEtcToCurrency(currencyResponse.getNGN());

//        Currency EURCurrency = new Currency();
        EURCurrency.setEtcToCurrency(currencyResponse.getEUR());

//        Currency JPYCurrency = new Currency();
        JPYCurrency.setEtcToCurrency(currencyResponse.getJPY());

//        Currency CHFCurrency = new Currency();
        CHFCurrency.setEtcToCurrency(currencyResponse.getCHF());

//        Currency CADCurrency = new Currency();
        CADCurrency.setEtcToCurrency(currencyResponse.getCAD());

//        Currency AUDCurrency = new Currency();
        AUDCurrency.setEtcToCurrency(currencyResponse.getAUD());

//        Currency ZARCurrency = new Currency();
        ZARCurrency.setEtcToCurrency(currencyResponse.getNGN());

        setCurrenciesSymbol();

        currencies.add(BTCCurrency);
        currencies.add(ETHCurrency);
        currencies.add(NGNCurrency);
        currencies.add(USDCurrency);
        currencies.add(EURCurrency);
        currencies.add(JPYCurrency);
        currencies.add(CHFCurrency);
        currencies.add(CADCurrency);
        currencies.add(AUDCurrency);
        currencies.add(ZARCurrency);
    }

    private void makeBtcDifferentCurrencies(List<Currency> currencies ,CurrencyResponse currencyResponse){

        //        Currency BTCCurrency = new Currency();
        BTCCurrency.setBtcToCurrency(currencyResponse.getBTC());

//        Currency ETHCurrency = new Currency();
        ETHCurrency.setBtcToCurrency(currencyResponse.getETH());

//        Currency USDCurrency = new Currency();
        USDCurrency.setBtcToCurrency(currencyResponse.getUSD());

//        Currency NGNCurrency = new Currency();
        NGNCurrency.setBtcToCurrency(currencyResponse.getNGN());

//        Currency EURCurrency = new Currency();
        EURCurrency.setBtcToCurrency(currencyResponse.getEUR());

//        Currency JPYCurrency = new Currency();
        JPYCurrency.setBtcToCurrency(currencyResponse.getJPY());

//        Currency CHFCurrency = new Currency();
        CHFCurrency.setBtcToCurrency(currencyResponse.getCHF());

//        Currency CADCurrency = new Currency();
        CADCurrency.setBtcToCurrency(currencyResponse.getCAD());

//        Currency AUDCurrency = new Currency();
        AUDCurrency.setBtcToCurrency(currencyResponse.getAUD());

//        Currency ZARCurrency = new Currency();
        ZARCurrency.setBtcToCurrency(currencyResponse.getNGN());

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
    }
}
