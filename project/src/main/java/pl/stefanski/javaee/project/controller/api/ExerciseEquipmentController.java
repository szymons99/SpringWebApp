package pl.stefanski.javaee.project.controller.api;

import org.springframework.web.bind.annotation.*;
import pl.stefanski.javaee.project.domain.ExerciseEquipment;
import pl.stefanski.javaee.project.service.ExerciseEquipmentService;

import javax.validation.Valid;

@RestController
public class ExerciseEquipmentController {
    private final ExerciseEquipmentService exerciseEquipmentService;

    public ExerciseEquipmentController(ExerciseEquipmentService exerciseEquipmentService) {
        this.exerciseEquipmentService = exerciseEquipmentService;
    }

    @GetMapping("/api/exerciseEquipment/{id}")
    public ExerciseEquipment getOne(@PathVariable Long id) {
        var one = exerciseEquipmentService.getOne(id);
        if(one == null) {
            throw new ExerciseEquipmentNotFoundExeption();
        }
        return  exerciseEquipmentService.getOne(id);
    }

    @GetMapping("/api/exerciseEquipment")
    public Iterable<ExerciseEquipment> getAll() {
        return exerciseEquipmentService.getAll();
    }

    @PostMapping("/api/exerciseEquipment")
    public ExerciseEquipment create(@Valid @RequestBody ExerciseEquipment exerciseEquipment) {
        return exerciseEquipmentService.create(exerciseEquipment);
    }

    @PutMapping("/api/exerciseEquipment/{id}")
    public ExerciseEquipment update(@PathVariable Long id, @Valid @RequestBody ExerciseEquipment exerciseEquipment) {
        return exerciseEquipmentService.update(id, exerciseEquipment);
    }

    @DeleteMapping("/api/exerciseEquipment/{id}")
    public void delete(@PathVariable Long id) {
        exerciseEquipmentService.delete(id);
    }
}
