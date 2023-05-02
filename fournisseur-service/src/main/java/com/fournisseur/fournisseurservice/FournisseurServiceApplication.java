package com.fournisseur.fournisseurservice;

import com.fournisseur.fournisseurservice.Model.Fournisseur;
import com.fournisseur.fournisseurservice.Repository.FournisseurRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient // Pour enregistrer le microservice dans le service de découverte
public class FournisseurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurServiceApplication.class, args);
	}
	@Bean
	ApplicationRunner start(FournisseurRepository repo) {
		return args -> {
			Stream.of(new Fournisseur("Lait", 700L, 2),
							new  Fournisseur("Smart-watch", 700L, 23))
					.forEach(notificationRequest ->
					{
						repo.save(notificationRequest);
					});
			repo.findAll().forEach(s -> System.out.println(s.getProductName()));
		};
	}
}
