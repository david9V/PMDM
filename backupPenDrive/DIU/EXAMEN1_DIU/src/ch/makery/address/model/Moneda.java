package ch.makery.address.model;

import javafx.beans.property.*;

public class Moneda {

    private final StringProperty nombre;

    private final IntegerProperty codigo;

    private final FloatProperty multiplicador;

    public Moneda(){
        this(null);
    }

    public Moneda(String nombre){
        this.nombre = new SimpleStringProperty(nombre);
        this.codigo = new SimpleIntegerProperty(10);
        this.multiplicador = new SimpleFloatProperty(1f);
    }

    public Moneda(StringProperty nombre, IntegerProperty codigo, FloatProperty multiplicador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.multiplicador = multiplicador;
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public int getCodigo() {
        return codigo.get();
    }

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public float getMultiplicador() {
        return multiplicador.get();
    }

    public FloatProperty multiplicadorProperty() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador.set(multiplicador);
    }
}
