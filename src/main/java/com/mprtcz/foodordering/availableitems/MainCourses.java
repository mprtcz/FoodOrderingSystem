package com.mprtcz.foodordering.availableitems;

import com.mprtcz.foodordering.orderelements.MainCourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azet on 2016-07-18.
 */
public class MainCourses {

    public static List<MainCourse> getItalianMainCourseList(){
        List<MainCourse> italianMainCourseList = new ArrayList<>();
        italianMainCourseList.add(new MainCourse("Italian Meal 0", "USD 1.99"));
        italianMainCourseList.add(new MainCourse("Italian Meal 1", "USD 2.99"));
        italianMainCourseList.add(new MainCourse("Italian Meal 2", "USD 1.29"));
        italianMainCourseList.add(new MainCourse("Italian Meal 3", "USD 2.29"));
        italianMainCourseList.add(new MainCourse("Italian Meal 4", "USD 3.99"));
        italianMainCourseList.add(new MainCourse("Italian Meal 5", "USD 2.44"));
        italianMainCourseList.add(new MainCourse("Italian Meal 6", "USD 5.99"));
        italianMainCourseList.add(new MainCourse("Italian Meal 7", "USD 2.55"));

        return italianMainCourseList;
    }

    public static List<MainCourse> getMexicanMainCoursesList(){
        List<MainCourse> mexicanMainCourseList = new ArrayList<>();
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 0", "USD 1.99"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 1", "USD 2.99"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 2", "USD 1.29"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 3", "USD 2.29"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 4", "USD 3.99"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 5", "USD 2.44"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 6", "USD 5.99"));
        mexicanMainCourseList.add(new MainCourse("Mexican Meal 7", "USD 2.55"));
        return mexicanMainCourseList;
    }

    public static List<MainCourse> getPolishMainCoursesList(){
        List<MainCourse> polishMainCourseList = new ArrayList<>();
        polishMainCourseList.add(new MainCourse("Polish Meal 0", "USD 1.99"));
        polishMainCourseList.add(new MainCourse("Polish Meal 1", "USD 2.99"));
        polishMainCourseList.add(new MainCourse("Polish Meal 2", "USD 1.29"));
        polishMainCourseList.add(new MainCourse("Polish Meal 3", "USD 2.29"));
        polishMainCourseList.add(new MainCourse("Polish Meal 4", "USD 3.99"));
        polishMainCourseList.add(new MainCourse("Polish Meal 5", "USD 2.44"));
        polishMainCourseList.add(new MainCourse("Polish Meal 6", "USD 5.99"));
        polishMainCourseList.add(new MainCourse("Polish Meal 7", "USD 2.55"));
        return polishMainCourseList;
    }
}
