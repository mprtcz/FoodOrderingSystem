package com.mprtcz.foodordering;

import java.util.Scanner;

/**
 * Created by Azet on 2016-07-08.
 */
public class App {
    public static void main(String[] args) {

        Order order = new Order();
        Scanner scanner;

        do {
            try {
                order.pickMainMeal();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to order another Main Course? Yes if so");
            scanner = new Scanner(System.in);
        }
        while (scanner.nextLine().toLowerCase().equals("yes"));

        do {
            try {
                order.pickDessert();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to order another dessert? Yes if so");
            scanner = new Scanner(System.in);
        }
        while (scanner.nextLine().toLowerCase().equals("yes")) ;
    }
}
