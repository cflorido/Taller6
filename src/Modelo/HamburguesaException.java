package Modelo;

public abstract class HamburguesaException extends Exception {
    public HamburguesaException(String errorMessage) {
        super(errorMessage);
    }
}