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
public class ObservacionesDTORespuesta {
    private Integer idFormatoA;
    private String titulo;
    private Date fechaCreacion;

    private EstadoDTORespuesta objEstado;
    private EvaluacionDTORespuesta objEvaluacion;
    private List<DocenteDTORespuesta> docentes;
    private List<String> observaciones;
}
