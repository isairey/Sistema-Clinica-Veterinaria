package com.sgvet.rrhh.util;

import com.sgvet.rrhh.entity.RRHH;

public class RRHHValidador {
    
    /**
     * Valida que los campos obligatorios del empleado no estén vacíos
     * @param empleado El empleado a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarCamposObligatorios(RRHH empleado) {
        if (empleado == null) {
            return false;
        }
        
        // Validar campos obligatorios
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            return false;
        }
        
        if (empleado.getApellido() == null || empleado.getApellido().trim().isEmpty()) {
            return false;
        }
        
        if (empleado.getCedula() == null || empleado.getCedula().trim().isEmpty()) {
            return false;
        }
        
        if (empleado.getCargo() == null || empleado.getCargo().trim().isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Valida el formato del correo electrónico
     * @param correo El correo a validar
     * @return true si el formato es válido, false en caso contrario
     */
    public static boolean validarFormatoCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return true; // El correo es opcional
        }
        
        // Validación básica de formato de correo
        return correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    /**
     * Valida el formato del teléfono
     * @param telefono El teléfono a validar
     * @return true si el formato es válido, false en caso contrario
     */
    public static boolean validarFormatoTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return true; // El teléfono es opcional
        }
        
        // Validación más flexible de formato de teléfono (permite guiones)
        return telefono.matches("^[0-9-]{7,15}$");
    }
    
    /**
     * Valida que la cédula tenga el formato correcto
     * @param cedula La cédula a validar
     * @return true si el formato es válido, false en caso contrario
     */
    public static boolean validarFormatoCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return false;
        }
        
        // Validación más flexible de formato de cédula (7-10 dígitos)
        return cedula.matches("^[0-9]{7,10}$");
    }
    
    /**
     * Valida todos los campos del empleado
     * @param empleado El empleado a validar
     * @return true si todos los campos son válidos, false en caso contrario
     */
    public static boolean validarEmpleado(RRHH empleado) {
        if (!validarCamposObligatorios(empleado)) {
            return false;
        }
        
        if (!validarFormatoCedula(empleado.getCedula())) {
            return false;
        }
        
        if (!validarFormatoCorreo(empleado.getCorreo())) {
            return false;
        }
        
        if (!validarFormatoTelefono(empleado.getTelefono())) {
            return false;
        }
        
        return true;
    }
} 