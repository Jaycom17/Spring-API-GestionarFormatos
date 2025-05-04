package edu.co.unicauca.tallerJPA_2.infraestructura.input.controllerGestionFormatos.Validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ObjetivosSonVerbosValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjetivosSonVerbosValidatorInt {
    String message() default "Los objetivos deben empezar por un verbo en infinitivo";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
