package ma.ob.reservationservice.repositories;

import ma.ob.reservationservice.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
