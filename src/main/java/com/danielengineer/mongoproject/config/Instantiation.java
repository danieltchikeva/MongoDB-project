package com.danielengineer.mongoproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielengineer.mongoproject.domain.Post;
import com.danielengineer.mongoproject.domain.User;
import com.danielengineer.mongoproject.dto.AuthorDTO;
import com.danielengineer.mongoproject.dto.CommentDTO;
import com.danielengineer.mongoproject.repositoy.PostRepository;
import com.danielengineer.mongoproject.repositoy.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User francisco = new User(null, "Francisco de Assis", "francisco@gmail.com");
		User clara = new User(null, "Clara de Assis", "clara@gmail.com");
		User antonio = new User(null, "Antonio de Lisboa e Pádua", "antonio@gmail.com");
		User rita = new User(null, "Rita de Cássia", "rita@gmail.com");
		User ines = new User(null, "Inês de Assis", "ines@gmail.com");

		userRepository.save(Arrays.asList(francisco, clara, antonio, rita, ines));

		Post post1 = new Post(null, sdf.parse("09/12/2023"), "Go on vacation", "I'm travelling to California, bye bye!",
				new AuthorDTO(francisco));
		Post post2 = new Post(null, sdf.parse("01/01/2024"), "Go to the beach", "I'm going to the beach right now!",
				new AuthorDTO(clara));

		CommentDTO c1 = new CommentDTO("Boa viagem, Francisco!", sdf.parse("09/12/2023"), new AuthorDTO(clara));
		CommentDTO c2 = new CommentDTO("Aproveita a viagem, Francisco!", sdf.parse("10/12/2023"), new AuthorDTO(rita));
		CommentDTO c3 = new CommentDTO("Tudo de melhor pra você, Francisco!", sdf.parse("11/12/2023"), new AuthorDTO(antonio));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));		
		post2.getComments().addAll(Arrays.asList(c3));		
		
		postRepository.save(Arrays.asList(post1, post2));

		francisco.getPost().addAll(Arrays.asList(post1, post2));
		userRepository.save(francisco);
	}

}
