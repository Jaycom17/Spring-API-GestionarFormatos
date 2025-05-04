package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarObservacionCUIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.ObservacionDTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.ObservacionDTORespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/observaciones")
@Validated
public class ObservacionRestController {
    private final GestionarObservacionCUIntPort objGestionarObservacionCUIntPort;
    private final ModelMapper objMapeador;

    public ObservacionRestController(GestionarObservacionCUIntPort objGestionarObservacionCUIntPort, @Qualifier("ObservacionMapperInfraestructuraDominio")
            ModelMapper objMapeador) {
        this.objGestionarObservacionCUIntPort = objGestionarObservacionCUIntPort;
        this.objMapeador = objMapeador;
    }

    @PostMapping("")
    public ResponseEntity<ObservacionDTORespuesta> crearObservacion(@Valid @RequestBody ObservacionDTOPeticion observacion) {

        Observacion objObservacion = objMapeador.map(observacion, Observacion.class);

        objObservacion = objGestionarObservacionCUIntPort.crearObservacion(objObservacion);

        ObservacionDTORespuesta objObservacionDTORespuesta = objMapeador.map(objObservacion, ObservacionDTORespuesta.class);
        
        return ResponseEntity.status(201).body(objObservacionDTORespuesta);
    }

    @GetMapping("/listarPorFormato")
    public ResponseEntity<List<ObservacionDTORespuesta>> listarObservacionesPorFormato(@Min(value = 0, message = "{user.idformatoa.min}") @RequestParam Integer idFormatoA) {
        List<Observacion> objObservaciones = objGestionarObservacionCUIntPort.listarObservacionesPorFormato(idFormatoA);

         List<ObservacionDTORespuesta> respuesta = objMapeador.map(objObservaciones,
                new org.modelmapper.TypeToken<List<ObservacionDTORespuesta>>() {}.getType());

        return ResponseEntity.ok(respuesta);
    }
    
    
}
