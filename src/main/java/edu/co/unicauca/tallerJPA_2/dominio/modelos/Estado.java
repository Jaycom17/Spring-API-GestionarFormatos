package edu.co.unicauca.tallerJPA_2.dominio.modelos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Estado {
    private Integer idEstado;
    private String estadoActual;
    private Date fechaRegistroEstado;

    private FormatoA objFormatoA;

    public Estado(){}
}
