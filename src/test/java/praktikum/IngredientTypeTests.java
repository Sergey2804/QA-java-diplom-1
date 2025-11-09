package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTests {

    @Test
    public void valuesNoParametersTypes() {
        IngredientType[] expectedValues = { IngredientType.SAUCE, IngredientType.FILLING };
        Assert.assertArrayEquals("values() should return all IngredientType constants", expectedValues, IngredientType.values());
    }

    @Test
    public void valueOfValidNameType() {
        Assert.assertEquals("valueOf('SAUCE') should return IngredientType.SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        Assert.assertEquals("valueOf('FILLING') should return IngredientType.FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfInvalidNameException() {
        IngredientType.valueOf("INVALID");
    }
}