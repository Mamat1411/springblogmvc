package com.springboot.springblogmvc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.javafaker.Faker;
import com.springboot.springblogmvc.users.entities.User;
import com.springboot.springblogmvc.users.repositories.UserRepository;
@SpringBootApplication
public class SpringblogmvcApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringblogmvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			int max = 10;
			Faker faker = new Faker(new Locale("en-US"));

			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			User user = new User("Muhammad Mujahid", "mamat1411", "mamat1411@gmail.com", bcrypt.encode("mamat1411"));
			userRepository.save(user);
			for (int i = 0; i < max; i++) {
				User userSeed = new User(faker.name().fullName(), faker.name().username(), faker.internet().safeEmailAddress(), bcrypt.encode("123456"));
				userRepository.save(userSeed);
			}
		};
	}
}
