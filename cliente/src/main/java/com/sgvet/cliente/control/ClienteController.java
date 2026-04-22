package com.sgvet.cliente.control;

import com.sgvet.cliente.boundary.ClienteRepository;
import com.sgvet.cliente.entity.Cliente;

import java.util.List;

public class ClienteController {

    private ClienteRepository clienteRepository = new ClienteRepository();
    // Aquí puedes agregar métodos para manejar las solicitudes relacionadas con los clientes
    // Por ejemplo, crear, actualizar, eliminar y listar clientes

    public Boolean crearCliente(Cliente cliente) {
        // Lógica para crear un cliente
        try{

            clienteRepository.insertar(cliente);
            return true;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> listarClientes() {
        // Lógica para listar todos los clientes
        return clienteRepository.listarTodos();
    }
    
}
