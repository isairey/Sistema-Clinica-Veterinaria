package com.sgvet.proveedor.entity;

public class Proveedor {

    private Integer id;
    private String nombre;
    private String razonSocial;
    private String telefono;
    private String correo;

    public Proveedor() {
    }

    public Proveedor(Integer id, String nombre, String razonSocial, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return String.format("Proveedor{id=%d, nombre='%s', razonSocial='%s', telefono='%s', correo='%s'}",
                id, nombre, razonSocial, telefono, correo);
    }
}
