package com.mprtcz.foodordering;

import com.mprtcz.foodordering.drinks.Drinks;
import com.mprtcz.foodordering.helpers.OrderHelper;
import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Azet on 2016-07-08.
 */
public class Order {
    List<MainCourse> orderedMainCourses;
    List<Dessert> orderedDesserts;
    List<Drink> orderedDrinks;

    public Order() {
        orderedMainCourses = new ArrayList<>();
        orderedDesserts = new ArrayList<>();
        orderedDrinks = new ArrayList<>();

    }

    private Cuisine pickCuisine() {
        int choice;
        boolean validChoice;
        List<Cuisine.CuisineOptions> cuisineOptions = new ArrayList<>(Arrays.asList(Cuisine.CuisineOptions.values()));

        do {
            OrderHelper.listOutCuisineOptions();

            choice = OrderHelper.getIntegerFromSysInput();

            validChoice = OrderHelper.validateChoice(choice, cuisineOptions);

        } while (!validChoice);

        System.out.println("Picked " + Cuisine.getInstance(cuisineOptions.get(choice)).getName());
        return Cuisine.getInstance(cuisineOptions.get(choice));
    }

    void pickMainMeal() throws Exception {
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

            OrderHelper.listOutOrderOptions(mealOptions);

            choice = OrderHelper.getIntegerFromSysInput();

            validChoice = OrderHelper.validateChoice(choice, mealOptions);

            if (validChoice) {
                orderedMainCourses.add(mealOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        System.out.println("Would you like to order another Main Course? Yes or Y if so");
        Scanner scanner = new Scanner(System.in);
        String wantsAnother = scanner.nextLine();
        if(wantsAnother.toLowerCase().equals("yes") || wantsAnother.toLowerCase().equals("y")){
            pickMainMeal();
        }
    }

    void pickDessert() throws Exception {
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

            OrderHelper.listOutOrderOptions(dessertOptions);

            choice = OrderHelper.getIntegerFromSysInput();

            validChoice = OrderHelper.validateChoice(choice, dessertOptions);

            if (validChoice) {
                orderedDesserts.add(dessertOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        System.out.println("Would you like to order another Dessert? Yes or Y if so");
        Scanner scanner = new Scanner(System.in);
        String wantsAnother = scanner.nextLine();
        if(wantsAnother.toLowerCase().equals("yes") || wantsAnother.toLowerCase().equals("y")){
            pickDessert();
        }
    }

    void pickDrink() throws Exception {
        boolean validChoice;
        int choice;

        do {
            System.out.println("Pick a drink by choosing it's number:");
            List<Drink> drinkOptions = Drinks.getDrinksList();

            OrderHelper.listOutOrderOptions(drinkOptions);

            choice = OrderHelper.getIntegerFromSysInput();

            validChoice = OrderHelper.validateChoice(choice, drinkOptions);

            if (validChoice) {
                Drink drink = drinkOptions.get(choice);
                String addons = OrderHelper.addonsToDrink();
                drink.wantsLemon(OrderHelper.wantsLemons(addons));
                drink.wantsIce(OrderHelper.wantsIceCubes(addons));

                orderedDrinks.add(drink);
                validChoice = true;
            }
        } while (!validChoice);

        System.out.println("Would you like to order another Drink? Yes or Y if so");
        Scanner scanner = new Scanner(System.in);
        String wantsAnother = scanner.nextLine();
        if(wantsAnother.toLowerCase().equals("yes") || wantsAnother.toLowerCase().equals("y")){
            pickDrink();
        }
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
