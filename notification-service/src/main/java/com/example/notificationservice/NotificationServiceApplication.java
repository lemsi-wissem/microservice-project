package com.example.notificationservice;

import com.example.notificationservice.model.NotificationRequest;
import com.example.notificationservice.repository.NotificationRequestRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner start(NotificationRequestRepository repo) {
		return args -> {
			Stream.of(new NotificationRequest("wissemkill@gmail.com", "hello", "+21624153480"),
							new NotificationRequest("wissemkill@gmail.com", "3aslema", "+21624153480"))
					.forEach(notificationRequest ->
					{
						repo.save(notificationRequest);
					});
			repo.findAll().forEach(s -> System.out.println(s.getMessage()));
		};
	}
}
