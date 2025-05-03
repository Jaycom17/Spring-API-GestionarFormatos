package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.FormatoADTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.ObservacionDTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatoADTORespuesta;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.HistoricoDTORespuesta;

@Configuration
public class MapperInfraestructuraDominio {

    @Bean("DocenteMapperInfraestructuraDominio")
    public ModelMapper crearDocenteMapperInfraestructuraDominio() {
        return new ModelMapper();
    }

    @Bean("FormatoAMapperInfraestructuraDominio")
    public ModelMapper crearFormatoAMapperInfraestructuraDominio() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);

        modelMapper.typeMap(FormatoADTOPeticion.class, FormatoA.class)
            .addMappings(mapper -> {

                mapper.using(ctx -> {
                    List<String> list = (List<String>) ctx.getSource();
                    if (list == null) {
                        return null;
                    }

                    // Convertir la lista de cadenas a una cadena separada por ;
                    return list.stream()
                            .collect(Collectors.joining(";"));

                }).map(FormatoADTOPeticion::getObjetivosEspecificos, FormatoA::setObjetivosEspecificos);
            });

        modelMapper.typeMap(FormatoA.class, FormatoADTORespuesta.class).addMappings(mapper -> {
            mapper.using(ctx -> {
                String list = (String) ctx.getSource();
                if (list == null) {
                    return null;
                }

                // Convertir la cadena separada por ; a una lista de cadenas
                return List.of(list.split(";"));
            }).map(FormatoA::getObjetivosEspecificos, FormatoADTORespuesta::setObjetivosEspecificos);
        });

        return modelMapper;
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

    @Bean("HistoricoMapperInfraestructuraDominio")
    public ModelMapper crearHistoricoMapperInfraestructuraDominio() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);

        modelMapper.typeMap(Historico.class, HistoricoDTORespuesta.class).addMappings(mapper -> {
            mapper.skip(HistoricoDTORespuesta::setObjRol);
        });

        return modelMapper;
    }
}
