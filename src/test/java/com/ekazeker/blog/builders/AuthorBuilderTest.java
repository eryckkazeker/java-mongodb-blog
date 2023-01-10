package com.ekazeker.blog.builders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ekazeker.blog.model.Author;
import com.ekazeker.blog.persistence.AuthorDocument;

class AuthorBuilderTest {

	@Test
	void should_CreateAuthorDocument_FromAuthor() {
		var author = new Author()
			.name("name")
			.description("description")
			.password("password")
			.username("username");

		var authorDocument = AuthorBuilder.fromAuthor(author);

		assertEquals(author.getName(), authorDocument.getName());
		assertEquals(author.getDescription(), authorDocument.getDescription());
		assertEquals(author.getPassword(), authorDocument.getPassword());
		assertEquals(author.getUsername(), authorDocument.getUserName());
	}

	@Test
	void should_CreateAuthor_FromAuthorDocument() {
		var authorDocument = new AuthorDocument("name","description","username","password");

		var author = AuthorBuilder.fromAuthorDocument(authorDocument);

		assertEquals(authorDocument.getName(), author.getName());
		assertEquals(authorDocument.getDescription(), author.getDescription());
		assertNull(author.getPassword());
		assertEquals(authorDocument.getUserName(), author.getUsername());
	}
}
