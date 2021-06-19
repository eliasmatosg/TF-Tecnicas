package TF01.TF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"TF01"})
@EntityScan(basePackages = {"TF01"})

@EnableJpaRepositories(basePackages = {"TF01"})

public class TfApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfApplication.class, args);
	}

}
