package com.example.workshopMongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
@Document(collection = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();

	public User(String id, @NotBlank String name, @NotBlank @Email String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
}
