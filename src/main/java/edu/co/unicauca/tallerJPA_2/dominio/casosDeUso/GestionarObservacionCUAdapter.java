package edu.co.unicauca.tallerJPA_2.dominio.casosDeUso;

import java.util.Date;
import java.util.List;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarObservacionCUIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarDocenteGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarFormatoAGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarObservacionGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;

public class GestionarObservacionCUAdapter implements GestionarObservacionCUIntPort{

    public final GestionarObservacionGatewayIntPort objGestionarObservacionGateway;
    public final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    public final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    public final FormateadorResultadosIntPort objFormatoResultados;

    public GestionarObservacionCUAdapter(GestionarObservacionGatewayIntPort objGestionarObservacionGateway,
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            FormateadorResultadosIntPort objFormatoResultados) {
        this.objGestionarObservacionGateway = objGestionarObservacionGateway;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objFormatoResultados = objFormatoResultados;
    }

    @Override
    public Observacion crearObservacion(Observacion objObservacion) {
        if (!this.objGestionarFormatoAGateway.existeFormatoPorId(objObservacion.getIdFormatoA())) {
            objFormatoResultados.retornarRespuestaErrorEntidadNoExiste("No existe un formato A con el id: " + objObservacion.getIdFormatoA());
            return null;
        }

        for (Docente objDocente : objObservacion.getDocentes()) {
            if (!this.objGestionarDocenteGateway.existeDocentePorId(objDocente.getIdDocente())) {
                objFormatoResultados.retornarRespuestaErrorEntidadNoExiste("No existe un docente con el id: " + objDocente.getIdDocente());
                return null;
            }
        }

        objObservacion.setFechaRegistroObservacion(new Date());

        Observacion objObservacionCreada = this.objGestionarObservacionGateway.guardarObservacion(objObservacion);

        return objObservacionCreada;
    }

    @Override
    public List<Observacion> listarObservacionesPorFormato(Integer idFormatoA) {
        if (!this.objGestionarFormatoAGateway.existeFormatoPorId(idFormatoA)) {
            objFormatoResultados.retornarRespuestaErrorEntidadNoExiste("No existe un formato A con el id: " + idFormatoA);
            return null;
        }

        return null;
    }
    
}
