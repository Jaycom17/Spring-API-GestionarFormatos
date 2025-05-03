package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.HistoricoEntity;


@Configuration
public class HistoricoMapper {
    @Bean("HistoricoMapperPersistenciaDominio")
    public ModelMapper crearFormatoAMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setSkipNullEnabled(true);

        modelMapper.typeMap(HistoricoEntity.class, Historico.class)
            .addMappings(mapper -> {
                
                mapper.skip(Historico::setObjRol);

                mapper.using(ctx -> {
                    DocenteEntity entity = (DocenteEntity) ctx.getSource();
                    if (entity == null){
                        return null;
                    }

                    Docente docente = new Docente();

                    docente.setIdDocente(entity.getIdDocente());
                    docente.setNombresDocente(entity.getNombresDocente());
                    docente.setApellidosDocente(entity.getApellidosDocente());
                    docente.setNombreGrupo(entity.getNombreGrupo());
                    docente.setCorreo(entity.getCorreo());

                    return docente;
                }).map(HistoricoEntity::getObjDocente, Historico::setObjDocente);
            });

        
        return modelMapper;
    }

}
