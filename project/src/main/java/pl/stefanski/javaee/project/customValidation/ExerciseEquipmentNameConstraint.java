package pl.stefanski.javaee.project.customValidation;

import pl.stefanski.javaee.project.domain.ExerciseEquipment;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExerciseEquipmentNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExerciseEquipmentNameConstraint {
    String message() default "Invalid name. Only letters allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
