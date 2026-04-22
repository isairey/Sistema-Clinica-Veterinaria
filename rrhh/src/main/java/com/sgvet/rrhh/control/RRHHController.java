package com.sgvet.rrhh.control;

import com.sgvet.rrhh.boundary.RRHHRepository;
import com.sgvet.rrhh.entity.RRHH;
import com.sgvet.rrhh.util.RRHHValidador;

import java.util.List;

public class RRHHController {

    private RRHHRepository rrhhRepository = new RRHHRepository();

    public Boolean crearRRHH(RRHH RRHH) {
        try {
            // rrhhRepository.insertar(RRHH);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<RRHH> listarRRHHes() {
        return rrhhRepository.listarTodos();
    }

    public void eliminarRRHH(int id) {
        // rrhhRepository.eliminarPorId(id);
    }

    public RRHH buscarRRHH(int id) {
        List<RRHH> lista = rrhhRepository.listarTodos();
        for (RRHH rrhh : lista) {
            if (rrhh.getId() == id) {
                return rrhh;
            }
        }
        return null; // Si no se encuentra
    }

    public boolean solicitarVacaciones(int id, String fechaInicio, String fechaFin) {
        RRHH rrhh = buscarRRHH(id);
        if (rrhh != null) {
            System.out.println("Solicitud de vacaciones:");
            System.out.println("RRHH ID: " + id);
            System.out.println("Desde: " + fechaInicio + " Hasta: " + fechaFin);
            // Aquí podrías guardar en base de datos o lista en memoria
            return true;
        }
        return false;
    }

    public boolean solicitarPermiso(int id, String motivo, String fecha) {
        RRHH rrhh = buscarRRHH(id);
        if (rrhh != null) {
            System.out.println("Solicitud de permiso:");
            System.out.println("RRHH ID: " + id);
            System.out.println("Motivo: " + motivo);
            System.out.println("Fecha: " + fecha);
            // Aquí podrías guardar en base de datos o lista en memoria
            return true;
        }
        return false;
    }

    /**
     * Actualiza los datos personales de un empleado existente
     * @param empleadoActualizado El empleado con los datos actualizados
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarEmpleado(RRHH empleadoActualizado) {
        try {
            // Validar que el empleado exista
            if (empleadoActualizado.getId() == null) {
                System.out.println("Error: El ID del empleado es requerido para la actualización");
                return false;
            }
            
            // Validar los datos del empleado
            if (!RRHHValidador.validarEmpleado(empleadoActualizado)) {
                System.out.println("Error: Los datos del empleado no son válidos");
                return false;
            }
            
            // Buscar el empleado existente
            RRHH empleadoExistente = buscarRRHH(empleadoActualizado.getId());
            if (empleadoExistente == null) {
                System.out.println("Error: No se encontró el empleado con ID " + empleadoActualizado.getId());
                return false;
            }
            
            // Actualizar en la base de datos
            rrhhRepository.actualizar(empleadoActualizado);
            
            System.out.println("Empleado actualizado exitosamente: " + empleadoActualizado.getNombre() + " " + empleadoActualizado.getApellido());
            return true;
            
        } catch (Exception e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
