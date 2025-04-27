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
public class HistoricoDTORespuesta {
    private Integer idHistorico;
    private int activo;
    private Date fechaInicio;
    private Date fechaFin;
    
    private DocenteDTORespuesta objDocente;
    private RolDTORespuesta objRol;
}
