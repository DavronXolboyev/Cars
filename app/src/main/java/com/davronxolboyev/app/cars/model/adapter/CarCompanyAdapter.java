package com.davronxolboyev.app.cars.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davronxolboyev.app.cars.R;
import com.davronxolboyev.app.cars.model.CarCompany;

import java.util.List;

public class CarCompanyAdapter extends RecyclerView.Adapter<CarCompanyAdapter.CarCompanyViewHolder> {

    Context context;
    List<CarCompany> companyList;
    int lposition = -1;

    public CarCompanyAdapter(Context context, List<CarCompany> companyList) {
        this.context = context;
        this.companyList = companyList;
    }

    @NonNull
    @Override
    public CarCompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        return new CarCompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarCompanyAdapter.CarCompanyViewHolder holder, int position) {
        holder.logo.setImageResource(companyList.get(position).getCompanyImage());
        holder.nameCompany.setText(companyList.get(position).getCompanyName());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setAdapter(companyList.get(position).getAdapter());

        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lposition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.setAnimation(animation);
        lposition = position;

    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    public static class CarCompanyViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        TextView nameCompany;
        RecyclerView recyclerView;

        public CarCompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logoCompany);
            nameCompany = itemView.findViewById(R.id.nameCompany);
            recyclerView = itemView.findViewById(R.id.carsList);
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull CarCompanyAdapter.CarCompanyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

}
