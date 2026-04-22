package com.sgvet.mascota.boundary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sgvet.mascota.boundary.MascotaDbManager;
import com.sgvet.mascota.entity.Mascota;    

public class MascotaRepository {
    MascotaDbManager mascotaDbManager = MascotaDbManager.getInstance();

    public MascotaRepository() {
    }

    public boolean eliminarPorId(int id) {
        String sql = "DELETE FROM Mascota WHERE ID = ?";
        try (PreparedStatement ps = MascotaDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Mascota> listarTodos() {
        List<Mascota> Mascotas = new ArrayList<>();
        String sql = "SELECT * FROM Mascota";

        try (Statement stmt = MascotaDbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mascota c = new Mascota(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getInt("EDAD"),
                        rs.getString("TELEFONO"),
                        rs.getInt("IDCLIENTE"),
                        rs.getString("TIPOMASCOTA"),
                        rs.getString("RAZA")
                );
                Mascotas.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Mascotas;
    }

    public void insertar(Mascota mascota) {
        String sql = "INSERT INTO Mascota (ID, NOMBRE, APELLIDO, EDAD, TELEFONO, IDCLIENTE, TIPOMASCOTA, RAZA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = MascotaDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, mascota.getId());
            ps.setString(2, mascota.getNombre());
            ps.setString(3, mascota.getApellido());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getTelefono());
            ps.setInt(6, mascota.getIdCliente());
            ps.setString(7, mascota.getTipoMascota());
            ps.setString(8, mascota.getRaza());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
