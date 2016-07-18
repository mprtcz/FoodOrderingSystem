package com.mprtcz.foodordering;

import com.mprtcz.foodordering.helpers.OrderHelper;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-08.
 */
public class Order {
    private List<MainCourse> orderedMainCourses;
    private List<Dessert> orderedDesserts;
    private List<Drink> orderedDrinks;

    Order() {
        orderedMainCourses = new ArrayList<>();
        orderedDesserts = new ArrayList<>();
        orderedDrinks = new ArrayList<>();

    }

    void addPickedMainMeal(MainCourse mainCourse){
        orderedMainCourses.add(mainCourse);
    }

    void addPickedDessert(Dessert dessert){
        orderedDesserts.add(dessert);
    }

    void addPickedDrink(Drink drink){
        orderedDrinks.add(drink);
    }

    void listOutPickedItems(){
        System.out.println("orderedMainCourses = " + orderedMainCourses.toString());
        System.out.println("orderedDesserts = " + orderedDesserts.toString());
        System.out.println("orderedDrinks = " + orderedDrinks.toString());
    }

    void getTotalPrice(){
        Money price = OrderHelper.summarizePrices(orderedMainCourses, orderedDesserts, orderedDrinks);
        System.out.println("Total: " +price.toString());
    }
}
