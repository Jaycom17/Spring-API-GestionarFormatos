package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
  @NotNull(message = "{user.title.empty}")
  @Size(min = 20, message = "{user.title.length}")
  private String titulo;

  @NotNull(message = "{user.objetg.empty}")
  @Size(min = 50, message = "{user.objetg.length}")
  private String objetivoGeneral;
  
  @NotNull(message = "{user.objetesp.empty}")
  @Size(min = 3, max = 5, message = "{user.objetesp.length}")
  private List<String> objetivosEspecificos;

  @NotNull(message = "{user.cod.empty}")
  @Pattern(message = "{user.cod.pattern}", regexp = "[1046][0-12]{11}")
  private String codigoEstudiante1;

  @NotNull(message = "{user.name.empty}")
  @Size(min = 5, max = 45, message = "{user.name.length}")
  private String nombreEstudiante1;

  @NotNull(message = "{user.name.empty}")
  @Size(min = 5, max = 45, message = "{user.name.length}")
  private DocenteDTOPeticion objDocente;
}
