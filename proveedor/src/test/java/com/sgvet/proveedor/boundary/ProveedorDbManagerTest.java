package com.sgvet.proveedor.boundary;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ProveedorDbManagerTest {

    @Test
    public void testSingletonInstance() {
        ProveedorDbManager instance1 = ProveedorDbManager.getInstance();
        ProveedorDbManager instance2 = ProveedorDbManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void testConnectionNotNull() {
        Connection conn = ProveedorDbManager.getConnection();
        Assert.assertNotNull(conn);
    }
}