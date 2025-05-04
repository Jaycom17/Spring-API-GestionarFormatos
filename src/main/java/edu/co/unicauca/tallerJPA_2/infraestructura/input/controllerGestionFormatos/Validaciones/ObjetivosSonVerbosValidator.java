package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class ObjetivosSonVerbosValidator implements ConstraintValidator<ObjetivosSonVerbosValidatorInt, List<String>>{

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {

        if (value == null) return true;

        for (String objetivo : value) {
            if (objetivo == null || objetivo.trim().isEmpty()) continue;

            String primeraPalabra = objetivo.trim().split("\\s+")[0].toLowerCase();

            if (!(primeraPalabra.endsWith("ar") ||
                  primeraPalabra.endsWith("er") ||
                  primeraPalabra.endsWith("ir") ||
                  primeraPalabra.endsWith("or"))) {
                return false;
            }
        }

        return true;
    }
    
    
}
