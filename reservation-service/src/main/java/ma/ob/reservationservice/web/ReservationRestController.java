package ma.ob.reservationservice.web;

import ma.ob.reservationservice.dtos.PersonneResponseDto;
import ma.ob.reservationservice.entities.Reservation;
import ma.ob.reservationservice.mappers.PersonneMapper;
import ma.ob.reservationservice.model.Resource;
import ma.ob.reservationservice.service.PersonneService;
import ma.ob.reservationservice.service.ReservationService;
import ma.ob.reservationservice.service.ResourceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationRestController {
    private PersonneService personneService;
    private ReservationService reservationService;
    private PersonneMapper personneMapper;
    private ResourceClient resourceClient;

    public ReservationRestController(PersonneService personneService, ReservationService reservationService, PersonneMapper personneMapper, ResourceClient resourceClient) {
        this.personneService = personneService;
        this.reservationService = reservationService;
        this.personneMapper = personneMapper;
        this.resourceClient = resourceClient;
    }

    @GetMapping("/Reservations")
    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = reservationService.getReservations();
        reservations.forEach(reservation -> {
            Long resourceId = reservation.getResourceId();
            Resource resource = resourceClient.getResource(resourceId);
            reservation.setResource(resource);
        });

        return reservations;
    }

    @GetMapping("/Reservations/{id}")
    public Reservation getReservation(@PathVariable Long id){

        return reservationService.getReservationById(id);
    }

    @GetMapping("/Personnes")
    public List<PersonneResponseDto> getAllPersonnes(){
        return personneService.getPersonnes();
    }
}
