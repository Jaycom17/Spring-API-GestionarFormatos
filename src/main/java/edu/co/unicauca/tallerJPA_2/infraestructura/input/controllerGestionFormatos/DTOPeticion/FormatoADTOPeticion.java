package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

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
  @JsonSubTypes.Type(value = FormatoppADTOPeticion.class, name = "pp"),
  @JsonSubTypes.Type(value = FormatotiADTOPeticion.class, name = "ti")
})
public abstract class FormatoADTOPeticion {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String nombreEstudiante1;

    private DocenteDTOPeticion objDocente;
}
