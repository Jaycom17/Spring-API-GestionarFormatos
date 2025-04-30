package edu.co.unicauca.tallerJPA_2.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.controladorExepciones.excepcionesPropias.EntidadNoExisteException;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.controladorExepciones.excepcionesPropias.EntidadYaExisteException;
import edu.co.unicauca.tallerJPA_2.infraestructura.output.controladorExepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;
    }

}
