package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DocenteDTOPeticionValidator.class)
@Documented
public @interface ValidDocenteDTOPeticion {
    String message() default "Debe enviar solo el ID o todos los demás campos, pero no ambos a la vez.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
