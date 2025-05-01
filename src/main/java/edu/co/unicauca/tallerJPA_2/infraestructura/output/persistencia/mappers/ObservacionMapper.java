package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservacionMapper {
    @Bean("ObservacionMapperPersistenciaDominio")
    public ModelMapper crearObservacionMapper(){
        return new ModelMapper();
    }
}
