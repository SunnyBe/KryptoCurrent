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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    CurrencyListAdapter currencyListAdapter;
    List<Currency> currencyList;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar.setVisibility(View.VISIBLE);
        getCurrencyConversion();
        recyclerView.setAdapter(new CurrencyListAdapter(getApplicationContext(),currencyList));
    }

    private void getCurrencyConversion() {

        try {
            ApiClient client = new ApiClient();
            ApiService service = client.getRetrofit().create(ApiService.class);

            Call<CurrencyResponse> call = service.getBTCConversion();
            call.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {

                   List<Currency> currencies = makeDifferentCurrencies(response.body());
                    currencyList = currencies;

                    Log.d(TAG, "currencies recieved");
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Log.d(TAG, "ERROR currencies not recieved "+ t.getMessage());
                }
            });

        }catch (Exception e){
            progressBar.setVisibility(View.GONE);
            Log.d(TAG, "Catch ERROR currencies not recieved " + e.getMessage());
        }

    }
    private List<Currency> makeDifferentCurrencies(CurrencyResponse currencyResponse){

        currencyList = new ArrayList<>();

        Currency BTCCurrency = new Currency();
        BTCCurrency.setBtcConvertValue(currencyResponse.getBTC());

        Currency ETHCurrency = new Currency();
        ETHCurrency.setBtcConvertValue(currencyResponse.getETH());

        Currency USDCurrency = new Currency();
        USDCurrency.setBtcConvertValue(currencyResponse.getUSD());

        Currency NGNCurrency = new Currency();
        NGNCurrency.setBtcConvertValue(currencyResponse.getNGN());

        Currency EURCurrency = new Currency();
        EURCurrency.setBtcConvertValue(currencyResponse.getEUR());

        Currency JPYCurrency = new Currency();
        JPYCurrency.setBtcConvertValue(currencyResponse.getJPY());

        Currency CHFCurrency = new Currency();
        CHFCurrency.setBtcConvertValue(currencyResponse.getCHF());

        Currency CADCurrency = new Currency();
        CADCurrency.setBtcConvertValue(currencyResponse.getCAD());

        Currency AUDCurrency = new Currency();
        AUDCurrency.setBtcConvertValue(currencyResponse.getAUD());

        Currency ZARCurrency = new Currency();
        ZARCurrency.setBtcConvertValue(currencyResponse.getNGN());

        currencyList.add(BTCCurrency);
        currencyList.add(ETHCurrency);
        currencyList.add(NGNCurrency);
        currencyList.add(USDCurrency);
        currencyList.add(EURCurrency);
        currencyList.add(USDCurrency);
        currencyList.add(USDCurrency);
        currencyList.add(USDCurrency);
        currencyList.add(USDCurrency);
        currencyList.add(USDCurrency);

        return currencyList;
    }
}
