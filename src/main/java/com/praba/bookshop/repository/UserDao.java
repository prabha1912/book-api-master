package com.praba.bookshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praba.bookshop.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String name);
	
	public Optional<User> findByUsernameAndPassword(String username, String password);
}
