package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.tallerJPA_2.aplicacion.input.GestionarFormatoACUIntPort;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatoppA;
import edu.co.unicauca.tallerJPA_2.dominio.modelos.FormatotiA;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.FormatoADTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.FormatoppADTOPeticion;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatoADTORespuesta;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatoppADTORespuesta;
import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTORespuesta.FormatotiADTORespuesta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/formatoa")
public class FormatoARestController {
    private final GestionarFormatoACUIntPort objGestionarFormatoACUIntPort;
    private final ModelMapper objMapeador;

    public FormatoARestController(GestionarFormatoACUIntPort objGestionarFormatoACUIntPort, @Qualifier("FormatoAMapperInfraestructuraDominio") ModelMapper objMapeador) {
        this.objGestionarFormatoACUIntPort = objGestionarFormatoACUIntPort;
        this.objMapeador = objMapeador;
    }   

    @PostMapping("") 
    public FormatoADTORespuesta postMethodName(@RequestBody FormatoADTOPeticion formatoA) {

        FormatoA objFormatoADominio = null;
        FormatoADTORespuesta objRespuesta = null;

        if (formatoA instanceof FormatoppADTOPeticion) {
            objFormatoADominio = objMapeador.map(formatoA, FormatoppA.class);
        } else {
            objFormatoADominio = objMapeador.map(formatoA, FormatotiA.class);
        }

        objFormatoADominio = objGestionarFormatoACUIntPort.crearFormatoA(objFormatoADominio);

        if (objFormatoADominio instanceof FormatoppA) {
            objRespuesta = objMapeador.map(objFormatoADominio, FormatoppADTORespuesta.class);
        } else {
            objRespuesta = objMapeador.map(objFormatoADominio, FormatotiADTORespuesta.class);
        }

        
        return objRespuesta;
    }
    
}
