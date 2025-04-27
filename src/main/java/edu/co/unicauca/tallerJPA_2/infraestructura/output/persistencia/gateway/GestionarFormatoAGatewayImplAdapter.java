package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarFormatoAGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.FormatoARepository;

public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort{

    private final FormatoARepository objFormatoARepository;
    private final ModelMapper formatoAModelMapper;

    public GestionarFormatoAGatewayImplAdapter(FormatoARepository objFormatoARepository, ModelMapper formatoAModelMapper) {
        this.objFormatoARepository = objFormatoARepository;
        this.formatoAModelMapper = formatoAModelMapper;
    }

    @Override
    @Transactional
    public FormatoA crearFormatoA(FormatoA formatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearFormatoA'");
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoPorTitulo(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeFormatoPorTitulo'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> listarPorDocente(Integer idDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorDocente'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> listarPorTituloEntreFechas(String titulo, Date fechaInicio, Date fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorTituloEntreFechas'");
    }

    @Override
    @Transactional(readOnly = true)
    public Integer obtenerUltimaEvaluacion(Integer idFormatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUltimaEvaluacion'");
    }
    
}
