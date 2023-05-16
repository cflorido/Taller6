package Modelo;

import java.util.HashMap;

import Modelo.Producto;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	private int calorias;

	public ProductoMenu(String nombre, int precio, int calorias)
	{
		this.nombre = nombre;
		this.precioBase = precio;
		this.calorias = calorias;
	}


	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getPrecio()
	{
		return precioBase;
	}
	
	public String generarTextoFactura()
	{
		String precio = "$"+ getPrecio();
		String nombre = getNombre().substring(0, 1).toUpperCase() + getNombre().substring(1);
		String x = (String.format("%-20s\t%-10s\t%s", nombre, precio, getCalorias()));
		return x;
	}



	@Override
	public int getCalorias() {
	
		return this.calorias;
	}
}

