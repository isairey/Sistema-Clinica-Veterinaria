package com.sgvet.cliente.boundary;

import org.junit.Assert;
import org.junit.Test;

import com.sgvet.cliente.entity.Cliente;

import java.sql.Connection;

public class ClienteDbManagerTest {

    @Test
    public void testSingletonInstance() {
        ClienteDbManager instance1 = ClienteDbManager.getInstance();
        ClienteDbManager instance2 = ClienteDbManager.getInstance();
        Assert.assertNotNull(instance1);
        Assert.assertSame(instance1, instance2);
    }

    @Test
    public void testConnectionNotNull() {
        Connection conn = ClienteDbManager.getConnection();
        Assert.assertNotNull(conn);
    }

    

}