package edu.co.unicauca.tallerJPA_2.aplicacion.input;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Historico;

public interface GestionarHistoricoCUIntPort {
    List<Historico> listarMiembrosComite();
}
