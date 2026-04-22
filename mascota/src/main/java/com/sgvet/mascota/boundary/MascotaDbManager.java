package com.sgvet.mascota.boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.sgvet.base.boundary.BaseDbManager;

public class MascotaDbManager {


    private static BaseDbManager base = BaseDbManager.getInstance();
    private static MascotaDbManager instance;
    private static final String INIT_SQL_RESOURCE = "db/initMascotas.sql";
    protected MascotaDbManager() {
        try {
            System.out.println("Inicializando base Mascotas desde: " + INIT_SQL_RESOURCE);
            base.runSqlScriptFromResources(INIT_SQL_RESOURCE);
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Error inicializando la base", e);
        }
    }


    public static MascotaDbManager getInstance() {
        if (instance == null) {
            instance = new MascotaDbManager(); // Sin script de inicialización
        }
        return instance;
    }
    public static Connection getConnection() {
               return  base.getConnection();
    }

    public static void main(String[] args) {
        System.out.println("Test");
        getInstance();
    }

}
