package com.perror.app.kryptocurrent.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.perror.app.kryptocurrent.R;

/**
 * Created by ndu on 10/21/17.
 */

public class DetailConverterActivity extends AppCompatActivity {
    TextView symbol;
    TextView btcCurrencyValue,ethCurrencyValue;
    EditText currencyValueEditText;
    Button convertButton;

    //String countrySymbol,unitBtcToCurrency,unitEthToCurrency;
    String countrySymbol;
    String unitBtcToCurrency;
    String unitEthToCurrency;

    String btcValueString,ethValueString,valueString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_converter_activity);

        //initialize the views
        initViews();

        //bind the initial value from intent to view
        getIntentsFromSource();

        //Listen for convert button clicks
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (currencyValueEditText.getText().toString() != null || currencyValueEditText.getText().toString() != "") {
                        double value = Double.parseDouble(currencyValueEditText.getText().toString());
                        double btcValue = performBTCConvertion(value);
                        double ethValue = performETHConvertion(value);

                        valueString = String.valueOf(value);
                        btcValueString = String.valueOf(btcValue);
                        ethValueString = String.valueOf(ethValue);

                        btcCurrencyValue.setText(String.valueOf(btcValue));
                        ethCurrencyValue.setText(String.valueOf(ethValue));
                    }else {
                        btcCurrencyValue.setText("0");
                        ethCurrencyValue.setText("0");
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Failed to convert ", Toast.LENGTH_SHORT).show();
                    Log.d("ConverterActivity ", "Only Number is allowed");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        symbol = (TextView) findViewById(R.id.symbol_of_currency);
        btcCurrencyValue = (TextView) findViewById(R.id.BTC_converted_text);
        ethCurrencyValue = (TextView) findViewById(R.id.ETH_converted_text);
        currencyValueEditText = (EditText) findViewById(R.id.currency_convert_input);
        convertButton = (Button) findViewById(R.id.currency_convert_button);

        LinearLayout layout = (LinearLayout) findViewById(R.id.converter_container);
        Drawable d = getResources().getDrawable(R.mipmap.logo);
        d.setAlpha(30);
        layout.setBackgroundDrawable(d);
    }

    private void getIntentsFromSource(){
        countrySymbol = getIntent().getStringExtra("symbol");
        unitBtcToCurrency = getIntent().getStringExtra("btcValue");
        unitEthToCurrency = getIntent().getStringExtra("ethValue");

        symbol.setText("Conversion For "+countrySymbol);
    }

    private double performBTCConvertion(double valueToConvert){
        double finalBTC = valueToConvert/Double.parseDouble(unitBtcToCurrency);
        return finalBTC;
    }
    private double performETHConvertion(double valueToConvert){
        double finalETH = valueToConvert/Double.parseDouble(unitEthToCurrency);
        return finalETH;
    }

    private Intent createShareForcastIntent(){
        String amount = currencyValueEditText.getText().toString();
        String symbol = countrySymbol;
        String btcValueSend = btcValueString;
        String ethValueSend= ethValueString;

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out the current BTC and ETH conversion for "+amount
                        +symbol+"\n"+
                        "\n Check out for more currencies on Krypto Current App on Google Play Store")
                .getIntent();
        return shareIntent;
    }
}
