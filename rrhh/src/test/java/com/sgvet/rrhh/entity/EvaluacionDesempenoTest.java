package com.sgvet.rrhh.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluacionDesempenoTest {

    @Test
    public void testCalculoNormal() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno(1, "2025-07-27", 80, 85, 90, 95, "Observación");
        assertEquals(87.5, eval.getCalificacionFinal(), 0.01);
    }

    @Test
    public void testCalificacionMaxima() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno(2, "2025-07-27", 100, 100, 100, 100, "Excelente");
        assertEquals(100.0, eval.getCalificacionFinal(), 0.01);
    }

    @Test
    public void testCalificacionMinima() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno(3, "2025-07-27", 0, 0, 0, 0, "Mal desempeño");
        assertEquals(0.0, eval.getCalificacionFinal(), 0.01);
    }

    @Test
    public void testCalificacionNegativos() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno(4, "2025-07-27", -10, -20, -30, -40, "Error de carga");
        assertEquals(-25.0, eval.getCalificacionFinal(), 0.01); // A menos que valides esto como error
    }

    @Test
    public void testCalificacionUnicoAlto() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno(5, "2025-07-27", 100, 0, 0, 0, "Sólo puntual");
        assertEquals(25.0, eval.getCalificacionFinal(), 0.01);
    }

    @Test
    public void testSettersYGetters() {
        EvaluacionDesempeno eval = new EvaluacionDesempeno();
        eval.setIdEmpleado(6);
        eval.setFecha("2025-07-27");
        eval.setPuntualidad(70);
        eval.setAtencionCliente(75);
        eval.setTrabajoEquipo(80);
        eval.setResponsabilidad(85);
        eval.setObservaciones("Setters test");

        assertEquals(6, eval.getIdEmpleado());
        assertEquals("2025-07-27", eval.getFecha());
        assertEquals(77.5, eval.getCalificacionFinal(), 0.01);
    }
}
