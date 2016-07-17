package com.mprtcz.foodordering.cuisines;

import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-15.
 */
public class PolishCuisine implements Cuisine {

    private List<MainCourse> mainCourseList;
    private List<Dessert> dessertsList;

    public PolishCuisine() {
        createMainCourseList();
        createDessertsList();
    }

    @Override
    public String getName() {
        return "Italian Cuisine";
    }

    @Override
    public List<MainCourse> getMainCourseList() {
        return mainCourseList;
    }

    @Override
    public List<Dessert> getDessertsList() {
        return dessertsList;
    }

    private void createMainCourseList(){
        mainCourseList = new ArrayList<>();
        mainCourseList.add(new MainCourse("Polish Meal 0", "USD 1.99"));
        mainCourseList.add(new MainCourse("Polish Meal 1", "USD 2.99"));
        mainCourseList.add(new MainCourse("Polish Meal 2", "USD 1.29"));
        mainCourseList.add(new MainCourse("Polish Meal 3", "USD 2.29"));
        mainCourseList.add(new MainCourse("Polish Meal 4", "USD 3.99"));
        mainCourseList.add(new MainCourse("Polish Meal 5", "USD 2.44"));
        mainCourseList.add(new MainCourse("Polish Meal 6", "USD 5.99"));
        mainCourseList.add(new MainCourse("Polish Meal 7", "USD 2.55"));
    }

    private void createDessertsList(){
        dessertsList = new ArrayList<>();
        dessertsList.add(new Dessert("Polish Dessert 0", "USD 1.99"));
        dessertsList.add(new Dessert("Polish Dessert 1", "USD 2.99"));
        dessertsList.add(new Dessert("Polish Dessert 2", "USD 1.29"));
    }
}
