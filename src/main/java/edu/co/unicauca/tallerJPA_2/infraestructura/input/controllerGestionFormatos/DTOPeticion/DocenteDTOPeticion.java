package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

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
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
}
