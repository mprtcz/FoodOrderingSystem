package com.mprtcz.foodordering.drinks;

import com.mprtcz.foodordering.orderelements.Drink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-17.
 */
public class Drinks {

    List<Drink> drinksList;

    public Drinks() {
        createDrinksList();
    }

    private void createDrinksList(){
        drinksList = new ArrayList<>();
        drinksList.add(new Drink("Drink 1", 1.99));
        drinksList.add(new Drink("Drink 2", 2.99));
        drinksList.add(new Drink("Drink 3", 3.99));
        drinksList.add(new Drink("Drink 4", 4.99));
        drinksList.add(new Drink("Drink 5", 5.99));
    }
}
