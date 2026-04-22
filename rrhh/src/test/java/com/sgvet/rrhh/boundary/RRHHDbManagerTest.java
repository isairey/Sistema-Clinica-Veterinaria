package com.sgvet.rrhh.boundary;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class RRHHDbManagerTest {

    @Test
    public void testSingletonInstance() {
        RRHHDbManager instance1 = RRHHDbManager.getInstance();
        RRHHDbManager instance2 = RRHHDbManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void testConnectionNotNull() {
        Connection conn = RRHHDbManager.getConnection();
        Assert.assertNotNull(conn);
    }

    @Test
    public void testConnectionClosed() {
        Connection conn = RRHHDbManager.getConnection();
        try {
            conn.close();
            Assert.assertTrue(conn.isClosed());
        } catch (Exception e) {
            Assert.fail("Connection should be closed: " + e.getMessage());
        }
    }

   
}