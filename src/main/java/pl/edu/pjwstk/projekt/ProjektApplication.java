package pl.edu.pjwstk.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjektApplication {
	//swagger http://localhost:8080/v3/api-docs
	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);
	}

}
