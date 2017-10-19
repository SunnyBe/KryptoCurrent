package com.perror.app.kryptocurrent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ndu on 10/17/17.
 */

public class Currency {
    private static String symbol;
    private double btcToCurrency;
    private double etcToCurrency;

    private double ValueToConvert;

    public Currency() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBtcToCurrency() {
        return btcToCurrency;
    }

    public void setBtcToCurrency(double btcToCurrency) {
        this.btcToCurrency = btcToCurrency;
    }

    public double getValueToConvert() {
        return ValueToConvert;
    }

    public void setValueToConvert(double valueToConvert) {
        ValueToConvert = valueToConvert;
    }

    public double getEtcToCurrency() {
        return etcToCurrency;
    }

    public void setEtcToCurrency(double etcToCurrency) {
        this.etcToCurrency = etcToCurrency;
    }
}
