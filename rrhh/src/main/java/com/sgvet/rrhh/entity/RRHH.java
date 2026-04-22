package com.sgvet.rrhh.entity;

public class RRHH {

    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String cargo;      // Ejemplo: Veterinario, Asistente, etc.
    private String especialidad; // Ejemplo: Cirugía, Clínica, etc.

    public RRHH() {
    }

    public RRHH(Integer id, String nombre, String apellido, String cedula, String telefono, String correo, String cargo, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.cargo = cargo;
        this.especialidad = especialidad;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return String.format("RRHH{id=%d, nombre='%s', apellido='%s', cedula='%s', telefono='%s', correo='%s', cargo='%s', especialidad='%s'}",
                id, nombre, apellido, cedula, telefono, correo, cargo, especialidad);
    }
}
