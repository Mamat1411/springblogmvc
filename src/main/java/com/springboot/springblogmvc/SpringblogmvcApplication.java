package com.springboot.springblogmvc;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.javafaker.Faker;
import com.springboot.springblogmvc.categories.entities.Category;
import com.springboot.springblogmvc.categories.repositories.CategoryRepository;
import com.springboot.springblogmvc.posts.entities.Post;
import com.springboot.springblogmvc.posts.repositories.PostRepository;
import com.springboot.springblogmvc.users.entities.User;
import com.springboot.springblogmvc.users.repositories.UserRepository;

@SpringBootApplication
public class SpringblogmvcApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringblogmvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			
			// Faker Instantiation
			Faker faker = new Faker(new Locale("en-US"));
			
			// Bcrypt Instantiation
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			
			// User Seeding (USE IT ONLY FOR DEVELOPMENT PURPOSES)
			int users = 4;
			User user = new User("Muhammad Mujahid", "mamat1411", "mamat1411@gmail.com", bcrypt.encode("mamat1411"));
			userRepository.save(user);
			for (int i = 0; i < users; i++) {
				User userSeed = new User(faker.name().fullName(), faker.name().username(),
						faker.internet().safeEmailAddress(), bcrypt.encode("123456"));
				userRepository.save(userSeed);
			}

			// Category Seeding (USE IT ONLY FOR DEVELOPMENT PURPOSES)
			Category backendDevelopment = new Category("Backend Development", "backend-development");
			Category frontendDevelopment = new Category("Frontend Development", "frontend-development");
			Category fullstackDevelopment = new Category("Fullstack Development", "fullstack-development");
			Category personal = new Category("Personal", "personal");
			categoryRepository.save(backendDevelopment);
			categoryRepository.save(frontendDevelopment);
			categoryRepository.save(fullstackDevelopment);
			categoryRepository.save(personal);

			// Posts Seeding (USE IT ONLY FOR DEVELOPMENT PURPOSES)
			int posts = 20;
			for (int i = 0; i < posts; i++) {
				Post postSeed = new Post(
					faker.number().numberBetween(1l, 3l), 
					faker.number().numberBetween(1l, 5l),
					faker.book().title(), faker.lorem().sentence(), 
					faker.internet().slug(), 
					String.join("", faker.lorem().paragraphs(faker.number().numberBetween(2, 5))), 
					null);
				postRepository.save(postSeed);
			}
		};
	}
}
