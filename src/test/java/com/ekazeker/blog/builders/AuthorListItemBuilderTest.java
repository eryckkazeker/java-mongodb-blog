package com.ekazeker.blog.builders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ekazeker.blog.persistence.AuthorDocument;

class AuthorListItemBuilderTest {

	@Test
	void should_BuildListItem_FromAuthorDocument() {
		var document = new AuthorDocument("name", "description", "username", "password");

		var listItem = AuthorListItemBuilder.fromAuthorDocument(document);

		assertEquals("name", listItem.getName());
	}
}
