package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormatotiA extends FormatoA{
    private String nombreEstudiante2;
    private String codigoEstudiante2;

    public FormatotiA() {
        super();
    }

    public FormatotiA(String titulo, String objetivoGeneral, String objetivosEspecifico, String nombreEstudiante1, String nombreEstudiante2, String codigoEstudiante1, String codigoEstudiante2) {
        super(titulo, objetivoGeneral, objetivosEspecifico, nombreEstudiante1, codigoEstudiante1);
        this.nombreEstudiante2 = nombreEstudiante2;
        this.codigoEstudiante2 = codigoEstudiante2;
    }
}
