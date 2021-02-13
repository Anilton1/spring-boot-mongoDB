package com.araujo.estudomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.araujo.estudomongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
