package ma.ob.resourceservice.services;

import ma.ob.resourceservice.dtos.ResourceResponseDto;

import java.util.List;

public interface ResourceService {
    List<ResourceResponseDto> getAll();
    ResourceResponseDto getbyId(Long id);
}
