package pl.stefanski.javaee.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.stefanski.javaee.project.domain.Producer;
import pl.stefanski.javaee.project.repository.ProducerRepository;

@Transactional
@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Producer getOne(Long id) {
        return producerRepository.findById(id).get();
    }

    public Iterable<Producer> getAll() {
        return producerRepository.findAll();
    }

    public Producer create(Producer producer) {
        return producerRepository.save(producer);
    }

    public Producer update(Long id, Producer producer) {
        Producer producerToUpdate = producerRepository.findById(id).get();

        producerToUpdate.setName(producer.getName());
        producerToUpdate.setYoe(producer.getYoe());

        return producerRepository.save(producerToUpdate);
    }

    public void delete(Long id) {
        producerRepository.deleteById(id);
    }


}
