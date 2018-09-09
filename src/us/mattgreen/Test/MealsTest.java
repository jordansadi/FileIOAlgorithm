package us.mattgreen.Test;
import org.junit.*;
import us.mattgreen.MealType;
import us.mattgreen.Meals;

public class MealsTest extends junit.framework.TestCase {
    public MealsTest() {}

    MealType mealType;
    private String item;
    private int calories;
    Meals testMeal, otherMeal;

    @Before
    public void setUp() throws Exception {
        mealType = MealType.BREAKFAST;
        item = "Bagel";
        calories = 200;
        testMeal = new Meals(mealType, item, calories);
        otherMeal = new Meals(mealType, item, calories * 2);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetMealType() {
        assertEquals(testMeal.getMealType(), MealType.BREAKFAST);
        assertNotSame(testMeal.getMealType(), MealType.DINNER);
    }

    @Test
    public void testGetItem() {
        assertEquals(testMeal.getItem(), "Bagel");
        assertNotSame(testMeal.getItem(), "Scone");
    }

    @Test
    public void testGetCalories() {
        assertEquals(testMeal.getCalories(), 200);
        assertNotSame(testMeal.getCalories(), 100);
    }

    @Test
    public void testEquals() {
        assertTrue(testMeal.equals(testMeal));
        assertFalse(testMeal.equals(otherMeal));
    }

    @Test
    public void testHashCode() {
        assertEquals(testMeal.hashCode(), 171354449);
        assertNotSame(testMeal.hashCode(), 123456789);
    }

    @Test
    public void testToString() {
        assertEquals(testMeal.toString(), "Meals{" +
                "mealType=" + mealType +
                ", item='" + item + '\'' +
                ", calories=" + calories +
                '}');
    }
}
