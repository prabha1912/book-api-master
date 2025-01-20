package com.praba.bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.praba.bookshop.model.Author;
import com.praba.bookshop.repository.AuthorDao;
import com.praba.bookshop.service.exceptions.AuthorExistsException;
import com.praba.bookshop.service.exceptions.AuthorNotFoundException;

@Service
public class AuthorService {

	private AuthorDao authorDao;

	@Autowired
	public AuthorService(AuthorDao AuthorDao) {
		super();
		this.authorDao = AuthorDao;
	}

	@Transactional
	public Author save(Author author) {
		Optional<Author> optionalAuthor = authorDao.findByLastName(author.getLastName());
		if (optionalAuthor.isPresent()) {
			if (author.getId() == 0 || optionalAuthor.get().getId() != author.getId()) {
				throw new AuthorExistsException("Author with last name of " + author.getLastName() + " already exists");
			}
		}

		return authorDao.save(author);
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public List<Author> findByFirstOrLastname(String name) {
		return authorDao.findByFirstNameContainingOrLastNameContainingIgnoreCase(name, name);
	}

	public Author findById(int id) {
		Optional<Author> author = authorDao.findById(id);
		if (author.isEmpty()) {
			throw new AuthorNotFoundException("Author with id of " + id + " was not found");
		}
		return author.get();
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		authorDao.deleteById(id);
	}
	
}
