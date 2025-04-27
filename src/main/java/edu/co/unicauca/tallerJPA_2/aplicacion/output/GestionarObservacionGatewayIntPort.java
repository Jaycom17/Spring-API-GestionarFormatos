package edu.co.unicauca.tallerJPA_2.aplicacion.output;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;

public interface GestionarObservacionGatewayIntPort {
    public Observacion guardarObservacion(Observacion objObservacion);
    List<Observacion> listarPorFormato(Integer idFormatoA);
}
