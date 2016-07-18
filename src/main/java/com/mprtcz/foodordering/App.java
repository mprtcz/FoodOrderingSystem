package com.mprtcz.foodordering;

import com.mprtcz.foodordering.drinks.Drinks;
import com.mprtcz.foodordering.helpers.ConsoleInputHelper;
import com.mprtcz.foodordering.helpers.OrderHelper;
import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Azet on 2016-07-08.
 */
public class App {
    public static void main(String[] args) throws Exception {


        Order order = new Order();
        if(ConsoleInputHelper.wantsAnotherPick(" Main course")){
            pickMainMeal(order);
        }
        if(ConsoleInputHelper.wantsAnotherPick("Dessert")){
            pickDessert(order);
        }
        if(ConsoleInputHelper.wantsAnotherPick("Drink")){
            pickDrink(order);
        }

        order.listOutPickedItems();
        order.getTotalPrice();

    }

    static Cuisine pickCuisine(){
        int cuisineChoice;
        boolean isChoiceValid;

        List<Cuisine.CuisineOptions> cuisineOptions = new ArrayList<>(Arrays.asList(Cuisine.CuisineOptions.values()));
        do{
            ConsoleInputHelper.listOutCuisineOptions();

            cuisineChoice = ConsoleInputHelper.getIntegerFromSysInput();

            isChoiceValid = ConsoleInputHelper.validateChoice(cuisineChoice, cuisineOptions);
        } while (!isChoiceValid);

        return Cuisine.getInstance(cuisineOptions.get(cuisineChoice));
    }

    static void pickMainMeal(Order order) throws Exception {
        boolean validChoice;
        int choice;
        Cuisine cuisine;

        System.out.println("Pick a cuisine for a main meal :");
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

        if(ConsoleInputHelper.wantsAnotherPick("another Main course")){
            pickMainMeal(order);
        }
    }

    static void pickDessert(Order order) throws Exception {
        boolean validChoice;
        int choice;
        Cuisine cuisine;

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

        if(ConsoleInputHelper.wantsAnotherPick("another Dessert")){
            pickDessert(order);
        }
    }

    static void pickDrink(Order order) throws Exception {
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

        if(ConsoleInputHelper.wantsAnotherPick("another Drink")){
            pickDrink(order);
        }
    }
}
