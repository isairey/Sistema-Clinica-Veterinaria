package com.sgvet.usuario.control;

import org.junit.Assert;
import org.junit.Test;

public class UsuarioControllerTest {

    @Test
    public void testUsuarioControllerInstance() {
        UsuarioController controller = new UsuarioController();
        Assert.assertNotNull(controller);
    }
}
