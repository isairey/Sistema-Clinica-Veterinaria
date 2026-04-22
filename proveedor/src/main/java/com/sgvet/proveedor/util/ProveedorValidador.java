package com.sgvet.proveedor.util;

/**
 * Clase utilitaria para validaciones específicas de Proveedor
 * Contiene validaciones mejoradas y métodos de ayuda
 */
public class ProveedorValidador {

    /**
     * Valida el formato de un email
     * @param email Email a validar
     * @return true si el formato es válido
     */
    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        // Regex mejorado para validación de email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    /**
     * Valida el formato de un teléfono
     * @param telefono Teléfono a validar
     * @return true si el formato es válido
     */
    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return true; // El teléfono es opcional
        }
        
        // Permite números, espacios, guiones, paréntesis y +
        String telefonoRegex = "^[\\d\\s\\-\\(\\)\\+]+$";
        String soloNumeros = telefono.replaceAll("[^\\d]", "");
        
        return telefono.matches(telefonoRegex) && soloNumeros.length() >= 7 && soloNumeros.length() <= 15;
    }

    /**
     * Valida que un campo obligatorio no esté vacío
     * @param campo Valor del campo
     * @param nombreCampo Nombre del campo para el mensaje de error
     * @return true si es válido
     */
    public static boolean validarCampoObligatorio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            System.out.println("❌ Error: " + nombreCampo + " es obligatorio.");
            return false;
        }
        return true;
    }

    /**
     * Valida la longitud máxima de un campo
     * @param campo Valor del campo
     * @param longitudMaxima Longitud máxima permitida
     * @param nombreCampo Nombre del campo para el mensaje de error
     * @return true si es válido
     */
    public static boolean validarLongitudMaxima(String campo, int longitudMaxima, String nombreCampo) {
        if (campo != null && campo.length() > longitudMaxima) {
            System.out.println("❌ Error: " + nombreCampo + " no puede exceder " + longitudMaxima + " caracteres.");
            return false;
        }
        return true;
    }

    /**
     * Limpia y normaliza un string
     * @param valor String a limpiar
     * @return String limpio y normalizado
     */
    public static String limpiarString(String valor) {
        if (valor == null) return "";
        return valor.trim().replaceAll("\\s+", " ");
    }

    /**
     * Valida todos los campos de un proveedor de manera integral
     * @param nombre Nombre del proveedor
     * @param razonSocial Razón social del proveedor
     * @param telefono Teléfono del proveedor
     * @param correo Correo del proveedor
     * @return true si todos los campos son válidos
     */
    public static boolean validarTodosCampos(String nombre, String razonSocial, String telefono, String correo) {
        boolean esValido = true;

        // Validar campos obligatorios
        if (!validarCampoObligatorio(nombre, "El nombre")) {
            esValido = false;
        }
        
        if (!validarCampoObligatorio(razonSocial, "La razón social")) {
            esValido = false;
        }

        // Validar longitudes
        if (!validarLongitudMaxima(nombre, 50, "El nombre")) {
            esValido = false;
        }
        
        if (!validarLongitudMaxima(razonSocial, 100, "La razón social")) {
            esValido = false;
        }
        
        if (!validarLongitudMaxima(telefono, 20, "El teléfono")) {
            esValido = false;
        }
        
        if (!validarLongitudMaxima(correo, 100, "El correo")) {
            esValido = false;
        }

        // Validar formatos específicos
        if (telefono != null && !telefono.trim().isEmpty() && !validarTelefono(telefono)) {
            System.out.println("❌ Error: El formato del teléfono no es válido.");
            esValido = false;
        }
        
        if (correo != null && !correo.trim().isEmpty() && !validarEmail(correo)) {
            System.out.println("❌ Error: El formato del correo electrónico no es válido.");
            esValido = false;
        }

        return esValido;
    }
}
