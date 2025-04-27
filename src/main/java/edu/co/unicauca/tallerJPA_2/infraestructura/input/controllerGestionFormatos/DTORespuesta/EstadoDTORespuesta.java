package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTORespuesta {
    private Integer idEstado;
    private String estadoActual;
    private Date fechaRegistroEstado;

    private FormatoADTORespuesta objFormatoA;
}
