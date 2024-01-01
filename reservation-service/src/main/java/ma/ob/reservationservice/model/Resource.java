package ma.ob.reservationservice.model;

import lombok.*;
import ma.ob.reservationservice.enums.Type;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Resource {
    private Long id;
    private String nom;
    private Type type;
}
