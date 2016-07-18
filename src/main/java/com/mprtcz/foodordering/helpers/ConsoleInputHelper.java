package com.mprtcz.foodordering.helpers;

import com.mprtcz.foodordering.interfaces.Cuisine;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Azet on 2016-07-17.
 */
public class ConsoleInputHelper {

    public static boolean validateChoice(int choice, List<?> options) {

        if (choice < 0 || choice > options.size() - 1) {
            System.out.println("Numbers only from 0 to " + (options.size() - 1) + " please. \n");
            return false;
        }

        return true;
    }

    public static int getIntegerFromSysInput() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Only numerical values \n");
        }
        return choice;
    }

    public static void listOutOrderOptions(List<?> options){
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + ". " + options.get(i));
        }
    }

    public void soutPickedCuisine(Cuisine cuisine){
        System.out.println("Picked " + cuisine.getName());
    }

    public static void listOutCuisineOptions(){
        Cuisine.CuisineOptions[] options = Cuisine.CuisineOptions.values();

        System.out.println("Pick a cuisine by typing it's number: ");

        int index = 0;
        for (Cuisine.CuisineOptions c : options) {
            System.out.println(index + " " + c.toString());
            index++;
        }
    }

    public static String addonsToDrink(){
        System.out.println("Do you want a lemon or ice cubes to be added to your drink?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean wantsAnotherPick(String string){
        System.out.println("Would you like to order " + string +"? Yes or Y if so");
        Scanner scanner = new Scanner(System.in);
        String wantsAnother = scanner.nextLine();

        return wantsAnother.toLowerCase().equals("yes") || wantsAnother.toLowerCase().equals("y");
    }
}