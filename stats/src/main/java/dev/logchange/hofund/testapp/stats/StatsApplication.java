package dev.logchange.hofund.testapp.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatsApplication.class, args);
	}

}
