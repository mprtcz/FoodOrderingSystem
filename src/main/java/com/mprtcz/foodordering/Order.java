package com.mprtcz.foodordering;

import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    Cuisine pickCuisine() {
        int choice = -1;
        boolean validChoice;
        Cuisine.CuisineOptions[] options = Cuisine.CuisineOptions.values();

        do {
            validChoice = true;
            System.out.println("Pick a cuisine by typing it's number: ");

            int index = 0;
            for (Cuisine.CuisineOptions c : options) {
                System.out.println(index + " " + c.toString());
                index++;
            }

            Scanner scanner = new Scanner(System.in);

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Only numerical values \n");
                validChoice = false;
            }

            if (choice < 0 || choice > options.length - 1) {
                System.out.println("Numbers only from 0 to " + (options.length - 1) + " please. \n");
                validChoice = false;
            }

        } while (!validChoice);

        System.out.println("Picked " + Cuisine.getInstance(options[choice]).getName());
        return Cuisine.getInstance(options[choice]);
    }

    void pickMainMeal() throws Exception {
        boolean validChoice;
        int choice = -1;
        Cuisine cuisine;

        cuisine = pickCuisine();

        if (cuisine == null) {
            throw new Exception("Cuisine not initialized");
        }

        do {
            System.out.println("Pick main meal by choosing it's number:");
            List<MainCourse> mealOptions = cuisine.getMainCourseList();

            listOutOrderOptions(mealOptions);

            choice = getIntegerFromSysInput();

            validChoice = validateChoice(choice, mealOptions);

            if (validChoice) {
                orderedMainCourses.add(mealOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        System.out.println("Would you like to order another Main Course? Yes if so");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().toLowerCase().equals("yes")){
            pickMainMeal();
        }
    }

    void pickDessert() throws Exception {
        boolean validChoice;
        int choice;
        Cuisine cuisine;

        cuisine = pickCuisine();

        if (cuisine == null) {
            throw new Exception("Cuisine not initialized");
        }

        do {
            System.out.println("Pick dessert by choosing it's number:");
            List<Dessert> dessertOptions = cuisine.getDessertsList();

            listOutOrderOptions(dessertOptions);

            choice = getIntegerFromSysInput();

            validChoice = validateChoice(choice, dessertOptions);

            if (validChoice) {
                orderedDesserts.add(dessertOptions.get(choice));
                validChoice = true;
            }
        } while (!validChoice);

        System.out.println("Would you like to order another Dessert? Yes if so");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().toLowerCase().equals("yes")){
            pickDessert();
        }
    }


    static boolean validateChoice(int choice, List<?> options) {

        if (choice < 0 || choice > options.size() - 1) {
            System.out.println("Numbers only from 0 to " + (options.size() - 1) + " please. \n");
            return false;
        }

        return true;
    }

    static int getIntegerFromSysInput() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Only numerical values \n");
        }
        return choice;
    }

    static void listOutOrderOptions(List<?> options){
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + ". " + options.get(i));
        }
    }
}
