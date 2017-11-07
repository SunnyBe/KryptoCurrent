package com.perror.app.kryptocurrent.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
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
    Toolbar toolbar;

    Button convertButton, dismissButton;
    LinearLayout btcToBaseConversion,BaseToBtcConversion, etcToBaseConversion, BaseToEthConversion;

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

        /*
        * Listen for the kind of conversion to make
        * */

        BaseToBtcConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailConverterActivity.this, "Convert Bitcoin to Base", Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder converterDialog = new AlertDialog.Builder(DetailConverterActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.converter_dialog, null);

                final EditText amountEditText;

                amountEditText = mView.findViewById(R.id.amount_edit_text);
                convertButton = mView.findViewById(R.id.convert_button);
                dismissButton = mView.findViewById(R.id.dismis_button);

                convertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        try {
                            double amount = Double.parseDouble(amountEditText.getText().toString());
                            if (amountEditText.getText().toString() == "") {
                                Toast.makeText(DetailConverterActivity.this, "Box is empty", Toast.LENGTH_SHORT).show();
                            } else {
                                double result = performBTCConvertion(amount);

                                // Alert to show the answer
                                final AlertDialog.Builder answer = new AlertDialog.Builder(DetailConverterActivity.this);

                                answer.setTitle("Your Conversion");
                                answer.setMessage("BTC "+String.valueOf(result));

                                final AlertDialog answerDialog = answer.create();
                                answerDialog.show();
                            }

                        } catch (NumberFormatException ex) {
                            Log.d("ERROR", "Only Number is allowed");
                        }
                    }
                });

                converterDialog.setView(mView);
                final AlertDialog dialog = converterDialog.create();
                dialog.show();

                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        btcToBaseConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailConverterActivity.this, "Convert Bitcoin to Base", Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder converterDialog = new AlertDialog.Builder(DetailConverterActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.converter_dialog, null);

                final EditText amountEditText;

                amountEditText = mView.findViewById(R.id.amount_edit_text);
                convertButton = mView.findViewById(R.id.convert_button);
                dismissButton = mView.findViewById(R.id.dismis_button);

                convertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        try {
                            double amount = Double.parseDouble(amountEditText.getText().toString());
                            if (amountEditText.getText().toString() == "") {
                                Toast.makeText(DetailConverterActivity.this, "Box is empty", Toast.LENGTH_SHORT).show();
                            } else {
                                double result = performConvertionFromBTC(amount);
                                // Alert to show the answer
                                final AlertDialog.Builder answer = new AlertDialog.Builder(DetailConverterActivity.this);

                                answer.setTitle("Your Conversion");
                                answer.setMessage(symbol.getText()+" "+String.valueOf(result));

                                final AlertDialog answerDialog = answer.create();
                                answerDialog.show();
                            }

                        } catch (NumberFormatException ex) {
                            Log.d("ERROR", "Only Number is allowed");
                        }
                    }
                });

                converterDialog.setView(mView);
                final AlertDialog dialog = converterDialog.create();
                dialog.show();

                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        etcToBaseConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailConverterActivity.this, "Convert Bitcoin to Base", Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder converterDialog = new AlertDialog.Builder(DetailConverterActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.converter_dialog, null);

                final EditText amountEditText;

                amountEditText = mView.findViewById(R.id.amount_edit_text);
                convertButton = mView.findViewById(R.id.convert_button);
                dismissButton = mView.findViewById(R.id.dismis_button);

                convertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        try {
                            double amount = Double.parseDouble(amountEditText.getText().toString());
                            if (amountEditText.getText().toString() == "") {
                                Toast.makeText(DetailConverterActivity.this, "Box is empty", Toast.LENGTH_SHORT).show();
                            } else {
                                double result = performConvertionFromETH(amount);
                                Toast.makeText(DetailConverterActivity.this, "Value is " + result, Toast.LENGTH_SHORT).show();

                                // Alert to show the answer
                                final AlertDialog.Builder answer = new AlertDialog.Builder(DetailConverterActivity.this);

                                answer.setTitle("Your Conversion");
                                answer.setMessage(symbol.getText()+" "+String.valueOf(result));

                                final AlertDialog answerDialog = answer.create();
                                answerDialog.show();

                            }

                        } catch (NumberFormatException ex) {
                            Log.d("ERROR", "Only Number is allowed");
                        }
                    }
                });

                BaseToEthConversion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailConverterActivity.this, "Convert Bitcoin to Base", Toast.LENGTH_SHORT).show();

                        final AlertDialog.Builder converterDialog = new AlertDialog.Builder(DetailConverterActivity.this);
                        View mView = getLayoutInflater().inflate(R.layout.converter_dialog, null);

                        final EditText amountEditText;

                        amountEditText = mView.findViewById(R.id.amount_edit_text);
                        convertButton = mView.findViewById(R.id.convert_button);
                        dismissButton = mView.findViewById(R.id.dismis_button);

                        convertButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                try {
                                    double amount = Double.parseDouble(amountEditText.getText().toString());
                                    if (amountEditText.getText().toString() == "") {
                                        Toast.makeText(DetailConverterActivity.this, "Box is empty", Toast.LENGTH_SHORT).show();
                                    } else {
                                        double result = performETHConvertion(amount);
                                        // Alert to show the answer
                                        final AlertDialog.Builder answer = new AlertDialog.Builder(DetailConverterActivity.this);

                                        answer.setTitle("Your Conversion");
                                        answer.setMessage("ETH "+String.valueOf(result));

                                        final AlertDialog answerDialog = answer.create();
                                        answerDialog.show();
                                    }

                                } catch (NumberFormatException ex) {
                                    Log.d("ERROR", "Only Number is allowed");
                                }
                            }
                        });

                        converterDialog.setView(mView);
                        final AlertDialog dialog = converterDialog.create();
                        dialog.show();

                        dismissButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                    }
                });

                converterDialog.setView(mView);
                final AlertDialog dialog = converterDialog.create();
                dialog.show();

                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
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
//        btcCurrencyValue = (TextView) findViewById(R.id.BTC_converted_text);
//        ethCurrencyValue = (TextView) findViewById(R.id.ETH_converted_text);
//        currencyValueEditText = (EditText) findViewById(R.id.currency_convert_input);
//        convertButton = (Button) findViewById(R.id.currency_convert_button);

        btcToBaseConversion = (LinearLayout) findViewById(R.id.bitcoin_to_base_conversion);
        BaseToBtcConversion = (LinearLayout) findViewById(R.id.base_to_bitcoin);
        etcToBaseConversion = (LinearLayout) findViewById(R.id.etherum_base_conversion);
        BaseToEthConversion = (LinearLayout) findViewById(R.id.base_to_etherum);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        LinearLayout layout = (LinearLayout) findViewById(R.id.conversion_container);
        Drawable d = getResources().getDrawable(R.mipmap.logo);
        d.setAlpha(20);
        layout.setBackgroundDrawable(d);
    }

    private void getIntentsFromSource(){
        countrySymbol = getIntent().getStringExtra("symbol");
        unitBtcToCurrency = getIntent().getStringExtra("btcValue");
        unitEthToCurrency = getIntent().getStringExtra("ethValue");

        symbol.setText("Conversion For "+countrySymbol);
    }

    // Handle Conversion from Currency to BTC
    private double performBTCConvertion(double valueToConvert){
        double finalBTC = valueToConvert/Double.parseDouble(unitBtcToCurrency);
        return finalBTC;
    }
    // Handle Conversion from BTC to Currency
    private double performConvertionFromBTC(double btcValue) {
        double currencyFromBTCvalue = btcValue * Double.parseDouble(unitBtcToCurrency);
        return currencyFromBTCvalue;
    }

    // Handles the conversion from Currency to ETH
    private double performETHConvertion(double valueToConvert){
        double finalETH = valueToConvert/Double.parseDouble(unitEthToCurrency);
        return finalETH;
    }

    // Handles the conversion from ETH to Currency
    private double performConvertionFromETH(double ethValue) {
        double currencyFromETHvalue = ethValue * Double.parseDouble(unitEthToCurrency);
        return currencyFromETHvalue;
    }


    private Intent createShareForcastIntent(){
//        String amount = amountEditText.getText().toString();
        String symbol = countrySymbol;
        String btcValueSend = btcValueString;
        String ethValueSend= ethValueString;

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out the current BTC and ETH conversion for "
                        +symbol+"On Krypto Current mobile App\n"+
                        "\n Check out for more currencies on Krypto Current App on Google Play Store")
                .getIntent();
        return shareIntent;
    }
}
