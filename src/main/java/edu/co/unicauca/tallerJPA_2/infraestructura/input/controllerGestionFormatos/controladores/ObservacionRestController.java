package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarObservacionCUIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.Observacion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.ObservacionDTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.ObservacionDTORespuesta;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/observaciones")
public class ObservacionRestController {
    private final GestionarObservacionCUIntPort objGestionarObservacionCUIntPort;
    private final ModelMapper objMapeador;

    public ObservacionRestController(GestionarObservacionCUIntPort objGestionarObservacionCUIntPort, @Qualifier("ObservacionMapperInfraestructuraDominio")
            ModelMapper objMapeador) {
        this.objGestionarObservacionCUIntPort = objGestionarObservacionCUIntPort;
        this.objMapeador = objMapeador;
    }

    @PostMapping("")
    public ObservacionDTORespuesta crearObservacion(@RequestBody ObservacionDTOPeticion observacion) {

        Observacion objObservacion = objMapeador.map(observacion, Observacion.class);

        System.out.println("objObservacion: " + objObservacion.toString());

        objObservacion = objGestionarObservacionCUIntPort.crearObservacion(objObservacion);

        ObservacionDTORespuesta objObservacionDTORespuesta = objMapeador.map(objObservacion, ObservacionDTORespuesta.class);
        
        return objObservacionDTORespuesta;
    }
    
}
