package com.mprtcz.foodordering.orderelements;

/**
 * Created by Azet on 2016-07-17.
 */
public class Drink {
    String name;
    double price;
    boolean withLemon;
    boolean withIce;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void wantsLemon(boolean wantsLemon){
        withLemon = wantsLemon;
        price += 0.2;
    }

    public void wantsIce(boolean wantsIce){
        withIce = wantsIce;
        price += 0.1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(", ");
        if(withIce){
            stringBuilder.append(" + Ice");
        }

        if(withLemon){
            stringBuilder.append(" + Lemon");
        }

        stringBuilder.append(", ").append(String.format("%.2f", price)).append(";");
        return stringBuilder.toString();
    }
}
