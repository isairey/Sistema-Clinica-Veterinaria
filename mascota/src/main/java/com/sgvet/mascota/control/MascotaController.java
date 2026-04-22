package com.sgvet.mascota.control;

import com.sgvet.mascota.boundary.MascotaRepository;
import com.sgvet.mascota.entity.Mascota;

import java.util.List;

public class MascotaController {

    private MascotaRepository mascotaRepository = new MascotaRepository();
    // Aquí puedes agregar métodos para manejar las solicitudes relacionadas con los Mascotas
    // Por ejemplo, crear, actualizar, eliminar y listar Mascotas

    public Boolean crearMascota(Mascota Mascota) {
        // Lógica para crear un Mascota
        try{

            mascotaRepository.insertar(Mascota);
            return true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Mascota> listarMascotas() {
        // Lógica para listar todos los Mascotas
        return mascotaRepository.listarTodos();
    }

    public boolean eliminarMascota(int id) {
        return mascotaRepository.eliminarPorId(id);
    }
    
}
