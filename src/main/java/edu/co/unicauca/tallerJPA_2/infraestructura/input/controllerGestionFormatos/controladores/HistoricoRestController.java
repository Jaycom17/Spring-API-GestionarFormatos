package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarHistoricoCUIntPort;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.HistoricoDTORespuesta;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/historicos")
public class HistoricoRestController {
    
    private final GestionarHistoricoCUIntPort objGestionarHistoricoCUIntPort;
    private final ModelMapper objMapeador;

    public HistoricoRestController(GestionarHistoricoCUIntPort objGestionarHistoricoCUIntPort,@Qualifier("HistoricoMapperInfraestructuraDominio") ModelMapper objMapeador) {
        this.objGestionarHistoricoCUIntPort = objGestionarHistoricoCUIntPort;
        this.objMapeador = objMapeador;
    }

    @GetMapping("/miembrosComite")
    public ResponseEntity<List<HistoricoDTORespuesta>> listarMiembrosComite() {
        List<HistoricoDTORespuesta> respuesta = objMapeador.map(
                objGestionarHistoricoCUIntPort.listarMiembrosComite(),
                new org.modelmapper.TypeToken<List<HistoricoDTORespuesta>>() {}.getType());

        return ResponseEntity.ok(respuesta);
    }
    
}
