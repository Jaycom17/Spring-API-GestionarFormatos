package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FormatoppADTOPeticion extends FormatoADTOPeticion {
    private String nombreAsesor;
    private String rutaCartaAceptacion;
}
