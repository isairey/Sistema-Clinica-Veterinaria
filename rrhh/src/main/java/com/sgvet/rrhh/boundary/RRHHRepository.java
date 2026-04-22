package com.sgvet.rrhh.boundary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sgvet.rrhh.boundary.RRHHDbManager;
import com.sgvet.rrhh.entity.RRHH;    

public class RRHHRepository {
    RRHHDbManager rrhhDbManager = RRHHDbManager.getInstance();

    public RRHHRepository() {
    }

    public List<RRHH> listarTodos() {
        List<RRHH> rrhhes = new ArrayList<>();
        String sql = "SELECT * FROM RRHH";

        try (Statement stmt = RRHHDbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RRHH c = new RRHH(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("CEDULA"),
                        rs.getString("TELEFONO"),
                        rs.getString("CORREO"),
                        rs.getString("CARGO"),
                        rs.getString("ESPECIALIDAD")
                );
                rrhhes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rrhhes;
    }

    public void insertar(RRHH rrhh) {
        String sql = "INSERT INTO RRHH (ID, NOMBRE, APELLIDO, CEDULA, TELEFONO, CORREO, CARGO, ESPECIALIDAD) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = RRHHDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, rrhh.getId());
            ps.setString(2, rrhh.getNombre());
            ps.setString(3, rrhh.getApellido());
            ps.setString(4, rrhh.getCedula());
            ps.setString(5, rrhh.getTelefono());
            ps.setString(6, rrhh.getCorreo());
            ps.setString(7, rrhh.getCargo());
            ps.setString(8, rrhh.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public RRHH buscarPorId(int id) {
        String sql = "SELECT * FROM RRHH WHERE ID = ?";
        
        try (PreparedStatement ps = RRHHDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new RRHH(
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getString("APELLIDO"),
                    rs.getString("CEDULA"),
                    rs.getString("TELEFONO"),
                    rs.getString("CORREO"),
                    rs.getString("CARGO"),
                    rs.getString("ESPECIALIDAD")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void actualizar(RRHH rrhh) {
        String sql = "UPDATE RRHH SET NOMBRE=?, APELLIDO=?, CEDULA=?, TELEFONO=?, CORREO=?, CARGO=?, ESPECIALIDAD=? WHERE ID=?";

        try (PreparedStatement ps = RRHHDbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, rrhh.getNombre());
            ps.setString(2, rrhh.getApellido());
            ps.setString(3, rrhh.getCedula());
            ps.setString(4, rrhh.getTelefono());
            ps.setString(5, rrhh.getCorreo());
            ps.setString(6, rrhh.getCargo());
            ps.setString(7, rrhh.getEspecialidad());
            ps.setInt(8, rrhh.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
