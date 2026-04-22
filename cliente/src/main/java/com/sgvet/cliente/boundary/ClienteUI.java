package com.sgvet.cliente.boundary;
import com.sgvet.cliente.control.ClienteController;
import com.sgvet.cliente.entity.Cliente;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Scanner;

public class ClienteUI {

    static ClienteController clienteController = new ClienteController();
    public static void main(String[] args) {
        menuClientes();
    }
    
    public static void menuClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menu de Clientes ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion (0-4): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                switch (opcion) {
                    case 1:
                        crearCliente(scanner);
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        eliminarCliente(scanner);
                        break;
                    case 4:
                        buscarCliente(scanner);
                        break;
                    case 0:
                        System.out.println("Volviendo al menu principal...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        // scanner.close(); // No cerrar aquí si se comparte el scanner globalmente
    }

    private static void crearCliente(Scanner scanner) {
        System.out.println("Funcionalidad para crear cliente (pendiente de implementar).");
        // Aquí iría la lógica para crear un cliente
    }

    private static void listarClientes() {
        System.out.println("Funcionalidad para listar clientes (pendiente de implementar).");
        List<Cliente> listaClientes=  clienteController.listarClientes();
        for (Cliente cliente: listaClientes){
            System.out.println("Nombre:" + cliente.getNombre());
            System.out.println("Apellido:" + cliente.getApellido());
            System.out.println("Telefono:" + cliente.getTelefono());
            System.out.println("Edad:" + cliente.getEdad());
            System.out.println("Id:" + cliente.getId());

        }
        // Aquí iría la lógica para listar clientes
    }

    private static void eliminarCliente(Scanner scanner) {
        System.out.println("Funcionalidad para eliminar cliente (pendiente de implementar).");
        // Aquí iría la lógica para eliminar un cliente
    }

    private static void buscarCliente(Scanner scanner) {
        System.out.println("Funcionalidad para buscar cliente (pendiente de implementar).");
        // Aquí iría la lógica para buscar un cliente
    }
}
