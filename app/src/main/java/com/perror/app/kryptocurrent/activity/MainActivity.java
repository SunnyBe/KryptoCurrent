package com.perror.app.kryptocurrent.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    TextView notConnected;
    Toolbar toolbar;

    Currency BTCCurrency = new Currency();
    Currency ETHCurrency = new Currency();

    Currency USDCurrency = new Currency();
    Currency NGNCurrency = new Currency();
    Currency EURCurrency = new Currency();
    Currency JPYCurrency = new Currency();
    Currency CHFCurrency = new Currency();
    Currency CADCurrency = new Currency();
    Currency AUDCurrency = new Currency();
    Currency BRLCurrency = new Currency();
    Currency CLPCurrency = new Currency();
    Currency CZKCurrency = new Currency();

    Currency DKKCurrency = new Currency();
    Currency INRCurrency = new Currency();
    Currency UEDCurrency = new Currency();
    Currency GBPCurrency = new Currency();
    Currency SGDCurrency = new Currency();
    Currency RUBCurrency = new Currency();
    Currency QARCurrency = new Currency();
    Currency RONCurrency = new Currency();
    Currency GHCCurrency = new Currency();
    Currency ZARCurrency = new Currency();

    List<Currency> currencyList;
    //MainViewPresenter viewPresenter;


    /**
     * This method is called when the activity is started
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind my progress bar and the recylcer view and other views
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_container);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiper_container);
        swipeRefreshLayout.setColorSchemeResources(R.color.GREEN);
        notConnected = (TextView) findViewById(R.id.not_connecting);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        //Then update the recycler view with the content from web
        loadCurrencyConversion();
    }

    /**
     * Method to handle refresh menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.refresh){
            progressBar.setVisibility(View.VISIBLE);
            loadCurrencyConversion();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method loads the value from the Api and update the recycler view with the response
     */
    private void loadCurrencyConversion() {
//        progressBar.setVisibility(View.GONE);
//        currencyList = viewPresenter.loadCurrencyFromRest();
//        swipeRefreshLayout.setRefreshing(false);
//        recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));

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
                    swipeRefreshLayout.setRefreshing(false);
                    notConnected.setVisibility(View.GONE);
                    Log.d(TAG, "BTC Load Response is on ... \n "+ response.raw()+"\n "+ response.body());

                    //Store the response from this call in a variable
                    CurrencyResponse responseFromApi = response.body();

                    //make all the currency and add them to a list
                    makeBtcDifferentCurrencies(currencyList, responseFromApi);

//                    //Populate the recycler view
//                    recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));
                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    notConnected.setVisibility(View.VISIBLE);
                    Log.d(TAG, "Error Sir");
                }
            });

            /**
             * I want to create a dummy to take the eth conversion too
             */

            currencyResponseCall = converterService.getETHConversion();
            currencyResponseCall.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                    //handle the progress bar hide on response
                    progressBar.setVisibility(View.GONE);
                    swipeRefreshLayout.setRefreshing(false);
                    notConnected.setVisibility(View.GONE);
                    Log.d(TAG, "ETH Load Response is on ... \n "+ response.raw()+"\n "+ response.body());

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
                    progressBar.setVisibility(View.GONE);
                    notConnected.setVisibility(View.VISIBLE);
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

        BRLCurrency.setSymbol("BRL");
        CLPCurrency.setSymbol("CLP");
        CZKCurrency.setSymbol("CZK");
        DKKCurrency.setSymbol("DKK");
        INRCurrency.setSymbol("INR");
        UEDCurrency.setSymbol("UED");
        GBPCurrency.setSymbol("GBP");
        SGDCurrency.setSymbol("SGD");
        RUBCurrency.setSymbol("RUB");
        QARCurrency.setSymbol("QAR");
        RONCurrency.setSymbol("RON");
        GHCCurrency.setSymbol("GHC");
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

        BRLCurrency.setEtcToCurrency(currencyResponse.getbRL());
        CLPCurrency.setEtcToCurrency(currencyResponse.getcLP());
        CZKCurrency.setEtcToCurrency(currencyResponse.getcZK());
        DKKCurrency.setEtcToCurrency(currencyResponse.getdKK());
        INRCurrency.setEtcToCurrency(currencyResponse.getiNR());
        UEDCurrency.setEtcToCurrency(currencyResponse.getuED());
        GBPCurrency.setEtcToCurrency(currencyResponse.getgBP());
        SGDCurrency.setEtcToCurrency(currencyResponse.getsGD());
        RUBCurrency.setEtcToCurrency(currencyResponse.getrUB());
        QARCurrency.setEtcToCurrency(currencyResponse.getqAR());
        RONCurrency.setEtcToCurrency(currencyResponse.getrON());
        GHCCurrency.setEtcToCurrency(currencyResponse.getgHC());

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
        currencies.add(BRLCurrency);
        currencies.add(CLPCurrency);
        currencies.add(CZKCurrency);
        currencies.add(DKKCurrency);
        currencies.add(INRCurrency);
        currencies.add(UEDCurrency);
        currencies.add(GBPCurrency);
        currencies.add(SGDCurrency);
        currencies.add(RUBCurrency);
        currencies.add(QARCurrency);
        currencies.add(RONCurrency);
        currencies.add(GHCCurrency);
    }

    private void makeBtcDifferentCurrencies(List<Currency> currencies ,CurrencyResponse currencyResponse){

        BTCCurrency.setBtcToCurrency(currencyResponse.getBTC());

        ETHCurrency.setBtcToCurrency(currencyResponse.getETH());

        USDCurrency.setBtcToCurrency(currencyResponse.getUSD());

        NGNCurrency.setBtcToCurrency(currencyResponse.getNGN());

        EURCurrency.setBtcToCurrency(currencyResponse.getEUR());

        JPYCurrency.setBtcToCurrency(currencyResponse.getJPY());

        CHFCurrency.setBtcToCurrency(currencyResponse.getCHF());

        CADCurrency.setBtcToCurrency(currencyResponse.getCAD());

        AUDCurrency.setBtcToCurrency(currencyResponse.getAUD());

        ZARCurrency.setBtcToCurrency(currencyResponse.getNGN());

        BRLCurrency.setBtcToCurrency(currencyResponse.getbRL());
        CLPCurrency.setBtcToCurrency(currencyResponse.getcLP());
        CZKCurrency.setBtcToCurrency(currencyResponse.getcZK());
        DKKCurrency.setBtcToCurrency(currencyResponse.getdKK());
        INRCurrency.setBtcToCurrency(currencyResponse.getiNR());
        UEDCurrency.setBtcToCurrency(currencyResponse.getuED());
        GBPCurrency.setBtcToCurrency(currencyResponse.getgBP());
        SGDCurrency.setBtcToCurrency(currencyResponse.getsGD());
        RUBCurrency.setBtcToCurrency(currencyResponse.getrUB());
        QARCurrency.setBtcToCurrency(currencyResponse.getqAR());
        RONCurrency.setBtcToCurrency(currencyResponse.getrON());
        GHCCurrency.setBtcToCurrency(currencyResponse.getgHC());

    }
}
