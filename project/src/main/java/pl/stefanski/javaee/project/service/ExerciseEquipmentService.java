package pl.stefanski.javaee.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.stefanski.javaee.project.domain.Distributor;
import pl.stefanski.javaee.project.domain.ExerciseEquipment;
import pl.stefanski.javaee.project.domain.Producer;
import pl.stefanski.javaee.project.domain.UserManual;
import pl.stefanski.javaee.project.repository.DistributorRepository;
import pl.stefanski.javaee.project.repository.ExerciseEquipmentRepository;
import pl.stefanski.javaee.project.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ExerciseEquipmentService{

    private final ExerciseEquipmentRepository exerciseEquipmentRepository;
    private final ProducerRepository producerRepository;
    private final DistributorRepository distributorRepository;

    public ExerciseEquipmentService(ExerciseEquipmentRepository exerciseEquipmentRepository, ProducerRepository producerRepository, DistributorRepository distributorRepository) {
        this.exerciseEquipmentRepository = exerciseEquipmentRepository;
        this.producerRepository = producerRepository;
        this.distributorRepository = distributorRepository;
    }

    public ExerciseEquipment getOne(Long id) {
        return  exerciseEquipmentRepository.findById(id).get();
    }

    public Iterable<ExerciseEquipment> getAll() {
        return exerciseEquipmentRepository.findAll();
    }

    public ExerciseEquipment create(ExerciseEquipment exerciseEquipment) {
        return exerciseEquipmentRepository.save(exerciseEquipment);
    }

    public ExerciseEquipment update(Long id, ExerciseEquipment exerciseEquipment) {
        ExerciseEquipment exerciseEquipmentToUpdate = exerciseEquipmentRepository.findById(id).get();

        exerciseEquipmentToUpdate.setName(exerciseEquipment.getName());
        exerciseEquipmentToUpdate.setPrice(exerciseEquipment.getPrice());
        exerciseEquipmentToUpdate.setProducer(exerciseEquipment.getProducer());
        exerciseEquipmentToUpdate.setDistributors(exerciseEquipment.getDistributors());
        exerciseEquipmentToUpdate.setUserManual(exerciseEquipment.getUserManual());

        return exerciseEquipmentRepository.save(exerciseEquipmentToUpdate);
    }

    public void delete(Long id) {
        exerciseEquipmentRepository.deleteById(id);
    }

    public Iterable<Producer> getProducers() {
        return producerRepository.findAll();
    }

    public Iterable<Distributor> getDistributors() {
        return  distributorRepository.findAll();
    }

    public void initialData() {
        ExerciseEquipment exerciseEquipment1 = new ExerciseEquipment("orbiterk", 1111);
        ExerciseEquipment exerciseEquipment2 = new ExerciseEquipment("orbiterk", 1324);
        ExerciseEquipment exerciseEquipment3 = new ExerciseEquipment("bieżnia", 175);
        ExerciseEquipment exerciseEquipment4 = new ExerciseEquipment("bieżnia", 1111);
        ExerciseEquipment exerciseEquipment5 = new ExerciseEquipment("rower", 1656);

        Producer producer1 = new Producer("Sport", 2000);
        Producer producer2 = new Producer("FitCorp", 1999);
        Producer producer3 = new Producer("Gymco", 2018);

        Distributor distributor1 = new Distributor("Matres", 1955);
        Distributor distributor2 = new Distributor("FitStore", 2000);
        Distributor distributor3 = new Distributor("SportStore", 2008);

        UserManual userManual1 = new UserManual("Instrukcja", 7);
        UserManual userManual2 = new UserManual("Specyfikacja", 73);
        UserManual userManual3 = new UserManual("Specyfikacja", 27);
        UserManual userManual4 = new UserManual("Informacja", 57);
        UserManual userManual5 = new UserManual("Informacja", 57);

        exerciseEquipment1.setUserManual(userManual3);
        exerciseEquipment2.setUserManual(userManual4);
        exerciseEquipment3.setUserManual(userManual1);
        exerciseEquipment4.setUserManual(userManual2);
        exerciseEquipment5.setUserManual(userManual5);

        List<ExerciseEquipment> exerciseEquipments1 = new ArrayList<>();
        exerciseEquipments1.add(exerciseEquipment1);
        exerciseEquipments1.add(exerciseEquipment2);

        List<ExerciseEquipment> exerciseEquipments2 = new ArrayList<>();
        exerciseEquipments2.add(exerciseEquipment3);
        exerciseEquipments2.add(exerciseEquipment4);
        exerciseEquipments2.add(exerciseEquipment5);

        distributor1.setExerciseEquipments(exerciseEquipments1);
        distributor2.setExerciseEquipments(exerciseEquipments1);
        distributor3.setExerciseEquipments(exerciseEquipments2);
        distributor2.setExerciseEquipments(exerciseEquipments2);
        distributor3.setExerciseEquipments(exerciseEquipments1);

        List<Distributor> distributors1 = new ArrayList<>();
        distributors1.add(distributor1);
        distributors1.add(distributor2);
        distributors1.add(distributor3);

        List<Distributor> distributors2 = new ArrayList<>();
        distributors2.add(distributor2);
        distributors2.add(distributor3);

        exerciseEquipmentRepository.saveAll(exerciseEquipments1);

        distributorRepository.saveAll(distributors1);
        distributorRepository.saveAll(distributors2);

        exerciseEquipment1.setDistributors(distributors1);
        exerciseEquipment2.setDistributors(distributors1);
        exerciseEquipment3.setDistributors(distributors2);
        exerciseEquipment4.setDistributors(distributors2);
        exerciseEquipment5.setDistributors(distributors2);

        exerciseEquipment1.setProducer(producer1);
        exerciseEquipment2.setProducer(producer2);
        exerciseEquipment3.setProducer(producer3);
        exerciseEquipment4.setProducer(producer2);
        exerciseEquipment5.setProducer(producer1);

        exerciseEquipmentRepository.saveAll(exerciseEquipments2);

        producerRepository.save(producer1);
        producerRepository.save(producer2);
        producerRepository.save(producer3);

        //Find producer by year of establishment
        producerRepository.findByYoe(2000).forEach(System.out::println);

        //Find exercise equipment by price
        exerciseEquipmentRepository.findByPrice(1111).forEach(System.out::println);
    }
}
