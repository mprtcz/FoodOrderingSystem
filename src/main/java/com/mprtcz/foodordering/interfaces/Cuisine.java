package com.mprtcz.foodordering.interfaces;

import com.mprtcz.foodordering.cuisines.ItalianCuisine;
import com.mprtcz.foodordering.cuisines.MexicanCuisine;
import com.mprtcz.foodordering.cuisines.PolishCuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.List;

/**
 * Created by Azet on 2016-07-16.
 */
public interface Cuisine {
    String getName();

    List<MainCourse> getMainCourseList();
    List<Dessert> getDessertsList();


    enum CuisineOptions{
        POLISH("Polish cuisine"),
        MEXICAN("Mexican cuisine"),
        ITALIAN("Italian Cuisine");

        private String value;

        CuisineOptions(String value){
            this.value = value;
        }

        @Override
        public String toString(){
            return value;
        }
    }


    static Cuisine getInstance(CuisineOptions cuisine){
        switch(cuisine){
            case POLISH:
                return new PolishCuisine();
            case MEXICAN:
                return new MexicanCuisine();
            case ITALIAN:
                return new ItalianCuisine();
            default:
                return new PolishCuisine();
        }
    }
}
