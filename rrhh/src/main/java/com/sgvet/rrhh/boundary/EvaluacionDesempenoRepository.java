package com.sgvet.rrhh.boundary;

import com.sgvet.rrhh.entity.EvaluacionDesempeno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvaluacionDesempenoRepository {

    RRHHDbManager rrhhDbManager = RRHHDbManager.getInstance();

    public void insertar(EvaluacionDesempeno eval) {
        String sql = "INSERT INTO EvaluacionDesempeno (ID_EMPLEADO, FECHA, PUNTUALIDAD, ATENCION_CLIENTE, TRABAJO_EQUIPO, RESPONSABILIDAD, OBSERVACIONES) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = RRHHDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, eval.getIdEmpleado());
            ps.setDate(2, Date.valueOf(eval.getFecha()));
            ps.setInt(3, eval.getPuntualidad());
            ps.setInt(4, eval.getAtencionCliente());
            ps.setInt(5, eval.getTrabajoEquipo());
            ps.setInt(6, eval.getResponsabilidad());
            ps.setString(7, eval.getObservaciones());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EvaluacionDesempeno> listarPorEmpleado(int idEmpleado) {
        List<EvaluacionDesempeno> lista = new ArrayList<>();
        String sql = "SELECT * FROM EvaluacionDesempeno WHERE ID_EMPLEADO = ?";

        try (PreparedStatement ps = RRHHDbManager.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EvaluacionDesempeno eval = new EvaluacionDesempeno();
                eval.setId(rs.getInt("ID"));
                eval.setIdEmpleado(rs.getInt("ID_EMPLEADO"));
                eval.setFecha(rs.getDate("FECHA").toString());
                eval.setPuntualidad(rs.getInt("PUNTUALIDAD"));
                eval.setAtencionCliente(rs.getInt("ATENCION_CLIENTE"));
                eval.setTrabajoEquipo(rs.getInt("TRABAJO_EQUIPO"));
                eval.setResponsabilidad(rs.getInt("RESPONSABILIDAD"));
                eval.setObservaciones(rs.getString("OBSERVACIONES"));
                lista.add(eval);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
