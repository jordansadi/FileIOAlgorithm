package us.mattgreen.Test;
import org.junit.*;
import us.mattgreen.*;

import java.util.ArrayList;

public class MealsArrayTest extends junit.framework.TestCase {
    public MealsArrayTest() {}

    MealsArray testArray;
    ArrayList<Meals> meals;

    @Before
    public void setUp() throws Exception {
        testArray = new MealsArray();
        testArray.addElementWithStrings("Breakfast", "Bagel", "200");
        meals = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testAddElementWithStrings() {
        meals = testArray.getMeals();
        assertEquals(meals.get(0).getCalories(), 200);
        assertEquals(meals.get(0).getItem(), "Bagel");
        assertEquals(meals.get(0).getMealType(), MealType.BREAKFAST);
    }

    @Test
    public void testGetMeals() {
        assertNotSame(meals, testArray.getMeals());
        meals = testArray.getMeals();
        assertSame(meals, testArray.getMeals());
    }

    @Test
    public void testPrintAllMeals() {
        meals = testArray.getMeals();
        for (Meals item: meals) {
            if (item != null) {
                assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
            }
        }
    }

    @Test
    public void testPrintMealsByType() {
        meals = testArray.getMeals();
        for (Meals item: meals) {
            if (item != null && item.getMealType() == MealType.BREAKFAST) {
                assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
            }
        }
    }

    @Test
    public void testPrintByNameSearch() {
        meals = testArray.getMeals();
        for (Meals item: meals) {
            if (item != null && item.getItem().indexOf("Bagel") >= 0) {
                assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
            }
        }
    }
}
