package com.ekazeker.blog.builders;

import com.ekazeker.blog.model.AuthorListItem;
import com.ekazeker.blog.persistence.AuthorDocument;

public class AuthorListItemBuilder {

	private AuthorListItemBuilder() {

	}

	public static AuthorListItem fromAuthorDocument(AuthorDocument authorDocument) {
		return new AuthorListItem()
			.id(authorDocument.getId())
			.name(authorDocument.getName());
	}
}
