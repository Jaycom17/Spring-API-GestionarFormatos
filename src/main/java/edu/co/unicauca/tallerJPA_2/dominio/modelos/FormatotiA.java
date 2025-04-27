package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormatotiA extends FormatoA{
    private String nombreEstudiante2;

    public FormatotiA() {
        super();
    }

    public FormatotiA(String titulo, String objetivoGeneral, String objetivosEspecifico, String nombreEstudiante1, String nombreEstudiante2) {
        super(titulo, objetivoGeneral, objetivosEspecifico, nombreEstudiante1);
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
