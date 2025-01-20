package com.praba.bookshop.service.exceptions;

@SuppressWarnings("serial")
public class AuthorExistsException extends RuntimeException {

	public AuthorExistsException(String message) {
		super(message);
	}

}
