package ch.makery.address.model;


public class ExcepcionClient extends Exception {
    private String mensaje;

    public ExcepcionClient() {
    }

    /**
     *
     * @param ms
     */
    public ExcepcionClient(String ms) {
        this.mensaje = ms;
    }

    /**
     *
     * @return
     */
    public String imprimirMensaje() {
        return this.mensaje;
    }
}