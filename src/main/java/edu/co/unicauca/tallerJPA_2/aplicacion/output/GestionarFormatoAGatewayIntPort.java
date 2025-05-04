package edu.co.unicauca.tallerJPA_2.aplicacion.output;

import java.util.Date;
import java.util.List;

import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;

public interface GestionarFormatoAGatewayIntPort {
    public FormatoA crearFormatoA(FormatoA formatoA);
    public boolean existeFormatoPorTitulo(String titulo);
    public List<FormatoA> listarPorDocente(Integer idDocente);
    public List<FormatoA> listarPorTituloEntreFechas(String titulo, Date fechaInicio, Date fechaFin);
    public List<FormatoA> listarPorDocenteYFechas(Integer idDocente, Date fechaInicio, Date fechaFin);
    public boolean existeFormatoPorId(Integer idFormatoA);
}
