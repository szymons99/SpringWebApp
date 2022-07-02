package pl.stefanski.javaee.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.stefanski.javaee.project.domain.Distributor;
import pl.stefanski.javaee.project.repository.DistributorRepository;

@Transactional
@Service
public class DistributorService {
    private final DistributorRepository distributorRepository;

    public DistributorService(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    public Distributor getOne(Long id) {
        return distributorRepository.findById(id).get();
    }

    public Iterable<Distributor> getAll() {
        return distributorRepository.findAll();
    }

    public Distributor create(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public Distributor update(Long id, Distributor distributor) {
        Distributor distributorToUpdate = distributorRepository.findById(id).get();

        distributorToUpdate.setName(distributor.getName());
        distributorToUpdate.setYoe(distributor.getYoe());

        return distributorRepository.save(distributorToUpdate);
    }

    public void delete(Long id) {
        distributorRepository.deleteById(id);
    }
}
