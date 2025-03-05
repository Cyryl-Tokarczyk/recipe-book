package c.tokarczyk.recipeTypesMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RecipeTypesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeTypesMicroserviceApplication.class, args);
	}

}
