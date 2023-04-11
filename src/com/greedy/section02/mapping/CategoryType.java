package com.greedy.section02.mapping;

public enum CategoryType {

	TOP("상의"), 
	PANTS("하의");

	private final String description;

	CategoryType(String description) {	
		this.description = description;
		
	}
	
	public String getDescription() {
		return this.description;
	}


}
