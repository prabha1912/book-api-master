package com.praba.bookshop.service.exceptions;

@SuppressWarnings("serial")
public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException(String message) {
		super(message);
	}

}
