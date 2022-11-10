package ch.makery.address.util;

public enum Regimen {
    ALOJAMIENTO_Y_DESAYUNO ("Alojamiento y desayuno"),
    MEDIA_PENSION ("Media pensión"),
    PENSION_COMPLETA ("Pensión completa");

    private final String name;
    Regimen(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
