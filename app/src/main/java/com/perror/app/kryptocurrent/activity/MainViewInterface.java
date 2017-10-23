package com.perror.app.kryptocurrent.activity;

import android.content.Context;

import com.perror.app.kryptocurrent.model.Currency;

import java.util.List;

/**
 * Created by ndu on 10/21/17.
 */

public interface MainViewInterface {
    public List<Currency> loadCurrencyFromRest();
    public void onCurrencyItemClicked();
    public void onSwipeReload();
}
