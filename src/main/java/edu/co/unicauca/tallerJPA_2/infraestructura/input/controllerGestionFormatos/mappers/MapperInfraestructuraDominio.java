package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
}
