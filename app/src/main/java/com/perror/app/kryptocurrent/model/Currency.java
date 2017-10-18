package com.perror.app.kryptocurrent.model;

/**
 * Created by ndu on 10/17/17.
 */

public class Currency {
    private String btcConvertValue;
    private String ethConvertValue;
    private String symbol;
    private Double valueToConvert;

    CurrencyResponse btcToCurrency;

    public String getBtcConvertValue() {
        return btcConvertValue;
    }

    public void setBtcConvertValue(String btcConvertValue) {
        this.btcConvertValue = btcConvertValue;
    }

    public String getEthConvertValue() {
        return ethConvertValue;
    }

    public void setEthConvertValue(String ethConvertValue) {
        this.ethConvertValue = ethConvertValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getValueToConvert() {
        return valueToConvert;
    }

    public void setValueToConvert(Double valueToConvert) {
        this.valueToConvert = valueToConvert;
    }
}
