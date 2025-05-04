package edu.co.unicauca.tallerJPA_2.dominio.casosDeUso;

import java.util.Date;
import java.util.List;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarFormatoACUIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarDocenteGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarFormatoAGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;

public class GestionarFormatosACUAdapter implements GestionarFormatoACUIntPort {

    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormatoResultados;

    public GestionarFormatosACUAdapter(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway,
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objFormatoResultados) {
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objFormatoResultados = objFormatoResultados;
    }

    @Override
    public FormatoA crearFormatoA(FormatoA objFormatoA) {

        FormatoA objRetornarFormatoA = null;

        System.out.println("Creando Formato A: " + objFormatoA.getObjetivosEspecificos());

        if (objGestionarFormatoAGateway.existeFormatoPorTitulo(objFormatoA.getTitulo())) {
            this.objFormatoResultados.retornarRespuestaErrorEntidadExiste(
                    "Error, ya existe un formato con el titulo: " + objFormatoA.getTitulo());
            return null;

        }

        if (objFormatoA.getObjDocente().getIdDocente() == null) {
            if (objGestionarDocenteGateway.existeDocentePorCorreo(objFormatoA.getObjDocente().getCorreo())) {
                this.objFormatoResultados.retornarRespuestaErrorEntidadExiste(
                        "Error, se encuentra en el sistema un docente con el correo: "
                                + objFormatoA.getObjDocente().getCorreo());
                return null;
            }
        } else {
            if (!objGestionarDocenteGateway.existeDocentePorId(objFormatoA.getObjDocente().getIdDocente())) {
                this.objFormatoResultados
                        .retornarRespuestaErrorEntidadNoExiste("Error, no existe un docente con ese ID");
                return null;
            }
        }

        objFormatoA.setFechaCreacion(new Date());

        objRetornarFormatoA = objGestionarFormatoAGateway.crearFormatoA(objFormatoA);

        return objRetornarFormatoA;
    }

    @Override
    public List<FormatoA> listarPorDocente(Integer idDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorDocente'");
    }

    @Override
    public List<FormatoA> listarPorTituloEntreFechas(String titulo, Date fechaInicio, Date fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorTituloEntreFechas'");
    }

}
