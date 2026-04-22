package com.sgvet.proveedor.control;

import com.sgvet.proveedor.entity.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraController {
    private List<Compra> listaCompras = new ArrayList<>();
    private int idCounter = 1;

    public void registrarCompra(Compra compra) {
        compra.setId(idCounter++);
        listaCompras.add(compra);
    }

    public List<Compra> listarCompras() {
        return listaCompras;
    }

    public Compra buscarCompraPorId(int id) {
        for (Compra compra : listaCompras) {
            if (compra.getId() == id) {
                return compra;
            }
        }
        return null;
    }

    public boolean eliminarCompra(int id) {
        return listaCompras.removeIf(c -> c.getId() == id);
    }
}
