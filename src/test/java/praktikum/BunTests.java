package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

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
                {"Bunny", 2.3f, new Bun("Bunny", 2.3f)},
                {"Булочка", 80.22f, new Bun("Булочка", 80.22f)}
        };
    }

    @Test
    public void getName() {
        Assert.assertEquals("No name", bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bunPrice, bun.getPrice(), 0f);
    }
}