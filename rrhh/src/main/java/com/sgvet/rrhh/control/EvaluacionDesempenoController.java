package com.sgvet.rrhh.control;

import com.sgvet.rrhh.boundary.EvaluacionDesempenoRepository;
import com.sgvet.rrhh.entity.EvaluacionDesempeno;

import java.util.List;

public class EvaluacionDesempenoController {

    private EvaluacionDesempenoRepository repository;

    public EvaluacionDesempenoController() {
        repository = new EvaluacionDesempenoRepository();
    }

    public void registrarEvaluacion(EvaluacionDesempeno evaluacion) {
        repository.insertar(evaluacion);
    }

    public List<EvaluacionDesempeno> obtenerPorEmpleado(int idEmpleado) {
        return repository.listarPorEmpleado(idEmpleado);
    }
}
