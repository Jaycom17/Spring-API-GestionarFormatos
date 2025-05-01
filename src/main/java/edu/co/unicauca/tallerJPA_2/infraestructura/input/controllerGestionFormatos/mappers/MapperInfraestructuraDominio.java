package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
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
    public ModelMapper crearDocenteMapperInfraestructuraDominio() {
        return new ModelMapper();
    }

    @Bean("FormatoAMapperInfraestructuraDominio")
    public ModelMapper crearFormatoAMapperInfraestructuraDominio() {
        return new ModelMapper();
    }

    @Bean("ObservacionMapperInfraestructuraDominio")
    public ModelMapper crearObservacionMapperInfraestructuraDominio() {
        ModelMapper objMapper = new ModelMapper();
        objMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Converter para List<Integer> -> List<Docente>
        Converter<List<Integer>, List<Docente>> docentesConverter = ctx -> {
            List<Integer> ids = ctx.getSource();
            if (ids == null) {
                return null;
            }
            return ids.stream()
                    .map(id -> {
                        Docente docente = new Docente();
                        docente.setIdDocente(id);
                        return docente;
                    })
                    .collect(Collectors.toList());
        };

        // Configuración del mapeo
        objMapper.createTypeMap(ObservacionDTOPeticion.class, Observacion.class)
                .addMappings(mapper -> {
                    mapper.map(ObservacionDTOPeticion::getIdFormatoA, Observacion::setIdFormatoA);
                    mapper.using(docentesConverter).map(ObservacionDTOPeticion::getDocentes, Observacion::setDocentes);
                });

        return objMapper;
    }
}
