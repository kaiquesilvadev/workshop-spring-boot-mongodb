package com.example.workshopMongo.dto;

import java.io.Serializable;

import com.example.workshopMongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}	
}
