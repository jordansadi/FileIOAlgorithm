package us.mattgreen;

import java.util.ArrayList;

/**
 * This method creates, updates, and accesses an ArrayList of Meals.
 * Created by jsadi on 9/8/2018.
 * @author Jordan Sadi
 * @version 2018 0908 .3
 */
public class MealsArray {
    private ArrayList<Meals> meals = new ArrayList<>(100);
    private int i = 0;
    private int calories;

    /**
     * This method adds a Meal to the ArrayList using a specified type, item, and number of calories.
     * The method defaults to a 100-calorie Dinner if the specified inputs are not in the correct format.
     * @param arg1 String the specified MealType.
     * @param arg2 String the specified item(s) in the Meal.
     * @param arg3 String the specified number of calories in the Meal.
     */
    public void addElementWithStrings(String arg1, String arg2, String arg3) {
        MealType mealType;
        if (i <= meals.size()) {

            switch (arg1) {
                case "Breakfast":
                    mealType = MealType.BREAKFAST;
                    break;
                case "Lunch":
                    mealType = MealType.LUNCH;
                    break;
                case "Dinner":
                    mealType = MealType.DINNER;
                    break;
                case "Dessert":
                    mealType = MealType.DESSERT;
                    break;
                default:
                    mealType = MealType.DINNER;
                    System.out.println("Invalid Meal Type " + arg1 + ", defaulted to Dinner.");
            }

            if (arg3.matches("-?\\d+(\\.\\d+)?")) {
                calories = Integer.parseInt(arg3);
            } else {
                calories = 100;
                System.out.println("Invalid Calories " + arg3 + ", defaulted to 100.");
            }
            meals.add(new Meals(mealType, arg2, calories));
        }
        else {
            System.out.println("Items exceeded system size.  File has " + i + ", while the system can only handle " + meals.size() + ".");
        }
    }

    /**
     * This method returns the full ArrayList of Meals.
     * @return ArrayList the full list of Meals.
     */
    public ArrayList<Meals> getMeals() {
        return meals;
    }

    /**
     * This method prints all Meals in the ArrayList.
     */
    public void printAllMeals() {
        for (Meals item: meals) {
            if (item != null) {
                System.out.println(item);
            }

        }
    }

    /**
     * This method searches the ArrayList for all Meals for a specified MealType and prints them.
     * @param mealType the specified MealType fo search for.
     */
    public void printMealsByType(MealType mealType) {
        for (Meals item: meals) {
            if (item != null && item.getMealType() == mealType) {
                System.out.println(item);
            }

        }
    }

    /**
     * This method searches the ArrayList for a specified String and prints all Meals that contain that String.
     * @param s String the specified word to search for.
     */
    public void printByNameSearch(String s) {
        for (Meals item: meals) {
            if (item != null && item.getItem().indexOf(s) >= 0) {
                System.out.println(item);
            }

        }
    }
}
