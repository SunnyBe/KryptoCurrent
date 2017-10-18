package com.perror.app.kryptocurrent.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ndu on 10/17/17.
 */

public class CurrencyResponse {

    @SerializedName("ETH")
    private String ETH;

    @SerializedName("BTC")
    private String BTC;

    @SerializedName("USD")
    private String USD;

    @SerializedName("NGN")
    private String NGN;

    @SerializedName("EUR")
    private String EUR;

    @SerializedName("JPY")
    private String JPY;

    @SerializedName("CHF")
    private String CHF;

    @SerializedName("CAD")
    private String CAD;

    @SerializedName("AUD")
    private String AUD;

    @SerializedName("ZAR")
    private String ZAR;



    public String getBTC() {
        return BTC;
    }

    public void setBTC(String BTC) {
        this.BTC = BTC;
    }

    public String getETH() {
        return ETH;
    }

    public void setETH(String ETH) {
        this.ETH = ETH;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getNGN() {
        return NGN;
    }

    public void setNGN(String NGN) {
        this.NGN = NGN;
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }

    public String getJPY() {
        return JPY;
    }

    public void setJPY(String JPY) {
        this.JPY = JPY;
    }

    public String getCHF() {
        return CHF;
    }

    public void setCHF(String CHF) {
        this.CHF = CHF;
    }

    public String getCAD() {
        return CAD;
    }

    public void setCAD(String CAD) {
        this.CAD = CAD;
    }

    public String getAUD() {
        return AUD;
    }

    public void setAUD(String AUD) {
        this.AUD = AUD;
    }

    public String getZAR() {
        return ZAR;
    }

    public void setZAR(String ZAR) {
        this.ZAR = ZAR;
    }
}
