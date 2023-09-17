package com.example.workshopMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshopMongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
