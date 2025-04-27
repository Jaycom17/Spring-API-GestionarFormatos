package edu.co.unicauca.tallerJPA_2.aplicacion.output;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {
    boolean existeDocentePorCorreo(String correo);
    boolean existeDocentePorId(Integer idDocente);public List<Docente> listarDocentesPorGrupoPatron(String nombreGrupo, String patronBusqueda);
    List<Docente> listarMiembrosComite();
}
