package com.example.coffeeshop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView coffeeRecyclerView;
    private CoffeeAdapter coffeeAdapter;
    private List<CoffeeModel> coffeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = findViewById(R.id.coffeeCategories);
        tabLayout.addTab(tabLayout.newTab().setText("All Coffee"));
        tabLayout.addTab(tabLayout.newTab().setText("Macchiato"));
        tabLayout.addTab(tabLayout.newTab().setText("Latte"));


        coffeeRecyclerView = findViewById(R.id.coffeeRecyclerView);
        coffeeRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        coffeeList = new ArrayList<>();
        coffeeList.add(new CoffeeModel("Caffe Mocha", "Deep Foam", "$4.53", R.drawable.mocha, 4.5f));
        coffeeList.add(new CoffeeModel("Flat White", "Espresso", "$3.53", R.drawable.flat_white, 4.8f));
        coffeeList.add(new CoffeeModel("Cappuccino", "Rich & Creamy", "$3.99", R.drawable.cappuccino, 4.6f));
        coffeeList.add(new CoffeeModel("Espresso", "Strong & Bold", "$2.99", R.drawable.espresso, 4.7f));

        coffeeAdapter = new CoffeeAdapter(this, coffeeList);
        coffeeRecyclerView.setAdapter(coffeeAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setBackground(null);
    }
}
