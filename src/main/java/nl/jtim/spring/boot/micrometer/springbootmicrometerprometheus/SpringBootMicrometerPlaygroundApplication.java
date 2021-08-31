package nl.jtim.spring.boot.micrometer.springbootmicrometerprometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootMicrometerPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicrometerPlaygroundApplication.class, args);
	}
}
