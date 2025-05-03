package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarObservacionGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.ObservacionEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.DocenteRepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.EvaluacionRepository;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.repositorios.ObservacionRepository;

@Service
public class GestionarObservacionGatewayImplAdapter implements GestionarObservacionGatewayIntPort{

    private final ObservacionRepository objObservacionRepository;
    private final DocenteRepository objDocenteRepository;
    private final EvaluacionRepository objEvaluacionRepository;
    private final ModelMapper observacionModelMapper;

    public GestionarObservacionGatewayImplAdapter(ObservacionRepository objObservacionRepository, DocenteRepository objDocenteRepository,
    EvaluacionRepository objEvaluacionRepository, @Qualifier("ObservacionMapperPersistenciaDominio") ModelMapper observacionModelMapper) {
        this.objObservacionRepository = objObservacionRepository;
        this.objDocenteRepository = objDocenteRepository;
        this.objEvaluacionRepository = objEvaluacionRepository;
        this.observacionModelMapper = observacionModelMapper;
    }

    @Override
    @Transactional
    public Observacion guardarObservacion(Observacion objObservacion) {

        ObservacionEntity observacionEntity = this.observacionModelMapper.map(objObservacion, ObservacionEntity.class);

        List<DocenteEntity> docentes = new ArrayList<DocenteEntity>();

        for (Docente docente : objObservacion.getDocentes()) {
            docentes.add(this.objDocenteRepository.getReferenceById(docente.getIdDocente()));
        }

        Integer idEvaluacion = this.objEvaluacionRepository.findLastEvaluacionIdByFormatoAId(objObservacion.getIdFormatoA());

        EvaluacionEntity evaluacionEntity = this.objEvaluacionRepository.getReferenceById(idEvaluacion);

        observacionEntity.setDocentes(docentes);
        observacionEntity.setObjEvaluacion(evaluacionEntity);

        ObservacionEntity observacionCreada = this.objObservacionRepository.save(observacionEntity);

        Observacion objObservacionCreada = this.observacionModelMapper.map(observacionCreada, Observacion.class);

        return objObservacionCreada;
    }

    @Override
    public List<Observacion> listarPorFormato(Integer idFormatoA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorFormato'");
    }

    @Override
    @Transactional(readOnly = true)
    public Integer encontrarUltimaEvaluacionPorFormato(Integer idFormatoA) {
        Integer idEvaluacion = this.objEvaluacionRepository.findLastEvaluacionIdByFormatoAId(idFormatoA);
        return idEvaluacion;
    }
    
}
