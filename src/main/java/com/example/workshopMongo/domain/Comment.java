package com.example.workshopMongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.workshopMongo.dto.AuthorDTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Document
public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String text;
	private Date date;
	
	@DBRef
	private AuthorDTO author;
}
