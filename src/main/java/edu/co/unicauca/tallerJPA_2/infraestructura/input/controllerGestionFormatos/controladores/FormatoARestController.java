package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/formatoa")
@Validated
public class FormatoARestController {
    private final GestionarFormatoACUIntPort objGestionarFormatoACUIntPort;
    private final ModelMapper objMapeador;

    public FormatoARestController(GestionarFormatoACUIntPort objGestionarFormatoACUIntPort,
            @Qualifier("FormatoAMapperInfraestructuraDominio") ModelMapper objMapeador) {
        this.objGestionarFormatoACUIntPort = objGestionarFormatoACUIntPort;
        this.objMapeador = objMapeador;
    }

    @PostMapping("")
    public ResponseEntity<FormatoADTORespuesta> crearFormatoA(@Valid @RequestBody FormatoADTOPeticion formatoA) {

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

        // REtornar codigo 201 created
        return ResponseEntity.status(201).body(objRespuesta);
    }

    @GetMapping("/listarPorDocente")
    public ResponseEntity<List<FormatoADTORespuesta>> getMethodName(
            @Min(value = 0, message = "{user.idformatoa.min}") @RequestParam Integer idDocente) {
        List<FormatoA> objFormatoADominio = objGestionarFormatoACUIntPort.listarPorDocente(idDocente);

        List<FormatoADTORespuesta> respuestas = new ArrayList<FormatoADTORespuesta>();

        for (FormatoA formato : objFormatoADominio) {
            if (formato instanceof FormatotiA) {
                FormatotiA objFormatotiADominio = (FormatotiA) formato;
                FormatotiADTORespuesta objFormatoADTORespuesta = objMapeador.map(objFormatotiADominio,
                        FormatotiADTORespuesta.class);
                respuestas.add(objFormatoADTORespuesta);
            } else {
                FormatoppA objFormatoppADominio = (FormatoppA) formato;
                FormatoppADTORespuesta objFormatoADTORespuesta = objMapeador.map(objFormatoppADominio,
                        FormatoppADTORespuesta.class);
                respuestas.add(objFormatoADTORespuesta);
            }
        }

        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/listarPorDocenteEntreFechas")
    public ResponseEntity<List<FormatoADTORespuesta>> listarPorDocente(
            @Min(value = 0, message = "{user.idformatoa.min}") @RequestParam Integer idDocente,
            @NotNull @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @NotNull @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<FormatoA> objFormatoADominio = objGestionarFormatoACUIntPort.listarPorDocenteYFechas(idDocente,
                fechaInicio, fechaFin);

        List<FormatoADTORespuesta> respuestas = new ArrayList<FormatoADTORespuesta>();

        for (FormatoA formato : objFormatoADominio) {
            if (formato instanceof FormatotiA) {
                FormatotiA objFormatotiADominio = (FormatotiA) formato;
                FormatotiADTORespuesta objFormatoADTORespuesta = objMapeador.map(objFormatotiADominio,
                        FormatotiADTORespuesta.class);
                respuestas.add(objFormatoADTORespuesta);
            } else {
                FormatoppA objFormatoppADominio = (FormatoppA) formato;
                FormatoppADTORespuesta objFormatoADTORespuesta = objMapeador.map(objFormatoppADominio,
                        FormatoppADTORespuesta.class);
                respuestas.add(objFormatoADTORespuesta);
            }
        }

        return ResponseEntity.ok(respuestas);
    }

}
