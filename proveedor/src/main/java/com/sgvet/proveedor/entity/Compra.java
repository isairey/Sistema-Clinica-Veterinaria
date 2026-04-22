package com.sgvet.proveedor.entity;

import java.time.LocalDate;

public class Compra {
    private int id;
    private int proveedorId;
    private LocalDate fecha;
    private double montoTotal;
    private String descripcion;

    public Compra(int id, int proveedorId, LocalDate fecha, double montoTotal, String descripcion) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
    }

    public int getId() { return id; }
    public int getProveedorId() { return proveedorId; }
    public LocalDate getFecha() { return fecha; }
    public double getMontoTotal() { return montoTotal; }
    public String getDescripcion() { return descripcion; }

    public void setId(int id) { this.id = id; }
    public void setProveedorId(int proveedorId) { this.proveedorId = proveedorId; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
