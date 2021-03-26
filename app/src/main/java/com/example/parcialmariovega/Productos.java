package com.example.parcialmariovega;

public class Productos {

    private String nombre;
    private String descripcion;
    private int fotoproducto;

    public Productos() {



    }

    public Productos(String nombre, String descripcion, int fotoproducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoproducto = fotoproducto;
    }

    public int getFotoproducto() {
        return fotoproducto;
    }

    public void setFotoproducto(int fotoproducto) {
        this.fotoproducto = fotoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
