package com.sgvet.ui;

import java.util.Scanner;
import com.sgvet.cliente.boundary.ClienteUI;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Bienvenidos al sistema de gestion veterinaria" );
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Gestion de Usuarios");
        System.out.println("2. Gestion de Clientes");
        System.out.println("3. Gestion de Mascotas");
        System.out.println("4. Gestion de Consultas");
        System.out.println("5. Gestion de Tratamientos");
        System.out.println("6. Gestion de Ventas");
        System.out.println("7. Gestion de Compras");
        System.out.println("8. Gestion de Inventario");
        System.out.println("0. Salir");

        int opcion = -1;
        while (opcion != 0) {
            System.out.print("Ingrese una opcion (0-8): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Gestion de Usuarios seleccionada.");
                        break;
                    case 2:
                        System.out.println("Gestion de Clientes seleccionada.");
                        new ClienteUI().menuClientes(); // Llama al menú de clientes    
                        break;
                    case 3:
                        System.out.println("Gestion de Mascotas seleccionada.");
                        break;
                    case 4:
                        System.out.println("Gestion de Consultas seleccionada.");
                        break;
                    case 5:
                        System.out.println("Gestion de Tratamientos seleccionada.");
                        break;
                    case 6:
                        System.out.println("Gestion de Ventas seleccionada.");
                        break;
                    case 7:
                        System.out.println("Gestion de Compras seleccionada.");
                        break;
                    case 8:
                        System.out.println("Gestion de Inventario seleccionada.");
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }

        scanner.close();
    }
}
