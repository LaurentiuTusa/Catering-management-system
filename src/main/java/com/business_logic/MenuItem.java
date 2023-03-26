package com.business_logic;

/**
 * MenuItem describes the appearance and functionality of a product
 * it is an abstract class, the methods are implemented inside the classes that extend this class
 */
public abstract class MenuItem {

    protected String title;
    protected double rating;
    protected int calories;
    protected int protein;
    protected int fat;
    protected int sodium;
    protected int price;

    public abstract String getTitle();
    public abstract double getRating();
    public abstract int getCalories();
    public abstract int getProtein();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract int getPrice();
    public abstract String objToString();
    public abstract void update(double parseDouble, int parseInt, int parseInt1, int parseInt2, int parseInt3, int parseInt4);
}
