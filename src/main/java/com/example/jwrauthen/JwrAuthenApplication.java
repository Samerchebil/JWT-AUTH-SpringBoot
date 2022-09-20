package com.example.jwrauthen;

import com.example.jwrauthen.Domain.Role;
import com.example.jwrauthen.Domain.UserApp;
import com.example.jwrauthen.Service.UserService;
import com.example.jwrauthen.Service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwrAuthenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwrAuthenApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserServiceImpl userService){
	return args -> {
//
//		userService.saveRole(new Role(null,"ROLE_USER"));
//		userService.saveRole(new Role(null,"ROLE_ADMIN"));
//		userService.saveRole(new Role(null,"ROLE_MANAGER"));
//     	userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//		userService.saveUser(new UserApp(null,"John Trav","john","12345",new ArrayList<>()));
//		userService.saveUser(new UserApp(null,"leo messi","leo","12345",new ArrayList<>()));
//		userService.saveUser(new UserApp(null,"andrea pirlo","andrea","12345",new ArrayList<>()));
//		userService.saveUser(new UserApp(null,"zlatan ibrahimovic","zlatan","12345",new ArrayList<>()));

//		userService.addRoleToUser("John","ROLE_USER");
//		userService.addRoleToUser("John","ROLE_ADMIN");
//		userService.addRoleToUser("leo","ROLE_USER");
//		userService.addRoleToUser("andrea","ROLE_ADMIN");
//		userService.addRoleToUser("zlatan","ROLE_ADMIN");
//		userService.addRoleToUser("zlatan","ROLE_SUPER_ADMIN");
//


	};

	}
}
