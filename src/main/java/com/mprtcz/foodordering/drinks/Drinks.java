package com.mprtcz.foodordering.drinks;

import com.mprtcz.foodordering.orderelements.Drink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-17.
 */
public class Drinks {

    public static List<Drink> getDrinksList(){
        List<Drink> drinksList;

        drinksList = new ArrayList<>();
        drinksList.add(new Drink("Drink 0", 1.99));
        drinksList.add(new Drink("Drink 1", 2.99));
        drinksList.add(new Drink("Drink 2", 3.99));
        drinksList.add(new Drink("Drink 3", 4.99));
        drinksList.add(new Drink("Drink 4", 5.99));

        return drinksList;
    }
}
