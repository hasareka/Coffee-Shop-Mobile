package com.example.coffeeshop;

public class CoffeeModel {
    private String name, type, price;
    private int image;

    public CoffeeModel(String name, String type, String price, int image, float v) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getPrice() { return price; }
    public int getImage() { return image; }
}
