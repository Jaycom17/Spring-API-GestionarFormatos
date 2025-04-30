package edu.co.unicauca.tallerJPA_2.dominio.casosDeUso;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarObservacionCUIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;

public class GestionarObservacionCUAdapter implements GestionarObservacionCUIntPort{

    @Override
    public Observacion crearObservacion(Observacion objObservacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearObservacion'");
    }

    @Override
    public List<Observacion> listarObservacionesPorFormato(Integer idFormatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarObservacionesPorFormato'");
    }
    
}
