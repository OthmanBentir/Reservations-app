package ma.ob.reservationservice.service;

import ma.ob.reservationservice.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("resources-service")
public interface ResourceClient {
    @GetMapping("/Resources/{id}")
    public Resource getResource(@PathVariable Long id);
}
