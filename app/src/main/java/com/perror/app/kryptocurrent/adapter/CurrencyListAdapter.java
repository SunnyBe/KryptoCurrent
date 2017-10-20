package com.perror.app.kryptocurrent.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.perror.app.kryptocurrent.R;
import com.perror.app.kryptocurrent.model.Currency;
import com.perror.app.kryptocurrent.model.CurrencyResponse;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        final Currency currency = currencies.get(position);

        holder.btcToCurrency.setText(String.valueOf(currency.getBtcToCurrency()));
        holder.ethToCurrency.setText(String.valueOf(currency.getEtcToCurrency()));
        holder.currencySymbol.setText(currency.getSymbol().toString());

        //make a date object for the current date and time
        Date date = new Date();

        holder.btcContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setCancelable(true);

                dialog.show();
                Log.d("CurrencyListActivity:", "Currency Converter Dialog on");
            }
        });

        holder.ethToCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder convertDialog = new AlertDialog.Builder(context);
                convertDialog.setMessage("Enter Conversion Value: ");
                convertDialog.setTitle("ETH - "+currency.getSymbol()+" Conveter: ");
                convertDialog.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Conversion Complete ",Toast.LENGTH_SHORT).show();
                        Log.d("CurrencyListActivity:", "Currency Converter Dialog on");
                    }
                });
                convertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Dialog dialog = new Dialog(context);
                        dialog.setCancelable(true);
                        dialog.show();
                        Log.d("CurrencyListActivity:", "Currency Converter Dialog complete");

                    }
                });
                convertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView btcToCurrency, ethToCurrency, currencySymbol,dateAndTime;
        ViewGroup btcContainer, ethContainer;
        public ViewHolder(View itemView) {
            super(itemView);

            btcToCurrency = itemView.findViewById(R.id.btc_section_view_amount);
            ethToCurrency = itemView.findViewById(R.id.eth_section_view_amount);
            currencySymbol = itemView.findViewById(R.id.tv_currency_logo);
            dateAndTime = itemView.findViewById(R.id.current_date_and_time);

            btcContainer = itemView.findViewById(R.id.btc_container);
            ethContainer = itemView.findViewById(R.id.eth_container);
        }
    }
}
