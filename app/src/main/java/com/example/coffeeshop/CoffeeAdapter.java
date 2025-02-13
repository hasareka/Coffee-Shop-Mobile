package com.example.coffeeshop;

import android.content.Context;
import android.content.Intent;
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
        holder.coffeeDescription.setText(coffee.getDescription());
        holder.coffeePrice.setText(coffee.getPrice());
        holder.coffeeImage.setImageResource(coffee.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CoffeeDetailsActivity.class);
            intent.putExtra("coffee_name", coffee.getName());
            intent.putExtra("coffee_description", coffee.getDescription());
            intent.putExtra("coffee_price", coffee.getPrice());
            intent.putExtra("coffee_rating", coffee.getRating());
            intent.putExtra("coffee_image", coffee.getImageResId());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView coffeeName, coffeeDescription, coffeePrice;
        ImageView coffeeImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coffeeName = itemView.findViewById(R.id.coffeeName);
            coffeeDescription = itemView.findViewById(R.id.coffeeDescription);
            coffeePrice = itemView.findViewById(R.id.coffeePrice);
            coffeeImage = itemView.findViewById(R.id.coffeeImage);
        }
    }
}
