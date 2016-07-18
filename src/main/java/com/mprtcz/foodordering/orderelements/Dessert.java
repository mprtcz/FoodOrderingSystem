package com.mprtcz.foodordering.orderelements;

import org.joda.money.Money;

/**
 * Created by Azet on 2016-07-17.
 */
public class Dessert {
    private String name;
    private Money price;

    public Dessert(String name, String price) {
        this.name = name;
        this.price = Money.parse(price);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name +", " + price;
    }
}
