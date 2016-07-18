package com.mprtcz.foodordering.interfaces;

import com.mprtcz.foodordering.availableitems.Desserts;
import com.mprtcz.foodordering.availableitems.MainCourses;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.List;

/**
 * Created by Azet on 2016-07-16.
 */
public interface Cuisine {

    String getName();

    enum CuisineOptions {
        POLISH("Polish cuisine") {
            @Override
            public List<MainCourse> getMainCourseList() {
                return MainCourses.getPolishMainCoursesList();
            }

            @Override
            public List<Dessert> getDessertsList() {
                return Desserts.getPolishDessertsList();
            }
        },
        MEXICAN("Mexican cuisine") {
            @Override
            public List<MainCourse> getMainCourseList() {
                return MainCourses.getMexicanMainCoursesList();
            }

            @Override
            public List<Dessert> getDessertsList() {
                return Desserts.getMexicanDessertsList();
            }
        },
        ITALIAN("Italian Cuisine") {
            @Override
            public List<MainCourse> getMainCourseList() {return MainCourses.getItalianMainCourseList();}

            @Override
            public List<Dessert> getDessertsList() {
                return Desserts.getItalianDessertsList();
            }
        };

        private String value;

        CuisineOptions(String value) {
            this.value = value;
        }

        public abstract List<MainCourse> getMainCourseList();
        public abstract List<Dessert> getDessertsList();

        @Override
        public String toString() {
            return value;
        }
    }
}
