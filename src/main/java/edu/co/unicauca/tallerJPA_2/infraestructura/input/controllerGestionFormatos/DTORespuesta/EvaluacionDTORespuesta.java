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
public class EvaluacionDTORespuesta {
    private Integer idEvaluacion;
    private String concepto;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;

    private FormatoADTORespuesta objFormatoA;
    private List<ObservacionDTORespuesta> observaciones;
}
