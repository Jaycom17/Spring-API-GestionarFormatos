package edu.co.unicauca.tallerJPA_2.dominio.casosDeUso;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarHistoricoCUIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarHistoricoGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;

public class GestionarHistoricoCUAdapter implements GestionarHistoricoCUIntPort{

    private final GestionarHistoricoGatewayIntPort objGestionarHistoricoGateway;
    private final FormateadorResultadosIntPort formateadorResultados;

    public GestionarHistoricoCUAdapter(GestionarHistoricoGatewayIntPort objGestionarHistoricoGateway,
            FormateadorResultadosIntPort formateadorResultados) {
        this.objGestionarHistoricoGateway = objGestionarHistoricoGateway;
        this.formateadorResultados = formateadorResultados;
    }

    @Override
    public List<Historico> listarMiembrosComite() {
        List<Historico> listaMiembrosComite = objGestionarHistoricoGateway.listarMiembrosComite();
        if (listaMiembrosComite.isEmpty()) {
            formateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error, no existen miembros del comite");
            return null;
        }
        return listaMiembrosComite;
    }
    
}
