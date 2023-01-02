package com.ekazeker.blog.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ekazeker.blog.persistence.AuthorDocument;

@Repository
public interface AuthorsRepository extends MongoRepository<AuthorDocument, String> {
	
}
