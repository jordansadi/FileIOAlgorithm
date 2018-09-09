package us.mattgreen;

/**
 * This enumeration defines the MealTypes that Meals are permitted to have.
 * Created by jsadi on 9/8/2018.
 * @author Jordan Sadi
 * @version 2018 0908 .3
 */
public enum MealType {
    BREAKFAST("Breakfast"), DESSERT("Dessert"), DINNER("Dinner"), LUNCH("Lunch");

    private String meal;

    /**
     * This constructor creates an instance of a MealType using a specified string.
     * @param meal String specifying the MealType
     */
    MealType(String meal) {
        this.meal = meal;
    }

    /**
     * This method returns a String of the MealType
     * @return String of the MealType
     */
    public String getMeal() {
        return meal;
    }
}
