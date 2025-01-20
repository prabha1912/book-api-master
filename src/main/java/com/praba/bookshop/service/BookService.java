package com.praba.bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praba.bookshop.model.Book;
import com.praba.bookshop.repository.BookDao;
import com.praba.bookshop.service.exceptions.BookNotFoundException;

@Service
public class BookService {

	private BookDao bookDao;

	@Autowired
	public BookService(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
	@Transactional
	public Book save(Book book) {
		return bookDao.save(book);
	}
	
	public List<Book> findAll(){
		return bookDao.findAll();
	}
	
	public Book findById(int id){
		Optional<Book> book = bookDao.findById(id);
		if (book.isEmpty()) {
			throw new BookNotFoundException("Book with id of " + id + " was not found");
		}
		return book.get();
	}

	public List<Book> findByTitle(String title){
		return bookDao.findByTitleContainingIgnoreCase(title);
	}
}
