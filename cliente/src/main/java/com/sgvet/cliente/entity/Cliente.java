package com.sgvet.cliente.entity;

public class Cliente {

    private Integer id;

    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String apellido, Integer edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', apellido='%s', edad=%d, telefono='%s'}",
                id, nombre, apellido, edad, telefono);
    }
}
