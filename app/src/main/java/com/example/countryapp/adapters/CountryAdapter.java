package com.example.countryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryapp.R;
import com.example.countryapp.models.Country;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{

    private List<Country> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public CountryAdapter(Context context, List<Country> data)
    {
        this.mInflater=LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creare de iteme (randuri)
        View view = mInflater.inflate(R.layout.country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = mData.get(position);
        holder.countryTextView.setText(country.getName());
        holder.countryCapitalTextView.setText(country.getCapital());
        holder.countryPopulationTextView.setText(String.valueOf(country.getPopulation()));
        Picasso.get().load(country.getImageURL()).into(holder.countryFlagImageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView countryTextView;
        TextView countryCapitalTextView;
        TextView countryPopulationTextView;
        ImageView countryFlagImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryTextView=itemView.findViewById(R.id.tvCountryName);
            countryCapitalTextView=itemView.findViewById(R.id.tvCountryCapital);
            countryPopulationTextView=itemView.findViewById(R.id.tvCountryPopulation);
            countryFlagImageView=itemView.findViewById(R.id.imgURL);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener!=null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Country getItem(int id)
    {
        return mData.get(id);
    }

    public void removeItem(int position)
    {
        mData.remove(position);      //---> Lista din spate
        notifyItemRemoved(position); //---> UI
    }

    public void restoreItem(Country item, int position)
    {
        mData.add(position, item);    //--->Lista din spate
        notifyItemInserted(position); //-->UI
    }

    public void setClickListener(ItemClickListener itemClickListener)
    {
        this.mClickListener=itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
