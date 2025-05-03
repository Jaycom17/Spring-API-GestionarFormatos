package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOPeticion {

    private Integer idDocente;
    @NotBlank
    private String nombresDocente;
    @NotBlank
    private String apellidosDocente;
    @NotBlank
    private String nombreGrupo;
    @NotBlank
    @Email
    private String correo;
}
