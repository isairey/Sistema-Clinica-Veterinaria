# Funcionalidad: Actualizar Datos Personales del Empleado

## Descripción
Implementación del caso de uso "Actualizar datos personales del empleado" del módulo de Recursos Humanos (RRHH).

## Funcionalidad implementada
- Permitir la actualización de los datos personales de un empleado existente en el sistema veterinario
- Validar los datos obligatorios (nombre, apellido, cédula, cargo)
- Validar formatos de correo electrónico, teléfono y cédula
- Interfaz de usuario para actualizar datos
- Mostrar confirmación de la actualización exitosa

## Campos del empleado que se pueden actualizar
- Nombre (obligatorio)
- Apellido (obligatorio)
- Cédula (obligatorio, formato: 10 dígitos)
- Teléfono (opcional, formato: 7-15 dígitos)
- Correo electrónico (opcional, formato válido)
- Cargo (obligatorio)
- Especialidad (opcional)

## Archivos implementados
- `RRHHValidador.java` - Clase para validar datos del empleado
- `RRHHController.java` - Método `actualizarEmpleado()` agregado
- `RRHHUI.java` - Opción de menú y método `actualizarEmpleado()` agregados

## Validaciones implementadas
- Campos obligatorios no vacíos
- Formato de cédula (10 dígitos numéricos)
- Formato de correo electrónico
- Formato de teléfono (solo números, 7-15 dígitos)
- Existencia del empleado antes de actualizar

## Uso
1. Seleccionar opción "5. Actualizar datos del empleado" en el menú de RRHH
2. Ingresar el ID del empleado a actualizar
3. Ver los datos actuales del empleado
4. Ingresar nuevos datos (dejar vacío para mantener valor actual)
5. Confirmar la actualización 