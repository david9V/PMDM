package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Client {

    private final IntegerProperty id;
    private final StringProperty dni;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty address;
    private final StringProperty city;
    private final StringProperty province;

    /**
     * Default constructor.
     */
    public Client() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Client(String firstName, String lastName) {
        this.id = new SimpleIntegerProperty(123);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Random data to test
        this.dni = new SimpleStringProperty("12345678A");
        this.address = new SimpleStringProperty("Dirección cualquiera");
        this.city = new SimpleStringProperty("Localidad cualquiera");
        this.province = new SimpleStringProperty("Provincia cualquiera");
    }

    public Client(IntegerProperty id, StringProperty firstName, StringProperty lastName, StringProperty dni, StringProperty address, StringProperty city, StringProperty province) {
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
    }

    public Client(String dni){
        this.dni = new SimpleStringProperty(dni);
        this.id = new SimpleIntegerProperty(123);
        this.firstName = new SimpleStringProperty("aa");
        this.lastName = new SimpleStringProperty("aa");

        // Random data to test
        this.address = new SimpleStringProperty("Dirección cualquiera");
        this.city = new SimpleStringProperty("Localidad cualquiera");
        this.province = new SimpleStringProperty("Provincia cualquiera");

    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getDni() {
        return this.dni.get();
    }

    public void setDni(String dni){
        this.dni.set(dni);
    }

    public StringProperty dniProperty() {
        return dni;
    }

    public String getAdress() {
        return this.address.get();
    }

    public void setAddress(String address){
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getCity() {
        return this.city.get();
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getProvince() {
        return this.province.get();
    }

    public void setProvince(String province){
        this.province.set(province);
    }

    public StringProperty provinceProperty() {
        return province;
    }

    public void setId(int id){
        this.id.set(id);
    }

    public int getId(){
        return this.id.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        boolean e = this.dni.getValue().equals(client.dni.getValue());
        return e;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}