package ma.ob.reservationservice.service;

import ma.ob.reservationservice.dtos.PersonneResponseDto;
import ma.ob.reservationservice.entities.Reservation;
import ma.ob.reservationservice.mappers.PersonneMapper;
import ma.ob.reservationservice.mappers.ReservationMapper;
import ma.ob.reservationservice.model.Resource;
import ma.ob.reservationservice.repositories.ReservationRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private ReservationMapper reservationMapper;
    private ReservationRepository reservationRepository;
    private PersonneService personneService;
    private PersonneMapper personneMapper;

    public ReservationServiceImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository, PersonneService personneService, PersonneMapper personneMapper) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.personneService = personneService;
        this.personneMapper = personneMapper;
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
//        return reservations.stream().map(reservationMapper::from).collect(Collectors.toList());
        return reservations;
    }

    @Override
    public Reservation getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation == null) throw new RuntimeException(String.format("reservation by Id : %d is not found", id));
        PersonneResponseDto personne = personneService.getPersonneById(reservation.getId());
        reservation.setPersonne(personneMapper.to(personne));
        RestClient restClient = RestClient.create("http://localhost:8000/resources-service");
        Resource resource = restClient.get().uri("/Resources/" + reservation.getResourceId()).retrieve().body(new ParameterizedTypeReference<>() {});
        reservation.setResource(resource);
        return reservation;
    }
}
