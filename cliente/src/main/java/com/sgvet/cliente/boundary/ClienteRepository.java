package com.sgvet.cliente.boundary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sgvet.cliente.boundary.ClienteDbManager;
import com.sgvet.cliente.entity.Cliente;    

public class ClienteRepository {
    ClienteDbManager clienteDbManager = ClienteDbManager.getInstance();

    public ClienteRepository() {
    }


    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";

        try (Statement stmt = ClienteDbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getInt("EDAD"),
                        rs.getString("TELEFONO")
                );
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (ID, NOMBRE, APELLIDO, EDAD, TELEFONO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ClienteDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getEdad());
            ps.setString(5, cliente.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
