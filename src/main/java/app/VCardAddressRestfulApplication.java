package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfig.class)
@ComponentScan("controller")
public class VCardAddressRestfulApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VCardAddressRestfulApplication.class, args);
	}
	
}
