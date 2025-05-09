package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones.ObjetivosSonVerbosValidatorInt;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

  @NotEmpty(message = "{user.objetg.empty}")
  private String objetivoGeneral;
  
  @NotNull(message = "{user.objetesp.empty}")
  @Size(min = 3, max = 5, message = "{user.objetesp.length}")
  @ObjetivosSonVerbosValidatorInt
  private List<String> objetivosEspecificos;

  @NotEmpty(message = "{user.cod.empty}")
  @Pattern(message = "{user.cod.pattern}", regexp = "^1046\\d{8}$")
  private String codigoEstudiante1;

  @NotNull(message = "{user.name.empty}")
  @Size(min = 5, max = 45, message = "{user.name.length}")
  private String nombreEstudiante1;

  @NotNull(message = "{user.name.empty}")
  @Valid
  private DocenteDTOPeticion objDocente;
}
