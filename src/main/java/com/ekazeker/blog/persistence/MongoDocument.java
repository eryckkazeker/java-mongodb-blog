package com.ekazeker.blog.persistence;

import org.springframework.data.annotation.Id;

public class MongoDocument {

	@Id
	private String id;

	public String getId() {
		return id;
	}
	
}
