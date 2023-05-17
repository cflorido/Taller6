package Test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modelo.Ingrediente;
import Modelo.IngredienteRepetidoException;
import Modelo.Producto;
import Modelo.ProductoAjustado;
import Modelo.ProductoMenu;

public class ProductoAjustadoTest {
    private ProductoAjustado productoAjustado;

    @Before
    public void setUp() {
        Producto base = new ProductoMenu("corral queso", 16000, 47); 
        productoAjustado = new ProductoAjustado(base); 
    }



    @Test
    public void getPrecio() {
        Ingrediente ingrediente = new Ingrediente("lechuga", 1000, 20); 
        productoAjustado.agregarIngrediente(ingrediente); 
        int precio = productoAjustado.getPrecio(); 
        Assert.assertEquals(16000+1000, precio); 
    }

    @Test
    public void agregarIngrediente() {
        Ingrediente ingrediente = new Ingrediente("lechuga", 1000, 20); 
        productoAjustado.agregarIngrediente(ingrediente); 
        Assert.assertTrue(productoAjustado.getingredientes(productoAjustado).contains(ingrediente)); 
    }


    

    @Test
    public void eliminarIngrediente() {
        Ingrediente ingrediente = new Ingrediente("lechuga", 1000, 20); 
        productoAjustado.agregarIngrediente(ingrediente); 
        productoAjustado.eliminarIngrediente(0, ingrediente); 
        Assert.assertFalse(productoAjustado.getingredientes(productoAjustado).contains(ingrediente)); 
    }


    @Test
    public void generarTextoFactura() {

        Ingrediente ingrediente = new Ingrediente("lechuga", 1000, 20); 
        productoAjustado.agregarIngrediente(ingrediente); 
        String textoFactura = productoAjustado.generarTextoFactura(); 
        String expectedText = "Corral queso        	$17000    	67"; 
        Assert.assertEquals(expectedText, textoFactura); 
    }

    @Test
    public void getCalorias() {
        Ingrediente ingrediente = new Ingrediente("lechuga", 1000, 20); 
        productoAjustado.agregarIngrediente(ingrediente); 
        int calorias = productoAjustado.getCalorias(); 
        Assert.assertEquals(67, calorias); 
    }
    }