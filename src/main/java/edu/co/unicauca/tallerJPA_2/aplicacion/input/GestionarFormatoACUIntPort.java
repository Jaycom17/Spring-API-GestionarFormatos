package edu.co.unicauca.tallerJPA_2.aplicacion.input;

import java.util.Date;
import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;

public interface GestionarFormatoACUIntPort {
    public FormatoA crearFormatoA(FormatoA objFormatoA);
    List<FormatoA> listarPorDocente(Integer idDocente); 
    List<FormatoA> listarPorTituloEntreFechas(String titulo, Date fechaInicio, Date fechaFin);
    List<FormatoA> listarPorDocenteYFechas(Integer idDocente, Date fechaInicio, Date fechaFin);
}
