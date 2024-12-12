package org.example;

public class Juguete {
    private int id;
    private String nombre;

    // Constructor
    public Juguete(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Representación en formato de cadena (opcional)
    @Override
    public String toString() {
        return "Juguete{id=" + id + ", nombre='" + nombre + "'}";
    }
}
