package ch.makery.address.util;

public enum TipoHabitacion {
    DOBLE_DE_USO_INDIVIDUAL ("Doble de uso individual"),
    DOBLE ("Doble"),
    JUNIOR_SUITE ("Junior suite"),
    JUNIOR ("Junior");

    private final String name;

    TipoHabitacion(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
