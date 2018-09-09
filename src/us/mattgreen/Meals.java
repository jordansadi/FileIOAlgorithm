package us.mattgreen;

/**
 * This class defines a Meal.
 * Created by jsadi on 9/8/2018.
 * @author Jordan Sadi
 * @version 2018 0908 .3
 */
public class Meals {
    private MealType mealType;
    private String item;
    private int calories;

    /**
     * This constructor creates an instance of a Meal using a specified MealType, item, and number of calories.
     * @param mealType MealType of the Meal.
     * @param item String the item(s) in the Meal.
     * @param calories int the number of calories in the Meal.
     */
    public Meals(MealType mealType, String item, int calories) {
        this.mealType = mealType;
        this.item = item;
        this.calories = calories;
    }

    /**
     * This method returns the MealType of a Meal.
     * @return MealType of the Meal.
     */
    public MealType getMealType() {
        return mealType;
    }

    /**
     * This method returns the item(s) in a Meal.
     * @return String the item(s) in the Meal.
     */
    public String getItem() {
        return item;
    }

    /**
     * This method returns the number of calories in the Meal.
     * @return int the number of calories in the Meal.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * This method overrides the equals() method to compare a Meal to a second, specified Meal.
     * @param o the Meal to compare.
     * @return boolean indicating whether the Meals are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meals meals = (Meals) o;

        if (getCalories() != meals.getCalories()) return false;
        if (getMealType() != meals.getMealType()) return false;
        return getItem().equals(meals.getItem());
    }

    /**
     * This method converts a Meal to a hashcode.
     * @return int the hashcode of the Meal.
     */
    @Override
    public int hashCode() {
        int result = getMealType().hashCode();
        result = 31 * result + getItem().hashCode();
        result = 31 * result + getCalories();
        return result;
    }

    /**
     * This method inputs the details of a Meal in a specifically-formatted String.
     * @return String of the Meal details.
     */
    @Override
    public String toString() {
        return "Meals{" +
                "mealType=" + mealType +
                ", item='" + item + '\'' +
                ", calories=" + calories +
                '}';
    }
}