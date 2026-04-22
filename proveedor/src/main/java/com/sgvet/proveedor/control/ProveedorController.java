package com.sgvet.proveedor.control;

import java.util.ArrayList;
import java.util.List;

import com.sgvet.proveedor.boundary.ProveedorRepository;
import com.sgvet.proveedor.entity.Proveedor;
import com.sgvet.proveedor.util.ProveedorValidador;

public class ProveedorController {

    private ProveedorRepository proveedorRepository = new ProveedorRepository();
    // Aquí puedes agregar métodos para manejar las solicitudes relacionadas con los Proveedors
    // Por ejemplo, crear, actualizar, eliminar y listar Proveedors

    public Boolean crearProveedor(Proveedor Proveedor) {
        // Lógica para crear un Proveedor
        try{

            proveedorRepository.insertar(Proveedor);
            return true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Proveedor> listarProveedores() {
        // Lógica para listar todos los Proveedors
        return proveedorRepository.listarTodos();
    }

    public Proveedor buscarProveedorPorId(Integer id) {
        // Lógica para buscar un proveedor por ID
        try {
            return proveedorRepository.buscarPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean editarProveedor(Proveedor proveedor) {
        // Lógica para editar un proveedor existente
        try {
            // Primero verificamos que el proveedor existe
            Proveedor proveedorExistente = proveedorRepository.buscarPorId(proveedor.getId());
            if (proveedorExistente == null) {
                System.out.println("Error: El proveedor con ID " + proveedor.getId() + " no existe.");
                return false;
            }
            
            // Si existe, procedemos con la actualización
            return proveedorRepository.actualizar(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Proveedor> buscarProveedoresPorNombre(String nombre) {
        // Lógica para buscar proveedores por nombre
        try {
            return proveedorRepository.buscarPorNombre(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean validarDatosProveedor(Proveedor proveedor) {
        // Usar la clase utilitaria para validaciones mejoradas
        boolean esValido = ProveedorValidador.validarTodosCampos(
            proveedor.getNombre(),
            proveedor.getRazonSocial(),
            proveedor.getTelefono(),
            proveedor.getCorreo()
        );
        
        // Validar que el correo no esté duplicado en otro proveedor
        if (esValido && proveedor.getCorreo() != null && !proveedor.getCorreo().trim().isEmpty()) {
            if (proveedorRepository.existeCorreoEnOtroProveedor(proveedor.getCorreo(), proveedor.getId())) {
                System.out.println("❌ Error: Ya existe otro proveedor con este correo electrónico.");
                esValido = false;
            }
        }
        
        return esValido;
    }

    public Boolean editarProveedorMejorado(Proveedor proveedorActualizado) {
        try {
            // Verificar que el proveedor existe
            Proveedor proveedorExistente = proveedorRepository.buscarPorId(proveedorActualizado.getId());
            if (proveedorExistente == null) {
                System.out.println("❌ Error: El proveedor con ID " + proveedorActualizado.getId() + " no existe.");
                return false;
            }
            
            // Limpiar y normalizar los datos antes de guardar
            Proveedor proveedorLimpio = new Proveedor(
                proveedorActualizado.getId(),
                ProveedorValidador.limpiarString(proveedorActualizado.getNombre()),
                ProveedorValidador.limpiarString(proveedorActualizado.getRazonSocial()),
                ProveedorValidador.limpiarString(proveedorActualizado.getTelefono()),
                ProveedorValidador.limpiarString(proveedorActualizado.getCorreo())
            );
            
            // Validar los datos antes de actualizar
            if (!validarDatosProveedor(proveedorLimpio)) {
                return false;
            }
            
            // Realizar la actualización
            return proveedorRepository.actualizar(proveedorLimpio);
            
        } catch (Exception e) {
            System.out.println("❌ Error inesperado al editar el proveedor: " + e.getMessage());
            return false;
        }
    }

    public Proveedor registrarProveedor(Proveedor proveedor){
        proveedorRepository.insertar(proveedor);
        return proveedor;
    }
    
}
