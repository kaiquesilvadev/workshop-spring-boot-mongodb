package com.example.workshopMongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.workshopMongo.domain.Comment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public CommentDTO(String text, Date date, AuthorDTO author) {
	
		this.text = text;
		this.date = date;
		this.author = author;
	}
	
	
}
