package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Evaluacion {
    private Integer idEvaluacion;
    private String concepto;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;

    private FormatoA objFormatoA;
    private List<Observacion> observaciones;

    public Evaluacion() {
        observaciones = new ArrayList<Observacion>();
    }
}
