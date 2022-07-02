package pl.stefanski.javaee.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stefanski.javaee.project.domain.Distributor;

import java.util.List;

@Repository
public interface DistributorRepository extends CrudRepository<Distributor, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Distributor where yoe=?")
    List<Distributor> findByYoe(int yoe);


}
