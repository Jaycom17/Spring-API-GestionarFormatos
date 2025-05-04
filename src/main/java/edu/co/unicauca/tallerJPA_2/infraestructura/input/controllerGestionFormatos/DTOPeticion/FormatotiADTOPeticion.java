package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Pattern(message = "{user.cod.pattern}", regexp = "^1046\\d{8}$")
    private String codigoEstudiante2;
}
