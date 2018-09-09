package us.mattgreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the driver method for this package.
 * Created by jsadi on 9/8/2018.
 * @author Jordan Sadi
 * @version 2018 0908 .3
 */
public class Main {

    private final static FileInput indata = new FileInput("meals_data.csv");
    private static Scanner keyboard = new Scanner(System.in);
    private static MealsArray mealsArray = new MealsArray();

    public static void main(String[] args) {
        String line;
        ArrayList<String> fields;

        while ((line = indata.fileReadLine()) != null) {
            fields = new ArrayList<>(Arrays.asList(line.split(",")));
            mealsArray.addElementWithStrings(fields.get(0),fields.get(1),fields.get(2));
        }
        runMenu();
    }

    /**
     * This method prints the menu one line at a time and then waits for input from the user.
     */
    private static void printMenu() {
        System.out.println("Select Action");
        System.out.println("1. List All Items");
        System.out.println("2. List All Items by Meal");
        System.out.println("3. Search by Meal Name");
        System.out.println("4. Exit");
        System.out.print("Please Enter your Choice: ");
    }

    /**
     * This method accepts input from the user and then runs a specified method based on the input.
     */
    private static void runMenu() {
        char ans;
        boolean userContinue = true;
        while(userContinue) {
            printMenu();
            ans = keyboard.next().charAt(0);
            switch(ans) {
                case '1':   mealsArray.printAllMeals();break;
                case '2':   listByMeal();break;
                case '3':   searchByName();break;
                case '4':   userContinue=false;break;
            }
        }
    }

    /**
     * This method accepts a specified type of meal from the user and prints all Meals of that type.
     */
    private static void listByMeal() {
        char ans;
        int ansNum=0;
        MealType mealType;
        ArrayList<MealType> mealTypeName = new ArrayList<>();

        System.out.println("Which Meal Type");
        int i=0;

        for(MealType m : MealType.values())
        {
            if (i < MealType.values().length) {
                i++;
                mealTypeName.add(m);
                System.out.println(i + ") "+ m.getMeal());
            }
            else {
                System.out.println("Too Many Meal Types " + m.getMeal() + " not included.");
            }
        }
        System.out.print("Please Enter your Choice: ");
        ans = keyboard.next().charAt(0);
        if (Character.isDigit(ans)) {
            ansNum = Character.getNumericValue(ans);
            mealType = mealTypeName.get(ansNum-1);
        }
        else {
            mealType = MealType.DINNER;
            System.out.println("Invalid Meal Type " + ans + ", defaulted to " + mealType.getMeal() + ".");
        }
        mealsArray.printMealsByType(mealType);
    }

    /**
     * This method accepts input from the user, then searches for and prints all Meals containing that specified term.
     */
    private static void searchByName() {
        keyboard.nextLine();
        System.out.print("Please Enter Value: ");
        String ans = keyboard.nextLine();
        mealsArray.printByNameSearch(ans);
    }
}