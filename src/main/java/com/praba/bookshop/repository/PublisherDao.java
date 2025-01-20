package com.praba.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praba.bookshop.model.Publisher;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Integer> {

}
