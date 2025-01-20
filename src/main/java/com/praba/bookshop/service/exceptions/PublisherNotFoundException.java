package com.praba.bookshop.service.exceptions;

@SuppressWarnings("serial")
public class PublisherNotFoundException extends RuntimeException {

	public PublisherNotFoundException(String message) {
		super(message);
	}

}
