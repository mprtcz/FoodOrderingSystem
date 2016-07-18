package com.mprtcz.foodordering;

import com.mprtcz.foodordering.availableitems.Drinks;
import com.mprtcz.foodordering.helpers.ConsoleInputHelper;
import com.mprtcz.foodordering.helpers.OrderHelper;
import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.logger.AppLogger;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Azet on 2016-07-08.
 */
public class App {
    private final static Logger logger = Logger.getLogger(AppLogger.class.getName());
    private static Level level = Level.CONFIG;

    public static void main(String[] args) throws Exception {
        AppLogger.initializeLogger();

        Order order = new Order();
        if (ConsoleInputHelper.wantsAnotherPick("Main course")) {
            pickMainMeal(order);
        }
        if (ConsoleInputHelper.wantsAnotherPick("Dessert")) {
            pickDessert(order);
        }
        if (ConsoleInputHelper.wantsAnotherPick("Drink")) {
            pickDrink(order);
        }

        System.out.println(order.listOutPickedItems());
        System.out.println("Total price is: " + order.getTotalPrice());

    }

    private static Cuisine.CuisineOptions pickCuisine() {
        logger.log(level, "");

        int cuisineChoice;
        boolean isChoiceValid;

        List<Cuisine.CuisineOptions> cuisineOptions = new ArrayList<>(Arrays.asList(Cuisine.CuisineOptions.values()));
        do {
            ConsoleInputHelper.listOutCuisineOptions();

            cuisineChoice = ConsoleInputHelper.getIntegerFromSysInput();

            isChoiceValid = ConsoleInputHelper.validateChoice(cuisineChoice, cuisineOptions);
        } while (!isChoiceValid);

        return cuisineOptions.get(cuisineChoice);
    }

    private static void pickMainMeal(Order order) throws Exception {
        logger.log(level, "");

        boolean validChoice;
        int choice;
        Cuisine.CuisineOptions cuisine;

        System.out.println("Pick a cuisine for a main meal:");
        cuisine = pickCuisine();

        if (cuisine == null) {
            throw new Exception("Cuisine not initialized");
        }

        do {
            System.out.println("Pick main meal by choosing it's number:");
            List<MainCourse> mealOptions = cuisine.getMainCourseList();

            ConsoleInputHelper.listOutOrderOptions(mealOptions);

            choice = ConsoleInputHelper.getIntegerFromSysInput();

            validChoice = ConsoleInputHelper.validateChoice(choice, mealOptions);

            if (validChoice) {
                order.addPickedMainMeal(mealOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        if (ConsoleInputHelper.wantsAnotherPick("another Main course")) {
            pickMainMeal(order);
        }
    }

    private static void pickDessert(Order order) throws Exception {
        logger.log(level, "");

        boolean validChoice;
        int choice;
        Cuisine.CuisineOptions cuisine;

        System.out.println("Pick a cuisine for a dessert:");

        cuisine = pickCuisine();

        if (cuisine == null) {
            throw new Exception("Cuisine not initialized");
        }

        do {
            System.out.println("Pick dessert by choosing it's number:");
            List<Dessert> dessertOptions = cuisine.getDessertsList();

            ConsoleInputHelper.listOutOrderOptions(dessertOptions);

            choice = ConsoleInputHelper.getIntegerFromSysInput();

            validChoice = ConsoleInputHelper.validateChoice(choice, dessertOptions);

            if (validChoice) {
                order.addPickedDessert(dessertOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        if (ConsoleInputHelper.wantsAnotherPick("another Dessert")) {
            pickDessert(order);
        }
    }

    private static void pickDrink(Order order) throws Exception {
        logger.log(level, "");

        boolean validChoice;
        int choice;

        do {
            System.out.println("Pick a drink by choosing it's number:");
            List<Drink> drinkOptions = Drinks.getDrinksList();

            ConsoleInputHelper.listOutOrderOptions(drinkOptions);

            choice = ConsoleInputHelper.getIntegerFromSysInput();

            validChoice = ConsoleInputHelper.validateChoice(choice, drinkOptions);

            if (validChoice) {
                Drink drink = drinkOptions.get(choice);
                String addons = ConsoleInputHelper.addonsToDrink();
                drink.wantsLemon(OrderHelper.wantsLemons(addons));
                drink.wantsIce(OrderHelper.wantsIceCubes(addons));

                order.addPickedDrink(drink);
                validChoice = true;
            }
        } while (!validChoice);

        if (ConsoleInputHelper.wantsAnotherPick("another Drink")) {
            pickDrink(order);
        }
    }
}
