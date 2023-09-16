package com.example.workshopMongo.resources;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.dto.UserDTO;
import com.example.workshopMongo.repositories.UserRepository;
import com.example.workshopMongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService Service;
	
	@Autowired
	private UserRepository repository;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = Service.findAll();
		if (list.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		 return Service.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(new UserDTO(resposta)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO user) {
	     User obj = Service.insert(user);
	     return ResponseEntity.status(HttpStatus.CREATED).body( new UserDTO(obj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
	    
	     Service.delete(id);
	     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	     
	}
}
