package com.example.coffeeshop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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

        coffeeRecyclerView = findViewById(R.id.coffeeRecyclerView);
        coffeeRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        coffeeList = new ArrayList<>();
        coffeeList.add(new CoffeeModel("Caffe Mocha", "Deep Foam", "$4.53", R.drawable.mocha));
        coffeeList.add(new CoffeeModel("Flat White", "Espresso", "$3.53", R.drawable.flat_white));

        coffeeAdapter = new CoffeeAdapter(this, coffeeList);
        coffeeRecyclerView.setAdapter(coffeeAdapter);
    }
}
