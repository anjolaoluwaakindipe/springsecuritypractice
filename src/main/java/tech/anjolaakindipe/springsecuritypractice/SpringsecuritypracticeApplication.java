package tech.anjolaakindipe.springsecuritypractice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.MongoDbFactoryParser;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mongodb.client.MongoClient;

import tech.anjolaakindipe.springsecuritypractice.domain.Role;
import tech.anjolaakindipe.springsecuritypractice.domain.User;
import tech.anjolaakindipe.springsecuritypractice.service.UserService;

@SpringBootApplication
public class SpringsecuritypracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritypracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return arg->{
			// userService.saveRole(new Role(null, "ROLE_USER"));
			// userService.saveRole(new Role(null, "ROLE_MANAGER"));
			// userService.saveRole(new Role(null, "ROLE_ADMIN"));
			// userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			// userService.saveUser(new User(null, "Anjola Akindipe", "anjola", "1234", new ArrayList<>()));
			// userService.saveUser(new User(null, "Jason Osoba", "jason", "1234", new ArrayList<>()));
			// userService.saveUser(new User(null, "Obichukwu Nwosu", "obi", "1234", new ArrayList<>()));
			// userService.saveUser(new User(null, "Damilare Adeniyi", "damilare", "1234", new ArrayList<>()));

			// userService.addRoleToUser("anjola", "ROLE_USER");
			// userService.addRoleToUser("damilare", "ROLE_MANAGER");
			// userService.addRoleToUser("jason", "ROLE_MANAGER");
			// userService.addRoleToUser("anjola", "ROLE_ADMIN");
			// userService.addRoleToUser("anjola", "ROLE_SUPER_ADMIN");
			// userService.addRoleToUser("obi", "ROLE_ADMIN");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
