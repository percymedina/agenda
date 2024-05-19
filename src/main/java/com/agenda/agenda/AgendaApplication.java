package com.agenda.agenda;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.repository.ContactRepository;

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return (String... args) -> {

				List<Contact> contacts = Arrays.asList(
					new Contact("percy medina", "percy@gmail.com", LocalDateTime.now()),
					new Contact("oscar medina", "oscar@gmail.com", LocalDateTime.now()),
					new Contact("diana medina", "diana@gmail.com", LocalDateTime.now()),
					new Contact("juan perez", "juan@gmail.com", LocalDateTime.now()),
					new Contact("carlos sanchez", "carlos@gmail.com", LocalDateTime.now())
				);
			contactRepository.saveAll(contacts);
					
		};
		
	};
}
