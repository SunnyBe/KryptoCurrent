package com.perror.app.kryptocurrent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ndu on 10/17/17.
 */

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

    @SerializedName("BRL")
    @Expose
    private double bRL;

    @SerializedName("GBP")
    @Expose
    private double gBP;

    @SerializedName("SGD")
    @Expose
    private double sGD;

    @SerializedName("RUB")
    @Expose
    private double rUB;

    @SerializedName("CLP")
    @Expose
    private double cLP;

    @SerializedName("CZK")
    @Expose
    private double cZK;

    @SerializedName("DKK")
    @Expose
    private double dKK;

    @SerializedName("INR")
    @Expose
    private double iNR;

    @SerializedName("GHC")
    @Expose
    private double gHC;

    @SerializedName("RON")
    @Expose
    private double rON;

    @SerializedName("QAR")
    @Expose
    private double qAR;

    @SerializedName("uED")
    @Expose
    private double uED;


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

    public double getbRL() {
        return bRL;
    }

    public void setbRL(double bRL) {
        this.bRL = bRL;
    }

    public double getgBP() {
        return gBP;
    }

    public void setgBP(double gBP) {
        this.gBP = gBP;
    }

    public double getsGD() {
        return sGD;
    }

    public void setsGD(double sGD) {
        this.sGD = sGD;
    }

    public double getrUB() {
        return rUB;
    }

    public void setrUB(double rUB) {
        this.rUB = rUB;
    }

    public double getcLP() {
        return cLP;
    }

    public void setcLP(double cLP) {
        this.cLP = cLP;
    }

    public double getcZK() {
        return cZK;
    }

    public void setcZK(double cZK) {
        this.cZK = cZK;
    }

    public double getdKK() {
        return dKK;
    }

    public void setdKK(double dKK) {
        this.dKK = dKK;
    }

    public double getiNR() {
        return iNR;
    }

    public void setiNR(double iNR) {
        this.iNR = iNR;
    }

    public double getgHC() {
        return gHC;
    }

    public void setgHC(double gHC) {
        this.gHC = gHC;
    }

    public double getrON() {
        return rON;
    }

    public void setrON(double rON) {
        this.rON = rON;
    }

    public double getqAR() {
        return qAR;
    }

    public void setqAR(double qAR) {
        this.qAR = qAR;
    }

    public double getuED() {
        return uED;
    }

    public void setuED(double uED) {
        this.uED = uED;
    }
}
