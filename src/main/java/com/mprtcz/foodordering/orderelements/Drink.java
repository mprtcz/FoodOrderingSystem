package com.mprtcz.foodordering.orderelements;

import org.joda.money.Money;

/**
 * Created by Azet on 2016-07-17.
 */
public class Drink {
    private String name;
    private Money price;
    private boolean withLemon;
    private boolean withIce;
    private static final Money LEMON_PRICE = Money.parse("USD 0.2");
    private static final Money ICE_PRICE = Money.parse("USD 0.1");

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

    public void wantsLemon(boolean wantsLemon) {
        withLemon = wantsLemon;
        price = price.plus(LEMON_PRICE);
    }

    public void wantsIce(boolean wantsIce) {
        withIce = wantsIce;
        price = price.plus(ICE_PRICE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        //stringBuilder.append(" ");
        if (withIce) {
            stringBuilder.append(" + Ice");
        }

        if (withLemon) {
            stringBuilder.append(" + Lemon");
        }

        stringBuilder.append(" ").append(price);
        return stringBuilder.toString();
    }
}
