package com.sgvet.rrhh.boundary;

import com.sgvet.rrhh.control.RRHHController;
import com.sgvet.rrhh.control.EvaluacionDesempenoController;
import com.sgvet.rrhh.entity.RRHH;
import com.sgvet.rrhh.entity.EvaluacionDesempeno;

import java.util.List;
import java.util.Scanner;

public class RRHHUI {

    static RRHHController rrhhController = new RRHHController();
    static EvaluacionDesempenoController evaluacionController = new EvaluacionDesempenoController();

    public static void main(String[] args) {
        menuRRHHes();
    }

    public static void menuRRHHes() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menu de RRHHs ---");
            System.out.println("1. Crear RRHH");
            System.out.println("2. Listar RRHHs");
            System.out.println("3. Eliminar RRHH");
            System.out.println("4. Buscar RRHH");
            System.out.println("5. Actualizar datos del empleado");
            System.out.println("6. Solicitar Vacaciones");
            System.out.println("7. Solicitar Permiso");
            System.out.println("8. Evaluaciones de Desempeño");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion (0-8): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                switch (opcion) {
                    case 1:
                        crearRRHH(scanner);
                        break;
                    case 2:
                        listarRRHHs();
                        break;
                    case 3:
                        eliminarRRHH(scanner);
                        break;
                    case 4:
                        buscarRRHH(scanner);
                        break;
                    case 5:
                        actualizarEmpleado(scanner);
                        break;
                    case 6:
                        solicitarVacaciones(scanner);
                        break;
                    case 7:
                        solicitarPermiso(scanner);
                        break;
                    case 8:
                        menuEvaluaciones(scanner);
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
    }

    // Métodos de RRHH...

    private static void crearRRHH(Scanner scanner) {
        System.out.println("Ingrese los datos del RRHH:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        RRHH rrhh = new RRHH(id, nombre, apellido, cedula, telefono, correo, cargo, especialidad);
        rrhhController.crearRRHH(rrhh);
        System.out.println("RRHH creado correctamente.");
    }

    private static void listarRRHHs() {
        List<RRHH> listaRRHHes = rrhhController.listarRRHHes();
        for (RRHH rrhh : listaRRHHes) {
            System.out.println("ID: " + rrhh.getId());
            System.out.println("Nombre: " + rrhh.getNombre());
            System.out.println("Apellido: " + rrhh.getApellido());
            System.out.println("Cédula: " + rrhh.getCedula());
            System.out.println("Teléfono: " + rrhh.getTelefono());
            System.out.println("Correo: " + rrhh.getCorreo());
            System.out.println("Cargo: " + rrhh.getCargo());
            System.out.println("Especialidad: " + rrhh.getEspecialidad());
            System.out.println("-----------------------------");
        }
    }

    private static void eliminarRRHH(Scanner scanner) {
        System.out.print("Ingrese el ID del RRHH a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        rrhhController.eliminarRRHH(id);
        System.out.println("RRHH eliminado correctamente.");
    }

    private static void buscarRRHH(Scanner scanner) {
        System.out.print("Ingrese el ID del RRHH a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        RRHH rrhh = rrhhController.buscarRRHH(id);
        if (rrhh != null) {
            System.out.println("ID: " + rrhh.getId());
            System.out.println("Nombre: " + rrhh.getNombre());
            System.out.println("Apellido: " + rrhh.getApellido());
            System.out.println("Cédula: " + rrhh.getCedula());
            System.out.println("Teléfono: " + rrhh.getTelefono());
            System.out.println("Correo: " + rrhh.getCorreo());
            System.out.println("Cargo: " + rrhh.getCargo());
            System.out.println("Especialidad: " + rrhh.getEspecialidad());
        } else {
            System.out.println("RRHH no encontrado.");
        }
    }

    private static void actualizarEmpleado(Scanner scanner) {
        System.out.println("\n--- Actualizar Datos del Empleado ---");
        System.out.print("Ingrese el ID del empleado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        RRHH empleadoExistente = rrhhController.buscarRRHH(id);
        if (empleadoExistente == null) {
            System.out.println("Error: No se encontró el empleado con ID " + id);
            return;
        }
        System.out.println("\nDatos actuales del empleado:");
        System.out.println("Nombre: " + empleadoExistente.getNombre());
        System.out.println("Apellido: " + empleadoExistente.getApellido());
        System.out.println("Cédula: " + empleadoExistente.getCedula());
        System.out.println("Teléfono: " + empleadoExistente.getTelefono());
        System.out.println("Correo: " + empleadoExistente.getCorreo());
        System.out.println("Cargo: " + empleadoExistente.getCargo());
        System.out.println("Especialidad: " + empleadoExistente.getEspecialidad());
        System.out.println("\nIngrese los nuevos datos (deje vacío para mantener el valor actual):");

        System.out.print("Nuevo nombre [" + empleadoExistente.getNombre() + "]: ");
        String nuevoNombre = scanner.nextLine();
        if (nuevoNombre.trim().isEmpty()) {
            nuevoNombre = empleadoExistente.getNombre();
        }

        System.out.print("Nuevo apellido [" + empleadoExistente.getApellido() + "]: ");
        String nuevoApellido = scanner.nextLine();
        if (nuevoApellido.trim().isEmpty()) {
            nuevoApellido = empleadoExistente.getApellido();
        }

        System.out.print("Nueva cédula [" + empleadoExistente.getCedula() + "]: ");
        String nuevaCedula = scanner.nextLine();
        if (nuevaCedula.trim().isEmpty()) {
            nuevaCedula = empleadoExistente.getCedula();
        }

        System.out.print("Nuevo teléfono [" + empleadoExistente.getTelefono() + "]: ");
        String nuevoTelefono = scanner.nextLine();
        if (nuevoTelefono.trim().isEmpty()) {
            nuevoTelefono = empleadoExistente.getTelefono();
        }

        System.out.print("Nuevo correo [" + empleadoExistente.getCorreo() + "]: ");
        String nuevoCorreo = scanner.nextLine();
        if (nuevoCorreo.trim().isEmpty()) {
            nuevoCorreo = empleadoExistente.getCorreo();
        }

        System.out.print("Nuevo cargo [" + empleadoExistente.getCargo() + "]: ");
        String nuevoCargo = scanner.nextLine();
        if (nuevoCargo.trim().isEmpty()) {
            nuevoCargo = empleadoExistente.getCargo();
        }

        System.out.print("Nueva especialidad [" + empleadoExistente.getEspecialidad() + "]: ");
        String nuevaEspecialidad = scanner.nextLine();
        if (nuevaEspecialidad.trim().isEmpty()) {
            nuevaEspecialidad = empleadoExistente.getEspecialidad();
        }

        RRHH empleadoActualizado = new RRHH(id, nuevoNombre, nuevoApellido, nuevaCedula,
                nuevoTelefono, nuevoCorreo, nuevoCargo, nuevaEspecialidad);

        boolean resultado = rrhhController.actualizarEmpleado(empleadoActualizado);

        if (resultado) {
            System.out.println("Empleado actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el empleado.");
        }
    }

    private static void solicitarVacaciones(Scanner scanner) {
        System.out.print("Ingrese el ID del RRHH que solicita vacaciones: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha de inicio (yyyy-mm-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Fecha de fin (yyyy-mm-dd): ");
        String fechaFin = scanner.nextLine();

        boolean exito = rrhhController.solicitarVacaciones(id, fechaInicio, fechaFin);
        if (exito) {
            System.out.println("Vacaciones solicitadas correctamente.");
        } else {
            System.out.println("No se pudo solicitar las vacaciones. Verifique el ID.");
        }
    }

    private static void solicitarPermiso(Scanner scanner) {
        System.out.print("Ingrese el ID del RRHH que solicita permiso: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Motivo del permiso: ");
        String motivo = scanner.nextLine();
        System.out.print("Fecha del permiso (yyyy-mm-dd): ");
        String fecha = scanner.nextLine();

        boolean exito = rrhhController.solicitarPermiso(id, motivo, fecha);
        if (exito) {
            System.out.println("Permiso solicitado correctamente.");
        } else {
            System.out.println("No se pudo solicitar el permiso. Verifique el ID.");
        }
    }

    // Evaluaciones de desempeño

    private static void menuEvaluaciones(Scanner scanner) {
        int opcionEval = -1;

        while (opcionEval != 0) {
            System.out.println("\n--- Menú Evaluaciones ---");
            System.out.println("1. Registrar evaluación");
            System.out.println("2. Listar evaluaciones por empleado");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcionEval = scanner.nextInt();
            scanner.nextLine();

            switch (opcionEval) {
                case 1:
                    registrarEvaluacion(scanner);
                    break;
                case 2:
                    listarEvaluaciones(scanner);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void registrarEvaluacion(Scanner scanner) {
        System.out.print("ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Puntualidad (1-10): ");
        int puntualidad = scanner.nextInt();
        System.out.print("Atención al cliente (1-10): ");
        int atencion = scanner.nextInt();
        System.out.print("Trabajo en equipo (1-10): ");
        int trabajo = scanner.nextInt();
        System.out.print("Responsabilidad (1-10): ");
        int responsabilidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Observaciones: ");
        String obs = scanner.nextLine();

        EvaluacionDesempeno eval = new EvaluacionDesempeno(
                idEmpleado, fecha, puntualidad, atencion, trabajo, responsabilidad, obs
        );
        evaluacionController.registrarEvaluacion(eval);
        System.out.println("✅ Evaluación registrada.");
    }

    private static void listarEvaluaciones(Scanner scanner) {
        System.out.print("ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();
        List<EvaluacionDesempeno> lista = evaluacionController.obtenerPorEmpleado(idEmpleado);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron evaluaciones.");
        } else {
            for (EvaluacionDesempeno e : lista) {
                System.out.println("Fecha: " + e.getFecha());
                System.out.println("Promedio: " + e.getCalificacionFinal());
                System.out.println("Observaciones: " + e.getObservaciones());
                System.out.println("----------------------------------");
            }
        }
    }
}
