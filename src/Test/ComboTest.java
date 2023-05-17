package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modelo.Combo;
import Modelo.ProductoMenu;

import java.util.ArrayList;

public class ComboTest {
    private Combo combo;

    @Before
    public void setUp() {
        combo = new Combo("combo corral", 0.1); 
    }

    @Test
    public void agregarItemCombo() {
        ProductoMenu productoMenu = new ProductoMenu("corral queso", 150, 500);
        combo.agregarItemCombo(productoMenu); 
        ArrayList<ProductoMenu> itemsCombo = combo.getItems(); 
        Assert.assertEquals(1, itemsCombo.size()); 
        Assert.assertEquals(productoMenu, itemsCombo.get(0));
    }

    @Test
    public void generarTextoFactura() {
        ProductoMenu productoMenu1 = new ProductoMenu("mexicana", 22000, 98);
        ProductoMenu productoMenu2 = new ProductoMenu("criolla", 22000, 56);
        combo.agregarItemCombo(productoMenu1);
        combo.agregarItemCombo(productoMenu2);

        String textoFactura = combo.generarTextoFactura(); 
        String expectedText = "Combo corral        	$39600    	154"; 
        Assert.assertEquals(expectedText, textoFactura); 
    }


    @Test
    public void getCalorias() {
        ProductoMenu productoMenu1 = new ProductoMenu("mexicana", 22000, 98);
        ProductoMenu productoMenu2 = new ProductoMenu("criolla", 22000, 56);
        combo.agregarItemCombo(productoMenu1);
        combo.agregarItemCombo(productoMenu2);

        int calorias = combo.getCalorias(); 
        Assert.assertEquals(154, calorias); 
}

}