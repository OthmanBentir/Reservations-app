package ma.ob.resourceservice.dtos;

import lombok.*;
import ma.ob.resourceservice.enums.Type;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ResourceResponseDto {
    private Long id;
    private String nom;
    private Type type;
}
