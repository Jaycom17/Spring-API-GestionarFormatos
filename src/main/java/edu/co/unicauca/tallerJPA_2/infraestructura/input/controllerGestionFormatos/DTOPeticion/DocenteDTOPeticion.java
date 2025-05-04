package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones.ValidDocenteDTOPeticion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidDocenteDTOPeticion
public class DocenteDTOPeticion {

    private Integer idDocente;

    @Size(min = 5, max = 45, message = "{user.name.length}")
    private String nombresDocente;

    @Size(min = 5, max = 45, message = "{user.lastname.length}")
    private String apellidosDocente;

    @Size(min = 5, max = 45, message = "La cantidad de caracteres para el grupo de investigación debe estar entre 5 y 45")
    private String nombreGrupo;

    @Email(message = "{user.email.mask}")
    private String correo;
}
