package com.danielengineer.mongoproject.services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielengineer.mongoproject.domain.User;
import com.danielengineer.mongoproject.dto.UserDTO;
import com.danielengineer.mongoproject.repositoy.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}

	
	public User findById(String id) throws AccountNotFoundException {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new AccountNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) throws AccountNotFoundException {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) throws AccountNotFoundException {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}


	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
