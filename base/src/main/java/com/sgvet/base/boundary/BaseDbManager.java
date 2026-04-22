package com.sgvet.base.boundary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class BaseDbManager {

    private static final Logger logger = Logger.getLogger(BaseDbManager.class);

    private static final String DB_NAME = "sgvetDB";
    // Cambia la URL para usar Derby en memoria
    private static final String DB_URL = "jdbc:derby:memory:" + DB_NAME + ";create=true";
    private static final String INIT_SQL_RESOURCE = "db/init.sql";

    private static BaseDbManager instance;
    public Connection connection;

    // Constructor privado (solo se ejecuta una vez)
    private BaseDbManager() {
        try {
            this.connection = DriverManager.getConnection(DB_URL);
            logger.info("Conexión establecida con Derby.");

            logger.info("Inicializando la base de datos desde init.sql...");
            runSqlScriptFromResources(INIT_SQL_RESOURCE);
        } catch (SQLException | IOException e) {
            logger.error("Error al inicializar la base de datos Derby", e);
            throw new RuntimeException("Error al inicializar la base de datos Derby", e);
        }
    }

    // Singleton: devuelve la única instancia
    public static synchronized BaseDbManager getInstance() {
        if (instance == null) {
            instance = new BaseDbManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    // Método privado para ejecutar el contenido de un BufferedReader como SQL
    private void executeSqlFromReader(BufferedReader reader) throws IOException, SQLException {
        try (Statement stmt = connection.createStatement()) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("--")) continue;

                sql.append(line);
                if (line.endsWith(";")) {
                    String command = sql.toString().replace(";", "");
                    stmt.executeUpdate(command);
                    sql.setLength(0);
                }
            }
        }
    }

    // Ejecuta el script SQL de inicialización desde un archivo del sistema
    public void runSqlScript(String filePath) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            executeSqlFromReader(reader);
        }
    }

    // Ejecuta el script SQL de inicialización desde resources
    public void runSqlScriptFromResources(String resourcePath) throws IOException, SQLException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IOException("Archivo no encontrado en resources: " + resourcePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                executeSqlFromReader(reader);
            }
        }
    }

    protected boolean isNewDatabase(String dbName) {
        return !Paths.get(dbName).toFile().exists();
    }

}
