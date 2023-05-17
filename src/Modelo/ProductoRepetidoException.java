package Modelo;

public class ProductoRepetidoException extends HamburguesaException {
    private String producto;

    public ProductoRepetidoException(String producto) {
        super("El producto " + producto + " está repetido.");
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }
}