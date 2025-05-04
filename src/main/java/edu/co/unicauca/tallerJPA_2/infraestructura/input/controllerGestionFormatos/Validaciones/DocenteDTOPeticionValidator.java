package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones;

import edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.DTOPeticion.DocenteDTOPeticion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocenteDTOPeticionValidator implements ConstraintValidator<ValidDocenteDTOPeticion, DocenteDTOPeticion> {

    @Override
    public boolean isValid(DocenteDTOPeticion dto, ConstraintValidatorContext context) {
        boolean idPresent = dto.getIdDocente() != null;
        boolean otherFieldsPresent = 
            isNotBlank(dto.getNombresDocente()) || 
            isNotBlank(dto.getApellidosDocente()) ||
            isNotBlank(dto.getNombreGrupo()) || 
            isNotBlank(dto.getCorreo());

        return (idPresent && !otherFieldsPresent) || (!idPresent && otherFieldsPresent);
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
