package Modelo;

public class PrecioException extends HamburguesaException{

    public PrecioException(int i) {
        super("Se tiene un precio de " + i + ", el limite es de 150.000");
    }
    
}
