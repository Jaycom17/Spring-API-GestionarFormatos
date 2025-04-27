package edu.co.unicauca.tallerJPA_2.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("FormatoppA") 
@Getter
@Setter
public class FormatoppAEntity extends FormatoAEntity {
    @Column(name = "nombre_asesor", length = 100)
    private String nombreAsesor;
    @Column(name = "ruta_carta_aceptacion", length = 255)
    private String rutaCartaAceptacion;

    public FormatoppAEntity() {
        super();
    }

    public FormatoppAEntity(String titulo, String objetivoGeneral, String objetivosEspecifico, String nombreEstudiante1, String nombreAsesor, String rutaCartaAceptacion) {
        super(titulo, objetivoGeneral, objetivosEspecifico, nombreEstudiante1);
        this.nombreAsesor = nombreAsesor;
        this.rutaCartaAceptacion = rutaCartaAceptacion;
    }
}
    
