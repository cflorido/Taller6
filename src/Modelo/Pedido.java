package Modelo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Modelo.Pedido;
import Modelo.Producto;

public class Pedido{
	
		private static int numeroPedidos = 0;
		private int idPedido;
		private String nombreCliente;
		private String direccionCliente;	
		public ArrayList<Producto> itemsPedido;
	

	public Pedido(String nombreCliente, String direccionCliente)
		{
			this.idPedido = numeroPedidos+100;
			this.nombreCliente = nombreCliente;
			this.direccionCliente = direccionCliente;
			this.itemsPedido = new ArrayList<>();
		}
	


	public ArrayList<Producto> getproductospedido(Pedido pedidoencurso){

		return pedidoencurso.itemsPedido;

	}

	public static int getNumeroPedidos()
		{
			return numeroPedidos;
		}
		
	public int getIdPedido()
		{
			return idPedido;
		}
	
	public void agregarProducto(Producto nuevoItem)
		{
			this.itemsPedido.add(nuevoItem);
		}

	private int getPrecioNetoPedido()
	{
		int precio = 0;
		for (Producto elementos: itemsPedido)
		{
			precio += elementos.getPrecio();
		}
		return precio;
	}
	private int getCalorias()
	{
		int cal = 0;
		for (Producto elementos: itemsPedido)
		{
			cal += elementos.getCalorias();
		}
		return cal;
	}	
	private int getPrecioTotalPedido()
	{
		return getPrecioNetoPedido() + getPrecioIVAPedido();
	}
	
	private int getPrecioIVAPedido()
	{
		return (int)(getPrecioNetoPedido()*0.19);
	}
	
	private String generarTextoFactura() {
		String x = "\n\n---------------------FACTURA---------------------\n\n";
		x += "Nombre del cliete:  " + nombreCliente + "\n";
		x += "Dirección del cliente:  "   +direccionCliente + "\n\n";
		x += "Precio neto  .......................  $" + getPrecioNetoPedido() + "\n";
		x += "Precio IVA  ........................  $" + getPrecioIVAPedido() + "\n";
		x += "Precio total  ......................  $" + getPrecioTotalPedido() + "\n";
		x += "Calorias totales  ..................  " + getCalorias() + " Calorias\n";
		x += "\n---------------Productos Comprados---------------\n\n";
		x += (String.format("%-20s\t%-10s\t%s", "Producto", " Precio", "Calorias  ")) +"";
		x += "\n_________________________________________________\n\n";		
		for (Producto productos:itemsPedido){
			x += productos.generarTextoFactura() +"\n";
		}

		return x;
	
	}
	
	public void guardarFactura(File archivo) throws IOException
	{
	    try {
	        FileWriter writer = new FileWriter(archivo);
	        writer.write(this.generarTextoFactura());
	        writer.close();
	 
	      } catch (IOException e) {
	        System.out.println("Ha ocurrido un error");
	        e.printStackTrace();
	      }
		Pedido.numeroPedidos += 1;
	}
}
