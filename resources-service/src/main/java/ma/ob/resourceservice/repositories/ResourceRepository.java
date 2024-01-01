package ma.ob.resourceservice.repositories;

import ma.ob.resourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
