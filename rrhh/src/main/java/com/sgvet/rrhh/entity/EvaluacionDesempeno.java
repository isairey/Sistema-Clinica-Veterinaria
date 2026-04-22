package com.sgvet.rrhh.entity;

public class EvaluacionDesempeno {
    private int id;
    private int idEmpleado;
    private String fecha;
    private int puntualidad;
    private int atencionCliente;
    private int trabajoEquipo;
    private int responsabilidad;
    private String observaciones;

    public EvaluacionDesempeno() {}

    public EvaluacionDesempeno(int idEmpleado, String fecha, int puntualidad, int atencionCliente,
                               int trabajoEquipo, int responsabilidad, String observaciones) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.puntualidad = puntualidad;
        this.atencionCliente = atencionCliente;
        this.trabajoEquipo = trabajoEquipo;
        this.responsabilidad = responsabilidad;
        this.observaciones = observaciones;
    }

    public double getCalificacionFinal() {
        return (puntualidad + atencionCliente + trabajoEquipo + responsabilidad) / 4.0;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getPuntualidad() { return puntualidad; }
    public void setPuntualidad(int puntualidad) { this.puntualidad = puntualidad; }

    public int getAtencionCliente() { return atencionCliente; }
    public void setAtencionCliente(int atencionCliente) { this.atencionCliente = atencionCliente; }

    public int getTrabajoEquipo() { return trabajoEquipo; }
    public void setTrabajoEquipo(int trabajoEquipo) { this.trabajoEquipo = trabajoEquipo; }

    public int getResponsabilidad() { return responsabilidad; }
    public void setResponsabilidad(int responsabilidad) { this.responsabilidad = responsabilidad; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
