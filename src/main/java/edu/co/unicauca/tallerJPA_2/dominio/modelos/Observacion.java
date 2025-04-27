package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Observacion {
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistroObservacion;

    private Evaluacion objEvaluacion;
    private List<Docente> docentes;

    public Observacion() {
        docentes = new ArrayList<Docente>();
    }
}
