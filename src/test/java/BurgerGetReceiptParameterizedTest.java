import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final String receipt;

    public BurgerGetReceiptParameterizedTest(Bun bun, Ingredient[] ingredients, String receipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.receipt = receipt;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        Bun blackBun = new Bun("black bun", 100);
        Bun whiteBun = new Bun("white bun", 200);
        Bun redBun = new Bun("red bun", 300);

        Ingredient hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient sourCream = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient chiliSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient dinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        Ingredient sausage = new Ingredient(IngredientType.FILLING, "sausage", 300);

        return new Object[][]{
                {
                        blackBun,
                        new Ingredient[]{hotSauce, cutlet, sausage},
                        String.format("(==== %s ====)%n= sauce %s =%n= filling %s =%n= filling %s =%n(==== %s ====)%n%nPrice: %f%n",
                                blackBun.getName(), hotSauce.getName(), cutlet.getName(), sausage.getName(),
                                blackBun.getName(), 700.0)
                },
                {
                        whiteBun,
                        new Ingredient[]{cutlet, sourCream, dinosaur},
                        String.format("(==== %s ====)%n= filling %s =%n= sauce %s =%n= filling %s =%n(==== %s ====)%n%nPrice: %f%n",
                                whiteBun.getName(), cutlet.getName(), sourCream.getName(), dinosaur.getName(),
                                whiteBun.getName(), 900.0)
                },
                {
                        redBun,
                        new Ingredient[]{dinosaur, sausage, chiliSauce},
                        String.format("(==== %s ====)%n= filling %s =%n= filling %s =%n= sauce %s =%n(==== %s ====)%n%nPrice: %f%n",
                                redBun.getName(), dinosaur.getName(), sausage.getName(), chiliSauce.getName(),
                                redBun.getName(), 1400.0)
                },
                {
                        blackBun,
                        new Ingredient[]{},
                        String.format("(==== %s ====)%n(==== %s ====)%n%nPrice: %f%n",
                                blackBun.getName(), blackBun.getName(), 200.0)
                }
        };
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(receipt, burger.getReceipt());
    }
}
