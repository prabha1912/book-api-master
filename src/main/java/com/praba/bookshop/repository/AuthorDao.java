package com.praba.bookshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praba.bookshop.model.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {

	public List<Author> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

	public Optional<Author> findByLastName(String lastName);
}
