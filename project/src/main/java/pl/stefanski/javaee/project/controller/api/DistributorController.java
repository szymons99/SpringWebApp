package pl.stefanski.javaee.project.controller.api;

import org.springframework.web.bind.annotation.*;
import pl.stefanski.javaee.project.domain.Distributor;
import pl.stefanski.javaee.project.service.DistributorService;

import javax.validation.Valid;

@RestController
public class DistributorController {
    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @GetMapping("/api/distributor/{id}")
    public Distributor getOne(@PathVariable Long id) {
        return  distributorService.getOne(id);
    }

    @GetMapping("/api/distributor")
    public Iterable<Distributor> getAll() {
        return distributorService.getAll();
    }

    @PostMapping("/api/distributor")
    public Distributor create(@Valid @RequestBody Distributor distributor) {
        return distributorService.create(distributor);
    }

    @PutMapping("/api/distributor/{id}")
    public Distributor update(@PathVariable Long id, @Valid @RequestBody Distributor distributor) {
        return distributorService.update(id, distributor);
    }

    @DeleteMapping("/api/distributor/{id}")
    public void delete(@PathVariable Long id) {
        distributorService.delete(id);
    }
}
