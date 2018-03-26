package p2.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import p2.backend.Beans.Employee;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);
    Employee findEmployeeByEmployeeId(Integer id);
}
