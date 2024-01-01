package ma.ob.resourceservice;

import ma.ob.resourceservice.entities.Resource;
import ma.ob.resourceservice.enums.Type;
import ma.ob.resourceservice.repositories.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ResourceRepository resourceRepository){
		return args -> {
			resourceRepository.saveAll(List.of(
					Resource.builder().nom("alienware").type(Type.MATERIEL_AUDIO_VUSUEL).build(),
					Resource.builder().nom("msi").type(Type.MATERIEL_INF0).build(),
					Resource.builder().nom("lenovo").type(Type.MATERIEL_AUDIO_VUSUEL).build()
			));
		};
	}
}
