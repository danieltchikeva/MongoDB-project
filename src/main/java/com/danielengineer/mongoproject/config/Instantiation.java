package com.danielengineer.mongoproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielengineer.mongoproject.domain.User;
import com.danielengineer.mongoproject.repositoy.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
	
		User francisco = new User(null, "Francisco de Assis", "francisco@gmail.com");
		User clara = new User(null, "Clara de Assis", "clara@gmail.com");
		User antonio = new User(null, "Antonio de Lisboa e Pádua", "antonio@gmail.com");
		User rita = new User(null, "Rita de Cássia", "rita@gmail.com");
		User ines = new User(null, "Inês de Assis", "ines@gmail.com");
		
		userRepository.saveAll(Arrays.asList(francisco, clara, antonio, rita, ines));
		
		
	}

}
