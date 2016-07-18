package com.mprtcz.foodordering;

import com.mprtcz.foodordering.helpers.OrderHelper;
import com.mprtcz.foodordering.logger.AppLogger;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Azet on 2016-07-08.
 */
public class Order {
    private final static Logger logger = Logger.getLogger(AppLogger.class.getName());
    private Level level = Level.CONFIG;

    private List<MainCourse> orderedMainCourses;
    private List<Dessert> orderedDesserts;
    private List<Drink> orderedDrinks;

    Order() {
        logger.log(level, "");

        orderedMainCourses = new ArrayList<>();
        orderedDesserts = new ArrayList<>();
        orderedDrinks = new ArrayList<>();

    }

    void addPickedMainMeal(MainCourse mainCourse) {
        logger.log(level, "mainCourse arg = " + mainCourse.toString());

        orderedMainCourses.add(mainCourse);
    }

    void addPickedDessert(Dessert dessert) {
        logger.log(level, "dessert arg = " + dessert.toString());
        orderedDesserts.add(dessert);
    }

    void addPickedDrink(Drink drink) {
        logger.log(level, "drink arg = " + drink.toString());
        orderedDrinks.add(drink);
    }

    String listOutPickedItems() {
        logger.log(level, "");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nOrdered items: \n");
        stringBuilder.append(orderedMainCourses.toString());
        stringBuilder.append("\n");
        stringBuilder.append(orderedDesserts.toString());
        stringBuilder.append("\n");
        stringBuilder.append(orderedDrinks.toString());
        stringBuilder.append("\n");

        logger.log(level, "returned stringBuilder = " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    Money getTotalPrice() {
        logger.log(level, "");

        Money price = OrderHelper.summarizePrices(orderedMainCourses, orderedDesserts, orderedDrinks);

        logger.log(level, "price = " + price);
        return price;
    }
}
