package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

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
    private String nombreAsesor;
    private String rutaCartaAceptacion;
}
