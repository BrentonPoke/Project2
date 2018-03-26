package p2.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import p2.backend.Beans.Events;

@Repository
@Transactional
public interface EventsRepository extends JpaRepository<Events, Integer> {

}
