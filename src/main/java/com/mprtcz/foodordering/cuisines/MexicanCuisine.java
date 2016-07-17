package com.mprtcz.foodordering.cuisines;

import com.mprtcz.foodordering.interfaces.Cuisine;
import com.mprtcz.foodordering.orderelements.Dessert;
import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Azet on 2016-07-15.
 */
public class MexicanCuisine implements Cuisine {

    List<MainCourse> mainCourseList;
    List<Dessert> dessertsList;

    public MexicanCuisine() {
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
        mainCourseList.add(new MainCourse("Mexican Meal 0", 1.99));
        mainCourseList.add(new MainCourse("Mexican Meal 1", 2.99));
        mainCourseList.add(new MainCourse("Mexican Meal 2", 1.29));
        mainCourseList.add(new MainCourse("Mexican Meal 3", 2.29));
        mainCourseList.add(new MainCourse("Mexican Meal 4", 3.99));
        mainCourseList.add(new MainCourse("Mexican Meal 5", 2.44));
        mainCourseList.add(new MainCourse("Mexican Meal 6", 5.99));
        mainCourseList.add(new MainCourse("Mexican Meal 7", 2.55));
    }

    private void createDessertsList(){
        dessertsList = new ArrayList<>();
        dessertsList.add(new Dessert("Mexican Dessert 0", 1.99));
        dessertsList.add(new Dessert("Mexican Dessert 1", 2.99));
        dessertsList.add(new Dessert("Mexican Dessert 2", 1.29));
    }
}
