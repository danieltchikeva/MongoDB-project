package com.danielengineer.mongoproject.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielengineer.mongoproject.domain.Post;
import com.danielengineer.mongoproject.repositoy.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public List<Post> findAll(){
		return repo.findAll();
	}

	
	public Post findById(String id) throws AccountNotFoundException {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new AccountNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
