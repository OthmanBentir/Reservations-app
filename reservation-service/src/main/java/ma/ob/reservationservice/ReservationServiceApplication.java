package ma.ob.reservationservice;

import ma.ob.reservationservice.entities.Personne;
import ma.ob.reservationservice.entities.Reservation;
import ma.ob.reservationservice.repositories.PersonneRepository;
import ma.ob.reservationservice.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ReservationRepository reservationRepository, PersonneRepository personneRepository){
        return args -> {
            Personne personne = new Personne() ;
            for (int i = 0; i <5; i++) {
                personne = Personne.builder().nom("nom" + i).email("nom" + i + "@gmail.com").fonction("fonction" + i).build();
                personneRepository.save(personne);
            }

            reservationRepository.saveAll(List.of(
                    Reservation.builder().nom("reservation-1").contexte("contexte1").date(new Date()).duree(3600L).idPersonne(3L).resourceId(2L).personne(personne).build(),
                    Reservation.builder().nom("reservation-2").contexte("contexte2").date(new Date()).duree(1800L).idPersonne(5L).resourceId(3L).personne(personne).build()
            ));
        };
    }
}
