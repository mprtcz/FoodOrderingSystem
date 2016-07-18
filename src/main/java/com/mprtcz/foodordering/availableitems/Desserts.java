package com.mprtcz.foodordering.availableitems;

import com.mprtcz.foodordering.orderelements.Dessert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-18.
 */
public class Desserts {



    public static List<Dessert> getItalianDessertsList(){
        List<Dessert> italianDessertsList = new ArrayList<>();
        italianDessertsList.add(new Dessert("Italian Dessert 0", "USD 1.99"));
        italianDessertsList.add(new Dessert("Italian Dessert 1", "USD 2.99"));
        italianDessertsList.add(new Dessert("Italian Dessert 2", "USD 1.29"));

        return italianDessertsList;
    }



    public static List<Dessert> getMexicanDessertsList(){
        List<Dessert> mexicanDessertsList = new ArrayList<>();
        mexicanDessertsList.add(new Dessert("Mexican Dessert 0", "USD 1.99"));
        mexicanDessertsList.add(new Dessert("Mexican Dessert 1", "USD 2.99"));
        mexicanDessertsList.add(new Dessert("Mexican Dessert 2", "USD 1.29"));
        return mexicanDessertsList;
    }



    public static List<Dessert> getPolishDessertsList(){
        List<Dessert> polishDessertsList = new ArrayList<>();
        polishDessertsList.add(new Dessert("Polish Dessert 0", "USD 1.99"));
        polishDessertsList.add(new Dessert("Polish Dessert 1", "USD 2.99"));
        polishDessertsList.add(new Dessert("Polish Dessert 2", "USD 1.29"));
        return polishDessertsList;
    }
}
