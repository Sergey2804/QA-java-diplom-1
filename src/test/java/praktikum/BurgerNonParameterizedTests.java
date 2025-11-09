package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.BurgerTests.*;

public class BurgerNonParameterizedTests {

    private Burger burger;
    private Bun bun;
    private Ingredient firstIngredient;
    private Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("Булочка", PRICE_OF_BUN_1);
        firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус", PRICE_OF_SAUCE_1);
        secondIngredient = new Ingredient(IngredientType.FILLING, "Начинка", PRICE_OF_FILLY_1);
    }

    @Test
    public void setBunsShouldSetCorrectBun() {
        burger.setBuns(bun);
        Assert.assertEquals("Булочка должна быть установлена", bun, burger.bun);
    }

    @Test
    public void addIngredientShouldIncreaseIngredientsCount() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(firstIngredient);

        Assert.assertEquals("Количество ингредиентов должно увеличиться на 1",
                initialSize + 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientShouldDecreaseIngredientsCount() {
        burger.addIngredient(firstIngredient);
        int sizeAfterAdd = burger.ingredients.size();

        burger.removeIngredient(0);

        Assert.assertEquals("Количество ингредиентов должно уменьшиться на 1",
                sizeAfterAdd - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldChangeIngredientPosition() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        Assert.assertEquals("Первый ингредиент должен переместиться на вторую позицию",
                firstIngredient, burger.ingredients.get(1));
    }
}