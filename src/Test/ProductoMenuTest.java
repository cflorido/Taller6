package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modelo.ProductoMenu;

public class ProductoMenuTest {
    private ProductoMenu productoMenu;

    @Before
    public void setUp() {
        productoMenu = new ProductoMenu("costeña", 20000, 90); 
    }



    @Test
    public void generarTextoFactura() {
        String textoFactura = productoMenu.generarTextoFactura(); 
        String expectedText = "Costeña             	$20000    	90"; 
        Assert.assertEquals(expectedText, textoFactura); 
    }

    @Test
    public void getCalorias() {
        int calorias = productoMenu.getCalorias(); 
        Assert.assertEquals(90, calorias); 
    }
}
