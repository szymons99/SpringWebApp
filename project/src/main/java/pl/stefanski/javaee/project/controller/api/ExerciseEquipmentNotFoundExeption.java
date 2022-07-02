package pl.stefanski.javaee.project.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExerciseEquipmentNotFoundExeption extends RuntimeException{
    public ExerciseEquipmentNotFoundExeption() {
        super("No such equipment in db");
    }
}
