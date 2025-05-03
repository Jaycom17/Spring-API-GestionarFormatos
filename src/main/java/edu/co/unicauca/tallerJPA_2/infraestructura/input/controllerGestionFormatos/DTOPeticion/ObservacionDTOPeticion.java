package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

import java.util.List;

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
public class ObservacionDTOPeticion {
    @NotNull(message = "{user.observation.empty}")
    private String observacion;
    
    private Integer idFormatoA;
    
    @NotNull(message = "{user.observation.docenteempty}")
    @Size(min = 1, max = 10)
    private List<Integer> docentes;
}
