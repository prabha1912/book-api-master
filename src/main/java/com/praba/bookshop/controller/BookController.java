package com.praba.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praba.bookshop.model.Book;
import com.praba.bookshop.service.BookService;
import com.praba.bookshop.service.exceptions.BookNotFoundException;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping()
	public List<Book> allBooks(Model model) {
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable int id) {
		return bookService.findById(id);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException bnfe){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bnfe.getMessage());
	}
}
