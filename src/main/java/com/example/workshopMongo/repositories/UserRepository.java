package com.example.workshopMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshopMongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
