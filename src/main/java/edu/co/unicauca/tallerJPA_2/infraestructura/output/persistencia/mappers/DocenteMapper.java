package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.DocenteEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoppAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatotiAEntity;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades.FormatoAEntity;

import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatoppADTORespuesta;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatotiADTORespuesta;

@Configuration
public class DocenteMapper {

    @Bean("DocenteMapperPersistenciaDominio")
    public ModelMapper crearDocenteMapper() {
        ModelMapper objMapper = new ModelMapper();

        // Mapear DocenteEntity -> Docente básico
        TypeMap<DocenteEntity, Docente> mapa = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        mapa.addMappings(m -> m.skip(Docente::setObservaciones)).implicitMappings();

        // Mapear los formatos de manera correcta
        objMapper.typeMap(DocenteEntity.class, Docente.class)
            .addMappings(mapper -> mapper.using(ctx -> {
                List<FormatoAEntity> formatos = (List<FormatoAEntity>) ctx.getSource();
                if (formatos == null) return new ArrayList<>();

                return formatos.stream().map(formato -> {
                    if (formato instanceof FormatoppAEntity formatoPP) {
                        // Mapea los campos del padre + los del hijo
                        FormatoppADTORespuesta dto = new FormatoppADTORespuesta();
                        dto.setIdFormatoA(formatoPP.getIdFormatoA());
                        dto.setTitulo(formatoPP.getTitulo());
                        dto.setObjetivoGeneral(formatoPP.getObjetivoGeneral());
                        dto.setObjetivosEspecificos(List.of(formatoPP.getObjetivosEspecificos().split(";")));
                        dto.setNombreEstudiante1(formatoPP.getNombreEstudiante1());
                        dto.setFechaCreacion(formatoPP.getFechaCreacion());
                        dto.setCodigoEstudiante1(formatoPP.getCodigoEstudiante1());
                        // puedes omitir objDocente, objEstado, evaluaciones si quieres
                        dto.setNombreAsesor(formatoPP.getNombreAsesor());
                        dto.setRutaCartaAceptacion(formatoPP.getRutaCartaAceptacion());
                        return dto;
                    } else if (formato instanceof FormatotiAEntity formatoTI) {
                        FormatotiADTORespuesta dto = new FormatotiADTORespuesta();
                        dto.setIdFormatoA(formatoTI.getIdFormatoA());
                        dto.setTitulo(formatoTI.getTitulo());
                        dto.setObjetivoGeneral(formatoTI.getObjetivoGeneral());
                        dto.setObjetivosEspecificos(List.of(formatoTI.getObjetivosEspecificos().split(";")));
                        dto.setNombreEstudiante1(formatoTI.getNombreEstudiante1());
                        dto.setNombreEstudiante2(formatoTI.getNombreEstudiante2());
                        dto.setCodigoEstudiante1(formatoTI.getCodigoEstudiante1());
                        dto.setCodigoEstudiante2(formatoTI.getCodigoEstudiante2());
                        dto.setFechaCreacion(formatoTI.getFechaCreacion());
                        return dto;
                    } else {
                        return null;
                    }
                }).filter(Objects::nonNull)
                  .collect(Collectors.toList());
            }).map(DocenteEntity::getFormatos, Docente::setFormatos));

        // Mapear los formatos de manera correcta

        return objMapper;
    }
}