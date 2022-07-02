package pl.stefanski.javaee.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stefanski.javaee.project.domain.Producer;

import java.util.List;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Producer where yoe=?")
    List<Producer> findByYoe(int yoe);
}
