package edu.co.unicauca.tallerJPA_2.aplicacion.input;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;

public interface GestionarObservacionCUIntPort {
    Observacion crearObservacion(Observacion objObservacion);
    List<Observacion> listarObservacionesPorFormato(Integer idFormatoA);
}
