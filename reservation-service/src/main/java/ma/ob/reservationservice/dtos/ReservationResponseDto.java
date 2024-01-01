package ma.ob.reservationservice.dtos;

import lombok.*;
import ma.ob.reservationservice.entities.Personne;
import ma.ob.reservationservice.model.Resource;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationResponseDto {
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private Long duree;
    private Long idPersonne;
    private Long resourceId;
    private Resource resource;
    private Personne personne;
}
