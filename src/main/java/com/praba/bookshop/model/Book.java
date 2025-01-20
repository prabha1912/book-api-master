package com.praba.bookshop.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book {
	@Id
	@GeneratedValue(generator = "bookgen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "bookgen", sequenceName = "book_seq", allocationSize = 1)
	private int bookId;
	
	@Column(length = 100, nullable = false)
	@Size(min = 2, max = 100, message = "Book title must be longer than 1 and less than 101 characters")
	private String title;
	
	@Column(length = 14, nullable = false)
	@Size(min = 10, max = 14, message = "ISBN number must be 10 or 14 characters")
	private String isbn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publicationDate;
	
	@DecimalMin(value = "0.50", message="Book price must be greater than 0.49")
	@DecimalMax(value = "10000.00", message = "Book price must be less than 10,000.00")
	private double price;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Publisher publisher;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Author> authors;
	
	private boolean discontinued = false;

	public Book() {
		super();
	}

	public Book(String title, String isbn, LocalDate publicationDate, double price, Publisher publisher,
			List<Author> authors, boolean discontinued) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.price = price;
		this.publisher = publisher;
		this.authors = authors;
		this.discontinued = discontinued;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	
}
