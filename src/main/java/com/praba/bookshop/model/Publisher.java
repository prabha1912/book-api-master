package com.praba.bookshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(generator = "publishergen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "publishergen", sequenceName = "publisher_seq", allocationSize = 1)
	private int publisherId;

	@Column(length = 100)
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;

	public Publisher() {
		super();
	}

	public Publisher(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
