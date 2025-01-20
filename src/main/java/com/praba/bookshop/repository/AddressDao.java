package com.praba.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praba.bookshop.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
