package pl.stefanski.javaee.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.stefanski.javaee.project.domain.ExerciseEquipment;
import pl.stefanski.javaee.project.service.ExerciseEquipmentService;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner setupApp(@Autowired ExerciseEquipmentService exerciseEquipmentService) {
		/*return args -> {
			System.out.println("Startuje CommandLineRunner...");
			exerciseEquipmentService.create(new ExerciseEquipment("Orbiterk", 1111));
		};*/
		return (args) -> exerciseEquipmentService.initialData();
	}
}
