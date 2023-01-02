package com.ekazeker.blog.persistence;

import org.springframework.data.mongodb.core.index.Indexed;

public class AuthorDocument extends MongoDocument {

	private String name;
	private String description;

	@Indexed(unique = true)
	private String userName;

	private String password;

	public AuthorDocument(String name, String description, String userName, String password) {
		this.name = name;
		this.description = description;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
