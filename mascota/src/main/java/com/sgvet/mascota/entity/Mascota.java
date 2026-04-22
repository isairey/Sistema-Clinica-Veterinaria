package com.sgvet.mascota.entity;

public class Mascota {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;
    private Integer idCliente;
    private String tipoMascota;
    private String raza;

    public Mascota() {
    }

    public Mascota(Integer id, String nombre, String apellido, Integer edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Mascota(Integer id, String nombre, String apellido, Integer edad, String telefono, Integer idCliente, String tipoMascota, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.idCliente = idCliente;
        this.tipoMascota = tipoMascota;
        this.raza = raza;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', apellido='%s', edad=%d, telefono='%s'}",
                id, nombre, apellido, edad, telefono);
    }
}
