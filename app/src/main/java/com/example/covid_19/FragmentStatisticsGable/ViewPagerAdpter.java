package com.example.covid_19.FragmentStatisticsGable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.covid_19.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdpter extends RecyclerView.Adapter<ViewPagerAdpter.ViewHolder> {

    List<Models> mModles ;
    Context context ;

    public ViewPagerAdpter(ArrayList<Models> models , Context context) {
        this.mModles = models;
        this.context = context ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_symptoms,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Models covid = mModles.get(position);

        holder.totalRecvoid.setText(covid.getmRecvid());
        holder.totalCases.setText(covid.getmCases());
        holder.totalDeath.setText(covid.getmDeath());

        // get Image contry flag
        Glide.with(context).load(covid.getmConrtyflag()).apply(new RequestOptions().override(240,160)).into(holder.Flag);
    }

    @Override
    public int getItemCount() {
        return mModles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView totalRecvoid , totalCases , totalDeath ;
        ImageView Flag ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            Flag = itemView.findViewById(R.id.flag);
            totalRecvoid = itemView.findViewById(R.id.totalRecvoid);
            totalCases = itemView.findViewById(R.id.totalCases);
            totalDeath = itemView.findViewById(R.id.totalDeath);
        }
    }
}
