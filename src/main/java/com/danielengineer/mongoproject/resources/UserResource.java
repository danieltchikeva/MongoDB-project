package com.danielengineer.mongoproject.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielengineer.mongoproject.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User francisco = new User("1", "Francisco de Assis", "francisco@gmail.com");
		User clara = new User("2", "Clara de Assis", "clara@gmail.com");
		User antonio = new User("3", "Antonio de Lisboa e Pádua", "antonio@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(francisco, clara, antonio));
		return ResponseEntity.ok().body(list);
	}
	
}
