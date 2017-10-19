package com.perror.app.kryptocurrent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ndu on 10/17/17.
 */

//public class CurrencyResponse {
//
//    @SerializedName("ETH")
//    private String ETH;
//
//    @SerializedName("BTC")
//    private String BTC;
//
//    @SerializedName("USD")
//    private String USD;
//
//    @SerializedName("NGN")
//    private String NGN;
//
//    @SerializedName("EUR")
//    private String EUR;
//
//    @SerializedName("JPY")
//    private String JPY;
//
//    @SerializedName("CHF")
//    private String CHF;
//
//    @SerializedName("CAD")
//    private String CAD;
//
//    @SerializedName("AUD")
//    private String AUD;
//
//    @SerializedName("ZAR")
//    private String ZAR;
//
//
//
//    public String getBTC() {
//        return BTC;
//    }
//
//    public void setBTC(String BTC) {
//        this.BTC = BTC;
//    }
//
//    public String getETH() {
//        return ETH;
//    }
//
//    public void setETH(String ETH) {
//        this.ETH = ETH;
//    }
//
//    public String getUSD() {
//        return USD;
//    }
//
//    public void setUSD(String USD) {
//        this.USD = USD;
//    }
//
//    public String getNGN() {
//        return NGN;
//    }
//
//    public void setNGN(String NGN) {
//        this.NGN = NGN;
//    }
//
//    public String getEUR() {
//        return EUR;
//    }
//
//    public void setEUR(String EUR) {
//        this.EUR = EUR;
//    }
//
//    public String getJPY() {
//        return JPY;
//    }
//
//    public void setJPY(String JPY) {
//        this.JPY = JPY;
//    }
//
//    public String getCHF() {
//        return CHF;
//    }
//
//    public void setCHF(String CHF) {
//        this.CHF = CHF;
//    }
//
//    public String getCAD() {
//        return CAD;
//    }
//
//    public void setCAD(String CAD) {
//        this.CAD = CAD;
//    }
//
//    public String getAUD() {
//        return AUD;
//    }
//
//    public void setAUD(String AUD) {
//        this.AUD = AUD;
//    }
//
//    public String getZAR() {
//        return ZAR;
//    }
//
//    public void setZAR(String ZAR) {
//        this.ZAR = ZAR;
//    }
//}

public class CurrencyResponse {

    @SerializedName("BTC")
    @Expose
    private double bTC;
    @SerializedName("ETH")
    @Expose
    private double eTH;
    @SerializedName("NGN")
    @Expose
    private double nGN;
    @SerializedName("USD")
    @Expose
    private double uSD;
    @SerializedName("EUR")
    @Expose
    private double eUR;
    @SerializedName("JPY")
    @Expose
    private double jPY;
    @SerializedName("CHF")
    @Expose
    private double cHF;
    @SerializedName("CAD")
    @Expose
    private double cAD;
    @SerializedName("AUD")
    @Expose
    private double aUD;
    @SerializedName("ZAR")
    @Expose
    private double zAR;

    public double getBTC() {
        return bTC;
    }

    public void setBTC(Double bTC) {
        this.bTC = bTC;
    }

    public double getETH() {
        return eTH;
    }

    public void setETH(Double eTH) {
        this.eTH = eTH;
    }

    public double getNGN() {
        return nGN;
    }

    public void setNGN(Double nGN) {
        this.nGN = nGN;
    }

    public double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public double getEUR() {
        return eUR;
    }

    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    public double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public double getCAD() {
        return cAD;
    }

    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    public double getAUD() {
        return aUD;
    }

    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    public double getZAR() {
        return zAR;
    }

    public void setZAR(double zAR) {
        this.zAR = zAR;
    }

}
