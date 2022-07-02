package pl.stefanski.javaee.project.controller.api;

import org.springframework.web.bind.annotation.*;
import pl.stefanski.javaee.project.domain.Producer;
import pl.stefanski.javaee.project.service.ProducerService;

import javax.validation.Valid;

@RestController
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/api/producer/{id}")
    public Producer getOne(@PathVariable Long id) {
        return  producerService.getOne(id);
    }

    @GetMapping("/api/producer")
    public Iterable<Producer> getAll() {
        return producerService.getAll();
    }

    @PostMapping("/api/producer")
    public Producer create(@Valid @RequestBody Producer producer) {
        return producerService.create(producer);
    }

    @PutMapping("/api/producer/{id}")
    public Producer update(@PathVariable Long id, @Valid @RequestBody Producer producer) {
        return producerService.update(id, producer);
    }

    @DeleteMapping("/api/producer/{id}")
    public void delete(@PathVariable Long id) {
        producerService.delete(id);
    }
}
