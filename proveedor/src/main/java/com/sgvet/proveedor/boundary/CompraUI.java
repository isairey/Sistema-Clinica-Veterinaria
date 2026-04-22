package com.sgvet.proveedor.boundary;

import com.sgvet.proveedor.control.CompraController;
import com.sgvet.proveedor.entity.Compra;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CompraUI {
    static CompraController compraController = new CompraController();

    public static void menuCompras() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Compras ---");
            System.out.println("1. Registrar compra");
            System.out.println("2. Listar compras");
            System.out.println("3. Buscar compra");
            System.out.println("4. Eliminar compra");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarCompra(scanner);
                    break;
                case 2:
                    listarCompras();
                    break;
                case 3:
                    buscarCompra(scanner);
                    break;
                case 4:
                    eliminarCompra(scanner);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    private static void registrarCompra(Scanner scanner) {
        System.out.print("ID del proveedor: ");
        int proveedorId = scanner.nextInt();
        scanner.nextLine(); // limpiar

        System.out.print("Descripción de la compra: ");
        String descripcion = scanner.nextLine();

        System.out.print("Monto total: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // limpiar

        LocalDate fecha = LocalDate.now();
        Compra compra = new Compra(0, proveedorId, fecha, monto, descripcion);
        compraController.registrarCompra(compra);
        System.out.println("Compra registrada correctamente.");
    }

    private static void listarCompras() {
        List<Compra> compras = compraController.listarCompras();
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }
        for (Compra c : compras) {
            System.out.printf("ID: %d | Proveedor ID: %d | Fecha: %s | Monto: %.2f | Descripción: %s%n",
                    c.getId(), c.getProveedorId(), c.getFecha(), c.getMontoTotal(), c.getDescripcion());
        }
    }

    private static void buscarCompra(Scanner scanner) {
        System.out.print("Ingrese el ID de la compra: ");
        int id = scanner.nextInt();
        Compra compra = compraController.buscarCompraPorId(id);
        if (compra != null) {
            System.out.println("Compra encontrada:");
            System.out.printf("ID: %d | Proveedor ID: %d | Fecha: %s | Monto: %.2f | Descripción: %s%n",
                    compra.getId(), compra.getProveedorId(), compra.getFecha(), compra.getMontoTotal(), compra.getDescripcion());
        } else {
            System.out.println("Compra no encontrada.");
        }
    }

    private static void eliminarCompra(Scanner scanner) {
        System.out.print("Ingrese el ID de la compra a eliminar: ");
        int id = scanner.nextInt();
        if (compraController.eliminarCompra(id)) {
            System.out.println("Compra eliminada.");
        } else {
            System.out.println("Compra no encontrada.");
        }
    }
}
