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

@RunWith(MockitoJUnitRunner.class)
public class IngredientTests {

    @Mock
    private Ingredient mockIngredient;

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
        Mockito.when(mockIngredient.getPrice()).thenReturn(2.5f);
        Assert.assertEquals("getPrice() didn't return correct price", 2.5f, mockIngredient.getPrice(), 0.0f);
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
        mockIngredient.price = 9.5f;
        Mockito.when(mockIngredient.getPrice()).thenReturn(9.5f);
        Assert.assertEquals("setPrice() should set correct price", 9.5f, mockIngredient.getPrice(), 0.0f);
    }
}