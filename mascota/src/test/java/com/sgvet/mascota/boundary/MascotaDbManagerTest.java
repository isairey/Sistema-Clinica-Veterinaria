package com.sgvet.mascota.boundary;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class MascotaDbManagerTest {

    @Test
    public void testSingletonInstance() {
        MascotaDbManager instance1 = MascotaDbManager.getInstance();
        MascotaDbManager instance2 = MascotaDbManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void testConnectionNotNull() {
        Connection conn = MascotaDbManager.getConnection();
        Assert.assertNotNull(conn);
    }
}