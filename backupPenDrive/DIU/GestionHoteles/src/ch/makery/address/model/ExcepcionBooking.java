package ch.makery.address.model;


public class ExcepcionBooking extends Exception {
    private String mensaje;

    public ExcepcionBooking() {
    }

    /**
     *
     * @param ms
     */
    public ExcepcionBooking(String ms) {
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