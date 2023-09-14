package com.example.workshopMongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopMongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	//teste da aplicação antes de usar JPA 
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		 List<User> p1 = Arrays.asList(
		 new User(1L , "maria silva" , "maria@gmail.com"),
		 new User(2L , "kaique" , "kaique@gmail.com"));
		 
		 return ResponseEntity.ok().body(p1);
	}
}
