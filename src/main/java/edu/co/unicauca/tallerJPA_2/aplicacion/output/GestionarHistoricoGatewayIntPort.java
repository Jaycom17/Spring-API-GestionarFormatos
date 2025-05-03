package edu.co.unicauca.tallerJPA_2.aplicacion.output;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;

public interface GestionarHistoricoGatewayIntPort {
    List<Historico> listarMiembrosComite();
}
