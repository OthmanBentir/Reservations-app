package ma.ob.reservationservice.service;

import ma.ob.reservationservice.entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getReservations();
    Reservation getReservationById(Long id);
}
