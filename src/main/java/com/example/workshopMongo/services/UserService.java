package com.example.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.dto.UserDTO;
import com.example.workshopMongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(String id) {
		return repository.findById(id);
	}

	public User insert(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		return repository.insert(user);
	}

	public void delete(String id) {
		Optional<User> test = repository.findById(id);

		if (test.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		repository.deleteById(id);
	}

	public User update(User novoUser) {
		return repository.findById(novoUser.getId()).map(existingUser -> {
			existingUser.setName(novoUser.getName());
			existingUser.setEmail(novoUser.getEmail());
			return repository.save(existingUser);
		}).orElse(null);
	}
}
