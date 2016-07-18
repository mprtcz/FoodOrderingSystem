package com.mprtcz.foodordering.helpers;

import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.logger.AppLogger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Azet on 2016-07-17.
 */
public class ConsoleInputHelper {
    private final static Logger logger = Logger.getLogger(AppLogger.class.getName());
    private static Level level = Level.CONFIG;


    public static boolean validateChoice(int choice, List<?> options) {
        logger.log(level, "Choice: " + choice + " options: " + options.toString()
        );
        if (choice < 0 || choice > options.size() - 1) {
            System.out.println("Numbers only from 0 to " + (options.size() - 1) + " please. \n");
            return false;
        }
        return true;
    }

    public static int getIntegerFromSysInput() {
        logger.log(level, "");

        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException ex) {
            logger.log(level, "exception for choice = " + choice + " " + ex.toString());
            System.out.println("Only numerical values \n");
        }
        logger.log(level, "Returned choice = " + choice);
        return choice;
    }

    public static void listOutOrderOptions(List<?> options) {
        logger.log(level, "Options = " + options);

        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + ". " + options.get(i));
        }
    }

    public static void listOutCuisineOptions() {
        logger.log(level, "");

        Cuisine.CuisineOptions[] options = Cuisine.CuisineOptions.values();

        System.out.println("Pick a cuisine by typing it's number: ");

        int index = 0;
        for (Cuisine.CuisineOptions c : options) {
            logger.log(level, "c = " + c.toString());
            System.out.println(index + " " + c.toString());
            index++;
        }
    }

    public static String addonsToDrink() {
        logger.log(level, "");

        System.out.println("Do you want a lemon or ice cubes to be added to your drink?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean wantsAnotherPick(String string) {
        logger.log(level, "String arg = " + string);

        System.out.println("Would you like to order " + string + "? Yes or Y if so");
        Scanner scanner = new Scanner(System.in);
        String wantsAnother = scanner.nextLine();

        logger.log(level, "Wants Another = " + wantsAnother);
        return wantsAnother.toLowerCase().equals("yes") || wantsAnother.toLowerCase().equals("y");
    }
}
