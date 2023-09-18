package com.example.workshopMongo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshopMongo.domain.Post;
import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.dto.UserDTO;
import com.example.workshopMongo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService Service;

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
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserDTO user) {
		User obj = Service.insert(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		Service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@PutMapping
	public ResponseEntity<User> update(@Valid @RequestBody User user) {
		User userAtualizado = Service.update(user);

		if (userAtualizado == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userAtualizado);
	}

	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
		Optional<List<Post>> listaPosts = Service.findById(id).map(User::getPosts);
	    
	    if (listaPosts.isPresent()) {
	        return ResponseEntity.ok(listaPosts.get());
	    } else {
	       throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    }
	}
}
