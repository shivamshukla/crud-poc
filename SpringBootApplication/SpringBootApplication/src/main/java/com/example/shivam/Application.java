package com.example.shivam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.shivam.domain.Person;
import com.example.shivam.domain.PersonRepository;
import com.example.shivam.domain.User;
import com.example.shivam.domain.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Save demo users, courses and persons to H2 DB
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, UserRepository userRerepository) {
		return (args) -> {
			// save Persons
			personRepository.save(new Person("John", "Wick", "29", "Red","Shopping")); 
			personRepository.save(new Person("John", "Wick1", "30", "Blue","Shopping"));
			personRepository.save(new Person("John", "Wick2", "31", "Green","Shopping"));
			personRepository.save(new Person("John", "Wick3", "32", "Black","Shopping"));
			personRepository.save(new Person("John", "Wick4", "33", "Grey","Shopping"));
			
			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			userRerepository.save(user1);
			userRerepository.save(user2); 
		};
	}
}
