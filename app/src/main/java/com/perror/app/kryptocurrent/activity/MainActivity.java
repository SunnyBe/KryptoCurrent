package com.perror.app.kryptocurrent.activity;

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


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set the progress bar to be rolling
        progressBar.setVisibility(View.VISIBLE);

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

            Call<CurrencyResponse> currencyResponseCall = converterService.getBTCConversion();
            currencyResponseCall.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                    //When There is a response set progress bar out of view
                    progressBar.setVisibility(View.GONE);
                    Log.d(TAG, "Load Response is on ... \n "+ response.raw()+"\n "+ response.body());

                    //Store the response from this call in a variable
                    CurrencyResponse responseFromApi = response.body();


                    //Create a list to populate the recycler view using the response
                    List<Currency> currencyList = new ArrayList<Currency>();

                    //make all the currency and add them to a list
                    makeDifferentCurrencies(currencyList, responseFromApi);

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
             * This is a dummy Test for getting Currency Response instead of CurrencyResponse response
             */

//            Call<Currency> currencyCall = converterService.getCurrencyConvertion("USD");
//            currencyCall.enqueue(new Callback<Currency>() {
//                @Override
//                public void onResponse(Call<Currency> call, Response<Currency> response) {
//                    progressBar.setVisibility(View.GONE);
//                    Log.d(TAG, "Load Response is on ...");
//
//                    Currency currencyRecieved = response.body();
//                    List<Currency> currencyList = new ArrayList<Currency>();
//                    currencyList.add(currencyRecieved);
//
//                    recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));
//                }
//
//                @Override
//                public void onFailure(Call<Currency> call, Throwable t) {
//                    progressBar.setVisibility(View.GONE);
//                    Log.d(TAG, "Error Sir");
//                }
//            });


        }catch (Exception e){
            Log.d(TAG, "Exception currencies not recieved " + e.getMessage());
        }


    }
    private void makeDifferentCurrencies(List<Currency> currencies ,CurrencyResponse currencyResponse){

        Currency BTCCurrency = new Currency();
        BTCCurrency.setBtcToCurrency(currencyResponse.getBTC());

        Currency ETHCurrency = new Currency();
        ETHCurrency.setBtcToCurrency(currencyResponse.getETH());

        Currency USDCurrency = new Currency();
        USDCurrency.setBtcToCurrency(currencyResponse.getUSD());

        Currency NGNCurrency = new Currency();
        NGNCurrency.setBtcToCurrency(currencyResponse.getNGN());

        Currency EURCurrency = new Currency();
        EURCurrency.setBtcToCurrency(currencyResponse.getEUR());

        Currency JPYCurrency = new Currency();
        JPYCurrency.setBtcToCurrency(currencyResponse.getJPY());

        Currency CHFCurrency = new Currency();
        CHFCurrency.setBtcToCurrency(currencyResponse.getCHF());

        Currency CADCurrency = new Currency();
        CADCurrency.setBtcToCurrency(currencyResponse.getCAD());

        Currency AUDCurrency = new Currency();
        AUDCurrency.setBtcToCurrency(currencyResponse.getAUD());

        Currency ZARCurrency = new Currency();
        ZARCurrency.setBtcToCurrency(currencyResponse.getNGN());

        currencies.add(BTCCurrency);
        currencies.add(ETHCurrency);
        currencies.add(NGNCurrency);
        currencies.add(USDCurrency);
        currencies.add(EURCurrency);
        currencies.add(USDCurrency);
        currencies.add(USDCurrency);
        currencies.add(USDCurrency);
        currencies.add(USDCurrency);
        currencies.add(USDCurrency);

        Currency testCurrency = new Currency();
        testCurrency.setBtcToCurrency(67.0887);
        currencies.add(testCurrency);

////        Currency BTCCurrency = new Currency();
////        BTCCurrency.setBtcConvertValue(currencyResponse.getBTC());
//
//        //currencyList.add(BTCCurrency);
//        currencyList.add(testCurrency);
//        currencyList.add(testCurrency);
//        currencyList.add(testCurrency);
//        currencyList.add(testCurrency);
////
//        return currencyList;
    }
}
