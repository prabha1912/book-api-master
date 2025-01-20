package com.praba.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praba.bookshop.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

	public List<Book> findByTitleContainingIgnoreCase(String title);
}
