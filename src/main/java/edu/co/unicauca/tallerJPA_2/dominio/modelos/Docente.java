package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Docente {
    private Integer idDocente;
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;

    private List<Observacion> observaciones;
    private List<FormatoA> formatos;

    public Docente() {
        observaciones = new ArrayList<Observacion>();
        formatos = new ArrayList<FormatoA>();
    }
}
