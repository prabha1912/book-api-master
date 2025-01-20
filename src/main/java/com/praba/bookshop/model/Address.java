package com.praba.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(generator = "addressgen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "addressgen", sequenceName = "address_seq", allocationSize = 1)
	private int addressId;

	@Column(length = 10)
	private String number;

	@Column(length = 50)
	private String street;

	@Column(length = 50)
	private String city;

	@Column(length = 12)
	private String postCode;

	@Column(length = 50)
	private String country;

	public Address() {
		super();
	}

	public Address(String number, String street, String city, String postCode, String country) {
		super();
		this.number = number;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
