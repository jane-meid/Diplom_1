import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private static final float DELTA = 0.001f;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f}
        });
    }
    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Имя булочки не совпадает", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Цена булочки не совпадает", price, bun.getPrice(), DELTA);
    }
}
