package Test;


import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modelo.Pedido;
import Modelo.PrecioException;
import Modelo.Producto;
import Modelo.ProductoMenu;

public class PedidoTest {
    private Pedido pedido;

    @Before
    public void setUp() {
        pedido = new Pedido("Carol Florido", "Calle 138"); // Crear una instancia de Pedido para utilizar en las pruebas
    }

    @Test
    public void getNumeroPedidos() {
        int numeroPedidos = Pedido.getNumeroPedidos(); 
        Assert.assertEquals(0, numeroPedidos); 
    }

    @Test
    public void getIdPedido() {
        int idPedido = pedido.getIdPedido(); 
        Assert.assertTrue(idPedido >= 100); 
    }
    @Test
    public void agregarProducto() throws PrecioException {
        Producto producto = new ProductoMenu("wrap de lomo", 22000, 97); 
        pedido.agregarProducto(producto); 
        Assert.assertTrue(pedido.getproductospedido(pedido).contains(producto)); 
    }

    @Test(expected = PrecioException.class)
    public void agregarProductoPrecioSuperior() throws PrecioException {
        Producto producto = new ProductoMenu("wrap de lomo", 22000000, 97); 
        pedido.agregarProducto(producto); 
    }

    @Test
    public void getPrecioNetoPedido() throws PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 
        Producto producto2 = new ProductoMenu("ensalada mexicana", 20900, 53); 
        pedido.agregarProducto(producto1); 
        pedido.agregarProducto(producto2);
        int precioNeto = pedido.getPrecioNetoPedido();
        Assert.assertEquals(42900, precioNeto); 
    }

    @Test
    public void getCalorias() throws PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 
        Producto producto2 = new ProductoMenu("ensalada mexicana", 20900, 53);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2); 
        int calorias = pedido.getCalorias(); 
        Assert.assertEquals(150, calorias); 
    }
    @Test
    public void getPrecioTotalPedido() throws PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 
        Producto producto2 = new ProductoMenu("ensalada mexicana", 20900, 53);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioTotal = pedido.getPrecioTotalPedido();

        Assert.assertEquals(51051, precioTotal);
    }

    @Test
    public void getPrecioIVAPedido() throws PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 
        Producto producto2 = new ProductoMenu("ensalada mexicana", 20900, 53);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioIVA = pedido.getPrecioIVAPedido();

        Assert.assertEquals(8151, precioIVA);
    }

    @Test
    public void generarTextoFactura() throws PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 

        pedido.agregarProducto(producto1);
      

        String textoFactura = pedido.generarTextoFactura();

        String expectedText = "\n\n---------------------FACTURA---------------------\n\n";
        expectedText += "Nombre del cliete:  Carol Florido\n";
        expectedText += "Dirección del cliente:  Calle 138\n\n";
        expectedText += "Precio neto  .......................  $22000\n";
        expectedText += "Precio IVA  ........................  $4180\n";
        expectedText += "Precio total  ......................  $26180\n";
        expectedText += "Calorias totales  ..................  97 Calorias\n";
		expectedText += "\n---------------Productos Comprados---------------\n\n";
		expectedText += (String.format("%-20s\t%-10s\t%s", "Producto", " Precio", "Calorias  ")) +"";
		expectedText += "\n_________________________________________________\n\n";		
        expectedText += String.format("%-20s\t%-10s\t%s", "Wrap de lomo", "$22000", "97") + "\n";

        Assert.assertEquals(expectedText, textoFactura);
    }

    @Test
    public void guardarFactura() throws IOException, PrecioException {
        Producto producto1 = new ProductoMenu("wrap de lomo", 22000, 97); 
        Producto producto2 = new ProductoMenu("ensalada mexicana", 20900, 53);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        File archivo = new File("factura.txt");
        pedido.guardarFactura(archivo);

        Assert.assertTrue(archivo.exists());
        archivo.delete();
    }
}