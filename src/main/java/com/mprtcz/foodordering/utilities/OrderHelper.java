package com.mprtcz.foodordering.utilities;

import com.mprtcz.foodordering.logger.AppLogger;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.Drink;
import com.mprtcz.foodordering.orderelements.MainCourse;
import org.joda.money.Money;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Azet on 2016-07-17.
 */
public class OrderHelper {
    private final static Logger logger = Logger.getLogger(AppLogger.class.getName());
    private static Level level = Level.CONFIG;

    private OrderHelper() {}

    public static boolean wantsLemons(String string) {
        logger.log(level, "String arg = " + string);
        return string.toLowerCase().contains("lemon");
    }

    public static boolean wantsIceCubes(String string) {
        logger.log(level, "String arg = " + string);

        return string.toLowerCase().contains("ice");
    }

    public static Money summarizePrices(List<MainCourse> orderedMainCourses, List<Dessert> orderedDesserts, List<Drink> orderedDrinks) {
        logger.log(level, "orderedMainCourses arg = " + orderedMainCourses.toString());
        logger.log(level, "orderedDesserts arg = " + orderedDesserts.toString());
        logger.log(level, "orderedDrinks arg = " + orderedDrinks.toString());

        Money totalPrice = Money.parse("USD 0");
        for (MainCourse m :
                orderedMainCourses) {
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

        logger.log(level, "Total price = " + totalPrice);
        return totalPrice;
    }

    public static String getStringItemsFromList(List<?> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object item : list){
            stringBuilder.append("\t");
            stringBuilder.append(item.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
