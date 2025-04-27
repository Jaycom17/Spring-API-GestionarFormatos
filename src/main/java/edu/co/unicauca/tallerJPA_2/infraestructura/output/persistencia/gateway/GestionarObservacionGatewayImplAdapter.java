package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarObservacionGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.ObservacionRepository;

public class GestionarObservacionGatewayImplAdapter implements GestionarObservacionGatewayIntPort{

    private final ObservacionRepository objObservacionRepository;
    private final ModelMapper observacionModelMapper;

    public GestionarObservacionGatewayImplAdapter(ObservacionRepository objObservacionRepository, ModelMapper observacionModelMapper) {
        this.objObservacionRepository = objObservacionRepository;
        this.observacionModelMapper = observacionModelMapper;
    }

    @Override
    public Observacion guardarObservacion(Observacion objObservacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarObservacion'");
    }

    @Override
    public List<Observacion> listarPorFormato(Integer idFormatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorFormato'");
    }
    
}
