package com.abc.assignment1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder>{
    private ArrayList<DetailsClass> rItems;
    Dialog detailsPopUp;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView country,capital;
        LinearLayout recycleLinear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recycleLinear = itemView.findViewById(R.id.recyclerLinearLayout);
            country = itemView.findViewById(R.id.countryTextView);
            capital = itemView.findViewById(R.id.captialTextView);
        }
    }

    public RecyclerAdaptor(ArrayList<DetailsClass> detailsClasses){
        rItems =  detailsClasses;
    }
    @NonNull
    @Override
    public RecyclerAdaptor.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_element,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        //dialog box
        detailsPopUp = new Dialog(parent.getContext());
        detailsPopUp.setContentView(R.layout.details_pop_up);

        viewHolder.recycleLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView countryDialog = detailsPopUp.findViewById(R.id.popUpCountryText);
                TextView capitalDialog = detailsPopUp.findViewById(R.id.popUpCapitalText);
                TextView currencyDialog = detailsPopUp.findViewById(R.id.popUpCurrencyText);

                countryDialog.setText(rItems.get(viewHolder.getAdapterPosition()).getCountry());
                capitalDialog.setText(rItems.get(viewHolder.getAdapterPosition()).getCapital());
                currencyDialog.setText(rItems.get(viewHolder.getAdapterPosition()).getCurrency());
                detailsPopUp.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptor.ViewHolder holder, int position) {
        DetailsClass currentLedger = rItems.get(position);

        holder.country.setText(currentLedger.getCountry());
        holder.capital.setText(currentLedger.getCapital());
    }

    @Override
    public int getItemCount() {
        return rItems.size();
    }
}
