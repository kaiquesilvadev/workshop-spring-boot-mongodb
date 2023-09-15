package com.example.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.repositories.UserRepository;
import com.example.workshopMongo.services.exception.ObjectNotFoundException;

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
}
