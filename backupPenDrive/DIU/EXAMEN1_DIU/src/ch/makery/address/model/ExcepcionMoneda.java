package ch.makery.address.model;

public class ExcepcionMoneda extends Exception {
    private String mensaje;

    public ExcepcionMoneda() {
    }

    public ExcepcionMoneda(String ms) {
        this.mensaje = ms;
    }

    public String imprimirMensaje() {
        return this.mensaje;
    }
}
