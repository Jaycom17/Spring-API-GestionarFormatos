package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObservacionDTORespuesta {
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistroObservacion;

    private EvaluacionDTORespuesta objEvaluacion;
    private List<DocenteDTORespuesta> docentes;
}
