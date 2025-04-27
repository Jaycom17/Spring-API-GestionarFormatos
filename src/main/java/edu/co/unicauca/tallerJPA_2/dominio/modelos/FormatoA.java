package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class FormatoA {
    private Integer idFormatoA;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String nombreEstudiante1;

    private Docente objDocente;
    private Estado objEstado;
    private List<Evaluacion> evaluaciones;

    public FormatoA() {
        this.evaluaciones = new ArrayList<Evaluacion>();
    }
    

    public FormatoA(String titulo, String objetivo_general, String objetivos_especifico, String nombre_estudiante1) {
        this.titulo = titulo;
        this.objetivoGeneral = objetivo_general;
        this.objetivosEspecificos = objetivos_especifico;
        this.nombreEstudiante1 = nombre_estudiante1;
        this.evaluaciones = new ArrayList<Evaluacion>();
    }
}
