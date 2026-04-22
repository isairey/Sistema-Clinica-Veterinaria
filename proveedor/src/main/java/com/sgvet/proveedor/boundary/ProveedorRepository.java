package com.sgvet.proveedor.boundary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sgvet.proveedor.entity.Proveedor;    

public class ProveedorRepository {
    ProveedorDbManager proveedorDbManager = ProveedorDbManager.getInstance();

    public ProveedorRepository() {
    }

    public List<Proveedor> listarTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";

        try (Statement stmt = ProveedorDbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Proveedor c = new Proveedor(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("RAZONSOCIAL"),
                        rs.getString("TELEFONO"),
                        rs.getString("CORREO")
                );
                proveedores.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }

    public void insertar(Proveedor proveedor) {
        String sql = "INSERT INTO Proveedor (ID, NOMBRE, RAZONSOCIAL, TELEFONO, CORREO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ProveedorDbManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, proveedor.getId());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getRazonSocial());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    proveedor.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proveedor buscarPorId(Integer id) {
        String sql = "SELECT * FROM Proveedor WHERE ID = ?";
        Proveedor proveedor = null;

        try (PreparedStatement ps = ProveedorDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proveedor = new Proveedor(
                            rs.getInt("ID"),
                            rs.getString("NOMBRE"),
                            rs.getString("RAZONSOCIAL"),
                            rs.getString("TELEFONO"),
                            rs.getString("CORREO")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedor;
    }

    public boolean actualizar(Proveedor proveedor) {
        String sql = "UPDATE Proveedor SET NOMBRE = ?, RAZONSOCIAL = ?, TELEFONO = ?, CORREO = ? WHERE ID = ?";
        
        try (PreparedStatement ps = ProveedorDbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getCorreo());
            ps.setInt(5, proveedor.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeCorreoEnOtroProveedor(String correo, Integer idProveedorActual) {
        String sql = "SELECT COUNT(*) FROM Proveedor WHERE CORREO = ? AND ID != ?";
        
        try (PreparedStatement ps = ProveedorDbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setInt(2, idProveedorActual);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Proveedor> buscarPorNombre(String nombre) {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor WHERE UPPER(NOMBRE) LIKE UPPER(?)";

        try (PreparedStatement ps = ProveedorDbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Proveedor p = new Proveedor(
                            rs.getInt("ID"),
                            rs.getString("NOMBRE"),
                            rs.getString("RAZONSOCIAL"),
                            rs.getString("TELEFONO"),
                            rs.getString("CORREO")
                    );
                    proveedores.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }
}
