package com.sgvet.usuario.boundary;

import com.sgvet.base.boundary.BaseDbManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioManagerTest {

    private static Connection conn;

    @BeforeClass
    public static void setUp() {
        conn = BaseDbManager.getInstance().getConnection();
    }

    @Test
    public void testConnectionNotNull() {
        Assert.assertNotNull(conn);
    }

    @Test
    public void testUsuarioTableExists() throws Exception {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO")) {
            Assert.assertNotNull(rs);
        }
    }

    @Test
    public void testUsuarioTableHasData() throws Exception {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO")) {
            boolean hasData = rs.next();
            Assert.assertTrue("La tabla USUARIO debe tener al menos un registro de prueba.", hasData);
        }
    }
}
