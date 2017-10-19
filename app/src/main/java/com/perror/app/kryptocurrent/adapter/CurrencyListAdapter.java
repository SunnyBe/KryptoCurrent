package com.perror.app.kryptocurrent.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perror.app.kryptocurrent.R;
import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;

import java.util.List;

/**
 * Created by ndu on 10/17/17.
 */

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.ViewHolder> {
    Context context;
    List<Currency> currencies;
//    Currency currency;

    public CurrencyListAdapter(Context context, List<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
        //this.currency = currency;
    }

    @Override
    public CurrencyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.currency_item_layout,
                parent,
                false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurrencyListAdapter.ViewHolder holder, final int position) {
        Currency currency = currencies.get(position);

        holder.btcToCurrency.setText(String.valueOf(currency.getBtcToCurrency()));
        holder.ethToCurrency.setText(String.valueOf(currency.getEtcToCurrency()));
        holder.currencySymbol.setText("USD");

    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView btcToCurrency, ethToCurrency, currencySymbol;
        public ViewHolder(View itemView) {
            super(itemView);

            btcToCurrency = itemView.findViewById(R.id.btc_section_view_label);
            ethToCurrency = itemView.findViewById(R.id.eth_section_view_label);
            currencySymbol = itemView.findViewById(R.id.tv_currency_logo);
        }
    }
}
