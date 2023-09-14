package com.example.workshopMongo.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
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
}
