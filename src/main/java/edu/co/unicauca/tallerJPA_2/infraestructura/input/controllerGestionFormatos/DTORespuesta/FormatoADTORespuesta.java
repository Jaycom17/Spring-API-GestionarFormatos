package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type"
)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FormatoppADTORespuesta.class, name = "pp"),
  @JsonSubTypes.Type(value = FormatotiADTORespuesta.class, name = "ti")
})
public abstract class FormatoADTORespuesta {
    private Integer idFormatoA;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String nombreEstudiante1;
    private Date fechaCreacion;

    private DocenteDTORespuesta objDocente;
    private EstadoDTORespuesta objEstado;
}
