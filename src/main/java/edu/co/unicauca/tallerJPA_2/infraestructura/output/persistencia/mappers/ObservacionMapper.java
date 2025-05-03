package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Evaluacion;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.ObservacionEntity;

@Configuration
public class ObservacionMapper {
    @Bean("ObservacionMapperPersistenciaDominio")
    public ModelMapper crearObservacionMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);

        TypeMap<ObservacionEntity, Observacion> typeMap = modelMapper.createTypeMap(ObservacionEntity.class,
                Observacion.class);

        typeMap.addMappings(mapper -> {
            mapper.map(ObservacionEntity::getIdObservacion, Observacion::setIdObservacion);
            mapper.map(ObservacionEntity::getObservacion, Observacion::setObservacion);
            mapper.map(ObservacionEntity::getFechaRegistroObservacion, Observacion::setFechaRegistroObservacion);

            // Extraer solo el ID del formato desde la evaluación
            mapper.map(src -> src.getObjEvaluacion().getObjFormatoA().getIdFormatoA(), Observacion::setIdFormatoA);

            // Si quieres traer Evaluacion parcial, puedes crear un convertidor
            // personalizado:
            mapper.using(ctx -> {
                EvaluacionEntity entity = (EvaluacionEntity) ctx.getSource();
                if (entity == null)
                    return null;
                Evaluacion evaluacion = new Evaluacion();
                evaluacion.setIdEvaluacion(entity.getIdEvaluacion());
                evaluacion.setConcepto(entity.getConcepto());
                evaluacion.setFechaRegistroConcepto(entity.getFechaRegistroConcepto());
                evaluacion.setNombreCoordinador(entity.getNombreCoordinador());
                return evaluacion;
            }).map(ObservacionEntity::getObjEvaluacion, Observacion::setObjEvaluacion);

            // Mismo con docentes
            mapper.using(ctx -> {
                List<DocenteEntity> lista = (List<DocenteEntity>) ctx.getSource();
                if (lista == null)
                    return new ArrayList<>();
                return lista.stream()
                        .map(doc -> {
                            Docente docente = new Docente();

                            docente.setIdDocente(doc.getIdDocente());
                            docente.setNombresDocente(doc.getNombresDocente());
                            docente.setNombreGrupo(doc.getNombreGrupo());
                            docente.setCorreo(doc.getCorreo());
                            docente.setApellidosDocente(doc.getApellidosDocente());

                            return docente;
                        })
                        .collect(Collectors.toList());
            }).map(ObservacionEntity::getDocentes, Observacion::setDocentes);
        });

        return modelMapper;
    }
}
