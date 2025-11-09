package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static praktikum.BurgerTests.*;

@RunWith(Parameterized.class)
public class BunTests {

    private final String bunName;
    private final float bunPrice;
    private final Bun bun;

    public BunTests(String bunName, float bunPrice, Bun bun) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.bun = bun;
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"Bunny", PRICE_OF_BUN_1, new Bun("Bunny", PRICE_OF_BUN_1)},
                {"Булочка", PRICE_OF_BUN_3, new Bun("Булочка", PRICE_OF_BUN_3)}
        };
    }

    @Test
    public void getName() {
        Assert.assertEquals("No name", bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bunPrice, bun.getPrice(), PRICE_DELTA);
    }
}