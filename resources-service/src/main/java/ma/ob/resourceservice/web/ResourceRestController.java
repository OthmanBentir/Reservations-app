package ma.ob.resourceservice.web;

import ma.ob.resourceservice.dtos.ResourceResponseDto;
import ma.ob.resourceservice.services.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceRestController {
    private ResourceService resourceService;


    public ResourceRestController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/Resources")
    public List<ResourceResponseDto> getAllRessources(){

        return resourceService.getAll();
    }

    @GetMapping("/Resources/{id}")
    public ResourceResponseDto getRessourceById(@PathVariable Long id){
        return resourceService.getbyId(id);
    }
}
