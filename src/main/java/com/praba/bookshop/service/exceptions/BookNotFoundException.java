package com.praba.bookshop.service.exceptions;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String message) {
		super(message);
	}
}
