package com.sgvet.rrhh.boundary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.sgvet.base.boundary.BaseDbManager;

public class RRHHDbManager {

    private static BaseDbManager base = BaseDbManager.getInstance();
    private static RRHHDbManager instance;
    private static final String INIT_SQL_RESOURCE = "db/initRRHH.sql";

    protected RRHHDbManager() {
        try {
            System.out.println("Inicializando base RRHHs desde: " + INIT_SQL_RESOURCE);
            base.runSqlScriptFromResources(INIT_SQL_RESOURCE);
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Error inicializando la base de RRHH", e);
        }
    }

    public static RRHHDbManager getInstance() {
        if (instance == null) {
            instance = new RRHHDbManager();
        }
        return instance;
    }

    public static Connection getConnection() {
        return base.getConnection();
    }

    public static void main(String[] args) {
        System.out.println("Test RRHHDbManager");
        getInstance();
    }
}
