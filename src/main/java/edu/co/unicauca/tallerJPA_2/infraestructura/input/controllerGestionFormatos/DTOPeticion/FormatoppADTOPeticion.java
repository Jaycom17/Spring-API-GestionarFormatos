package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import javax.validation.constraints.NotNull;
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
public class FormatoppADTOPeticion extends FormatoADTOPeticion {
    @NotNull(message = "{user.name.empty}")
    @Size(min = 5, max = 45, message = "{user.name.length}")
    private String nombreAsesor;

    @NotNull(message = "{user.rut.empty}")
    private String rutaCartaAceptacion;
}
