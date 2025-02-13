package com.example.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class CoffeeDetailsActivity extends AppCompatActivity {

    private ImageView coffeeImage;
    private TextView coffeeName, coffeeDescription, coffeePrice, coffeeRating, coffeeType;
    private Button buyNowButton;
    private Button sizeS, sizeM, sizeL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        coffeeImage = findViewById(R.id.coffeeImage);
        coffeeName = findViewById(R.id.coffeeName);
        coffeeDescription = findViewById(R.id.coffeeDescription);
        coffeePrice = findViewById(R.id.coffeePrice);
        coffeeRating = findViewById(R.id.coffeeRating);
        coffeeType = findViewById(R.id.coffeeType);
        buyNowButton = findViewById(R.id.buyNowButton);

        sizeS = findViewById(R.id.sizeS);
        sizeM = findViewById(R.id.sizeM);
        sizeL = findViewById(R.id.sizeL);

        View.OnClickListener sizeClickListener = v -> {
            resetButtonStyles();
            v.setBackgroundResource(R.drawable.size_button_selected); // Change to selected background
        };

        sizeS.setOnClickListener(sizeClickListener);
        sizeM.setOnClickListener(sizeClickListener);
        sizeL.setOnClickListener(sizeClickListener);

        Intent intent = getIntent();
        if (intent != null) {
            coffeeName.setText(intent.getStringExtra("coffee_name"));
            coffeeDescription.setText(intent.getStringExtra("coffee_description"));
            coffeePrice.setText(intent.getStringExtra("coffee_price"));
            coffeeRating.setText(String.valueOf(intent.getFloatExtra("coffee_rating", 0)));
            coffeeType.setText(intent.getStringExtra("coffee_type"));

            int imageResId = intent.getIntExtra("coffee_image", 0);
            if (imageResId != 0) {
                coffeeImage.setImageResource(imageResId);
            }
        }
    }

    private void resetButtonStyles() {
        sizeS.setBackgroundResource(R.drawable.size_button_background);
        sizeM.setBackgroundResource(R.drawable.size_button_background);
        sizeL.setBackgroundResource(R.drawable.size_button_background);
    }
}
