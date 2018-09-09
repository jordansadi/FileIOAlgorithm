package us.mattgreen.Test;
import org.junit.*;
import us.mattgreen.MealsArray;
import us.mattgreen.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MainTest extends junit.framework.TestCase {
    public MainTest() {}
    MealsArray testArray;
    ArrayList<Meals> meals;

    @Before
    public void setUp() throws Exception {
        testArray = new MealsArray();
        testArray.addElementWithStrings("Breakfast", "Bagel", "200");
        meals = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    public void testPrintMenu() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        System.out.println("Select Action");
        System.out.println("1. List All Items");
        System.out.println("2. List All Items by Meal");
        System.out.println("3. Search by Meal Name");
        System.out.println("4. Exit");
        System.out.print("Please Enter your Choice: ");

        assertEquals("Select Action" + System.getProperty("line.separator")
                + "1. List All Items" + System.getProperty("line.separator")
                + "2. List All Items by Meal" + System.getProperty("line.separator")
                + "3. Search by Meal Name" + System.getProperty("line.separator")
                + "4. Exit" + System.getProperty("line.separator")
                + "Please Enter your Choice: ", os.toString());
    }

    @Test
    public void testRunMenu() {
        meals = testArray.getMeals();
        boolean end = false;
        for (int i = 1; i < 5; i++) {
            switch ((char)i) {
                case '1':
                    for (Meals item: meals) {
                        assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
                    }
                case '2':
                    for (Meals item: meals) {
                        if (item != null && item.getMealType() == MealType.BREAKFAST) {
                            assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
                        }
                    }
                case '3':
                    for (Meals item: meals) {
                        if (item != null && item.getItem().indexOf("Bagel") >= 0) {
                            assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
                        }
                    }
                case '4':
                    end = true;
                    assertTrue(end);
            }
        }
    }

    @Test
    public void testListByMeal() {
        meals = testArray.getMeals();
        for (Meals item: meals) {
            if (item != null && item.getMealType() == MealType.BREAKFAST) {
                assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
            }
        }
    }

    @Test
    public void testSearchByName() {
        meals = testArray.getMeals();
        for (Meals item: meals) {
            if (item != null && item.getItem().indexOf("Bagel") >= 0) {
                assertEquals(item.toString(), "Meals{mealType=BREAKFAST, item='Bagel', calories=200}");
            }
        }
    }
}
