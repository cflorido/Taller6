package Modelo;

public class IngredienteRepetidoException extends HamburguesaException {
    private String ingrediente;

    public IngredienteRepetidoException(String ingrediente) {
        super("El ingrediente " + ingrediente + " está repetido.");
        this.ingrediente = ingrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }
}
