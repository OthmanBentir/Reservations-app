package ma.ob.reservationservice.service;

import ma.ob.reservationservice.dtos.PersonneResponseDto;

import java.util.List;

public interface PersonneService {
    List<PersonneResponseDto> getPersonnes();
    PersonneResponseDto getPersonneById(Long id);
}
