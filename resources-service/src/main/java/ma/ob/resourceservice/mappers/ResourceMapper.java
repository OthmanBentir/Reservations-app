package ma.ob.resourceservice.mappers;

import ma.ob.resourceservice.dtos.ResourceRequestDto;
import ma.ob.resourceservice.dtos.ResourceResponseDto;
import ma.ob.resourceservice.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public ResourceResponseDto from(Resource resource){
        return modelMapper.map(resource, ResourceResponseDto.class);
    }

    public Resource to(ResourceRequestDto resourceRequestDto){
        return modelMapper.map(resourceRequestDto, Resource.class);
    }
}
