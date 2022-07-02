package pl.stefanski.javaee.project.customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExerciseEquipmentNameValidator implements ConstraintValidator<ExerciseEquipmentNameConstraint, String> {

    @Override
    public void initialize(ExerciseEquipmentNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize((constraintAnnotation));
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[a-z]+(-[a-z]+)*");
    }
}
