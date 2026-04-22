package com.sgvet.proveedor.boundary;
import java.util.List;
import java.util.Scanner;

import com.sgvet.proveedor.boundary.CompraUI;
import com.sgvet.proveedor.control.ProveedorController;
import com.sgvet.proveedor.entity.Proveedor;

public class ProveedorUI {

    static ProveedorController proveedorController = new ProveedorController();
    public static void main(String[] args) {
        menuProveedores();
    }
    
    public static void menuProveedores() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menu de Proveedors ---");
            System.out.println("1. Crear proveedor");
            System.out.println("2. Listar Proveedors");
            System.out.println("3. Editar proveedor");
            System.out.println("4. Eliminar proveedor");
            System.out.println("5. Buscar proveedor");
            System.out.println("6. Ir a Gestión de Compras");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion (0-5): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                switch (opcion) {
                    case 1:
                        crearProveedor(scanner);
                        break;
                    case 2:
                        listarProveedors();
                        break;
                    case 3:
                        editarProveedor(scanner);
                        break;
                    case 4:
                        eliminarProveedor(scanner);
                        break;
                    case 5:
                        buscarProveedor(scanner);
                        break;
                    case 6:
                        CompraUI.menuCompras();
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

    private static void crearProveedor(Scanner scanner) {
        System.out.println("=== Registrar nuevo proveedor ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Razón Social: ");
        String razonSocial = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        Proveedor proveedor = new Proveedor();
        proveedor.setId(4);
        proveedor.setNombre(nombre);
        proveedor.setRazonSocial(razonSocial);
        proveedor.setTelefono(telefono);
        proveedor.setCorreo(correo);

        Proveedor guardado = proveedorController.registrarProveedor(proveedor);
        System.out.println("Proveedor registrado exitosamente: " + guardado);
    }

    private static void listarProveedors() {
        System.out.println("Funcionalidad para listar Proveedors (pendiente de implementar).");
        List<Proveedor> listaProveedores=  proveedorController.listarProveedores();
        for (Proveedor proveedor: listaProveedores){
            System.out.println("Nombre:" + proveedor.getNombre());
            System.out.println("Telefono:" + proveedor.getTelefono());
            System.out.println("Correo:" + proveedor.getCorreo());
            System.out.println("Razon Social:" + proveedor.getRazonSocial());
            System.out.println("Id:" + proveedor.getId());

        }
        // Aquí iría la lógica para listar Proveedors
    }

    private static void eliminarProveedor(Scanner scanner) {
        System.out.println("Funcionalidad para eliminar proveedor (pendiente de implementar).");
        // Aquí iría la lógica para eliminar un proveedor
    }

    private static void buscarProveedor(Scanner scanner) {
        System.out.println("Funcionalidad para buscar proveedor (pendiente de implementar).");
        // Aquí iría la lógica para buscar un proveedor
    }

    private static void editarProveedor(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("          🔧 EDITAR PROVEEDOR - TESTING");
        System.out.println("═".repeat(60));
        
        // Opciones de búsqueda
        System.out.println("\n¿Cómo desea buscar el proveedor a editar?");
        System.out.println("1. 📋 Ver lista completa y seleccionar por ID");
        System.out.println("2. 🔍 Buscar por nombre");
        System.out.println("3. 🆔 Buscar directamente por ID");
        System.out.println("0. ← Volver al menú principal");
        System.out.print("\nSeleccione una opción (0-3): ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
            scanner.next();
            return;
        }
        
        int opcionBusqueda = scanner.nextInt();
        scanner.nextLine();
        
        Proveedor proveedorAEditar = null;
        
        switch (opcionBusqueda) {
            case 0:
                return;
            case 1:
                proveedorAEditar = buscarProveedorPorLista(scanner);
                break;
            case 2:
                proveedorAEditar = buscarProveedorPorNombre(scanner);
                break;
            case 3:
                proveedorAEditar = buscarProveedorPorIdDirecto(scanner);
                break;
            default:
                System.out.println("❌ Opción inválida.");
                return;
        }
        
        if (proveedorAEditar == null) {
            return; // El usuario canceló o hubo error
        }
        
        // Mostrar datos actuales con formato mejorado
        mostrarDatosProveedorDetallado(proveedorAEditar);
        
        // Confirmar que quiere editar este proveedor
        System.out.print("\n¿Desea editar este proveedor? (s/n): ");
        String confirmar = scanner.nextLine().trim().toLowerCase();
        if (!confirmar.equals("s") && !confirmar.equals("si")) {
            System.out.println("📋 Operación cancelada.");
            return;
        }
        
        // Proceso de edición mejorado
        Proveedor proveedorActualizado = procesarEdicionProveedor(scanner, proveedorAEditar);
        
        if (proveedorActualizado == null) {
            System.out.println("📋 Edición cancelada.");
            return;
        }
        
        // Mostrar resumen de cambios
        mostrarResumenCambios(proveedorAEditar, proveedorActualizado);
        
        // Confirmación final
        System.out.print("\n✅ ¿Confirma que desea guardar estos cambios? (s/n): ");
        String confirmacionFinal = scanner.nextLine().trim().toLowerCase();
        
        if (!confirmacionFinal.equals("s") && !confirmacionFinal.equals("si")) {
            System.out.println("📋 Cambios no guardados. Operación cancelada.");
            return;
        }
        
        // Realizar la actualización
        Boolean resultado = proveedorController.editarProveedorMejorado(proveedorActualizado);
        
        if (resultado) {
            System.out.println("\n" + "✅".repeat(20));
            System.out.println("    🎉 ¡PROVEEDOR ACTUALIZADO EXITOSAMENTE! 🎉");
            System.out.println("✅".repeat(20));
            mostrarDatosProveedorDetallado(proveedorActualizado);
        } else {
            System.out.println("\n❌ Error al actualizar el proveedor.");
            System.out.println("💡 Verifique que los datos sean correctos e intente nuevamente.");
        }
    }
    
    private static Proveedor buscarProveedorPorLista(Scanner scanner) {
        System.out.println("\n📋 Lista de proveedores disponibles:");
        List<Proveedor> proveedores = proveedorController.listarProveedores();
        
        if (proveedores.isEmpty()) {
            System.out.println("❌ No hay proveedores registrados en el sistema.");
            return null;
        }
        
        // Mostrar lista con formato mejorado
        System.out.println("┌" + "─".repeat(80) + "┐");
        System.out.printf("│ %-3s │ %-20s │ %-25s │ %-15s │\n", "ID", "NOMBRE", "RAZÓN SOCIAL", "TELÉFONO");
        System.out.println("├" + "─".repeat(80) + "┤");
        
        for (Proveedor p : proveedores) {
            System.out.printf("│ %-3d │ %-20s │ %-25s │ %-15s │\n", 
                p.getId(), 
                truncateString(p.getNombre(), 20),
                truncateString(p.getRazonSocial(), 25),
                truncateString(p.getTelefono(), 15)
            );
        }
        System.out.println("└" + "─".repeat(80) + "┘");
        
        System.out.print("\n🆔 Ingrese el ID del proveedor a editar (0 para cancelar): ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
            scanner.next();
            return null;
        }
        
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (id == 0) return null;
        
        return proveedorController.buscarProveedorPorId(id);
    }
    
    private static Proveedor buscarProveedorPorNombre(Scanner scanner) {
        System.out.print("\n🔍 Ingrese el nombre del proveedor a buscar: ");
        String nombre = scanner.nextLine().trim();
        
        if (nombre.isEmpty()) {
            System.out.println("❌ Error: Debe ingresar un nombre.");
            return null;
        }
        
        List<Proveedor> proveedoresEncontrados = proveedorController.buscarProveedoresPorNombre(nombre);
        
        if (proveedoresEncontrados.isEmpty()) {
            System.out.println("❌ No se encontraron proveedores con el nombre: " + nombre);
            return null;
        }
        
        if (proveedoresEncontrados.size() == 1) {
            return proveedoresEncontrados.get(0);
        }
        
        // Si hay múltiples resultados, mostrar para seleccionar
        System.out.println("\n📋 Se encontraron " + proveedoresEncontrados.size() + " proveedores:");
        for (int i = 0; i < proveedoresEncontrados.size(); i++) {
            Proveedor p = proveedoresEncontrados.get(i);
            System.out.printf("%d. ID: %d - %s (%s)\n", 
                i + 1, p.getId(), p.getNombre(), p.getRazonSocial());
        }
        
        System.out.print("\nSeleccione el número del proveedor (0 para cancelar): ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
            scanner.next();
            return null;
        }
        
        int seleccion = scanner.nextInt();
        scanner.nextLine();
        
        if (seleccion <= 0 || seleccion > proveedoresEncontrados.size()) {
            return null;
        }
        
        return proveedoresEncontrados.get(seleccion - 1);
    }
    
    private static Proveedor buscarProveedorPorIdDirecto(Scanner scanner) {
        System.out.print("\n🆔 Ingrese el ID del proveedor: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
            scanner.next();
            return null;
        }
        
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Proveedor proveedor = proveedorController.buscarProveedorPorId(id);
        
        if (proveedor == null) {
            System.out.println("❌ No se encontró un proveedor con el ID: " + id);
        }
        
        return proveedor;
    }
    
    private static void mostrarDatosProveedorDetallado(Proveedor proveedor) {
        System.out.println("\n┌" + "─".repeat(50) + "┐");
        System.out.println("│" + " ".repeat(15) + "DATOS DEL PROVEEDOR" + " ".repeat(15) + "│");
        System.out.println("├" + "─".repeat(50) + "┤");
        System.out.printf("│ %-15s │ %-30s │\n", "ID:", proveedor.getId());
        System.out.printf("│ %-15s │ %-30s │\n", "Nombre:", truncateString(proveedor.getNombre(), 30));
        System.out.printf("│ %-15s │ %-30s │\n", "Razón Social:", truncateString(proveedor.getRazonSocial(), 30));
        System.out.printf("│ %-15s │ %-30s │\n", "Teléfono:", truncateString(proveedor.getTelefono(), 30));
        System.out.printf("│ %-15s │ %-30s │\n", "Correo:", truncateString(proveedor.getCorreo(), 30));
        System.out.println("└" + "─".repeat(50) + "┘");
    }
    
    private static Proveedor procesarEdicionProveedor(Scanner scanner, Proveedor proveedorOriginal) {
        System.out.println("\n📝 Ingrese los nuevos datos:");
        System.out.println("💡 Presione Enter para mantener el valor actual");
        System.out.println("💡 Los campos marcados con (*) son obligatorios");
        
        // Nombre (obligatorio)
        String nuevoNombre;
        do {
            System.out.print("\n(*) Nombre [" + proveedorOriginal.getNombre() + "]: ");
            nuevoNombre = scanner.nextLine().trim();
            if (nuevoNombre.isEmpty()) {
                nuevoNombre = proveedorOriginal.getNombre();
            }
            if (nuevoNombre.length() > 50) {
                System.out.println("❌ El nombre no puede exceder 50 caracteres.");
                nuevoNombre = "";
            }
        } while (nuevoNombre.isEmpty());
        
        // Razón Social (obligatorio)
        String nuevaRazonSocial;
        do {
            System.out.print("(*) Razón Social [" + proveedorOriginal.getRazonSocial() + "]: ");
            nuevaRazonSocial = scanner.nextLine().trim();
            if (nuevaRazonSocial.isEmpty()) {
                nuevaRazonSocial = proveedorOriginal.getRazonSocial();
            }
            if (nuevaRazonSocial.length() > 100) {
                System.out.println("❌ La razón social no puede exceder 100 caracteres.");
                nuevaRazonSocial = "";
            }
        } while (nuevaRazonSocial.isEmpty());
        
        // Teléfono
        String nuevoTelefono;
        do {
            System.out.print("Teléfono [" + proveedorOriginal.getTelefono() + "]: ");
            nuevoTelefono = scanner.nextLine().trim();
            if (nuevoTelefono.isEmpty()) {
                nuevoTelefono = proveedorOriginal.getTelefono();
                break;
            }
            if (nuevoTelefono.length() > 20) {
                System.out.println("❌ El teléfono no puede exceder 20 caracteres.");
                nuevoTelefono = "";
            } else if (!nuevoTelefono.matches("^[\\d\\s\\-\\(\\)\\+]+$")) {
                System.out.println("❌ El teléfono solo puede contener números, espacios, guiones, paréntesis y +.");
                nuevoTelefono = "";
            }
        } while (nuevoTelefono.isEmpty() && !nuevoTelefono.equals(proveedorOriginal.getTelefono()));
        
        // Correo
        String nuevoCorreo;
        do {
            System.out.print("Correo electrónico [" + proveedorOriginal.getCorreo() + "]: ");
            nuevoCorreo = scanner.nextLine().trim();
            if (nuevoCorreo.isEmpty()) {
                nuevoCorreo = proveedorOriginal.getCorreo();
                break;
            }
            if (nuevoCorreo.length() > 100) {
                System.out.println("❌ El correo no puede exceder 100 caracteres.");
                nuevoCorreo = "";
            } else if (!nuevoCorreo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                System.out.println("❌ El formato del correo electrónico no es válido.");
                nuevoCorreo = "";
            }
        } while (nuevoCorreo.isEmpty() && !nuevoCorreo.equals(proveedorOriginal.getCorreo()));
        
        return new Proveedor(
            proveedorOriginal.getId(),
            nuevoNombre,
            nuevaRazonSocial,
            nuevoTelefono,
            nuevoCorreo
        );
    }
    
    private static void mostrarResumenCambios(Proveedor original, Proveedor actualizado) {
        System.out.println("\n📋 RESUMEN DE CAMBIOS:");
        System.out.println("─".repeat(60));
        
        mostrarCambio("Nombre", original.getNombre(), actualizado.getNombre());
        mostrarCambio("Razón Social", original.getRazonSocial(), actualizado.getRazonSocial());
        mostrarCambio("Teléfono", original.getTelefono(), actualizado.getTelefono());
        mostrarCambio("Correo", original.getCorreo(), actualizado.getCorreo());
    }
    
    private static void mostrarCambio(String campo, String valorOriginal, String valorNuevo) {
        if (!valorOriginal.equals(valorNuevo)) {
            System.out.printf("🔄 %-15s: '%s' → '%s'\n", campo, valorOriginal, valorNuevo);
        } else {
            System.out.printf("➖ %-15s: Sin cambios\n", campo);
        }
    }
    
    private static String truncateString(String str, int maxLength) {
        if (str == null) return "";
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength - 3) + "...";
    }
}
