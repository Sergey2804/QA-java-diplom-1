package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerTests {

    private Burger burger;

    // Параметры для тестов
    private final Bun bun;
    private final Ingredient firstIngredient;
    private final Ingredient secondIngredient;
    private final float expectedTotalPrice;
    private final String testDescription;
    static final float PRICE_DELTA = 0.0f;
    static final float PRICE_OF_BUN_1 = 3.5f;
    static final float PRICE_OF_BUN_2 = 5f;
    static final float PRICE_OF_BUN_3 = 10f;
    static final float PRICE_OF_SAUCE_1 = 3.5f;
    static final float PRICE_OF_SAUCE_2 = 2.5f;
    static final float PRICE_OF_SAUCE_3 = 10.5f;
    static final float PRICE_OF_FILLY_1 = 6.5f;
    static final float PRICE_OF_FILLY_2 = 11.5f;

    public BurgerTests(Bun bun, Ingredient firstIngredient, Ingredient secondIngredient,
                       float expectedTotalPrice, String testDescription) {
        this.bun = bun;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.expectedTotalPrice = expectedTotalPrice;
        this.testDescription = testDescription;
    }

    @Parameterized.Parameters(name = "{4}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {
                        new Bun("Булочка", PRICE_OF_BUN_1),
                        new Ingredient(IngredientType.SAUCE, "Saucy", PRICE_OF_SAUCE_1),
                        new Ingredient(IngredientType.FILLING, "Filly", PRICE_OF_FILLY_1),
                        17f,
                        "Булочка 3.5 + соус 3.5 + начинка 6.5"
                },
                {
                        new Bun("Белая булочка", PRICE_OF_BUN_3),
                        new Ingredient(IngredientType.SAUCE, "Соус", PRICE_OF_SAUCE_3),
                        new Ingredient(IngredientType.FILLING, "Начинки", PRICE_OF_FILLY_2),
                        42f,
                        "Булочка 10.0 + соус 10.5 + начинка 11.5"
                },
                {
                        new Bun("Черная булочка", PRICE_OF_BUN_2),
                        new Ingredient(IngredientType.SAUCE, "Кетчуп", PRICE_OF_SAUCE_2),
                        new Ingredient(IngredientType.FILLING, "Котлета", PRICE_OF_FILLY_1),
                        19f,
                        "Булочка 5.0 + кетчуп 2.5 + котлета 6.5"
                }
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void getPriceShouldCalculateCorrectTotalPrice() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        float actualPrice = burger.getPrice();
        Assert.assertEquals("Общая цена должна корректно рассчитываться: " + testDescription,
                expectedTotalPrice, actualPrice, PRICE_DELTA);
    }

    @Test
    public void getReceiptShouldReturnCorrectFormat() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expectedReceipt = buildExpectedReceipt();
        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Чек должен быть сформирован корректно: " + testDescription,
                expectedReceipt, actualReceipt);
    }

    private String buildExpectedReceipt() {
        return String.format("(==== %s ====)%n", bun.getName())
                + String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), firstIngredient.getName())
                + String.format("= %s %s =%n", secondIngredient.getType().toString().toLowerCase(), secondIngredient.getName())
                + String.format("(==== %s ====)%n", bun.getName())
                + String.format("%nPrice: %f%n", expectedTotalPrice);
    }
}