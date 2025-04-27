package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class FormatoADTORespuesta {
    private Integer idFormatoA;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String nombreEstudiante1;

    private DocenteDTORespuesta objDocente;
    private EstadoDTORespuesta objEstado;
    private List<EvaluacionDTORespuesta> evaluaciones;
}
