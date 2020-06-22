package com.example;

import com.example.model.old.Customer;
import com.example.model.old.CustomerRepository;
import com.example.model.table.Contact;
import com.example.model.table.ContactRepository;
import com.example.model.table.Utilisateur;
import com.example.model.table.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Jason Mahdjoub
 * @version 1.0
 * @since SpringBoot
 */
@SpringBootApplication
public class ServingWebContentApplication {
	private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ContactRepository contactRepository, UtilisateurRepository utilisateurRepository) {
		return (args) -> {
			contactRepository.save(new Contact("Maëlle Laporte"));
			contactRepository.save(new Contact("Raphaël Robert"));
			contactRepository.save(new Contact("Valérian Lucien"));
			contactRepository.save(new Contact("Nicolas Strady"));
			contactRepository.save(new Contact("Hippolyte Massicot"));
			contactRepository.save(new Contact("Domitille Pottier"));
			contactRepository.save(new Contact("Hugo Robert"));
			contactRepository.save(new Contact("Hugo Malglaive"));
			contactRepository.save(new Contact("Jérémy Rasseneur"));
			contactRepository.save(new Contact("Clément Maillard"));
			contactRepository.save(new Contact("Antonin Chaney"));
			contactRepository.save(new Contact("Antoine Zych"));
			contactRepository.save(new Contact("Hugo Bouillard"));
			contactRepository.save(new Contact("Yohann Warnier"));

			utilisateurRepository.save(new Utilisateur("Admin", "Password"));
		};
	}
}

// save a few customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//// for (Customer bauer : repository.findByLastName("Bauer")) {
////  log.info(bauer.toString());
//// }
//			log.info("");
