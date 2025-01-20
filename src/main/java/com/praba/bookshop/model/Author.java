package com.praba.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	@Id
	@GeneratedValue(generator = "authorgen", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "authorgen", sequenceName = "author_seq", allocationSize = 1)
	private int id;

	@Column(length = 50)
	@Size(min = 2, max = 50, message = "Author first name must be longer than 1 and less than 51 characters")
	private String firstName;
	
	@Column(length = 50)
	@Size(min = 2, max = 50, message = "Author last name must be longer than 1 and less than 51 characters")
	private String lastName;
	
	@Column(length = 500)
	@Size(min = 2, max = 500, message = "Biography must be longer than 1 and less than 501 characters")
	private String biography;

	public Author(String firstName, String lastName, String biography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.biography = biography;
	}

	public Author() {
	}
	
	@JsonIgnore
	public String getFullname() {
		return firstName + " " + lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", biography=" + biography
				+ "]";
	}

	
}
