package us.mattgreen.Test;
import org.junit.*;
import us.mattgreen.MealType;

public class MealTypeTest extends junit.framework.TestCase {
    public MealTypeTest() {}

    MealType testMeal;

    @Before
    public void setUp() throws Exception {
        testMeal = MealType.DESSERT;
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetMeal() {
        assertEquals(testMeal, MealType.DESSERT);
        assertNotSame(testMeal, MealType.DINNER);
    }
}
