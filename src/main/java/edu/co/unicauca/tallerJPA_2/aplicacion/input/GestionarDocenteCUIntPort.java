package edu.co.unicauca.tallerJPA_2.aplicacion.input;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {
    public List<Docente> listarDocentesPorGrupoPatron(String nombreGrupo, String patronBusqueda);
}
