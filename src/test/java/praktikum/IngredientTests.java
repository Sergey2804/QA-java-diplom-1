package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.BurgerTests.PRICE_DELTA;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTests {

    @Mock
    private Ingredient mockIngredient;

    private static final float PRICE_OF_MOCKINGREDIENT_1 = 2.5f;
    private static final float PRICE_OF_MOCKINGREDIENT_2 = 9.5f;




    @Before
    public void setUp(){}

    @Test
    public void getTypeNoParametersType() {
        IngredientType mockType = IngredientType.SAUCE;
        Mockito.when(mockIngredient.getType()).thenReturn(mockType);
        Assert.assertEquals("getType() didn't return correct ingredient type", mockType, mockIngredient.getType());
    }

    @Test
    public void getNameNoParameters() {
        Mockito.when(mockIngredient.getName()).thenReturn("Mock Ingredient");
        Assert.assertEquals("getName() didn't return correct ingredient name", "Mock Ingredient", mockIngredient.getName());
    }

    @Test
    public void getPriceNoParameters() {
        Mockito.when(mockIngredient.getPrice()).thenReturn(PRICE_OF_MOCKINGREDIENT_1);
        Assert.assertEquals("getPrice() didn't return correct price", PRICE_OF_MOCKINGREDIENT_1, mockIngredient.getPrice(), PRICE_DELTA);
    }

    @Test
    public void setTypeUpdated() {
        IngredientType updatedType = IngredientType.FILLING;
        mockIngredient.type = updatedType;
        Mockito.when(mockIngredient.getType()).thenReturn(updatedType);
        Assert.assertEquals("setType() should set correct type", updatedType, mockIngredient.getType());
    }

    @Test
    public void setNameUpdated() {
        mockIngredient.name = "Mockman";
        Mockito.when(mockIngredient.getName()).thenReturn("Mockman");
        Assert.assertEquals("setName() should set correct name", "Mockman", mockIngredient.getName());
    }

    @Test
    public void setPriceUpdated() {
        mockIngredient.price = PRICE_OF_MOCKINGREDIENT_2;
        Mockito.when(mockIngredient.getPrice()).thenReturn(PRICE_OF_MOCKINGREDIENT_2);
        Assert.assertEquals("setPrice() should set correct price", PRICE_OF_MOCKINGREDIENT_2, mockIngredient.getPrice(), PRICE_DELTA);
    }
}