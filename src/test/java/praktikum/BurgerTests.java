package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTests {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsBunGetsCorrectBun() {
        Bun bun = new Bun("Булочка", 3.5f);
        burger.setBuns(bun);
        Assert.assertEquals("Булочек нет", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Saucy", 3.5f);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Добавлено больше одного ингредиента", 1, burger.ingredients.size());
        Assert.assertEquals("Добавлен несуществующий ингредиент", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Saucy", 2.5f);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Добавлено больше одного ингредиента", 1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент не удален", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Saucy", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Filly", 6.5f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент перемещён в неправильное положение", ingredient1, burger.ingredients.get(1));
        Assert.assertEquals("Ингредиент перемещён в неправильное положение", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBunTwoIngredients() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Saucy", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Filly", 6.5f);
        Bun bun = new Bun("Булочка", 5f);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(19f, burger.getPrice(), 0f);
    }

    @Test
    public void getReceiptBunTwoIngredients() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Соус", 10.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Начинки", 11.5f);
        Bun bun = new Bun("Булочка", 10f);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName())
                + String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName()) + String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(),
                ingredient2.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", 42f);
        Assert.assertEquals("Рецепты отличаются", expectedReceipt, burger.getReceipt());
    }
}