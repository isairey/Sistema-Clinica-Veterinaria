package com.sgvet.base.boundary;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDbManagerTest {

    @Test
    public void testSingletonInstance() {
        BaseDbManager instance1 = BaseDbManager.getInstance();
        BaseDbManager instance2 = BaseDbManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertSame(instance1, instance2);
        instance1.isNewDatabase("dbname");
    }

    @Test
    public void testConnectionNotNull() {
        BaseDbManager dbManager = BaseDbManager.getInstance();
        Connection conn = dbManager.getConnection();
        Assert.assertNotNull(conn);
    }

    @Test
    public void testInitSqlScriptExecuted() throws Exception {
        BaseDbManager dbManager = BaseDbManager.getInstance();
        Connection conn = dbManager.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1 FROM SYS.SYSTABLES")) {
            Assert.assertTrue(rs.next());
        }
    }

    @Test
    public void testRunScriptWithErrors() throws Exception {
        BaseDbManager dbManager = BaseDbManager.getInstance();
        try{
           dbManager.runSqlScript("");
            Assert.fail("Error al ejecutar el script de inicialización: ");

        }
        catch (Exception e) {
            System.out.println("Controlled error" + e.getMessage());
        }

    }
}
