import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private static final float DELTA = 0.001f;

    private final Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.SAUCE, "chili sauce", 300f},
                {IngredientType.FILLING, "cutlet", 100f},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.FILLING, "sausage", 300f},
        };
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), DELTA);
    }
}