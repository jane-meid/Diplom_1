import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final float price;
    private static final float DELTA = 0.001f;

    public BurgerGetPriceTest(Bun bun, Ingredient[] ingredients, float price) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        Bun bun = Mockito.mock(Bun.class);
        when(bun.getPrice()).thenReturn(50f);

        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(35f);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(45f);

        return Arrays.asList(new Object[][]{
                {bun, new Ingredient[]{}, 100f},
                {bun, new Ingredient[]{ingredient1}, 135f},
                {bun, new Ingredient[]{ingredient1, ingredient2}, 180f}
        });
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(price, burger.getPrice(), DELTA);
    }
}
