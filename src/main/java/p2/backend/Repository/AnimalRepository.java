package p2.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Employee;
import p2.backend.Beans.Food;

import java.util.Set;

@Repository
public interface AnimalRepository extends Neo4jRepository<Animal,Long> {

    Animal findAnimalByAnimalName(String name);
    Set<Animal> findAnimalsByAnimalIdIsNotNull();
}
