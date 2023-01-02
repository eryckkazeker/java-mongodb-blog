package com.ekazeker.blog.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ekazeker.blog.api.AuthorsApi;
import com.ekazeker.blog.builders.AuthorBuilder;
import com.ekazeker.blog.builders.AuthorListItemBuilder;
import com.ekazeker.blog.model.Author;
import com.ekazeker.blog.model.AuthorListItem;
import com.ekazeker.blog.persistence.repositories.AuthorsRepository;

@RestController
public class AuthorsController implements AuthorsApi {

	private final AuthorsRepository authorRepository;

	public AuthorsController(AuthorsRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public ResponseEntity<Author> postAuthor(@Valid Author author) {
		var authorDocument = AuthorBuilder.fromAuthor(author);
		var newAuthor = authorRepository.save(authorDocument);
		var createdAuthor = AuthorBuilder.fromAuthorDocument(newAuthor);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	}

	@Override
	public ResponseEntity<List<AuthorListItem>> getAuthors() {
		var authorsList = authorRepository.findAll().stream().map(document -> AuthorListItemBuilder.fromAuthorDocument(document)).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(authorsList);
	}

	@Override
	public ResponseEntity<Author> getAuthor(String id) {
		var author = authorRepository.findById(id);

		if (!author.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(AuthorBuilder.fromAuthorDocument(author.get()));

	}

	@Override
	public ResponseEntity<Void> deleteAuthor(String id) {
		var author = authorRepository.findById(id);

		if(!author.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		authorRepository.deleteById(id);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@Override
	public ResponseEntity<Author> updateAuthor(String id, @Valid Author author) {
		
		var existingAuthor = authorRepository.findById(id);

		if (!existingAuthor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		var existingDocument = existingAuthor.get();

		existingDocument.setDescription(author.getDescription());
		existingDocument.setName(author.getName());

		var updatedDocument = authorRepository.save(existingDocument);

		return ResponseEntity.status(HttpStatus.OK).body(AuthorBuilder.fromAuthorDocument(updatedDocument));


	}
}
