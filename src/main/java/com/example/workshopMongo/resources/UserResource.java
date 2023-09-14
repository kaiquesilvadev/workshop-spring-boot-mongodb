package com.example.workshopMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService Service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> p1 = Service.findAll();
		if(p1.isEmpty()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok().body(p1);
	}
}
