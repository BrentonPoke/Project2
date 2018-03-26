package p2.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    Animal findAnimalByAnimalName(String name);
    Set<Animal> findAnimalsByAnimalIdIsNotNull();
    Animal findAnimalByAnimalId(int id);
    Set<Animal> findAnimalsByEmployees(Employee id);
    @Modifying
    @Transactional
    @Query("UPDATE Animal a SET a.tracking = a.tracking + 1 where a.animalId = :id")
    void updateTracking(@Param("id") Integer id);

    List<Animal> findAnimalsByAnimalIdIsNotNullOrderByTrackingDesc();

}
