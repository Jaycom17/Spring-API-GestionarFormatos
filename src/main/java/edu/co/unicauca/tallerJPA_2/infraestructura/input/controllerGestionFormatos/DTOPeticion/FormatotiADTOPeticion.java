package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FormatotiADTOPeticion extends FormatoADTOPeticion{
    @NotNull(message = "{user.name.empty}")
    @Size(min = 5, max = 45, message = "{user.name.length}")
    private String nombreEstudiante2;
    
    @NotNull(message = "{user.cod.empty}")
    @Pattern(message = "{user.cod.pattern}", regexp = "[1046][0-12]{11}")
    private String codigoEstudiante2;
}
