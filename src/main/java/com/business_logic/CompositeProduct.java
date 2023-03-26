package com.business_logic;

import java.io.Serializable;
/**
 * CompositeProduct class
 * it extends abstract class MenuItem
 * it describes composite products
 */
public class CompositeProduct extends MenuItem implements Serializable {

    public CompositeProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public void update(double rating, int calories, int protein, int fat, int sodium, int price){
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public int getProtein() {
        return protein;
    }

    @Override
    public int getFat() {
        return fat;
    }

    @Override
    public int getSodium() {
        return sodium;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String objToString() {
        return getTitle() + "," + String.valueOf(getRating()) + "," + String.valueOf(getCalories()) + "," + String.valueOf(getProtein()) + "," + String.valueOf(getFat()) + "," + String.valueOf(getSodium()) + "," + String.valueOf(getPrice());
    }
}
