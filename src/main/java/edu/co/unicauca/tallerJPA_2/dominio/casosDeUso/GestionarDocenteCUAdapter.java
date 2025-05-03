package edu.co.unicauca.tallerJPA_2.dominio.casosDeUso;

import java.util.List;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarDocenteCUIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.FormateadorResultadosIntPort;
import edu.co.unicauca.tallerJPA_2.aplicacion.output.GestionarDocenteGatewayIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objProductoFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort objProductoFormateadorResultados) {
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objProductoFormateadorResultados = objProductoFormateadorResultados;
    }

    @Override
    public List<Docente> listarDocentesPorGrupoPatron(String nombreGrupo, String patronBusqueda) {

        System.out.println("Nombre del grupo: " + nombreGrupo);
        System.out.println("Patrón de búsqueda: " + patronBusqueda);

        List<Docente> listaObtenida = objGestionarDocenteGateway.listarDocentesPorGrupoPatron(nombreGrupo, patronBusqueda);

        return listaObtenida;
    }
    
}
