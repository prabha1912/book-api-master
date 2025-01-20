package com.praba.bookshop.service.exceptions;

@SuppressWarnings("serial")
public class AuthorNotFoundException extends RuntimeException {

	public AuthorNotFoundException(String message) {
		super(message);
	}

}
