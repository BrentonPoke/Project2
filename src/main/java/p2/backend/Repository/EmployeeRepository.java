package p2.backend.Repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p2.backend.Beans.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, Integer> {

    Employee findByUsername(String username);
    Employee findEmployeeByEmployeeId(Integer id);
}
