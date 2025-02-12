package com.example.coffeeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {
    private Context context;
    private List<CoffeeModel> coffeeList;

    public CoffeeAdapter(Context context, List<CoffeeModel> coffeeList) {
        this.context = context;
        this.coffeeList = coffeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_coffee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CoffeeModel coffee = coffeeList.get(position);
        holder.coffeeName.setText(coffee.getName());
        holder.coffeeType.setText(coffee.getType());
        holder.coffeePrice.setText(coffee.getPrice());
        holder.coffeeImage.setImageResource(coffee.getImage());
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView coffeeName, coffeeType, coffeePrice;
        ImageView coffeeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            coffeeName = itemView.findViewById(R.id.coffeeName);
            coffeeType = itemView.findViewById(R.id.coffeeType);
            coffeePrice = itemView.findViewById(R.id.coffeePrice);
            coffeeImage = itemView.findViewById(R.id.coffeeImage);
        }
    }
}
