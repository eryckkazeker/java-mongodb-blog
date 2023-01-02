package com.ekazeker.blog.builders;

import com.ekazeker.blog.model.Author;
import com.ekazeker.blog.persistence.AuthorDocument;

public class AuthorBuilder {
	
	private AuthorBuilder() {

	}

	public static AuthorDocument fromAuthor(Author author) {
		return new AuthorDocument(author.getName(), 
															author.getDescription(),
															author.getUsername(),
															author.getPassword());
	}

	public static Author fromAuthorDocument(AuthorDocument authorDocument) {
		return new Author()
			.id(authorDocument.getId())
			.name(authorDocument.getName())
			.description(authorDocument.getDescription())
			.username(authorDocument.getUserName());
	}
}
