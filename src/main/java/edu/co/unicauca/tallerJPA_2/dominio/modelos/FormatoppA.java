package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormatoppA extends FormatoA {
    private String nombreAsesor;
    private String rutaCartaAceptacion;

    public FormatoppA() {
        super();
    }

    public FormatoppA(String titulo, String objetivoGeneral, String objetivosEspecifico, String nombreEstudiante1, String nombreAsesor, String rutaCartaAceptacion, String codigoEstudiante1) {
        super(titulo, objetivoGeneral, objetivosEspecifico, nombreEstudiante1, codigoEstudiante1);
        this.nombreAsesor = nombreAsesor;
        this.rutaCartaAceptacion = rutaCartaAceptacion;
    }
}
