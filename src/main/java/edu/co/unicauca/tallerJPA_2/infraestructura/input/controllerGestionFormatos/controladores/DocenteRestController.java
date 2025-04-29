package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarDocenteCUIntPort;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.DocenteDTORespuesta;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/docentes")
public class DocenteRestController {
    private final GestionarDocenteCUIntPort objGestionarDocenteCUIntPort;
    private final ModelMapper objMapeador;

    public DocenteRestController(GestionarDocenteCUIntPort objGestionarDocenteCUIntPort,
            @Qualifier("DocenteMapperInfraestructuraDominio") ModelMapper objMapeador) {
        this.objGestionarDocenteCUIntPort = objGestionarDocenteCUIntPort;
        this.objMapeador = objMapeador;
    }

    @GetMapping("/docentesPorGrupo")
    public ResponseEntity<List<DocenteDTORespuesta>> listarDocentesPorGrupo(
            @RequestParam String nombreGrupo,
            @RequestParam String patronBusqueda) {
        List<DocenteDTORespuesta> respuesta = objMapeador.map(
                objGestionarDocenteCUIntPort.listarDocentesPorGrupoPatron(nombreGrupo, patronBusqueda),
                new TypeToken<List<DocenteDTORespuesta>>() {
                }.getType());

        return ResponseEntity.ok(respuesta);
    }

}
