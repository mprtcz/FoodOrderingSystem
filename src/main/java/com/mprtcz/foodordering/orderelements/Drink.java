package com.mprtcz.foodordering.orderelements;

import org.joda.money.Money;

/**
 * Created by Azet on 2016-07-17.
 */
public class Drink {
    String name;
    Money price;
    boolean withLemon;
    boolean withIce;
    Money lemonPrice = Money.parse("USD 0.2");
    Money icePrice = Money.parse("USD 0.1");

    public Drink(String name, String price) {
        this.name = name;
        this.price = Money.parse(price);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void wantsLemon(boolean wantsLemon){
        withLemon = wantsLemon;
        price = price.plus(lemonPrice);
    }

    public void wantsIce(boolean wantsIce){
        withIce = wantsIce;
        price = price.plus(icePrice);
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

        stringBuilder.append(" ").append(String.format("%.2f", price.getAmount())).append(";");
        return stringBuilder.toString();
    }
}
