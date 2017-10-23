package com.perror.app.kryptocurrent.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perror.app.kryptocurrent.activity.DetailConverterActivity;
import com.perror.app.kryptocurrent.R;
import com.perror.app.kryptocurrent.model.Currency;

import java.util.Date;
import java.util.List;

/**
 * Created by ndu on 10/17/17.
 */

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.ViewHolder> {
    //initialize neede objects
    Context context;
    List<Currency> currencies;

    /**
     * The Adapter constructor
      * @param context
     * @param currencies
     */
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
        final Currency currency = currencies.get(position);

        holder.btcToCurrency.setText(String.valueOf(currency.getBtcToCurrency()));
        holder.ethToCurrency.setText(String.valueOf(currency.getEtcToCurrency()));
        holder.currencySymbol.setText(currency.getSymbol().toString());

        //make a date object for the current date and time
        Date date = new Date();

        holder.relativeItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailConverterIntent = new Intent(context, DetailConverterActivity.class);
                detailConverterIntent.putExtra("btcValue", String.valueOf(currency.getBtcToCurrency()));
                detailConverterIntent.putExtra("ethValue", String.valueOf(currency.getEtcToCurrency()));
                detailConverterIntent.putExtra("symbol", String.valueOf(currency.getSymbol()));
                detailConverterIntent.putExtra("date", "19.45" );
                detailConverterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(detailConverterIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView btcToCurrency, ethToCurrency, currencySymbol,dateAndTime;
        ViewGroup btcContainer, ethContainer,relativeItemContainer;
        public ViewHolder(final View itemView) {
            super(itemView);

            btcToCurrency = itemView.findViewById(R.id.btc_section_view_amount);
            ethToCurrency = itemView.findViewById(R.id.eth_section_view_amount);
            currencySymbol = itemView.findViewById(R.id.tv_currency_logo);
            dateAndTime = itemView.findViewById(R.id.current_date_and_time);

            btcContainer = itemView.findViewById(R.id.btc_container);
            ethContainer = itemView.findViewById(R.id.eth_container);

            relativeItemContainer = itemView.findViewById(R.id.relative_item_container);

        }
    }
}
