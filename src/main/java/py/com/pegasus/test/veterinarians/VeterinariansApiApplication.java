package py.com.pegasus.test.veterinarians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VeterinariansApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariansApiApplication.class, args);
	}

}
