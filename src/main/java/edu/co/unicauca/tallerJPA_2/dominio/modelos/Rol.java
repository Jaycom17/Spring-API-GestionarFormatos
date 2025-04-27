package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rol {
    private Integer idRol;
    private String rolAsignado;
    
    public Rol() {
    }
}
