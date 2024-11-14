package org.bank.electronicmoney;

import org.bank.electronicmoney.entities.Carte;
import org.bank.electronicmoney.service.CarteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories
public class ElectronicmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicmoneyApplication.class, args);
	}

	//@Bean
	/*CommandLineRunner commandLineRunner(CarteService carteService){
		Random random=new Random();
		return args -> {
			for (int i = 1; i < 12 ; i++){
			  Carte c = Carte.builder().id(i+1L)
					.solde(random.nextInt(120000)+i)
					  .numeroCarte(String.valueOf(random.nextInt(90000000)))
					  .codePin(String.valueOf(random.nextInt(1234)))
					   .nomPorteur("Amine Ali")
					  .build();
			  carteService.creerCarte(c);
			}
		};
	}*/

}
