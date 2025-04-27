package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Historico {
    private Integer idHistorico;
    private int activo;
    private Date fechaInicio;
    private Date fechaFin;
    
    private Docente objDocente;
    private Rol objRol;

    public Historico() {
    }
}
