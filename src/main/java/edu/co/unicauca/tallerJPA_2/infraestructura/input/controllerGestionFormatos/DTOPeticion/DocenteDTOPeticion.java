package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "{user.name.empty}")
    @Size(min = 5, max = 45, message = "{user.name.length}")
    private String nombresDocente;

    @NotNull(message = "{user.name.empty}")
    @Size(min = 5, max = 45, message = "{user.lastname.length}")
    private String apellidosDocente;

    @NotNull(message = "{user.group.empty}")
    @Size(min = 5, max = 45, message = "La cantidad de caracteres para el grupo de investigación debe estar entre 5 y 45")
    private String nombreGrupo;

    @NotNull(message = "{user.email.empty}")
    @Email(message = "{user.email.mask}")
    private String correo;
}
