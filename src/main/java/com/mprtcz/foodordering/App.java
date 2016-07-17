package com.mprtcz.foodordering;

/**
 * Created by Azet on 2016-07-08.
 */
public class App {
    public static void main(String[] args) {

        Order order = new Order();

        try {
            order.pickMainMeal();
            order.pickDessert();
            order.pickDrink();
        } catch (Exception e) {
            e.printStackTrace();
        }

        order.listOutPickedItems();
        order.getTotalPrice();
    }
}
