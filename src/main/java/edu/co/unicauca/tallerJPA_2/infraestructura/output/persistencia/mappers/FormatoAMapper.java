package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;

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
