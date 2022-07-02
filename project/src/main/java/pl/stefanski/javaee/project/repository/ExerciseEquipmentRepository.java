package pl.stefanski.javaee.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stefanski.javaee.project.domain.ExerciseEquipment;

import java.util.List;

@Repository
public interface ExerciseEquipmentRepository extends CrudRepository<ExerciseEquipment, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM ExerciseEquipment WHERE name=?")
    List<ExerciseEquipment> findByName(String name);

    List<Object> findByPrice(float price);
}
