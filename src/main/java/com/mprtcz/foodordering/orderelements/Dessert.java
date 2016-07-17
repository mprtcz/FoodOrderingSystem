package com.mprtcz.foodordering.orderelements;

/**
 * Created by Azet on 2016-07-17.
 */
public class Dessert {
    String name;
    double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name +", " + price;
    }
}
