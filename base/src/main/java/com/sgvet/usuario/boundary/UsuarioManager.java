package com.sgvet.usuario.boundary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.sgvet.base.boundary.BaseDbManager;

public class UsuarioManager {
    private static final Logger logger = Logger.getLogger(UsuarioManager.class);

    public static void main(String[] args) {
        // Esto inicializa automáticamente la base al levantar el singleton
        Connection conn = BaseDbManager.getInstance().getConnection();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO")) {

            logger.info("Contenido de la tabla USUARIO:");
            while (rs.next()) {
                logger.info(String.format("ID: %d, Nombre: %s", rs.getInt("ID"), rs.getString("NOMBRE")));
            }
        } catch (Exception e) {
            logger.error("Error al consultar la base de datos : " + e.getMessage(), e);
        }
    }
}
