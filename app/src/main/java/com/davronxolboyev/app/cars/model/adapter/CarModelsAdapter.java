package com.davronxolboyev.app.cars.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davronxolboyev.app.cars.InfoActivity;
import com.davronxolboyev.app.cars.R;
import com.davronxolboyev.app.cars.model.CarModels;

import java.util.List;

public class CarModelsAdapter extends RecyclerView.Adapter<CarModelsAdapter.CarModelsViewHolder> {

    Context context;
    List<CarModels> carModels;

    int lposition = -1;

    public CarModelsAdapter(Context context, List<CarModels> carModels) {
        this.context = context;
        this.carModels = carModels;
    }

    public static class CarModelsViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName;
        TextView carCost;

        public CarModelsViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.carImage);
            carName = itemView.findViewById(R.id.carName);
            carCost = itemView.findViewById(R.id.carCost);
        }
    }

    @NonNull
    @Override
    public CarModelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        return new CarModelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarModelsAdapter.CarModelsViewHolder holder, int position) {
        holder.carName.setText(carModels.get(position).getCarName());
        holder.carImage.setImageResource(carModels.get(position).getCarImage());
        holder.carCost.setText(carModels.get(position).getCarCost());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoActivity.class);
            intent.putExtra("image", carModels.get(position).getCarImage());
            intent.putExtra("idCompany", carModels.get(position).getIdCompany());
            intent.putExtra("description", carModels.get(position).getDescription());
            intent.putExtra("carName", carModels.get(position).getCarName());
            intent.putExtra("carCost", carModels.get(position).getCarCost());

            context.startActivity(intent);
        });
        setAnimations(holder.itemView, position);

    }

    private void setAnimations(View itemView, int position) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        itemView.setAnimation(animation);
        lposition = position;
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }
}
