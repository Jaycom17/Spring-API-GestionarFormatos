package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Estado;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Evaluacion;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoppA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatotiA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EstadoEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoppAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatotiAEntity;

@Configuration
public class FormatoAMapper {

    @Bean("FormatoAMapperPersistenciaDominio")
    public ModelMapper crearFormatoAMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
        // Configuración general
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);
        
        // Configuración específica para DocenteEntity -> Docente
        configurarMapeoDocente(modelMapper);

        modelMapper.typeMap(FormatoppAEntity.class, FormatoppA.class).addMappings(mapper -> {
            mapper.using(ctx -> {
                List<EvaluacionEntity> evaluaciones = (List<EvaluacionEntity>) ctx.getSource();

                if (evaluaciones == null) return new ArrayList<>();

                return evaluaciones.stream().map(evaluacion -> {

                    Evaluacion eval = new Evaluacion();

                    eval.setIdEvaluacion(evaluacion.getIdEvaluacion());
                    eval.setConcepto(evaluacion.getConcepto());
                    eval.setFechaRegistroConcepto(evaluacion.getFechaRegistroConcepto());

                    List<Observacion> observaciones = new ArrayList<>();

                    if (evaluacion.getObservaciones() != null) {
                        evaluacion.getObservaciones().forEach(observacionEntity -> {
                            Observacion observacion = new Observacion();
                            observacion.setIdObservacion(observacionEntity.getIdObservacion());
                            observacion.setObservacion(observacionEntity.getObservacion());
                            observacion.setFechaRegistroObservacion(observacionEntity.getFechaRegistroObservacion());
                            observaciones.add(observacion);
                        });
                    }

                    eval.setObservaciones(observaciones);

                    return eval;
                }).toList();

            }).map(FormatoppAEntity::getEvaluaciones, FormatoppA::setEvaluaciones);

            // mapear objEstado sin que mapee el formato

            mapper.using(ctx -> {
                EstadoEntity estado = (EstadoEntity) ctx.getSource();
                if (estado == null) return null;

                Estado estadoDominio = new Estado();

                estadoDominio.setIdEstado(estado.getIdEstado());
                estadoDominio.setFechaRegistroEstado(estado.getFechaRegistroEstado());
                estadoDominio.setEstadoActual(estado.getEstadoActual());

                return estadoDominio;
            }).map(FormatoAEntity::getObjEstado, FormatoppA::setObjEstado);
        });

        modelMapper.typeMap(FormatotiAEntity.class, FormatotiA.class).addMappings(mapper -> {
            mapper.using(ctx -> {
                List<EvaluacionEntity> evaluaciones = (List<EvaluacionEntity>) ctx.getSource();

                if (evaluaciones == null) return new ArrayList<>();

                return evaluaciones.stream().map(evaluacion -> {

                    Evaluacion eval = new Evaluacion();

                    eval.setIdEvaluacion(evaluacion.getIdEvaluacion());
                    eval.setConcepto(evaluacion.getConcepto());
                    eval.setFechaRegistroConcepto(evaluacion.getFechaRegistroConcepto());

                    List<Observacion> observaciones = new ArrayList<>();

                    if (evaluacion.getObservaciones() != null) {
                        evaluacion.getObservaciones().forEach(observacionEntity -> {
                            Observacion observacion = new Observacion();
                            observacion.setIdObservacion(observacionEntity.getIdObservacion());
                            observacion.setObservacion(observacionEntity.getObservacion());
                            observacion.setFechaRegistroObservacion(observacionEntity.getFechaRegistroObservacion());
                            observaciones.add(observacion);
                        });
                    }

                    eval.setObservaciones(observaciones);

                    return eval;
                }).toList();

            }).map(FormatotiAEntity::getEvaluaciones, FormatotiA::setEvaluaciones);

            mapper.using(ctx -> {
                EstadoEntity estado = (EstadoEntity) ctx.getSource();
                if (estado == null) return null;

                Estado estadoDominio = new Estado();

                estadoDominio.setIdEstado(estado.getIdEstado());
                estadoDominio.setFechaRegistroEstado(estado.getFechaRegistroEstado());
                estadoDominio.setEstadoActual(estado.getEstadoActual());

                return estadoDominio;
            }).map(FormatoAEntity::getObjEstado, FormatotiA::setObjEstado);
            
        });
        
        return modelMapper;
    }
    
    private void configurarMapeoDocente(ModelMapper modelMapper) {
        // Mapeo de DocenteEntity a Docente
        modelMapper.typeMap(DocenteEntity.class, Docente.class)
            .addMappings(mapper -> {
                mapper.map(DocenteEntity::getIdDocente, Docente::setIdDocente);
                mapper.map(DocenteEntity::getNombresDocente, Docente::setNombresDocente);
                mapper.map(DocenteEntity::getApellidosDocente, Docente::setApellidosDocente);
                mapper.map(DocenteEntity::getNombreGrupo, Docente::setNombreGrupo);
                mapper.map(DocenteEntity::getCorreo, Docente::setCorreo);

                mapper.skip(Docente::setObservaciones);
                mapper.skip(Docente::setFormatos);
            });
        
        // Mapeo inverso de Docente a DocenteEntity (si es necesario)
        modelMapper.typeMap(Docente.class, DocenteEntity.class)
            .addMappings(mapper -> {
                mapper.map(Docente::getIdDocente, DocenteEntity::setIdDocente);
                mapper.map(Docente::getNombresDocente, DocenteEntity::setNombresDocente);
                mapper.map(Docente::getApellidosDocente, DocenteEntity::setApellidosDocente);
                mapper.map(Docente::getNombreGrupo, DocenteEntity::setNombreGrupo);
                mapper.map(Docente::getCorreo, DocenteEntity::setCorreo);

                mapper.skip(DocenteEntity::setObservaciones);
                mapper.skip(DocenteEntity::setFormatos);
            });
    }
}
