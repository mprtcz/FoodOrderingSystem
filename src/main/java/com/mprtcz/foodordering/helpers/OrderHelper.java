package com.mprtcz.foodordering.helpers;

import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;
import org.joda.money.Money;

import java.util.List;

/**
 * Created by Azet on 2016-07-17.
 */
public class OrderHelper {

    public static boolean wantsLemons(String string){
            return string.toLowerCase().contains("lemon");
    }

    public static boolean wantsIceCubes(String string){
            return string.toLowerCase().contains("ice");
    }

    public static Money summarizePrices(List<MainCourse> orderedMainCourses, List<Dessert> orderedDesserts, List<Drink> orderedDrinks){
        Money totalPrice =  Money.parse("USD 0");
        for (MainCourse m : orderedMainCourses){
            totalPrice = totalPrice.plus(m.getPrice());
        }
        for (Dessert d :
                orderedDesserts) {
            totalPrice = totalPrice.plus(d.getPrice());
        }
        for (Drink dr :
                orderedDrinks) {
            totalPrice = totalPrice.plus(dr.getPrice());
        }

        return totalPrice;
    }
}
