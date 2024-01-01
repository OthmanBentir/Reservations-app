package ma.ob.resourceservice.services;

import ma.ob.resourceservice.dtos.ResourceResponseDto;
import ma.ob.resourceservice.entities.Resource;
import ma.ob.resourceservice.mappers.ResourceMapper;
import ma.ob.resourceservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {
    private ResourceRepository resourceRepository;
    private ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public List<ResourceResponseDto> getAll() {
        List<Resource> keynotes = resourceRepository.findAll();
        return keynotes.stream().map(resourceMapper::from).collect(Collectors.toList());
    }

    @Override
    public ResourceResponseDto getbyId(Long id) {
        Resource resource = resourceRepository.findById(id).orElse(null);
        if (resource == null) throw new RuntimeException(String.format("keynote by Id : %d is not found", id));
        return resourceMapper.from(resource);
    }
}
