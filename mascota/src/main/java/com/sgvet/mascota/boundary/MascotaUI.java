package com.sgvet.mascota.boundary;
import com.sgvet.mascota.control.MascotaController;
import com.sgvet.mascota.entity.Mascota;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Scanner;

public class MascotaUI {

    static MascotaController mascotaController = new MascotaController();
    public static void main(String[] args) {
        menuMascotas();
    }
    
    public static void menuMascotas() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menu de Mascotas ---");
            System.out.println("1. Crear mascota");
            System.out.println("2. Listar Mascotas");
            System.out.println("3. Eliminar mascota");
            System.out.println("4. Buscar mascota");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion (0-4): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                switch (opcion) {
                    case 1:
                        crearMascota(scanner);
                        break;
                    case 2:
                        listarMascotas();
                        break;
                    case 3:
                        eliminarMascota(scanner);
                        break;
                    case 4:
                        buscarMascota(scanner);
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

    private static void crearMascota(Scanner scanner) {
        System.out.println("Funcionalidad para crear mascota (pendiente de implementar).");
        // Aquí iría la lógica para crear un mascota
    }

    private static void listarMascotas() {
        System.out.println("Funcionalidad para listar Mascotas (pendiente de implementar).");
        List<Mascota> listaMascotas=  mascotaController.listarMascotas();
        for (Mascota mascota: listaMascotas){
            System.out.println("Nombre:" + mascota.getNombre());
            System.out.println("Apellido:" + mascota.getApellido());
            System.out.println("Telefono:" + mascota.getTelefono());
            System.out.println("Edad:" + mascota.getEdad());
            System.out.println("Id:" + mascota.getId());

        }
        // Aquí iría la lógica para listar Mascotas
    }

    private static void eliminarMascota(Scanner scanner) {
        System.out.print("Ingrese el ID de la mascota a eliminar: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            scanner.nextLine(); // Clean buffer
            boolean eliminado = mascotaController.eliminarMascota(id);
            if (eliminado) {
                System.out.println("Mascota eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una mascota con ese ID.");
            }
        } else {
            System.out.println("ID inválido.");
            scanner.next(); // Clean invalid input
        }
    }

    private static void buscarMascota(Scanner scanner) {
        System.out.println("Funcionalidad para buscar mascota (pendiente de implementar).");
        // Aquí iría la lógica para buscar un mascota
    }
}
