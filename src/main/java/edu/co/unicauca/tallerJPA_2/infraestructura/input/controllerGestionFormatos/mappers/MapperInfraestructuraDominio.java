package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.mappers;

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
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.ObservacionDTOPeticion;


@Configuration
public class MapperInfraestructuraDominio {

    @Bean("DocenteMapperInfraestructuraDominio")
    public ModelMapper crearDocenteMapperInfraestructuraDominio(){
        return new ModelMapper();
    }

    @Bean("FormatoAMapperInfraestructuraDominio")
    public ModelMapper crearFormatoAMapperInfraestructuraDominio(){
        return new ModelMapper();
    }

    @Bean("ObservacionMapperInfraestructuraDominio")
    public ModelMapper crearObservacionMapperInfraestructuraDominio(){
        ModelMapper objMapper = new ModelMapper();

        objMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        // Configuración para mapear Integer objEvaluacion a Evaluacion
        TypeMap<ObservacionDTOPeticion, Observacion> typeMap = objMapper.createTypeMap(ObservacionDTOPeticion.class, Observacion.class);
        
        // Mapeo personalizado para objEvaluacion
        typeMap.addMappings(mapper -> {
            mapper.<Integer>map(ObservacionDTOPeticion::getObjEvaluacion, (dest, v) -> {
                if (v != null) {
                    Evaluacion evaluacion = new Evaluacion();
                    evaluacion.setIdEvaluacion(v);
                    dest.setObjEvaluacion(evaluacion);
                }
            });
        });
        
        // Mapeo personalizado para docentes
        typeMap.addMappings(mapper -> {
            mapper.<List<Integer>>map(ObservacionDTOPeticion::getDocentes, (dest, v) -> {
                if (v != null) {
                    List<Docente> docentes = v.stream()
                        .map(id -> {
                            Docente docente = new Docente();
                            docente.setIdDocente(id);
                            return docente;
                        })
                        .collect(Collectors.toList());
                    dest.setDocentes(docentes);
                }
            });
        });
        return objMapper;
    }
}
