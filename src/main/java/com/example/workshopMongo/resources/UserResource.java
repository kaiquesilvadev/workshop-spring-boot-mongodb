package com.example.workshopMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshopMongo.domain.User;
import com.example.workshopMongo.dto.UserDTO;
import com.example.workshopMongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService Service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = Service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		if (list.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		 return Service.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(new UserDTO(resposta)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
